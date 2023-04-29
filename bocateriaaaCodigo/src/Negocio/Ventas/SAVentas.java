package Negocio.Ventas;

import java.util.List;
import java.util.Map;

import Negocio.Productos.TProductos;

public interface SAVentas {

	public Integer create(TVentas tVenta);

	public TVentas read(Integer id);

	public List<TVentas> readAll();

	public Integer update(TVentas tVenta);

	public Integer delete(Integer id);
	
	public Integer agregarProd(Map<Integer, List<TProductos>> datos);
	
	public Integer eliminarProd(Map<Integer, List<TProductos>> datos);
	
	public Integer cerrar(Integer id);
	
	public List<TVentas> mostrarVentasEmp(Integer idEmp);
	
	public List<TProductos> mostrarProductosVenta(Integer idVenta);
	
}