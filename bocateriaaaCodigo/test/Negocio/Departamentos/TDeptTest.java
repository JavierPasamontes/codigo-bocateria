/**
 * 
 */
package Negocio.Departamentos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class TDeptTest{
	
	@Test
	public void comportamientoBasico() {
		TDept departamento = new TDept(1,"Prueba", "sede", true, "Una Descripcion");
		
		//comprobamos los getters:
		//getter del Id
		assertEquals(1,departamento.getId());
		//getter de la sede
		assertEquals("sede",departamento.getSede());
		//getter del nombre
		assertEquals("Prueba",departamento.getNombre());
		//getter de la descripcion
		assertEquals("Una Descripcion",departamento.getDescripcion());
		//segun el constructor el activo deberia ser true
		assertTrue(departamento.getActivo()); 
		
		departamento.aumentarEmpleados();
		//comprobamos el aumento de empleados
		assertTrue(departamento.getContEmpleados() == 1); 
		
		departamento.disminuirEmpleados();
		//comprobamos la disminucion de empleados
		assertTrue(departamento.getContEmpleados() == 0); 
	}


}