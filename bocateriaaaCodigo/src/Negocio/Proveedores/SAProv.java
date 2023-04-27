package Negocio.Proveedores;

import java.util.List;

import Integracion.MarcasProv.TMarcasProv;

public interface SAProv {

	public int create(TProveedores prov);

	public TProveedores read(Integer id);

	public List<TProveedores> readAll();

	public Integer update(TProveedores prov, boolean vinculado);

	public Integer delete(Integer id);

	public Integer vincularMarca(TMarcasProv relacion);

	public Integer desvincularMarca(TMarcasProv relacion);

	public  List<String> mostrarMarcasdeProv(Integer prov);
}