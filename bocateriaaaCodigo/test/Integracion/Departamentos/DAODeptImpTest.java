/**
 * 
 */
package Integracion.Departamentos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Integracion.FactoriaIntegracion.FactoriaIntg;
import Negocio.Departamentos.TDept;


class DAODeptImpTest {
	
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
		DAODept daoDept = FactoriaIntg.getInstance().generarDAODepts();
		
		openFile();//Funcion que vuelve a crear la Base de Datos
		
		TDept d1 = new TDept(-1, "Cocina", "Madrid,Getafe", true, "Departamento de Cocina");
		TDept d2 = new TDept(-1, "El bocatín", "Sevilla", true, "El bocatín de Sevilla");
		
		//PRUEBA DE CREATE()
		resultado = daoDept.create(d1);
		assertEquals(1,resultado,"No ha devuelto el id que acaba de crear");
		//comprobamos que devuelva el id correcto
		resultado = daoDept.create(d2);
		assertEquals(2,resultado,"No ha devuelto el id que acaba de crear");
		
		//PRUEBA DE READBYNAME()
		assertEquals(d1,daoDept.readByName("Cocina"));
		//deberian ser iguales el dept 1 y el que se manda a leer por el nombre

		TDept p3 = new TDept(-1, "El bocatín Almería", "Almería", true, "El bocatín de Almería");

		resultado = daoDept.create(p3);
		assertEquals(3,resultado,"No ha devuelto el id que acaba de crear");
		
		p3.setNombre("Repartos");
		p3.setSede("Alicante");
		
		//PRUEBA DE UPDATE()
		resultado = daoDept.update(p3);
		//comprobamos que funciona el update
		assertEquals("Repartos", daoDept.read(3).getNombre());
		assertEquals("Alicante", daoDept.read(3).getSede());
		assertEquals(3,resultado,"No ha devuelto el id del departamento que acaba de actualizar");

		
		List<TDept> deptList = new ArrayList<TDept>();
		
		//PRUEBA DE READALL()
		deptList = daoDept.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(deptList.size() == 3); //comprobamos que lea todo bien
		
		//PRUEBA DE DELETE()
		resultado = daoDept.delete(2);
		assertEquals(2, resultado,"No ha devuelto el id del departamento que acaba de dar de baja"); //devuelve el id que ha borrado
		//actualizamos la lista y comprobamos que se ha borrado
		
		deptList = daoDept.readAll();
		assertTrue(deptList.size() == 3); //el tamaño de la lista no disminuye
		assertTrue(deptList.get(1).getActivo() == false);//el departamento seleccionado 
	}

}