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
		FactoriaIntg factoriaIntegracion = FactoriaIntg.getInstance();
		DAODept daoDept = factoriaIntegracion.generarDAODepts();
		
		openFile();
		
		TDept d1 = new TDept(-1, "Cocina", "Madrid,Getafe", true, "Departamento de Cocina");
		TDept d2 = new TDept(-1, "El bocatín", "Sevilla", true, "El bocatín de Sevilla");
		
		int id;
		
		//PRUEBA DE CREATE()
		//comprobamos que devuelva el id correcto
		id = daoDept.create(d1);
		assertEquals(1,id,"No ha devuelto el id que acaba de crear");
	
		id = daoDept.create(d2);
		
		//PRUEBA DE READBYNAME()
		//deberian ser iguales el dept 1 y el que se manda a leer por el nombre
		assertEquals(d1,daoDept.readByName("Cocina"));
		
		TDept p3 = new TDept(3, "El bocatín", "Almería", true, "El bocatín de Almería");
		
		daoDept.create(p3);
		
		p3.setNombre("Repartos");
		p3.setSede("Alicante");
		
		//PRUEBA DE UPDATE()
		daoDept.update(p3);
		//comprobamos que funciona el update
		assertEquals("Repartos", daoDept.read(3).getNombre());
		assertEquals("Alicante", daoDept.read(3).getSede());
		
		List<TDept> deptList = new ArrayList<TDept>();
		
		//PRUEBA DE READALL()
		deptList = daoDept.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(deptList.size() == 3); //comprobamos que lea todo bien
		
		//PRUEBA DE DELETE()
		id = daoDept.delete(2);
		assertEquals(2, id); //devuelve el id que ha borrado
		//actualizamos la lista y comprobamos que se ha borrado
		
		deptList = daoDept.readAll();
		assertTrue(deptList.size() == 3); //el tamaño de la lista no disminuye
		assertTrue(deptList.get(1).getActivo() == false);//el departamento seleccionado 
	}
	
	@Test
	public void erroresComunes() {
		FactoriaIntg factoriaIntegracion = FactoriaIntg.getInstance();
		DAODept daoDept = factoriaIntegracion.generarDAODepts();
		
		openFile();
		
		TDept p1 = new TDept(1, "sede", "Prueba1", true, "Una Descripcion");
		
		int id = daoDept.create(p1);
		
		/* mirar
		//comprobamos que no pueda crear otro departamento con el mismo id y lanzamos una excepcion
		assertThrowsExactly(IOException.class, () -> {
		daoDept.create(new TDept(1, "sede", "Prueba" ,true, "Una Descripcion"));}
				);
		*/
	}
	
	
	
	
	
}