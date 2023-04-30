package Integracion.Ventas;

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
import Integracion.Productos.DAOProductos;
import Negocio.Productos.TProductos;
import Negocio.Ventas.TVentas;

class DAOVentasImpTest{
	
	private final static String _path = "resources/ventas/ventas.JSON";
	
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
		DAOVentas daoVentas = FactoriaIntg.getInstance().generarDAOVentas();
		
		openFile();
		
		//creamos la lista de productos
		List<TProductos> prodList = new ArrayList<TProductos>();
		//ID DE MARCA =1 
		TProductos p1 = new TProductos(-1, "Pan", 50, 1.50, true, 1);
		TProductos p2 = new TProductos(-1, "lechuga", 100, 0.50, true, 1);
		//ID DE MARCA =2 
		TProductos p3 = new TProductos(-1, "Coca cola Light Zero", 200, 0.89, true, 2);
		TProductos p4 = new TProductos(-1, "Nestea", 150, 0.79, true, 2);
		TProductos p5 = new TProductos(-1, "Aquarius Naranja", 125, 0.85, true, 2);

		prodList.add(p1);
		prodList.add(p2);
		prodList.add(p3);
		prodList.add(p4);
		prodList.add(p5);
	
		//CREACION DE LAS VENTAS
		TVentas v1 = new TVentas(-1,1,"23/4/2023", 750.65, prodList);
		v1.setAbierto(true);
		TVentas v2 = new TVentas(-1,3,"19/2/2022", 18923.65, prodList);
		v2.setAbierto(true);
		
		
		//PRUEBA DE CREATE()
		resultado = daoVentas.create(v1);
		assertEquals(1,resultado,"No ha devuelto el id que acaba de crear");
		//comprobamos que devuelva el id correcto
		resultado = daoVentas.create(v2);
		assertEquals(2,resultado,"No ha devuelto el id que acaba de crear");

		
		TVentas v3 = new TVentas(-1,3,"30/8/2021", 18923.65, prodList);
		v3.setAbierto(true);

		resultado = daoVentas.create(v3);
		assertEquals(3,resultado,"No ha devuelto el id que acaba de crear");
		
		//PRUEBA DE UPDATE()
		v3.setFechaVenta("22/3/2023");
		v3.setPrecioFinal(2000000.99);
		
		resultado = daoVentas.update(v3);
		//comprobamos que funciona el update
		assertEquals("22/3/2023", daoVentas.read(3).getFechaVenta());
		assertEquals(2000000.99, daoVentas.read(3).getPrecioFinal());
		assertEquals(3,resultado,"No ha devuelto el id de la venta que acaba de actualizar");

		//PRUEBA DE READALL()
		List<TVentas> ventList = new ArrayList<TVentas>();
		
		ventList = daoVentas.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(ventList.size() == 3); //comprobamos que lea todo bien
		
		
		//PRUEBA DE DELETE()
		resultado = daoVentas.delete(2);//devuelve el id que ha borrado
		assertEquals(2, resultado,"No ha devuelto el id de la venta que acaba de actualizar"); 
		//actualizamos la lista y comprobamos que se ha borrado
		ventList = daoVentas.readAll();
		assertTrue(ventList.size() == 2); //el tamaño de la lista disminuye		
	}
	
}