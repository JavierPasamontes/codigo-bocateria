
package Negocio.Ventas;

import java.io.Serializable;
import java.util.List;

import Negocio.Productos.TProductos;

@SuppressWarnings("serial")
public class TVentas implements Serializable {

	private int id;
	private int idEmpleado;
	private String fechaVenta;
	private double precioFinal;
	private List<TProductos> listaProductos;
	private Boolean abierto;
	
	
	
	public TVentas(int id, int idEmp, String fecha, double precio, List<TProductos> listaProductos){
		this.id = id;
		this.idEmpleado=idEmp;
		this.fechaVenta= fecha;
		this.precioFinal = precio;
		this.listaProductos = listaProductos;
		this.abierto = true;
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
	
	public Boolean getAbierto() {
		return abierto;
	}

	public void setAbierto(Boolean abierto) {
		this.abierto = abierto;
	}
	
	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public void agregarProducto(TProductos prod) {
		listaProductos.add(prod);
	}
	
	public void eliminarProducto(TProductos prod) {
		listaProductos.remove(prod);
	}
	
	public void aumentarPrecio(Double precioProd) {
		precioFinal += precioProd;
	}
	
	public void disminuirPrecio(Double precioProd) {
		precioFinal -= precioProd;
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


	public void setListaProductos(List<TProductos> listaProductos2) {
		// TODO Auto-generated method stub
		
	}

}