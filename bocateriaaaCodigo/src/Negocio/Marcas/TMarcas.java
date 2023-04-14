package Negocio.Marcas;

import java.io.Serializable;

import Negocio.Departamentos.TDept;


public class TMarcas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private Boolean activa;
	private Integer contProductos;

	public TMarcas(Integer id, String nombre, Boolean activa, Integer contProductos) {
		this.id = id;
		this.nombre = nombre;
		this.activa = activa;
		this.contProductos = contProductos;
	}
	
	public Integer getID() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getActiva() {
		return this.activa;
	}
	
	public void setActivo(Boolean activo) {
		this.activa = activo;
	}

	public Integer getCont() {
		return this.contProductos;
	}
	
	public void setCont(Integer cont) {
		this.contProductos = cont;
	}
	
	public void aumentarEmpleados() {
		this.contProductos++;
	}

	public void disminuirEmpleados() {
		this.contProductos--;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof TMarcas) {
			TMarcas mrc = (TMarcas) obj;
			
			if(this.id == mrc.id && this.nombre.equals(mrc.nombre) 
			&& this.activa.equals(mrc.activa) && this.contProductos.equals(mrc.contProductos)
			) {
				return true;
			}
			else return false;
		}
		else return false;
	}
	

}