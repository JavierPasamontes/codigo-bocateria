package Presentacion.Controlador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Integracion.Departamentos.DAODept;
import Integracion.FactoriaIntegracion.FactoriaIntg;
import Negocio.Departamentos.TDept;

class ControladorTest {
	
	
	@Test
	void departamentos() {
		Controlador controlador = Controlador.getInstance();
		
		controlador.accion(Eventos.ALTA_DEPARTAMENTO,new TDept(1, "Alimentos", "Caceres", true, "Descripccion") );
		
		FactoriaIntg factoriaIntegracion = FactoriaIntg.getInstance();
		DAODept daoDept = factoriaIntegracion.generarDAODepts();
		
		assertEquals(daoDept.read(1).getNombre(), "Alimentos", "NO SE HA CREADO EL DEPARTAMENTO");
		
		controlador.accion(Eventos.BAJA_DEPARTAMENTO,1 );
		
		assertEquals(daoDept.read(1), null, "NO SE HA BORRADO EL DEPARTAMENTO");
	}
}