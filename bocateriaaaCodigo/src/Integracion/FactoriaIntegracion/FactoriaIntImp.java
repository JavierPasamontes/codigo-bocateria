package Integracion.FactoriaIntegracion;

import Integracion.Departamentos.DAODept;
import Integracion.Departamentos.DAODeptImp;
import Integracion.Empleados.DAOEmpImp;
import Integracion.Empleados.DAOEmpleados;
import Integracion.Marcas.DAOMarcas;
import Integracion.Marcas.DAOMarcasImp;
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

	@Override
	public DAOMarcas generarDAOMarcas() {
		return new DAOMarcasImp();
	}

	@Override
	public DAOEmpleados generarDAOEmpleados() {
		return new DAOEmpImp();
	}
	
	
	
}