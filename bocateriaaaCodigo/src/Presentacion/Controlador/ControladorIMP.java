package Presentacion.Controlador;

import java.util.List;

import Negocio.Departamentos.SADepartamento;
import Negocio.Departamentos.TDept;
import Negocio.Factoria.FactoriaNeg;
import Presentacion.FactoriaGUI.FactoriaGUI;

public class ControladorIMP extends Controlador {

	public void accion(int evento, Object datos) {

		TDept tDept;
		SADepartamento saDept;
		int resultado;

		switch (evento) {

		case Eventos.VISTA_DEPARTAMENTOS:
			FactoriaGUI.getInstance().generarGUI(evento);
			break;

		case Eventos.ALTA_DEPARTAMENTO:

			tDept = (TDept) datos;

			saDept = FactoriaNeg.getInstance().generarSADept();

			resultado = saDept.create(tDept);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_DEPARTAMENTO_OK, resultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_DEPARTAMENTO_KO, null);
			}
			break;

		case Eventos.BAJA_DEPARTAMENTO:

			saDept = FactoriaNeg.getInstance().generarSADept();

			resultado = saDept.delete((Integer) datos);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_DEPARTAMENTO_OK, datos);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_DEPARTAMENTO_KO, datos);
			}
			break;
		case Eventos.MODIFICAR_DEPARTAMENTO:

			tDept = (TDept) datos;

			saDept = FactoriaNeg.getInstance().generarSADept();

			resultado = saDept.update(tDept);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_DEPARTAMENTO_OK, tDept);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_DEPARTAMENTO_KO, tDept);
			}
			break;
		case Eventos.MOSTRAR_DEPARTAMENTO:

			saDept = FactoriaNeg.getInstance().generarSADept();

			TDept tResultado = saDept.read((Integer) datos);

			if (tResultado != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTO_OK, tResultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTO_KO, datos);
			}
			break;

		case Eventos.MOSTRAR_DEPARTAMENTOS:

			saDept = FactoriaNeg.getInstance().generarSADept();

			List<TDept> ltResultado = saDept.readAll();

			if (ltResultado.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTOS_OK, ltResultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTOS_KO, null);
			}
			break;

			
		//Parte de empleados del switch
			
			
		case Eventos.VISTA_EMPLEADOS:
			FactoriaGUI.getInstance().generarGUI(evento);
			break;

		case Eventos.ALTA_EMPLEADO:

			tDept = (TDept) datos;

			saDept = FactoriaNeg.getInstance().generarSADept();

			resultado = saDept.create(tDept);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_EMPLEADO_OK, resultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_EMPLEADO_KO, null);
			}
			break;

		case Eventos.BAJA_EMPLEADO:

			saDept = FactoriaNeg.getInstance().generarSADept();

			resultado = saDept.delete((Integer) datos);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_EMPLEADO_OK, datos);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_EMPLEADO_KO, datos);
			}
			break;
		case Eventos.MODIFICAR_EMPLEADO:

			tDept = (TDept) datos;

			saDept = FactoriaNeg.getInstance().generarSADept();

			resultado = saDept.update(tDept);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_EMPLEADO_OK, tDept);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_EMPLEADO_KO, tDept);
			}
			break;
		case Eventos.MOSTRAR_EMPLEADO:

			saDept = FactoriaNeg.getInstance().generarSADept();

			TDept tResultado1 = saDept.read((Integer) datos);

			if (tResultado1 != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADO_OK, tResultado1);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADO_KO, datos);
			}
			break;

		case Eventos.MOSTRAR_EMPLEADOS:

			saDept = FactoriaNeg.getInstance().generarSADept();

			List<TDept> ltResultado1 = saDept.readAll();

			if (ltResultado1.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADOS_OK, ltResultado1);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADOS_KO, null);
			}
			break;
		
		}
		
	}
}