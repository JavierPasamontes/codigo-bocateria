package Integracion.MarcasProv;

import java.util.List;

public interface DAOProv_Marcas {

	public int vincularMarca(TMarcasProv r);
	
	public int desvincularMarca(TMarcasProv r);
	
	public List<TMarcasProv> readByID(Integer ID);
	
	public boolean vinculado(Integer prov, Integer marca);
}
