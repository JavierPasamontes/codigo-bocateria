/**
 * 
 */
package Integracion.FactoriaIntegracion;

import Integracion.Departamentos.DAODept;
import Integracion.Empleados.DAOEmpleados;
import Integracion.Marcas.DAOMarcas;
import Integracion.MarcasProv.DAOProv_Marcas;
import Integracion.Proveedores.DAOProv;

public abstract class FactoriaIntg {
	
	private static FactoriaIntg instance;

	
	public static FactoriaIntg getInstance() {
		if(instance == null)
		instance =  new FactoriaIntImp();
		
		return instance;
	}

	public abstract DAODept generarDAODepts();
	
	public abstract DAOMarcas generarDAOMarcas();
	
	public abstract DAOEmpleados generarDAOEmpleados();
	
	public abstract DAOProv generarDAOProv();
	
	public abstract DAOProv_Marcas generarDAOProvMarcas();
}