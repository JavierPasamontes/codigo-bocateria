/**
 * 
 */
package Presentacion.Controlador;

import Negocio.Departamentos.SADepartamento;
import Negocio.Departamentos.TDept;
import Negocio.Factoria.FactoriaNeg;

public class ControladorIMP extends Controlador {
	
	public void accion(int evento, Object datos) {
		switch(evento) {
		case Eventos.ALTA_DEPARTAMENTO:
			TDept tDept = (TDept) datos;
			
			SADepartamento saDept = FactoriaNeg.getInstance().generarSADept();
			
			int resultado = saDept.create(tDept);
			
			if(resultado > 0 ) {
				
			}
			else {
				
			}
		}
	}
}