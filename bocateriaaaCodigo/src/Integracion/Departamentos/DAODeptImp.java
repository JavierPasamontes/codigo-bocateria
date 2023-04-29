package Integracion.Departamentos;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Negocio.Departamentos.TDept;

public class DAODeptImp implements DAODept {

	private final static String _path = "resources/departamentos/dept.JSON";

	@Override
	public int create(TDept tDept) {
		int id = -1;
		int pointer = 1;
		// abrir fichero en este caso un documento de texto
		
		JSONObject out = new JSONObject();

		List<TDept> deptList = this.readAll();
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		for(TDept dept :deptList) {
			ids.add(dept.getId());
		}
		
		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) {
			
			if(! ids.contains(tDept.getId()) ) {
				if(tDept.getId() == null || tDept.getId() < 1 || deptList.size() > 1) {//si el departamento no tiene id, se lo asignamos
					
					boolean hayID = false;
			
					while (hayID == false) {
						if(ids.contains(pointer)) {
							pointer++;
						}
						else hayID = true;
					}
					id = pointer;
					tDept.setId(pointer);
				}
				else
					id = tDept.getId();
				
				deptList.add(tDept);
			
				JSONArray depts = new JSONArray();
				
				for(TDept dept :deptList) {
					JSONObject o = new JSONObject();
					o.put("ID", dept.getId());
					o.put("NOMBRE", dept.getNombre());
					o.put("SEDE", dept.getSede());
					o.put("ACTIVO", dept.getActivo());
					o.put("DESC", dept.getDescripcion());
					o.put("NUMEMP", dept.getContEmpleados());
					
					depts.put(o);
				}
							
				out.put("DEPARTAMENTOS", depts);
				salida.write(out.toString());
				salida.close();
			}
			else {
				throw new IOException("YA EXISTE ALGUIEN CON EL ID: " + tDept.getId());
			}

		} catch (Exception e) {
			System.out.println("Base de datos de departamentos creada");
		}
					
		return id;
	}

	@Override
	public TDept read(Integer id) {
		 //al tratarse de un JSON es mas conveniente leerlo todo,
		//convertirlo en objeto y luego trabajar con este
		TDept departamento = null;
		
		List<TDept> deptList = new ArrayList<TDept>();
		
		deptList = this.readAll();
		
		int i = 0;
		boolean salida = false;
		
		while (salida == false && i < deptList.size()) {
			if(deptList.get(i).getId() == id) {
				departamento = deptList.get(i);
				salida = true;
			}
			i++;
		}

		return departamento;
	}
	
	@Override
	public TDept readByName(String nombre) {
		TDept departamento = null;

		List<TDept> deptList = new ArrayList<TDept>();
		
		deptList = this.readAll();
		
		int i = 0;
		boolean salida = false;
		
		while (salida == false && i < deptList.size()) {
			if(deptList.get(i).getNombre().equals(nombre)) {
				departamento = deptList.get(i);
				salida = true;
			}
			i++;
		}

		return departamento;
	}

	@Override
	public List<TDept> readAll() { //funcion principal de lectura
		List<TDept> deptList = new ArrayList<TDept>();
		
		try (BufferedReader entrada = new BufferedReader(new FileReader(_path))) {
			
			String line = entrada.readLine();
			
			if(line != null ) {
				JSONObject jsonInput = new JSONObject(line);
		
				JSONArray depts= jsonInput.getJSONArray("DEPARTAMENTOS");
			
				for(int i = 0; i< depts.length(); i++) {
					JSONObject in = depts.getJSONObject(i);
					
					Integer auxId = in.getInt("ID");;
					String nombre = in.getString("NOMBRE");
					String sede = in.getString("SEDE");
					String descripcion =  in.getString("DESC");;
					Boolean activo = in.getBoolean("ACTIVO");
					Integer numEmp = in.getInt("NUMEMP");
					
					TDept departamento = new TDept(auxId, nombre, sede, activo, descripcion);
					departamento.setContEmpleados(numEmp);
					// leemos el id y lo insertamos en la lista
					deptList.add(departamento);
				}
			
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return deptList;
	}



	@Override
	public int update(TDept tDept) {
		List<TDept> deptList = new ArrayList<TDept>();

		deptList = this.readAll();
		
		for(int i = 0; i < deptList.size();i++) {
			if (deptList.get(i).getId() == tDept.getId()) {
				deptList.get(i).setNombre(tDept.getNombre());
				deptList.get(i).setSede(tDept.getSede());
				deptList.get(i).setDescripcion(tDept.getDescripcion());
				deptList.get(i).setActivo(tDept.getActivo());
				deptList.get(i).setContEmpleados(tDept.getContEmpleados());
			}
		}

		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) { // sobrescribimos el archivo de texto
			for (TDept departamento : deptList) {
				this.create(departamento);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tDept.getId();
	}

	@Override
	public int delete(Integer id) {
	
		TDept eliminado = read(id);
		
		//Para modificar y poner el activo a false
		eliminado.setActivo(false);
		
		this.update(eliminado);

		/*
		// Para eliminar
	
		if (eliminado != null) {
			List<TDept> deptList = new ArrayList<TDept>();
			
			deptList = this.readAll();
		
			deptList.remove(eliminado);
					
			try(BufferedWriter salida = new BufferedWriter(new FileWriter(_path)))
			{ //sobrescribimos el archivo de texto
				for(TDept departamento : deptList) {
					this.create(departamento);
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		 */		
		return id;
	}
}