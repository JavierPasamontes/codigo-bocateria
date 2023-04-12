package Negocio.Factoria;

import Negocio.Departamentos.SADepartamento;
import Negocio.Departamentos.SADeptImp;
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
}