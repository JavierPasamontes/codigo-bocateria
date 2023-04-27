package Negocio.Productos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TProductos implements Serializable {
	
	private Integer id;
	private String nombre;	
	private Integer cantidad;
	private Double precio;
	private Boolean activo;
	private Integer IDmarca;

	
	public TProductos(Integer idProducto, String nombreProducto, Integer cantidadProducto, Double precioProducto,
			Boolean activo, Integer iDmarca) {
		this.id = idProducto;
		this.nombre = nombreProducto;
		this.cantidad = cantidadProducto;
		this.precio = precioProducto;
		this.activo = activo;
		this.IDmarca = iDmarca;
	}
	

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer idProducto) {
		this.id = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombreProducto) {
		this.nombre = nombreProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidadProducto) {
		this.cantidad = cantidadProducto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precioProducto) {
		this.precio = precioProducto;
	}

	public Integer getIDmarca() {
		return IDmarca;
	}

	public void setIDmarca(Integer iDmarca) {
		IDmarca = iDmarca;
	}
	
	public void aumentarCantidad() {
		cantidad++;
	}
	
	public void disminuirCantidad() {
		cantidad--;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TProductos) {
			TProductos prd = (TProductos) obj;
			
			if(this.id == prd.id && this.nombre.equalsIgnoreCase(prd.nombre) 
				&& this.cantidad == prd.cantidad && this.precio == prd.precio
				&& this.activo == prd.activo && this.IDmarca == prd.IDmarca)
			{
				return true;
			}
			else return false;
		}
		else return false;
	}


	
}