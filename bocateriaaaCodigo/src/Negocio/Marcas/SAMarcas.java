/**
 * 
 */
package Negocio.Marcas;

import java.util.List;

public interface SAMarcas {

	public Integer create(TMarcas tMarc);

	public TMarcas read(Integer id);

	public List<TMarcas> readAll();

	public Integer update(TMarcas tMarca);

	public Integer delete(Integer id);
}