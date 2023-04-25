
package Integracion.Marcas;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import Integracion.FactoriaIntegracion.FactoriaIntg;
import Negocio.Marcas.TMarcas;


class DAOMarcasImpTest {

private final static String _path = "resources/marcas/marcas.JSON";
	
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
		DAOMarcas daoMarca = factoriaIntegracion.generarDAOMarcas();
		
		openFile();
		
		TMarcas p1 = new TMarcas(1, "Prueba1", true, 0,"Italia");
		TMarcas p2 = new TMarcas(2, "Prueba2", true, 0,"Suiza");		
		int id;
		
		//comprobamos que devuelva el id correcto
		id = daoMarca.create(p1);
		assertEquals(1,id,"No ha devuelto el id que acaba de crear");
	
		id = daoMarca.create(p2);
		
		//deberian ser iguales el dept 1 y el que se manda a leer por el nombre
		//assertEquals(p1,daoMarca.readByName("Prueba1"));
		
		TMarcas p3 = new TMarcas(3, "Prueba3", true, 0,"Eslovenia");		
		
		daoMarca.create(p3);
		
		p3.setNombre("ABC");
		
		daoMarca.update(p3);
		//comprobamos que funciona el update
		assertEquals("ABC", daoMarca.read(3).getNombre());
	//	assertEquals("nuevaSede", daoMarca.read(3).getSede());
		
		List<TMarcas> marcaList = new ArrayList<TMarcas>();
		
		marcaList = daoMarca.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(marcaList.size() == 3); //comprobamos que lea todo bien
		
		id = daoMarca.delete(2);
		assertEquals(2, id); //devuelve el id que ha borrado
		//actualizamos la lista y comprobamos que se ha borrado
		marcaList = daoMarca.readAll();
		assertTrue(marcaList.size() == 3); //el tamaño de la lista no disminuye
		assertTrue(marcaList.get(1).getActivo() == false);	
	}
	
	@Test
	public void erroresComunes() {
		FactoriaIntg factoriaIntegracion = FactoriaIntg.getInstance();
		DAOMarcas daoMarca = factoriaIntegracion.generarDAOMarcas();
		
		openFile();
		
		TMarcas p1 = new TMarcas(1, "Prueba1", true, 0,"a");
		int id;
		
		//comprobamos que devuelva el id correcto
		id = daoMarca.create(p1);
		
		/* mirar
		//comprobamos que no pueda crear otro departamento con el mismo id y lanzamos una excepcion
		assertThrowsExactly(IOException.class, () -> {
		daoDept.create(new TDept(1, "sede", "Prueba" ,true, "Una Descripcion"));}
				);
		*/
	}
	
	
}