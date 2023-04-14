/**
 * 
 */
package Integracion.Empleados;

import java.util.List;

import Negocio.Empleados.TEmpleados;

public interface DAOEmpleados {

	DAOEmpleados dAOEmpleados = null;

	DAOEmpleados dAOEmpleados2 = null;

	public int create(TEmpleados tEmp);

	public TEmpleados read(Integer id);

	public List<TEmpleados> readAll();

	public int update(TEmpleados tEmp);

	public int delete(Integer id);

	public void mostrarEmpPorDep(TEmpleados tEmp);
}