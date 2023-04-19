package Negocio.Empleados;

import java.util.ArrayList;
import java.util.List;

import Integracion.Departamentos.DAODept;
import Integracion.Empleados.DAOEmpleados;
import Integracion.FactoriaIntegracion.FactoriaIntg;
import Negocio.Departamentos.TDept;

public class SAEmpleadosImp implements SAEmpleados {
	
	public int create(TEmpleados tEmp) {
		int id = -1;	
		
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		TEmpleados empleado = daoEmp.readByDNI(tEmp.getDNI());
		TDept leidoDept = daoDept.read(tEmp.getIdDept());
		
		if (empleado == null) {
			if (leidoDept != null && leidoDept.isActivo()){
				id = daoEmp.create(tEmp);
				leidoDept.aumentarEmpleados();
				daoDept.update(leidoDept);
			}
		}
		else{
			if(!empleado.getActivo() && leidoDept.isActivo()){
				empleado.setActivo(true);
				leidoDept.aumentarEmpleados();
				daoDept.update(leidoDept);
			}	
		}
		return id;
	}

	public TEmpleados read(int id) {
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		return daoEmp.read(id);
	}

	public List<TEmpleados> readAll() {
		return FactoriaIntg.getInstance().generarDAOEmpleados().readAll();
	}
	
	public int update(TEmpleados tEmp) {
		
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		
		TEmpleados empleado = daoEmp.read(tEmp.getId());
		
		if(empleado.getActivo()){
			if (tEmp.getNombre().isEmpty())
				tEmp.setNombre(empleado.getNombre());
			
			if (tEmp.getApellidos().isEmpty())
				tEmp.setApellidos(empleado.getApellidos());
			
			if (tEmp.getDNI().isEmpty())
				tEmp.setDNI(empleado.getDNI());
			
			if (tEmp.getIdDept() == null) {
				tEmp.setIdDept(empleado.getIdDept());
			}
			else {
				DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
				TDept viejo = daoDept.read(empleado.getIdDept());
				TDept nuevo = daoDept.read(tEmp.getIdDept());
			
				if(nuevo.isActivo()){
					viejo.disminuirEmpleados();
					daoDept.update(viejo);
					nuevo.aumentarEmpleados();
					daoDept.update(nuevo);
				}
				else
					return -1;
			}
					
			
			
			if(empleado.getJornada() == 0) {//tiempo parcial
				TEmpleadosTP tTP = (TEmpleadosTP) tEmp;
				TEmpleadosTP empleadoTP = (TEmpleadosTP) empleado;
				if (tTP.getEurosHora() == 0) {
					tTP.setEurosHora(empleadoTP.getEurosHora());
				}
				if (tTP.getHoras() == 0) {
					tTP.setEurosHora(empleadoTP.getHoras());
				}
			}
			else{ //tiempo completo
				TEmpleadosTC tTC = (TEmpleadosTC) tEmp;
				TEmpleadosTC empleadoTC = (TEmpleadosTC) empleado;
				if (tTC.getSalario() == 0) {
					tTC.setSalario(empleadoTC.getSalario());
				}
				
			}
		}
		
		
		return tEmp.getId();
	
	}

	public int delete(int id) {
		
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		TEmpleados empleado = daoEmp.read(id);
		
		DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
		TDept leidoDept = daoDept.read(empleado.getIdDept());
		
		daoEmp.delete(id);
		
		leidoDept.disminuirEmpleados();
		daoDept.update(leidoDept);
		
		return id;
	}
	
	
	
	public List<TEmpleados> readEmpleadosDeDepartamento(int idDept){
		
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		
		List<TEmpleados> empDept = new ArrayList<TEmpleados>(); 
		
		List<TEmpleados> listaEmpleados = daoEmp.readAll();
		
		for(TEmpleados emp: listaEmpleados) {
			if (emp.getIdDept()== idDept) {
				empDept.add(emp);
			}
		}
		
		return empDept;
		
	}
}
