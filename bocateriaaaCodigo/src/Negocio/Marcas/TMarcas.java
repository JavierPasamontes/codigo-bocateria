package Negocio.Marcas;

import java.io.Serializable;


public class TMarcas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private Boolean activo;
	private Integer contProductos;
	private String pais;

	public TMarcas(Integer id, String nombre, Boolean activa, Integer contProductos,String pais) {
		this.id = id;
		this.nombre = nombre;
		this.activo = activa;
		this.contProductos = contProductos;
		this.pais = pais;
	}
	
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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

	public Boolean getActivo() {
		return this.activo;
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getCont() {
		return this.contProductos;
	}
	
	public void setCont(Integer cont) {
		this.contProductos = cont;
	}
	
	public void aumentarProductos() {
		this.contProductos++;
	}

	public void disminuirProductos() {
		this.contProductos--;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof TMarcas) {
			TMarcas mrc = (TMarcas) obj;
			
			if(this.id == mrc.id && this.nombre.equalsIgnoreCase(mrc.nombre) 
			&& this.activo == mrc.activo && this.contProductos ==mrc.contProductos
			) {
				return true;
			}
			else return false;
		}
		else return false;
	}
	

}