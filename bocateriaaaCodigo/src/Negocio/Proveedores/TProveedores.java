/**
 * 
 */
package Negocio.Proveedores;

import java.io.Serializable;

public class TProveedores implements Serializable {

	
	protected Integer id;
	protected String nombre;
	protected Boolean activo;
	protected Integer contMarcas;
	protected Character tipo;

	
	public TProveedores(Integer id, String nombre, Integer contMarcas, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		if(contMarcas > 0)
			this.contMarcas = contMarcas;
		else 
			this.contMarcas = 0;
		this.activo = activo;
	}
	
	public Integer getID() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getOrigen() {
		return null;
	}

	public Boolean getActivo() {
		return this.activo;
	}
	
	public void setCont(int i) {
		this.contMarcas = i;
	}

	public Integer getCont() {
		return this.contMarcas;
	}
	
	
	public void setId(Integer Id) {
		this.id = Id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public void incrementarMarcas() {
		this.contMarcas++;
	}


	public void decrementarMarcas() {
		this.contMarcas--;
	}
	
	public Character getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return this.id.toString() + ":" + this.nombre + ":" + getTipo() + ":" + getOrigen() + ":" +getCont().toString() + ":"+ 
	((this.activo) ? "true" : "false") + "\r\n" ; // el \r\n es para forzar utf8, sino japonés
				
	}
	
	
	/*
	public static TProveedores parseProv(String[] aux) {
		if(aux[2].equals("N")) {
			TProveedores prov = new TProvNacional(aux[3]);
			prov.setId(Integer.parseInt(aux[0]));
			prov.setNombre(aux[1]);
			
			prov.setTipo(aux[2].charAt(0));
			prov.setCont(Integer.parseInt(aux[4]));
			
			return prov;
		}
		else {
			TProveedores prov = new TProvComunitario(aux[3]);
			prov.setId(Integer.parseInt(aux[0]));
			prov.setNombre(aux[1]);
			
			prov.setTipo(aux[2].charAt(0));
			prov.setCont(Integer.parseInt(aux[4]));
			prov.setActivo(Boolean.parseBoolean(aux[5]));
			return prov;
		}
	}
	*/

}