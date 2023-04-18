/**
 * 
 */
package Integracion.Proveedores;

import java.util.List;

import Negocio.Proveedores.TProveedores;


public interface DAOProv {

	public Integer create(TProveedores tProv);

	public TProveedores read(Integer id);

	public List<TProveedores> readAll();

	public Integer update(TProveedores tProv);

	public TProveedores readByName(String nombre);

	public int delete(Integer id);
}