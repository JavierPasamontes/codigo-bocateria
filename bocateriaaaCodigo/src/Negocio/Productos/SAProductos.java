/**
 * 
 */
package Negocio.Productos;

import java.util.List;

public interface SAProductos {
	
	public int create(TProductos tProd);

	public TProductos read(int id);

	public List<TProductos> readAll();

	public int update(TProductos tProd);

	public int delete(int id);
	
	public List<TProductos> readProductosDeMarca(int idMarca);
}