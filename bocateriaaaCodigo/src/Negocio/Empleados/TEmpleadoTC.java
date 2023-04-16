package Negocio.Empleados;

public class TEmpleadoTC extends TransferEmpleados {

	private int salario;
	
	public TEmpleadoTC(String nombre, String apellidos, String DNI,Integer jornada, Integer idDept, Boolean activo, Integer salario) {
		super(nombre, apellidos, DNI, -1, jornada, idDept, activo);
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
