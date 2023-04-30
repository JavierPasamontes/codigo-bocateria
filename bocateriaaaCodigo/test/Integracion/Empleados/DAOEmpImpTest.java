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
		int resultado;
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		openFile();
		
		//jornada == 0 -> Empleado a Tiempo Parcial
		//jornada == 1-> Empleado a Tiempo Completo

		TEmpleados e1 = new TEmpleadosTC ("Juan Alberto", "García Pradilla", "34234576N", -1, 1, 1, true, 800);
		TEmpleados e2 = new TEmpleadosTP ("José Luis", "Perales Gutiérrez", "24563187L", -1, 0, 1, true,4 ,20 );		
		
		//PRUEBA DE CREATE()
		resultado = daoEmp.create(e1);	
		assertEquals(1,resultado,"No ha devuelto el id que acaba de crear");
		//comprobamos que devuelva el id correcto
		resultado = daoEmp.create(e2);
		assertEquals(2,resultado,"No ha devuelto el id que acaba de crear");
		
		TEmpleados e3 = new TEmpleadosTC ("Laura", "Pérez Muñoz", "43662196P", -1, 1, 3, true, 1000);
		
		resultado = daoEmp.create(e3);
		assertEquals(3,resultado,"No ha devuelto el id que acaba de crear");
		
		e3.setNombre("Carmen");
		e3.setApellidos("Jiménez López");
		e3.setDNI("56742456D");
		
		//PRUEBA DE UPDATE()
		resultado = daoEmp.update(e3);
		//comprobamos que funciona el update
		assertEquals("Carmen", daoEmp.read(3).getNombre());
		assertEquals("Jiménez López", daoEmp.read(3).getApellidos());
		assertEquals("56742456D", daoEmp.read(3).getDNI());
		assertEquals(3,resultado,"No ha devuelto el id del empleado que acaba de actualizar");


		//PRUEBA DE READALL()
		List<TEmpleados> empList = new ArrayList<TEmpleados>();
		
		empList = daoEmp.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(empList.size() == 3); //comprobamos que lea todo bien
		
		assertTrue(empList.get(0) instanceof TEmpleadosTC); //el primer empleado esta a tiempo completo
		assertTrue(empList.get(1) instanceof TEmpleadosTP);//el segundo empleado esta a tiempo parcial 

		//PRUEBA DE DELETE()
		resultado = daoEmp.delete(2);//devuelve el id que ha borrado
		assertEquals(2, resultado,"No ha devuelto el id del empleado que acaba de dar de baja"); 
		//actualizamos la lista y comprobamos que se ha borrado
		empList = daoEmp.readAll();
		assertTrue(empList.size() == 3); //el tamaño de la lista no disminuye
		assertTrue(empList.get(1).getActivo() == false);	
	}

	
	
	
}