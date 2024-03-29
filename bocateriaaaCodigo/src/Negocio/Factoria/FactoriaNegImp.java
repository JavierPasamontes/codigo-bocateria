package Negocio.Factoria;

import Negocio.Departamentos.SADepartamento;
import Negocio.Departamentos.SADeptImp;
import Negocio.Empleados.SAEmpleados;
import Negocio.Empleados.SAEmpleadosImp;
import Negocio.Marcas.SAMarcas;
import Negocio.Marcas.SAMarcasImp;
import Negocio.Productos.SAProductos;
import Negocio.Productos.SAProductosImp;
import Negocio.Proveedores.SAProv;
import Negocio.Proveedores.SAProvImp;
import Negocio.Ventas.SAVentas;
import Negocio.Ventas.SAVentasImp;

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
	public SAEmpleados generarSAEmp() {
		return new SAEmpleadosImp();
	}
	
	@Override
	public SAMarcas generarSAMarcas() {
		return new SAMarcasImp();
	}

	@Override
	public SAProductos generarSAProductos() {
		return new SAProductosImp();
	}

	@Override
	public SAVentas generarSAVentas() {
		return new SAVentasImp();
	}
	
}