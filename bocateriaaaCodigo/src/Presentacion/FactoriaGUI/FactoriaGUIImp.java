package Presentacion.FactoriaGUI;


import Presentacion.Controlador.Eventos;
import Presentacion.Departamentos.Departamentos.GUIDepartamentos;
import Presentacion.Empleados.Empleados.GUIEmpleados;
import Presentacion.Marcas.Marcas.GUIMarcas;

public class FactoriaGUIImp extends FactoriaGUI {
	private GUIDepartamentos ventanaDep;
	private GUIEmpleados ventanaEmp;
	private GUIMarcas ventanaMarcas;

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
		}
		return null;
	}

	@Override
	public void actualizar(int evento, Object datos) {
		// TODO Auto-generated method stub
		if(evento>1000&&evento<2000) {
			ventanaDep.actualizar(evento, datos);
		}
		if(evento>3000&&evento<4000) {
			ventanaMarcas.actualizar(evento, datos);
		}
	}

}
