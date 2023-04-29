/**
 * 
 */
package Integracion.FactoriaIntegracion;

import Integracion.Departamentos.DAODept;
import Integracion.Empleados.DAOEmpleados;
import Integracion.Marcas.DAOMarcas;
import Integracion.MarcasProv.DAOProv_Marcas;
import Integracion.Productos.DAOProductos;
import Integracion.Proveedores.DAOProv;
import Integracion.Ventas.DAOVentas;

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
	
	public abstract DAOProductos generarDAOProductos();
	
	public abstract DAOVentas generarDAOVentas();
}