/**
 * 
 */
package Negocio.Factoria;

import Negocio.Departamentos.SADepartamento;

public abstract class FactoriaNeg {
	
	private static FactoriaNeg instance;

	public static FactoriaNeg getInstance() {
		
		if(instance == null) {
			return new FactoriaNegImp();
		}
		return instance;
		
	}
	public abstract SADepartamento generarSADept();
}