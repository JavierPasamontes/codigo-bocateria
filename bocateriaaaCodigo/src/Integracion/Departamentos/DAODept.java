/**
 * 
 */
package Integracion.Departamentos;

import java.util.List;

import Negocio.Departamentos.TDept;


public interface DAODept {

	public int create(TDept tDept);

	public TDept read(Integer id);
	
	public List<TDept> readAll();
	
	public TDept readByName(String nombre);
	
	public int update(TDept tDept);

	public int delete(Integer id);
}