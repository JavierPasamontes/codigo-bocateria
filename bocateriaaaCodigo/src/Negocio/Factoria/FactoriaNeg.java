package Negocio.Factoria;

import Negocio.Departamentos.SADepartamento;
import Negocio.Proveedores.SAProv;

public abstract class FactoriaNeg {
	
	private static FactoriaNeg instance;

	public static FactoriaNeg getInstance() {
		
		if(instance == null) {
			instance = new FactoriaNegImp();
		}
		return instance;
		
	}
	public abstract SADepartamento generarSADept();
	
	public abstract SAProv generarSAProv();
}