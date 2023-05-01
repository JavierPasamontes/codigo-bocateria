package Negocio.Departamentos;

import java.util.List;

import Integracion.Departamentos.DAODept;
import Integracion.FactoriaIntegracion.FactoriaIntg;

public class SADeptImp implements SADepartamento {
	
	
	public int create(TDept tDept) {
		int id = -1;
		
		DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		TDept leido = daoDept.readByName(tDept.getNombre());
		
		if (leido == null) {
			id = daoDept.create(tDept);
		}
		else{
			if(leido.getActivo()){
				if(!leido.getSede().equalsIgnoreCase(tDept.getSede()))
					id = daoDept.create(tDept);
			}
			else{
				leido.setActivo(true);
				tDept.setId(leido.getId());
				id = daoDept.update(tDept);
			}
		}
		return id;
	}
	
	//------------------------------------------
	
	public TDept read(Integer id) {
		DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		return daoDept.read(id);
	}

	//------------------------------------------
	
	public List<TDept> readAll() {
		DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		return daoDept.readAll();
	}

	//------------------------------------------
	
	public int update(TDept tDept) {
		DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();

		TDept dept = daoDept.read(tDept.getId());

		if (dept.getActivo()) {
			if (!tDept.getNombre().isEmpty())
				dept.setNombre(tDept.getNombre());
			if (!tDept.getDescripcion().isEmpty())
				dept.setDescripcion(tDept.getDescripcion());
			if (!tDept.getSede().isEmpty())
				dept.setSede(tDept.getSede());
		}
		else {
			return -1;
		}

		return daoDept.update(dept);
	}

	//------------------------------------------
	
	public int delete(Integer id) {
		DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		TDept dept = daoDept.read(id);
		
		if(dept.getContEmpleados() == 0 && dept.getActivo() )
			return daoDept.delete(id);
		else
			return -1;
	}
}