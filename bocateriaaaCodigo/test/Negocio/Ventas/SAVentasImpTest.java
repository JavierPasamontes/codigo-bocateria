
package Negocio.Ventas;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import Integracion.Empleados.DAOEmpleados;
import Integracion.FactoriaIntegracion.FactoriaIntg;
import Integracion.Ventas.DAOVentas;
import Negocio.Empleados.TEmpleados;
import Negocio.Factoria.FactoriaNeg;
import Negocio.Productos.TProductos;

public class SAVentasImpTest{
	
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
		SAVentas saVentas = FactoriaNeg.getInstance().generarSAVentas();
		
		openFile();
		
		//creamos la lista de productos
		List<TProductos> prodList = new ArrayList<TProductos>();
	
		//CREACION DE LAS VENTAS
		//ID DE MARCA =1 
		TProductos p1 = new TProductos(1, "Pan", 50, 1.50, true, 1);
		TProductos p2 = new TProductos(2, "lechuga", 100, 0.50, true, 1);
		prodList.add(p1);
		prodList.add(p2);

		TVentas v1 = new TVentas(-1,1,"23/4/2023", 750.65, prodList);

		//ID DE MARCA =2 
		TProductos p3 = new TProductos(3, "Coca cola Light Zero", 200, 0.89, true, 2);
		TProductos p4 = new TProductos(4, "Nestea", 150, 0.79, true, 2);
		TProductos p5 = new TProductos(5, "Aquarius Naranja", 125, 0.85, true, 2);
		prodList.add(p3);
		prodList.add(p4);
		prodList.add(p5);
		TVentas v2 = new TVentas(-1,3,"19/2/2022", 18923.65, prodList);
		
		//PRUEBA DE CREATE()
		resultado = saVentas.create(v1);
		assertEquals(1,resultado,"No ha devuelto el id que acaba de crear");
		//comprobamos que devuelva el id correcto
		resultado = saVentas.create(v2);
		assertEquals(2,resultado,"No ha devuelto el id que acaba de crear");

		
		TVentas v3 = new TVentas(-1,3,"30/8/2021", 18923.65, prodList);
		
		resultado = saVentas.create(v3);
		assertEquals(3,resultado,"No ha devuelto el id que acaba de crear");
		
		//PRUEBA DE UPDATE()
		v3.setFechaVenta("22/3/2023");
		v3.setPrecioFinal(2000000.99);
		
		resultado = saVentas.update(v3);
		//comprobamos que funciona el update
		assertEquals("22/3/2023", saVentas.read(3).getFechaVenta());
		assertEquals(2000000.99, saVentas.read(3).getPrecioFinal());
		assertEquals(3,resultado,"No ha devuelto el id de la venta que acaba de actualizar");

		//PRUEBA DE READALL()
		List<TVentas> ventList = new ArrayList<TVentas>();
		
		ventList = saVentas.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(ventList.size() == 3); //comprobamos que lea todo bien
		
		//PRUEBA DE ELIMINAR PRODUCTO()
		TVentas v4 = new TVentas(-1,1,"23/6/2021", 18923.65, prodList);
		//creamos una nueva venta
		resultado = saVentas.create(v4);
		assertEquals(4,resultado,"No ha devuelto el id que acaba de crear");
		
		//creamos una lista con los productos que se quieren eliminar
		List<TProductos> listaEliminar = new ArrayList<>();
		listaEliminar.add(p3);
		listaEliminar.add(p4);
		listaEliminar.add(p5);

		//creamos el mapa con el id y los productos que se quieren eliminar
		Map<Integer, List<TProductos>> map=new HashMap<>();
		map.put(v4.getId(), listaEliminar);
		
		resultado = saVentas.eliminarProd(map);
		
		assertEquals(4,resultado,"No ha devuelto el id de la venta en la que se han eliminado los productos");
		v4 = saVentas.read(4);//leemos la base de datos actualizada
		assertEquals(2,v4.getListaProductos().size(),"No se han eliminado los productos correctamente");		
		
		map.clear(); //al ser en una interfaz el mapa se formatea constantemente

		//PRUEBA DE AGREGAR PRODUCTO()
		List<TProductos> listaAgregar = new ArrayList<>();
		//ID DE MARCA =1 
		TProductos p6 = new TProductos(6, "Tomate", 75, 0.65, true, 1);
		TProductos p7 = new TProductos(7, "Cebolla", 25, 0.85, true, 1);
		listaAgregar.add(p6);
		listaAgregar.add(p7);
		//agregamos los productos en una lista que pasaremos posteriormente al mapa con el id
		map.put(v4.getId(), listaAgregar);
		resultado = saVentas.agregarProd(map);
		assertEquals(4,resultado,"No ha devuelto el id de la venta en la que se han agregado los productos");
		v4 = saVentas.read(4);//leemos la base de datos actualizada
		assertEquals(4,v4.getListaProductos().size(),"No se han agregado los productos correctamente");
		
		map.clear(); //al ser en una interfaz el mapa se formatea constantemente

		//los volvemos a añadir para ver que funciona
		TVentas v5 = new TVentas(-1,1,"22/8/2020", 30004.90, new ArrayList<TProductos>());
		//creamos una nueva venta
		resultado = saVentas.create(v5);
		assertEquals(5,resultado,"No ha devuelto el id que acaba de crear");
		
		List<TProductos> listafinal = new ArrayList<>();
		listafinal.add(p3);
		listafinal.add(p4);
		listafinal.add(p5);
				
		map.put(v5.getId(), listafinal);
				
		resultado = saVentas.agregarProd(map);
		assertEquals(5,resultado,"No ha devuelto el id de la venta en la que se han agregado los productos");
		v5 = saVentas.read(5);//leemos la base de datos actualizada
		assertEquals(3,v5.getListaProductos().size(),"No se han agregado los productos correctamente");
		
		
		//PRUEBA DE CERRAR LA VENTA()
		resultado = saVentas.cerrar(v4.getId());
		assertEquals(4,resultado,"No ha devuelto el id de la venta que se ha cerrado");
		
		//PRUEBA DE DELETE()
		resultado = saVentas.delete(2);//devuelve el id que ha borrado
		assertEquals(2, resultado,"No ha devuelto el id de la venta que acaba de actualizar"); 
		//actualizamos la lista y comprobamos que se ha borrado
		ventList = saVentas.readAll();
		assertTrue(ventList.size() == 4); //el tamaño de la lista disminuye		
		
		//PRUEBA DE MOSTRAR VENTAS POR EMPLEDO()
		List<TVentas> ventasEmpleado = saVentas.mostrarVentasEmp(3);
		//deberia ser 1 venta, por que la venta 2 se ha eliminado y la venta4 se ha dado de baja
		assertEquals(1,ventasEmpleado.size(),"No se ha devuelto la lista de ventas correctamente");
	}
	
	
	
	

}