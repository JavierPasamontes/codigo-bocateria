/**
 * 
 */
package Integracion.FactoriaIntegracion;

import Integracion.Departamentos.DAODept;

public abstract class FactoriaIntg {
	
	private static FactoriaIntg instance;

	
	public static FactoriaIntg getInstance() {
		if(instance == null)
		instance =  new FactoriaIntImp();
		
		return instance;
	}

	public abstract DAODept generarDAODepts();
}