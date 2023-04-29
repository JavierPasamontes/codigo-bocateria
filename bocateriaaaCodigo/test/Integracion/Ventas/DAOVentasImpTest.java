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
		FactoriaIntg factoriaIntegracion = FactoriaIntg.getInstance();
		DAOVentas daoVentas = factoriaIntegracion.generarDAOVentas();
		
		openFile();
		List<TProductos> prodList = new ArrayList<TProductos>();

		TProductos p1 = new TProductos(-1, "Pan", 50, 1.50, true, 1);
		TProductos p2 = new TProductos(-1, "lechuga", 100, 0.50, true, 1);
		
		TProductos p3 = new TProductos(-1, "Coca cola Light Zero", 200, 0.89, true, 2);
		TProductos p4 = new TProductos(-1, "Nestea", 150, 0.79, true, 2);
		TProductos p5 = new TProductos(-1, "Aquarius Naranja", 125, 0.85, true, 2);

		
		prodList.add(p1);
		prodList.add(p2);
		prodList.add(p3);
		prodList.add(p4);
		prodList.add(p5);
	

		TVentas v1 = new TVentas(-1,"23/4/2023", 750.65, prodList);
		TVentas v2 = new TVentas(-1,"19/2/2022", 18923.65, prodList);
		
		int id;
		
		//PRUEBA DE CREATE()
		//comprobamos que devuelva el id correcto
		id = daoVentas.create(v1);
		assertEquals(1,id,"No ha devuelto el id que acaba de crear");
	
		id = daoVentas.create(v2);

		
		TVentas v3 = new TVentas(-1,"30/8/2021", 18923.65, prodList);
		
		
		daoVentas.create(v3);
		
		v3.setFechaVenta("22/3/2023");
		v3.setPrecioFinal(2000000.59);
		
		//PRUEBA DE UPDATE()
		daoVentas.update(v3);
		//comprobamos que funciona el update
		assertEquals("22/3/2023", daoVentas.read(3).getFechaVenta());
		assertEquals(2000000.59, daoVentas.read(3).getPrecioFinal());
		
		List<TVentas> ventList = new ArrayList<TVentas>();
		
		//PRUEBA DE READALL()
		ventList = daoVentas.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(ventList.size() == 3); //comprobamos que lea todo bien
		
		//PRUEBA DE DELETE()
		id = daoVentas.delete(2);
		assertEquals(2, id); //devuelve el id que ha borrado
		//actualizamos la lista y comprobamos que se ha borrado
		
		ventList = daoVentas.readAll();
		assertTrue(ventList.size() == 2); //el tamaño de la lista no disminuye		
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