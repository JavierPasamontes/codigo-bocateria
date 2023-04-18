package Negocio.Empleados;

import java.io.Serializable;

public class TEmpleados implements Serializable {
	
	private String nombre;
	private String apellidos;
	private String DNI;
	private Integer id;
	private Integer jornada;
	private Integer idDept;	
	private Integer contVentas;
	private Boolean activo;
		
	
	public TEmpleados(String nombre, String apellidos, String DNI, Integer id,Integer jornada, Integer idDept, Boolean activo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = DNI;
		this.id = id;
		this.jornada = jornada;
		this.idDept = idDept;
		this.contVentas = 0;
		this.activo = activo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getContVentas() {
		return contVentas;
	}

	public void setContVentas(Integer contVentas) {
		this.contVentas = contVentas;
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
	
	public void aumentarVentas(){
		this.contVentas++;
	}
	
	public void disminuirVentas(){
		this.contVentas--;
	}

	public int calcularSalario() {
		return 0;
	}
	

}