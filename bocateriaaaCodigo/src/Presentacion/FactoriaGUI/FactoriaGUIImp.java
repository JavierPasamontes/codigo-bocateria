package Presentacion.FactoriaGUI;


import Presentacion.Controlador.Eventos;
import Presentacion.Departamentos.Departamentos.GUIDepartamentos;

public class FactoriaGUIImp extends FactoriaGUI {
	private GUIDepartamentos ventanaDep;

	@Override
	public ObservadorGUI generarGUI(int evento) {
		switch(evento) {
		case Eventos.VISTA_DEPARTAMENTOS:{
			ventanaDep=new GUIDepartamentos();
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
	}

}
