
package Negocio.Productos;

import java.io.Serializable;


@SuppressWarnings("serial")
public class TProductos implements Serializable {
	
	private Integer idProducto;
	
	private String nombreProducto;
	
	private Integer cantidadProducto;
	
	private Double precioProducto;
	
	private Boolean activo;
	
	private Integer IDmarca;

	
	
	public TProductos(Integer idProducto, String nombreProducto, Integer cantidadProducto, Double precioProducto,
			Boolean activo, Integer iDmarca) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidadProducto = cantidadProducto;
		this.precioProducto = precioProducto;
		this.activo = activo;
		IDmarca = iDmarca;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	public Integer getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public Integer getCantidadProducto() {
		return cantidadProducto;
	}


	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}


	public Double getPrecioProducto() {
		return precioProducto;
	}


	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}


	public Integer getIDmarca() {
		return IDmarca;
	}


	public void setIDmarca(Integer iDmarca) {
		IDmarca = iDmarca;
	}


	
}