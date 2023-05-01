package Integracion.Productos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Integracion.FactoriaIntegracion.FactoriaIntg;
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
		int resultado;
		DAOProductos daoProd = FactoriaIntg.getInstance().generarDAOProductos();
		
		openFile();
		
		TProductos p1 = new TProductos(-1, "Pan", 50, 1.50, true, 1);
		TProductos p2 = new TProductos(-1, "lechuga", 100, 0.50, true, 1);
		
		
		//PRUEBA DE CREATE()
		resultado = daoProd.create(p1);
		assertEquals(1,resultado,"No ha devuelto el id que acaba de crear");
		//comprobamos que devuelva el id correcto
		resultado = daoProd.create(p2);
		assertEquals(2,resultado,"No ha devuelto el id que acaba de crear");

		
		//PRUEBA DE READBYNAME()
		//deberian ser iguales el dept 1 y el que se manda a leer por el nombre
		assertEquals(p1,daoProd.readByName("Pan"));
		
		TProductos p3 = new TProductos(-1, "Coca cola Light Zero", 200, 0.89, true, 2);
		TProductos p4 = new TProductos(-1, "Nestea", 150, 0.79, true, 2);
		TProductos p5 = new TProductos(-1, "Aquarius Naranja", 125, 0.85, true, 2);

		
		resultado = daoProd.create(p3);
		assertEquals(3,resultado,"No ha devuelto el id que acaba de crear");
		resultado = daoProd.create(p4);
		assertEquals(4,resultado,"No ha devuelto el id que acaba de crear");
		resultado = daoProd.create(p5);
		assertEquals(5,resultado,"No ha devuelto el id que acaba de crear");

		
		//PRUEBA DE UPDATE()
		p2.setNombre("Jamon");
		p2.setPrecio(1.50);
		
		resultado = daoProd.update(p2);
		//comprobamos que funciona el update
		assertEquals("Jamon", daoProd.read(2).getNombre());
		assertEquals(1.50, daoProd.read(2).getPrecio());
		assertEquals(2,resultado,"No ha devuelto el id del producto que acaba de actualizar");
		
		//PRUEBA DE READALL()	
		List<TProductos> prodList = new ArrayList<TProductos>();

		prodList = daoProd.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(prodList.size() == 5); //comprobamos que lea todo bien
		
		//PRUEBA DE DELETE()
		resultado = daoProd.delete(2); //devuelve el id que ha borrado
		assertEquals(2, resultado,"No ha devuelto el id del producto que acaba de dar de baja");
		//actualizamos la lista y comprobamos que se ha borrado
		
		prodList = daoProd.readAll();
		assertTrue(prodList.size() == 5); //el tamaño de la lista no disminuye
		assertTrue(prodList.get(1).getActivo() == false);//el departamento seleccionado 
	}	
	
}