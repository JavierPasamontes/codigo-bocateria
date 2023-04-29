package Integracion.Productos;

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

import Integracion.Departamentos.DAODept;
import Integracion.FactoriaIntegracion.FactoriaIntg;
import Negocio.Departamentos.TDept;
import Negocio.Productos.TProductos;

class DAOProductoImpTest {

private final static String _path = "resources/productos/productos.JSON";
	
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
		DAOProductos daoProd = factoriaIntegracion.generarDAOProductos();
		
		openFile();
		
		TProductos p1 = new TProductos(-1, "Pan", 50, 1.50, true, 1);
		TProductos p2 = new TProductos(-1, "lechuga", 100, 0.50, true, 1);
		
		int id;
		
		//PRUEBA DE CREATE()
		//comprobamos que devuelva el id correcto
		id = daoProd.create(p1);
		assertEquals(1,id,"No ha devuelto el id que acaba de crear");
	
		id = daoProd.create(p2);
		
		//PRUEBA DE READBYNAME()
		//deberian ser iguales el dept 1 y el que se manda a leer por el nombre
		assertEquals(p1,daoProd.readByName("Pan"));
		
		TProductos p3 = new TProductos(-1, "Coca cola Light Zero", 200, 0.89, true, 2);
		TProductos p4 = new TProductos(-1, "Nestea", 150, 0.79, true, 2);
		TProductos p5 = new TProductos(-1, "Aquarius Naranja", 125, 0.85, true, 2);

		
		daoProd.create(p3);
		daoProd.create(p4);
		daoProd.create(p5);

		p2.setNombre("Jamón");
		p2.setPrecio(1.50);
		
		//PRUEBA DE UPDATE()
		daoProd.update(p2);
		//comprobamos que funciona el update
		assertEquals("Jamón", daoProd.read(2).getNombre());
		assertEquals(1.50, daoProd.read(2).getPrecio());
		
		List<TProductos> prodList = new ArrayList<TProductos>();
		
		//PRUEBA DE READALL()
		prodList = daoProd.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(prodList.size() == 5); //comprobamos que lea todo bien
		
		//PRUEBA DE DELETE()
		id = daoProd.delete(2);
		assertEquals(2, id); //devuelve el id que ha borrado
		//actualizamos la lista y comprobamos que se ha borrado
		
		prodList = daoProd.readAll();
		assertTrue(prodList.size() == 5); //el tamaño de la lista no disminuye
		assertTrue(prodList.get(1).getActivo() == false);//el departamento seleccionado 
	}
	
	@Test
	public void erroresComunes() {
		FactoriaIntg factoriaIntegracion = FactoriaIntg.getInstance();
		DAOProductos daoProd = factoriaIntegracion.generarDAOProductos();
		
		openFile();
		
		TProductos p1 = new TProductos(-1, "lechuga", 50, 1.50, true, 3);
		
		//int id = daoProd.create(p1);
		
		/* mirar
		//comprobamos que no pueda crear otro departamento con el mismo id y lanzamos una excepcion
		assertThrowsExactly(IOException.class, () -> {
		daoDept.create(new TDept(1, "sede", "Prueba" ,true, "Una Descripcion"));}
				);
		*/
	}
	
}