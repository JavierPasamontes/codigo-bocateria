package Negocio.Empleados;

public class TEmpleadosTP extends TransferEmpleados {
	
	private static final long serialVersionUID = 1L;
	
	private int horas;
	private int eurosHora;
	public TEmpleadosTP(String nombre, String apellidos, String DNI, Integer jornada, Integer idDept, Boolean activo,int horas, int eurosHora) {
		super(nombre, apellidos, DNI, -1, jornada, idDept, activo);
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
	@Override 
	public int calcularSalario(){
		return this.eurosHora * this.horas;
	}
}
