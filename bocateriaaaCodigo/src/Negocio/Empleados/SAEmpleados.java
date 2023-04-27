package Negocio.Empleados;

import java.util.List;

public interface SAEmpleados {
	
	public int create(TEmpleados tEmp);

	public TEmpleados read(int id);

	public List<TEmpleados> readAll();

	public int update(TEmpleados tEmp);

	public int delete(int id);
	
	public List<TEmpleados> readEmpleadosDeDepartamento(int idDept);
}