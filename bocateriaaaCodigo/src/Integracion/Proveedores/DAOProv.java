/**
 * 
 */
package Integracion.Proveedores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import Negocio.Proveedores.TProveedores;


public interface DAOProv {

	public Integer create(TProveedores prov);

	public TProveedores read(Integer id);

	public Collection<TProveedores> readAll();

	public Integer update(TProveedores prov);

	public TProveedores readByName(String nombre);

	public int delete(Integer id);
}