package Negocio.Proveedores;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Integracion.FactoriaIntegracion.FactoriaIntg;
import Integracion.Proveedores.DAOProv;
import Integracion.MarcasProv.TMarcasProv;
import Negocio.Factoria.FactoriaNeg;
import Negocio.Marcas.TMarcas;

public class SAProvImpTest {
	
	private final static String _path = "resources/proveedores/proveedores.JSON";

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
		SAProv saProv = FactoriaNeg.getInstance().generarSAProv();
		
		openFile();

		TProveedores p1 = new TProvComunitario (-1, "pane di qualità p.A", 1, true, "Italia");
		p1.setTipo('C');
		TProveedores p2 = new TProvNacional (-1, "Verduras Huerta S.A", 1, true, "Huelva");
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
		assertTrue(provList.size() == 3); //comprobamos que lea todo bien
		
		assertTrue(provList.get(0) instanceof TProvComunitario);
		assertTrue(provList.get(1) instanceof TProvNacional); 

		//PRUEBA DE DELETE()
		resultado = saProv.delete(3);//devuelve el id que ha borrado
		assertEquals(3, resultado,"No ha devuelto el id del proveedor que acaba de dar de baja"); 
		//actualizamos la lista y comprobamos que se ha borrado
		provList = saProv.readAll();
		assertTrue(provList.size() == 3); //el tamaño de la lista no disminuye
		assertTrue(provList.get(2).getActivo() == false);	
	}

	
}