/**
 * 
 */
package Integracion.Empleados;

import java.util.List;

import Negocio.Empleados.TEmpleadosTP;
import Negocio.Empleados.TransferEmpleados;

public interface DAOEmpleados {

	DAOEmpleados dAOEmpleados = null;

	DAOEmpleados dAOEmpleados2 = null;

	public int create(TransferEmpleados tEmp);

	public TEmpleadosTP read(Integer id);

	public List<TransferEmpleados> readAll();

	public int update(TransferEmpleados tEmp);

	public int delete(Integer id);

	public void mostrarEmpPorDep(TransferEmpleados tEmp);

	public TransferEmpleados readByDNI(String dni);
}