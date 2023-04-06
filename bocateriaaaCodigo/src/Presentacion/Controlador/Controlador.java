package Presentacion.Controlador;

public abstract class Controlador {

	private static Controlador instance;

	public static Controlador getInstance() {
		if(instance == null) {
			instance = new ControladorIMP();
		}
		return instance;
	}

	public abstract void accion(int evento, Object datos);
}