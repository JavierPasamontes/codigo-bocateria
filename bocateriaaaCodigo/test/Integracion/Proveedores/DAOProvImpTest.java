package Integracion.Proveedores;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import Integracion.Empleados.DAOEmpleados;
import Integracion.FactoriaIntegracion.FactoriaIntg;
import Negocio.Empleados.TEmpleados;
import Negocio.Empleados.TEmpleadosTC;
import Negocio.Empleados.TEmpleadosTP;
import Negocio.Proveedores.TProvComunitario;
import Negocio.Proveedores.TProvNacional;
import Negocio.Proveedores.TProveedores;


class DAOProvImpTest {
	
	private final static String _path = "resources/proveedores/proveedores.JSON";

	public void openFile() {
		try(BufferedWriter salida = new BufferedWriter(new FileWriter(_path))){
			salida.close();
			}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void comportamientoBasico() {
		int resultado;
		DAOProv daoProv = FactoriaIntg.getInstance().generarDAOProv();
		
		openFile();

		TProveedores p1 = new TProvComunitario (-1, "pane di qualità p.A", 2, true, "Italia");
		TProveedores p2 = new TProvNacional (-1, "Verduras Huerta S.A", 1, true, "Huelva");
		
		//PRUEBA DE CREATE()
		resultado = daoProv.create(p1);
		assertEquals(1,resultado,"No ha devuelto el id que acaba de crear");
		//comprobamos que devuelva el id correcto
		resultado = daoProv.create(p2);
		assertEquals(2,resultado,"No ha devuelto el id que acaba de crear");

	
		TProveedores p3 = new TProvComunitario (-1, "Die Wurst A.G", 3, true, "Alemania");
		
		resultado = daoProv.create(p3);
		assertEquals(3,resultado,"No ha devuelto el id que acaba de crear");

		//PRUEBA DE UPDATE()
		p3.setNombre("hochwertige Saucen A.G");
		
		resultado = daoProv.update(p3);
		//comprobamos que funciona el update
		assertEquals("hochwertige Saucen A.G", daoProv.read(3).getNombre());
		assertEquals(3,resultado,"No ha devuelto el id del proveedor que acaba de actualizar");

		//PRUEBA DE READALL()
		List<TProveedores> provList = new ArrayList<TProveedores>();
		
		provList = daoProv.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(provList.size() == 3); //comprobamos que lea todo bien
		
		assertTrue(provList.get(0) instanceof TProvComunitario);
		assertTrue(provList.get(1) instanceof TProvNacional); 

		//PRUEBA DE DELETE()
		resultado = daoProv.delete(2);//devuelve el id que ha borrado
		assertEquals(2, resultado,"No ha devuelto el id del proveedor que acaba de dar de baja"); 
		//actualizamos la lista y comprobamos que se ha borrado
		provList = daoProv.readAll();
		assertTrue(provList.size() == 3); //el tamaño de la lista no disminuye
		assertTrue(provList.get(1).getActivo() == false);	
	}

}