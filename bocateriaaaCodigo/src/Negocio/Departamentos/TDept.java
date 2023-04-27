package Negocio.Departamentos;

import java.io.Serializable;

public class TDept implements Serializable {

	private static final long serialVersionUID = 6296631122731894254L;
	private Integer id;
	private String nombre;
	private String sede;
	private Integer contEmpleados;
	private String descripcion;
	private Boolean activo;
	
	
	public TDept(Integer id, String nombre, String sede, Boolean activo, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sede = sede;
		this.contEmpleados = 0;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getActivo() {
		return activo;
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getContEmpleados() {
		return contEmpleados;
	}
	
	public void setContEmpleados(Integer contEmpleados) {
		this.contEmpleados = contEmpleados;
	}
	
	public void aumentarEmpleados() {
		this.contEmpleados++;
	}
	
	public void disminuirEmpleados() {
		this.contEmpleados--;
	}
	
	public String toString() {
		return "Id: " + this.id
		+ " ;Sede: " + this.sede
		+ " ;Nombre: " + this.nombre
		+ " ;activo: " + this.activo
		+ " ;Descripcion: " + this.descripcion;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TDept) {
			TDept dpt = (TDept) obj;
			
			if(this.id == dpt.id && this.nombre.equalsIgnoreCase(dpt.nombre) 
			&& this.sede.equalsIgnoreCase(dpt.sede) && this.descripcion.equalsIgnoreCase(dpt.descripcion)
			&& this.activo == dpt.activo) {
				return true;
			}
			else return false;
		}
		else return false;
	}
}