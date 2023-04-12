package Negocio.Empleados;

public class TransferEmpleadosTP extends TransferEmpleados {
	private int horas;
	private int eurosHora;
	public TransferEmpleadosTP(String nombre, String apellidos, String DNI, Integer jornada, Integer idDept, Boolean activo,int horas, int eurosHora) {
		super(nombre, apellidos, DNI, jornada, idDept, activo);
		this.horas = horas;
		this.eurosHora = eurosHora;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getEurosHora() {
		return eurosHora;
	}
	public void setEurosHora(int eurosHora) {
		this.eurosHora = eurosHora;
	}
	
}
