package Integracion.FactoriaIntegracion;

import Integracion.Departamentos.DAODept;
import Integracion.Departamentos.DAODeptImp;

public class FactoriaIntImp extends FactoriaIntg {

	@Override
	public DAODept generarDAODepts() {
		
		return new DAODeptImp();
	}
	
	
}