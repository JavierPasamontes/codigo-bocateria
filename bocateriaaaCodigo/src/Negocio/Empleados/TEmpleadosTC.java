package Negocio.Empleados;

public class TEmpleadosTC extends TEmpleados {

	private static final long serialVersionUID = 1L;
	private int salario;
	
	public TEmpleadosTC(String nombre, String apellidos, String DNI, Integer id,Integer jornada, Integer idDept, Boolean activo, Integer salario) {
		super(nombre, apellidos, DNI, id, jornada, idDept, activo);
		this.salario = salario;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	@Override
	public int calcularSalario() {
		return salario;
	}
}
