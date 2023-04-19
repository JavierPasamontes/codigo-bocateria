package Negocio.Departamentos;

import java.util.List;

import Negocio.Empleados.TEmpleados;

public interface SADepartamento {
	
	public int create(TDept tDept);

	public TDept read(Integer id);

	public List<TDept> readAll();

	public int update(TDept tDept);

	public int delete(Integer id);
	
}