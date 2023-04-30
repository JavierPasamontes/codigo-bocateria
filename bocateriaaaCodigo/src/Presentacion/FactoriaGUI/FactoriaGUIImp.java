package Presentacion.FactoriaGUI;


import Presentacion.Controlador.Eventos;
import Presentacion.Departamentos.Departamentos.GUIDepartamentos;
import Presentacion.Empleados.Empleados.GUIEmpleados;
import Presentacion.Marcas.Marcas.GUIMarcas;
import Presentacion.Productos.Productos.GUIProductos;
import Presentacion.Proveedores.Proveedores.GUIProveedores;
import Presentacion.Ventas.Ventas.GUIVentas;

public class FactoriaGUIImp extends FactoriaGUI {
	private GUIDepartamentos ventanaDep;
	private GUIEmpleados ventanaEmp;
	private GUIMarcas ventanaMarcas;
	private GUIProveedores ventanaProv;
	private GUIProductos ventanaProductos;
	private GUIVentas ventanaVentas;

	@Override
	public ObservadorGUI generarGUI(int evento) {
		switch(evento) {
		case Eventos.VISTA_DEPARTAMENTOS:{
			ventanaDep=new GUIDepartamentos();
			break;
		}
		case Eventos.VISTA_EMPLEADOS:{
			ventanaEmp=new GUIEmpleados();
			break;
		}
		case Eventos.VISTA_PROVEEDOR:{
			ventanaProv = new GUIProveedores();
			break;
		}
		case Eventos.VISTA_MARCAS:{
			ventanaMarcas = new GUIMarcas();
			break;
		}
		case Eventos.VISTA_PRODUCTOS:{
			ventanaProductos = new GUIProductos();
			break;
		}
		case Eventos.VISTA_VENTAS:{
			ventanaVentas = new GUIVentas();
			break;
		}
		}
		return null;
	}

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento>1000&&evento<2000) {
			ventanaDep.actualizar(evento, datos);
		}
		if(evento>3000&&evento<4000) {
			ventanaEmp.actualizar(evento, datos);
		}
		if(evento>2000 && evento < 3000) {
			ventanaProv.actualizar(evento, datos);
		}
		if(evento>4000 && evento < 5000) {
			ventanaMarcas.actualizar(evento, datos);
		}
		if(evento>5000 && evento < 6000) {
			ventanaProductos.actualizar(evento, datos);
		}
		if(evento>6000 && evento < 7000) {
			ventanaVentas.actualizar(evento, datos);
		}
	}

}
