package Integracion.Empleados;

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

import Integracion.FactoriaIntegracion.FactoriaIntg;
import Integracion.Marcas.DAOMarcas;
import Negocio.Empleados.TEmpleados;
import Negocio.Empleados.TEmpleadosTP;
import Negocio.Marcas.TMarcas;
import Negocio.Empleados.TEmpleadosTC;


class DAOEmpImpTest{
	
	private final static String _path = "resources/empleados/emp.JSON";
	
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
		DAOEmpleados daoEmp = factoriaIntegracion.generarDAOEmpleados();
		
		openFile();
		
		TEmpleados p1 = new TEmpleadosTC ("Prueba", "numero1", "123X", -1, 5, 1, true, 800);
		TEmpleados p2 = new TEmpleadosTP ("Prueba", "numero2", "321X", -1, 5, 1, true,4 ,20 );		
		int id;
		
		//comprobamos que devuelva el id correcto
		id = daoEmp.create(p1);
		assertEquals(1,id,"No ha devuelto el id que acaba de crear");
	
		id = daoEmp.create(p2);
		
		//deberian ser iguales el dept 1 y el que se manda a leer por el nombre
		//assertEquals(p1,daoMarca.readByName("Prueba1"));
		
		TEmpleados p3 = new TEmpleadosTC ("Prueba", "numero3", "132X", -1, 7, 1, true, 1000);
		
		daoEmp.create(p3);
		
		p3.setNombre("ABC");
		
		daoEmp.update(p3);
		//comprobamos que funciona el update
		assertEquals("ABC", daoEmp.read(3).getNombre());
	//	assertEquals("nuevaSede", daoMarca.read(3).getSede());
		
		List<TEmpleados> empList = new ArrayList<TEmpleados>();
		
		empList = daoEmp.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(empList.size() == 3); //comprobamos que lea todo bien
		
		assertTrue(empList.get(0) instanceof TEmpleadosTC); //el primer empleado esta a tiempo completo
		assertTrue(empList.get(1) instanceof TEmpleadosTP);//el segundo empleado esta a tiempo parcial 

		
		id = daoEmp.delete(2);
		assertEquals(2, id); //devuelve el id que ha borrado
		//actualizamos la lista y comprobamos que se ha borrado
		empList = daoEmp.readAll();
		assertTrue(empList.size() == 3); //el tamaño de la lista no disminuye
		assertTrue(empList.get(1).getActivo() == false);	
	}

	
	
	
}