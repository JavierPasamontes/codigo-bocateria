package Integracion.Ventas;

import java.util.List;

import Negocio.Ventas.TVentas;

public interface DAOVentas {

	public int create(TVentas tVenta);

	public TVentas read(int id);

	public List<TVentas> readAll();

	public int update(TVentas tVenta);

	public int delete(int id);
}