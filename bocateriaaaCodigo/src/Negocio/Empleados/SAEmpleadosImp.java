package Negocio.Empleados;

import java.util.List;

import Integracion.Departamentos.DAODept;
import Integracion.Empleados.DAOEmpleados;
import Integracion.FactoriaIntegracion.FactoriaIntg;
import Negocio.Departamentos.TDept;

public class SAEmpleadosImp implements SAEmpleados {
	
	public int create(TransferEmpleados tEmp) {
		int id = -1;	
		
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		TransferEmpleados empleado = daoEmp.readByDNI(tEmp.getDNI());
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

	public TransferEmpleados read(int id) {
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		return daoEmp.read(id);
	}

	public List<TransferEmpleados> readAll() {
		return FactoriaIntg.getInstance().generarDAOEmpleados().readAll();
	}
	
	public int update(TransferEmpleados tEmp) {
		
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		
		TransferEmpleados empleado = daoEmp.read(tEmp.getId());
		
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
					
			//PREGUNTAR SEÑOR COMO CAMBIAR LOS PARAMETROS Q ESTAN DISTINTOS POR TRANSFER
			
			if(empleado.getJornada() == 0) {//tiempo parcial
				
			}
			else{ //tiempo completo
					
			}
		}
		
		
		return tEmp.getId();
	
	}

	public int delete(int dni) {
		return dni;
		//NO LO PODEMOS HACER AÚN
		//disminuir contador de empleados en el dept
	}
}