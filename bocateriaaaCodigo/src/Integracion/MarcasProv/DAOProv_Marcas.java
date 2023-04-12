package Integracion.MarcasProv;

public interface DAOProv_Marcas {

	public int vincularMarca(String prov, String marca);
	
	public int desvincularMarca(String prov, String marca);
}
