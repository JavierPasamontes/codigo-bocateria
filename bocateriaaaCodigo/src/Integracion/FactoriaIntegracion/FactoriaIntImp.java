package Integracion.FactoriaIntegracion;

import Integracion.Departamentos.DAODept;
import Integracion.Departamentos.DAODeptImp;
import Integracion.Proveedores.DAOProv;
import Integracion.Proveedores.DAOProvImp;

public class FactoriaIntImp extends FactoriaIntg {

	@Override
	public DAODept generarDAODepts() {
		
		return new DAODeptImp();
	}

	@Override
	public DAOProv generarDAOProv() {
		return new DAOProvImp();
	}
	
	
	
}