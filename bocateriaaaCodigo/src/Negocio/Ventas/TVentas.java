/**
 * 
 */
package Negocio.Ventas;

import java.io.Serializable;


@SuppressWarnings("serial")
public class TVentas implements Serializable {

	public TVentas(Integer id, String fechaVenta, Double precioFinal, Object listaProductos) {
		super();
		this.id = id;
		this.fechaVenta = fechaVenta;
		this.precioFinal = precioFinal;
		this.listaProductos = listaProductos;
	}
	
	private Integer id;

	private String fechaVenta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public Object getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(Object listaProductos) {
		this.listaProductos = listaProductos;
	}

	private Double precioFinal;

	private Object listaProductos;

	
}