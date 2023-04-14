/**
 * 
 */
package Integracion.Marcas;

import java.util.List;

import Negocio.Marcas.TMarcas;


public interface DAOMarcas {

	public int create(TMarcas tMarca);

	public TMarcas read(Integer id);

	public List<TMarcas> readAll();

	public int update(TMarcas tMarca);

	public int delete(Integer id);
}