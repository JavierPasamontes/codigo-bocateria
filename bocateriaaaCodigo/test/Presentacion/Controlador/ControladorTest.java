package Presentacion.Controlador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import Integracion.Departamentos.DAODept;
import Integracion.FactoriaIntegracion.FactoriaIntg;
import Negocio.Departamentos.TDept;

class ControladorTest {
	
	private final static String _path = "resources/departamentos/dept.JSON";
	
	public void openFile() {
		try(BufferedWriter salida = new BufferedWriter(new FileWriter(_path))){
			salida.close();
			}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void departamentos() {
		Controlador controlador = Controlador.getInstance();
		
		openFile();
		
		controlador.accion(Eventos.ALTA_DEPARTAMENTO,new TDept(1, "Alimentos", "Caceres", true, "Descripccion") );
		
		FactoriaIntg factoriaIntegracion = FactoriaIntg.getInstance();
		DAODept daoDept = factoriaIntegracion.generarDAODepts();
		
		assertEquals(daoDept.read(1).getNombre(), "Alimentos", "NO SE HA CREADO EL DEPARTAMENTO");
		
		controlador.accion(Eventos.BAJA_DEPARTAMENTO,1 );
		
		assertEquals(daoDept.read(1), null, "NO SE HA BORRADO EL DEPARTAMENTO");
	}
}