package Negocio.Factoria;

import Negocio.Departamentos.SADepartamento;
import Negocio.Departamentos.SADeptImp;
import Negocio.Empleados.SAEmpleados;
import Negocio.Empleados.SAEmpleadosImp;
import Negocio.Proveedores.SAProv;
import Negocio.Proveedores.SAProvImp;

public class FactoriaNegImp extends FactoriaNeg {

	@Override
	public SADepartamento generarSADept() {
		return new SADeptImp();
	}

	@Override
	public SAProv generarSAProv() {
		return new SAProvImp();
	}

	@Override
	public SAEmpleados generarSAEmpleados() {
		return new SAEmpleadosImp();
	}
}