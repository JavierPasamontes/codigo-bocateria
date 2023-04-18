package Integracion.Empleados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Negocio.Empleados.TEmpleados;
import Negocio.Empleados.TEmpleadosTP;
import Negocio.Empleados.TEmpleadosTC;


public class DAOEmpImp implements DAOEmpleados {
	
	private final static String _path = "resources/empleados/emp.JSON";

	@Override
	public int create(TEmpleados tEmp) {
		int id = -1;
		int pointer = 1;
		// abrir fichero en este caso un documento de texto
		
		JSONObject out = new JSONObject();

		List<TEmpleados> empList = this.readAll();
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		for(TEmpleados emp :empList) {
			ids.add(emp.getId());
		}
		
		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) {
			
			if(! ids.contains(tEmp.getId()) ) {
				if(tEmp.getId() == null || tEmp.getId() < 1 || empList.size() > 1) {//si el departamento no tiene id, se lo asignamos
					
					boolean hayID = false;
			
					while (hayID == false) {
						if(ids.contains(pointer)) {
							pointer++;
						}
						else hayID = true;
					}
					id = pointer;
					tEmp.setId(pointer);
				}
				else
					id = tEmp.getId();

				
				tEmp.aumentarVentas();
				
				empList.add(tEmp);
					
				JSONArray depts = new JSONArray();
				
				for(TEmpleados emp :empList) {
					JSONObject o = new JSONObject();
					//Independientemente del horario agragamos los datos comunes
					o.put("NOMBRE", emp.getNombre());
					o.put("APELLIDOS", emp.getApellidos());
					o.put("DNI", emp.getDNI());
					o.put("ID", emp.getId());
					o.put("JORNADA", emp.getJornada());
					o.put("DEPT", emp.getIdDept());
					o.put("ACTIVO", emp.getActivo());
					
					if(emp instanceof TEmpleadosTP ) { // si es un empleado a tiempo parcial
						o.put("HORAS", ((TEmpleadosTP) emp).getHoras());
						o.put("EUROS/HORA",((TEmpleadosTP) emp).getEurosHora());
					}
					else if (emp instanceof TEmpleadosTC ){ // si es un empleado a tiempo Completo
						o.put("SALARIO",((TEmpleadosTC) emp).getSalario());
					}
				
					depts.put(o);
				}
							
				out.put("EMPLEADOS", depts);
				salida.write(out.toString());
				salida.close();
			}
			else {
				throw new IOException("YA EXISTE UN EMPLEADO CON EL ID: " + tEmp.getId());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
					
		return id;
	}

	@Override
	public TEmpleados read(Integer id) {
		 //al tratarse de un JSON es mas conveniente leerlo todo,
		//convertirlo en objeto y luego trabajar con este
		TEmpleados empleado = null;
		
		List<TEmpleados> empList = new ArrayList<TEmpleados>();
		
		empList = this.readAll();
		
		int i = 0;
		boolean salida = false;
		
		while (salida == false && i < empList.size()) {
			if(empList.get(i).getId() == id) {
				empleado = empList.get(i);
				salida = true;
			}
			i++;
		}

		return empleado;
	}
	
	@Override
	public TEmpleados readByDNI(String dni) {
		TEmpleados empleado = null;

		List<TEmpleados> empList = new ArrayList<TEmpleados>();
		
		empList = this.readAll();
		
		int i = 0;
		boolean salida = false;
		
		while (salida == false && i < empList.size()) {
			if(empList.get(i).getDNI().equals(dni)) {
				empleado = empList.get(i);
				salida = true;
			}
			i++;
		}

		return empleado;
	}

	@Override
	public List<TEmpleados> readAll() {
		List<TEmpleados> empList = new ArrayList<TEmpleados>();
		
		try (BufferedReader entrada = new BufferedReader(new FileReader(_path))) {
			
			String line = entrada.readLine();
			
			if(line != null ) {
				JSONObject jsonInput = new JSONObject(line);
		
				JSONArray emps= jsonInput.getJSONArray("EMPLEADOS");
			
				for(int i = 0; i< emps.length(); i++) {
					JSONObject in = emps.getJSONObject(i);
					
					String nombre = in.getString("NOMBRE");
					String apellidos = in.getString("APELLIDOS");
					String dni = in.getString("DNI");
					Integer auxId = in.getInt("ID");
					Integer jornada = in.getInt("JORNADA");
					Integer dept = in.getInt("DEPT");
					Boolean activo = in.getBoolean("ACTIVO");
					
					TEmpleados empleado = new TEmpleados(nombre, apellidos, dni, auxId, jornada, dept, activo);
					
					if(in.has("SALARIO")) { //si es un empleado a tiempo completo 
						Integer salario = in.getInt("DEPT");
						empleado = new TEmpleadosTC(nombre, apellidos, dni,auxId,
								jornada, dept, activo, salario);
						
					}else {//si es un empleado a tiempo parcial
						Integer horas = in.getInt("HORAS");
						Integer eurosHora = in.getInt("EUROS/HORA");
						empleado = new TEmpleadosTP(nombre, apellidos, dni,auxId,
								jornada, dept, activo, horas, eurosHora);
					}

				empList.add(empleado);
				}
			
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return empList;
	}
	


	@Override
	public int update(TEmpleados tEmp) {
		List<TEmpleados> emptList = new ArrayList<TEmpleados>();

		emptList = this.readAll();
		
		
		for(int i = 0; i < emptList.size();i++) {
			if (emptList.get(i).getId() == tEmp.getId()) {
				emptList.get(i).setNombre(tEmp.getNombre());
				emptList.get(i).setApellidos(tEmp.getApellidos());
				emptList.get(i).setDNI(tEmp.getDNI());
				emptList.get(i).setActivo(tEmp.getActivo());
				emptList.get(i).setJornada(tEmp.getJornada());
				//si es un empleado a tiempo parcial
				if(emptList.get(i) instanceof TEmpleadosTP ) {
					((TEmpleadosTP) emptList.get(i)).setHoras(((TEmpleadosTP)tEmp).getHoras());;
					((TEmpleadosTP) emptList.get(i)).setHoras(((TEmpleadosTP)tEmp).getEurosHora());
				}
				else if (emptList.get(i) instanceof TEmpleadosTC ) {
					((TEmpleadosTC) emptList.get(i)).setSalario(((TEmpleadosTC)tEmp).getSalario());
				} //muchos cast's, pero espero que funciones
				
			}
		}

		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) { // sobrescribimos el archivo de texto
			for (TEmpleados empleado : emptList) {
				this.create(empleado);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tEmp.getId();
	}

	@Override
	public int delete(Integer id) {

		TEmpleados eliminado = read(id);
		
		//Para modificar y poner el activo a false
		eliminado.setActivo(false);
		
		this.update(eliminado);

		
		return id;
	}


	
	
}