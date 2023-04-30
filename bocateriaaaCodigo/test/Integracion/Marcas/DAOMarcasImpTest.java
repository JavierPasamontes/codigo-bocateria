
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
		int resultado;
		DAOMarcas daoMarca = FactoriaIntg.getInstance().generarDAOMarcas();
		
		openFile();
		
		TMarcas m1 = new TMarcas(-1, "Hacendado", true, 0,"España");
		TMarcas m2 = new TMarcas(-1, "Coca-Cola", true, 0,"España");		
		
		
		//PRUEBA DE CREATE()
		resultado = daoMarca.create(m1);
		assertEquals(1,resultado,"No ha devuelto el id que acaba de crear");
		//comprobamos que devuelva el id correcto
		resultado = daoMarca.create(m2);
		assertEquals(2,resultado,"No ha devuelto el id que acaba de crear");
		
		
		TMarcas m3 = new TMarcas(3, "El Pozo", true, 0,"España");		
		
		resultado = daoMarca.create(m3);
		assertEquals(3,resultado,"No ha devuelto el id que acaba de crear");

		//PRUEBA DE CREATE()
		m3.setNombre("Pepsi");
		
		resultado = daoMarca.update(m3);
		//comprobamos que funciona el update
		assertEquals("Pepsi", daoMarca.read(3).getNombre());
		assertEquals(3,resultado,"No ha devuelto el id de la marca que acaba de actualizar");

		
		//PRUEBA DE READALL()
		List<TMarcas> marcaList = new ArrayList<TMarcas>();
		
		marcaList = daoMarca.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(marcaList.size() == 3); //comprobamos que lea todo bien
		
		
		//PRUEBA DE DELETE()
		resultado = daoMarca.delete(3); //devuelve el id que ha borrado
		assertEquals(3, resultado,"No ha devuelto el id de la marca que acaba de dar de baja");
		//actualizamos la lista y comprobamos que se ha borrado
		marcaList = daoMarca.readAll();
		assertTrue(marcaList.size() == 3); //el tamaño de la lista no disminuye
		assertTrue(marcaList.get(2).getActivo() == false);	
	}
	
	
}