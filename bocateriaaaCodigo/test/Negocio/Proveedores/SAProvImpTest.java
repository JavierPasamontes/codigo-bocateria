package Negocio.Proveedores;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Integracion.FactoriaIntegracion.FactoriaIntg;
import Integracion.MarcasProv.DAOProv_Marcas;
import Integracion.MarcasProv.TMarcasProv;
import Negocio.Factoria.FactoriaNeg;

public class SAProvImpTest {
	
	private final static String _path = "resources/proveedores/proveedores.JSON";
	private final static String _path2 = "resources/proveedores/marcasProv.JSON";


	public void openFile() {
		try(BufferedWriter salida = new BufferedWriter(new FileWriter(_path))){
			salida.close();
			}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedWriter salida = new BufferedWriter(new FileWriter(_path2))){
			salida.close();
			}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void comportamientoBasico() {
		int resultado;
		SAProv saProv = FactoriaNeg.getInstance().generarSAProv();
		DAOProv_Marcas daoProvMarcas= FactoriaIntg.getInstance().generarDAOProvMarcas();
		
		openFile();

		TProveedores p1 = new TProvComunitario (-1, "pane di qualita p.A", 0, true, "Italia");
		p1.setTipo('C');
		TProveedores p2 = new TProvNacional (-1, "Verduras Huerta S.A", 0, true, "Huelva");
		p2.setTipo('N');

		//PRUEBA DE CREATE()
		resultado = saProv.create(p1);
		assertEquals(1,resultado,"No ha devuelto el id que acaba de crear");
		//comprobamos que devuelva el id correcto
		resultado = saProv.create(p2);
		assertEquals(2,resultado,"No ha devuelto el id que acaba de crear");

	
		TProveedores p3 = new TProvComunitario (-1, "Die Wurst A.G", 0, true, "Alemania");
		p3.setTipo('C');
		resultado = saProv.create(p3);
		assertEquals(3,resultado,"No ha devuelto el id que acaba de crear");
		
		TProveedores p4 = new TProvNacional (-1, "Servilletas S.A", 0, true, "Cadiz");
		p4.setTipo('N');
		resultado = saProv.create(p4);
		assertEquals(4,resultado,"No ha devuelto el id que acaba de crear");

		
		//PRUEBA DE UPDATE()
		p3.setNombre("hochwertige Saucen A.G");
		
		resultado = saProv.update(p3,true);
		//comprobamos que funciona el update
		assertEquals("hochwertige Saucen A.G", saProv.read(3).getNombre());
		assertEquals(3,resultado,"No ha devuelto el id del proveedor que acaba de actualizar");

		//PRUEBA DE READALL()
		List<TProveedores> provList = new ArrayList<TProveedores>();
		
		provList = saProv.readAll();
		//comprobamos que lee bien el fichero
		assertTrue(provList.size() == 4); //comprobamos que lea todo bien
		
		assertTrue(provList.get(0) instanceof TProvComunitario);
		assertTrue(provList.get(1) instanceof TProvNacional); 
		assertTrue(provList.get(2) instanceof TProvComunitario);
		assertTrue(provList.get(3) instanceof TProvNacional); 

		//PRUEBA DE DELETE()
		resultado = saProv.delete(4);//devuelve el id que ha borrado
		assertEquals(4, resultado,"No ha devuelto el id del proveedor que acaba de dar de baja"); 
		//actualizamos la lista y comprobamos que se ha borrado
		provList = saProv.readAll();
		assertTrue(provList.size() == 4); //el tamaño de la lista no disminuye
		assertTrue(provList.get(3).getActivo() == false);	
		
		//PRUEBA DE VINCULAR MARCA()	
		TMarcasProv r1 =  new TMarcasProv(2,1,true);//proveedor 2(Huerta) : marca 1(Hacendado)
		TMarcasProv r2 =  new TMarcasProv(1,2,true);//proveedor 1(italia) : marca 2(Coca-Cola)
		TMarcasProv r3 =  new TMarcasProv(1,3,true);//proveedor 1(italia) : marca 3(Pepsi)
		TMarcasProv r4 =  new TMarcasProv(3,4,true);//proveedor 3(italia) : marca 4(Heinz)

		resultado = saProv.vincularMarca(r1);
		assertEquals(1,resultado,"No ha popdido vincular la marca");
		resultado = saProv.vincularMarca(r2);
		assertEquals(1,resultado,"No ha popdido vincular la marca");
		resultado = saProv.vincularMarca(r2);
		assertEquals(-2,resultado,"No ha popdido vincular la marca porque ya esta vinculada");
		resultado = saProv.vincularMarca(r3);
		assertEquals(-1,resultado,"No ha popdido vincular la marca porque no esta activa");
		resultado = saProv.vincularMarca(r4);
		assertEquals(1,resultado,"No ha popdido vincular la marca");
		
		//PRUEBA DE MOSTRAR MARCAS DE PROVEEDORES()
		List<String> listaMarcas = saProv.mostrarMarcasdeProv(1);
		assertTrue(listaMarcas.size() == 1); //el proveedor 1 tiene 1 marca
		listaMarcas = saProv.mostrarMarcasdeProv(2);
		assertTrue(listaMarcas.size() == 1); //el proveedor 2 tiene 1 marca
		listaMarcas = saProv.mostrarMarcasdeProv(3);
		assertTrue(listaMarcas.size() == 1); //el proveedor 3 tiene 1 marca
		
		//PRUEBA DE DESVINCULAR MARCA()
		resultado = saProv.desvincularMarca(r1);
		assertEquals(1,resultado,"No ha popdido desvincular la marca");
		resultado = saProv.desvincularMarca(r2);
		assertEquals(1,resultado,"No ha popdido desvincular la marca");
		//comprobamos que se hayan eliminado
		assertFalse(daoProvMarcas.vinculado(2, 1)); //el proveedor 1 tiene 0 marcas
		assertFalse(daoProvMarcas.vinculado(1, 2)); //el proveedor 1 tiene 0 marcas
		
		
		//las volvemos a añadir
		resultado = saProv.vincularMarca(r1);
		assertEquals(1,resultado,"No ha popdido vincular la marca");
		resultado = saProv.vincularMarca(r2);
		assertEquals(1,resultado,"No ha popdido vincular la marca");
		

		
		
	}

	
}