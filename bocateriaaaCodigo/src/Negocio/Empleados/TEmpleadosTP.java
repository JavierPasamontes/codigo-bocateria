package Negocio.Empleados;

@SuppressWarnings("serial")
public class TEmpleadosTP extends TEmpleados {
	
	private int horas;
	private int eurosHora;
	
	
	public TEmpleadosTP(String nombre, String apellidos, String DNI, Integer id, Integer jornada, Integer idDept, Boolean activo,int horas, int eurosHora) {
		super(nombre, apellidos, DNI, id, jornada, idDept, activo);
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
