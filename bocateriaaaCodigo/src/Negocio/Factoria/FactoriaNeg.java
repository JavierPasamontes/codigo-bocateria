package Negocio.Factoria;

import Negocio.Departamentos.SADepartamento;
import Negocio.Empleados.SAEmpleados;
import Negocio.Marcas.SAMarcas;
import Negocio.Marcas.SAMarcasImp;
import Negocio.Productos.SAProductos;
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
	
	public abstract SAEmpleados generarSAEmp();
	
	public abstract SAMarcas generarSAMarcas();
	
	public abstract SAProductos generarSAProductos();
	
}