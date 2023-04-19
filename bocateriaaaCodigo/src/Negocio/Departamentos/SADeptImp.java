package Negocio.Departamentos;

import java.util.List;

import Integracion.Departamentos.DAODept;
import Integracion.FactoriaIntegracion.FactoriaIntg;

public class SADeptImp implements SADepartamento {
	
	public int create(TDept tDept) {
		DAODept daoDept;
		int id = -1;
		daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		TDept leido = daoDept.readByName(tDept.getNombre());
		
		if (leido == null) {
			id = daoDept.create(tDept);
			
		}
		else{
			if(leido.isActivo()){
				return -1;
			}
			else{
				leido.setActivo(true);
				id = daoDept.update(leido);
			}
		}
		return id;
	}

	public TDept read(Integer id) {
		
		DAODept daoDept;
		daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		return daoDept.read(id);
	}

	public List<TDept> readAll() {
		DAODept daoDept;
		daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		return daoDept.readAll();
	}

	public int update(TDept tDept) {
		DAODept daoDept;
		daoDept = FactoriaIntg.getInstance().generarDAODepts();

		TDept dept = daoDept.read(tDept.getId());

		if (dept.isActivo()) {
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

	public int delete(Integer id) {
		DAODept daoDept;
		daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		if(daoDept.read(id).getContEmpleados() == 0)
			return daoDept.delete(id);
		else
			return -1;
	}
}