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
		FactoriaIntg factoriaIntegracion = FactoriaIntg.getInstance();
		DAOProv daoProv = factoriaIntegracion.generarDAOProv();
		
		openFile();

		TProveedores p1 = new TProvComunitario (-1, "Prueba1", 2, true, "Italia");
		TProveedores p2 = new TProvNacional (-1, "Prueba2", 1, true, "Huelva");
		int id;
		
		//comprobamos que devuelva el id correcto
		id = daoProv.create(p1);
		assertEquals(1,id,"No ha devuelto el id que acaba de crear");
	
		id = daoProv.create(p2);
		
		//deberian ser iguales el dept 1 y el que se manda a leer por el nombre
		//assertEquals(p1,daoMarca.readByName("Prueba1"));
		
		TProveedores p3 = new TProvComunitario (-1, "Prueba3", 3, true, "Alemania");
		
		daoProv.create(p3);
		
		p3.setNombre("ABC");
		
		daoProv.update(p3);
		//comprobamos que funciona el update
		assertEquals("ABC", daoProv.read(3).getNombre());
	//	assertEquals("nuevaSede", daoMarca.read(3).getSede());
		
		List<TProveedores> provList = new ArrayList<TProveedores>();
		
		provList = daoProv.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(provList.size() == 3); //comprobamos que lea todo bien
		
		assertTrue(provList.get(0) instanceof TProvComunitario);
		assertTrue(provList.get(1) instanceof TProvNacional); 

		
		id = daoProv.delete(2);
		assertEquals(2, id); //devuelve el id que ha borrado
		//actualizamos la lista y comprobamos que se ha borrado
		provList = daoProv.readAll();
		assertTrue(provList.size() == 3); //el tamaÃ±o de la lista no disminuye
		assertTrue(provList.get(1).getActivo() == false);	
	}

}