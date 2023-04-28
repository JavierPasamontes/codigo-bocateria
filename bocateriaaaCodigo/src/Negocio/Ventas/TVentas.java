/**
 * 
 */
package Negocio.Ventas;

import java.io.Serializable;
import java.util.List;

import Negocio.Productos.TProductos;

public class TVentas implements Serializable {

	private int id;
	private String fechaVenta;
	private double precioFinal;
	private List<TProductos> listaProductos;
	
	public TVentas(int id, String fecha, double precio, List<TProductos> listaProductos){
		this.id = id;
		this.fechaVenta= fecha;
		this.precioFinal = precio;
		this.listaProductos = listaProductos;
	}


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


	public List<TProductos> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<TProductos> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof TVentas) {
			TVentas vts = (TVentas) obj;
			
			if(this.id == vts.id && this.fechaVenta.equalsIgnoreCase(vts.fechaVenta) 
			&& this.precioFinal == vts.precioFinal && this.listaProductos.equals(vts.listaProductos)) 
			{
				return true;
			}
			else return false;
		}
		else return false;
	}

	


}