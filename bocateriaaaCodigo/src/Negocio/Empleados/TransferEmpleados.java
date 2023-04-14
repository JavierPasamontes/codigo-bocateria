/**
 * 
 */
package Negocio.Empleados;

import java.io.Serializable;

public class TransferEmpleados implements Serializable {
	
	private String nombre;
	
	private String apellidos;
	
	private String DNI;
	
	private Integer jornada;
	
	private Integer idDept;
	
	private Boolean activo;
	
	
	public TransferEmpleados(String nombre, String apellidos, String DNI, Integer jornada, Integer idDept,
			Boolean activo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = DNI;
		this.jornada = jornada;
		this.idDept = idDept;
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Integer getJornada() {
		return jornada;
	}

	public void setJornada(Integer jornada) {
		this.jornada = jornada;
	}

	public Integer getIdDept() {
		return idDept;
	}

	public void setIdDept(Integer idDept) {
		this.idDept = idDept;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public int calcularSalario() {
		return 0;
		
	}
	
	

}