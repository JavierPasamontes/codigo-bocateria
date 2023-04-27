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
				return -1;
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
			if (tDept.getNombre().isEmpty())
				tDept.setNombre(dept.getNombre());
			if (tDept.getDescripcion().isEmpty())
				tDept.setDescripcion(dept.getDescripcion());
			if (tDept.getSede().isEmpty())
				tDept.setSede(dept.getSede());
		}
		else {
			return -1;
		}

		return daoDept.update(tDept);
	}

	//------------------------------------------
	
	public int delete(Integer id) {
		DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		if(daoDept.read(id).getContEmpleados() == 0)
			return daoDept.delete(id);
		else
			return -1;
	}
}