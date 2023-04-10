package Presentacion.FactoriaGUI;


import Presentacion.Departamentos.Departamentos.GUIDepartamentos;

public class FactoriaGUIImp extends FactoriaGUI {
	private GUIDepartamentos ventanaDep=new GUIDepartamentos();

	@Override
	public ObservadorGUI generarGUI(int evento) {
		// TODO Auto-generated method stub
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
