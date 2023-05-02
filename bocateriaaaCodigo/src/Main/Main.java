package Main;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

public class Main {
	public static void main(String[] args) {
		Controlador.getInstance().accion(Eventos.VISTA_PRINCIPAL, null);
	}
}
