/**
 * 
 */
package Negocio.Departamentos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Negocio.Factoria.FactoriaNeg;

class SADeptImpTest {
	
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
	public void comportamientoBasico() {
		int resultado;
		SADepartamento saDept = FactoriaNeg.getInstance().generarSADept();
		
		openFile();
		
		TDept d1 = new TDept(-1, "Cocina", "Madrid,Getafe", true, "Departamento de Cocina");
		TDept d2 = new TDept(-1, "El bocatin", "Sevilla", true, "El bocatin de Sevilla");
		
		//PRUEBA DE CREATE()
		resultado = saDept.create(d1);
		assertEquals(1,resultado,"No ha devuelto el id que acaba de crear");
		//comprobamos que devuelva el id correcto		
		resultado = saDept.create(d2);
		assertEquals(2,resultado,"No ha devuelto el id que acaba de crear");
		
		TDept d3 = new TDept(3, "El bocatin Almeria", "Almeria", true, "El bocatin de Almeria");
		
		resultado = saDept.create(d3);
		assertEquals(3,resultado,"No ha devuelto el id que acaba de crear");
	
		d3.setNombre("Repartos");
		d3.setSede("Alicante");
		
		//PRUEBA DE UPDATE()
		resultado = saDept.update(d3);
		//comprobamos que funciona el update
		assertEquals("Repartos", saDept.read(3).getNombre());
		assertEquals("Alicante", saDept.read(3).getSede());
		assertEquals(3,resultado,"No ha devuelto el id del departamento que acaba de actualizar");

		//PRUEBA DE READALL()
		List<TDept> deptList = new ArrayList<TDept>();

		deptList = saDept.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(deptList.size() == 3); //comprobamos que lea todo bien
		
		//PRUEBA DE DELETE()
		resultado = saDept.delete(2); //devuelve el id que ha borrado
		assertEquals(2, resultado,"No ha devuelto el id del departamento que acaba de dar de baja");
		//actualizamos la lista y comprobamos que se ha borrado
		
		deptList = saDept.readAll();
		assertTrue(deptList.size() == 3); //el tamaño de la lista no disminuye
		assertTrue(deptList.get(1).getActivo() == false);//el departamento seleccionado 
	}
	
}