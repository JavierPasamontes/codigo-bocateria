package Negocio.Factoria;

import Negocio.Departamentos.SADepartamento;
import Negocio.Empleados.SAEmpleados;
import Negocio.Marcas.SAMarcas;
import Negocio.Productos.SAProductos;
import Negocio.Proveedores.SAProv;
import Negocio.Ventas.SAVentas;

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
	
	public abstract SAVentas generarSAVentas();
	
}