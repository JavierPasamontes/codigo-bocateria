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
			if (leidoDept != null && leidoDept.getActivo()){
				id = daoEmp.create(tEmp);
				leidoDept.aumentarEmpleados();
				daoDept.update(leidoDept);
			}
		}
		else{
			if(!empleado.getActivo() && leidoDept.getActivo()){
				empleado.setActivo(true);
				leidoDept.aumentarEmpleados();
				daoDept.update(leidoDept);
			}	
		}
		return id;
	}
	
	//------------------------------------------

	public TEmpleados read(int id) {
		return FactoriaIntg.getInstance().generarDAOEmpleados().read(id);
	}
	
	//------------------------------------------

	public List<TEmpleados> readAll() {
		return FactoriaIntg.getInstance().generarDAOEmpleados().readAll();
	}
	
	//------------------------------------------
	
	public int update(TEmpleados tEmp) {
		
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		
		TEmpleados empleado = daoEmp.read(tEmp.getId());
		
		if(empleado.getActivo()){
			if (!tEmp.getNombre().isEmpty())
				empleado.setNombre(tEmp.getNombre());
			
			if (!tEmp.getApellidos().isEmpty())
				empleado.setApellidos(tEmp.getApellidos());
			
			if (!tEmp.getDNI().isEmpty())
				empleado.setDNI(tEmp.getDNI());
			
			if (tEmp.getIdDept() != null) {
				empleado.setIdDept(tEmp.getIdDept());
				
				DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
				TDept viejo = daoDept.read(empleado.getIdDept());
				TDept nuevo = daoDept.read(tEmp.getIdDept());
			
				if(nuevo.getActivo()){
					viejo.disminuirEmpleados();
					daoDept.update(viejo);
					nuevo.aumentarEmpleados();
					daoDept.update(nuevo);
				}
				else
					return -1;
			}
			
			if(empleado.getJornada() == 0) { //T.PARCIAL
				TEmpleadosTP tTP = (TEmpleadosTP) tEmp;
				TEmpleadosTP empleadoTP = (TEmpleadosTP) empleado;
				if (tTP.getEurosHora() != 0) {
					empleadoTP.setEurosHora(tTP.getEurosHora());
				}
				if (tTP.getHoras() != 0) {
					empleadoTP.setEurosHora(tTP.getHoras());
				}
			}
			else{ //T.COMPLETO
				TEmpleadosTC tTC = (TEmpleadosTC) tEmp;
				TEmpleadosTC empleadoTC = (TEmpleadosTC) empleado;
				if (tTC.getSalario() != 0) {
					empleadoTC.setSalario(tTC.getSalario());
				}
			}
		}
		else
			return -1;
		
		return daoEmp.update(empleado);
	}
	
	//------------------------------------------

	public int delete(int id) {
		
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		TEmpleados empleado = daoEmp.read(id);
		
		if(empleado != null && empleado.getActivo()) {
			DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
			TDept leidoDept = daoDept.read(empleado.getIdDept());
			
			daoEmp.delete(id);
			
			leidoDept.disminuirEmpleados();
			daoDept.update(leidoDept);
			
			return id;
		}
		else
			return -1;
	}
	
	//------------------------------------------
	
	public List<TEmpleados> readEmpleadosDeDepartamento(int idDept){
		
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		if(daoDept.read(idDept) == null) {
			return null;
		}
		
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
