/**
 * 
 */
package Integracion.Empleados;

import java.util.List;

import Negocio.Empleados.TEmpleados;

public class DAOEmpImp implements DAOEmpleados {
	
	private final static String _path = "resources/empleados/emp.JSON";

	@Override
	public int create(TEmpleados tEmp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TEmpleados read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TEmpleados> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(TEmpleados tEmp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void mostrarEmpPorDep(TEmpleados tEmp) {
		// TODO Auto-generated method stub
		
	}

	
}