/**
 * 
 */
package Integracion.Productos;

import java.util.List;

import Negocio.Productos.TProductos;

public interface DAOProductos {

	public int create(TProductos tProducto);

	public TProductos read(int id);

	public List<TProductos> readAll();

	public int update(TProductos tProducto);

	public TProductos readByName(String nombre);

	public int delete(int id);
}