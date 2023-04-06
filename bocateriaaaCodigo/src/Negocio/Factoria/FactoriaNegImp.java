package Negocio.Factoria;

import Negocio.Departamentos.SADepartamento;
import Negocio.Departamentos.SADeptImp;

public class FactoriaNegImp extends FactoriaNeg {

	@Override
	public SADepartamento generarSADept() {
		return new SADeptImp();
	}
}