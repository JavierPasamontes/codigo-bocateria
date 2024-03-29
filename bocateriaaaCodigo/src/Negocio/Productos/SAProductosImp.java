
package Negocio.Productos;

import java.util.ArrayList;
import java.util.List;

import Integracion.FactoriaIntegracion.FactoriaIntg;
import Integracion.Marcas.DAOMarcas;
import Integracion.Productos.DAOProductos;
import Negocio.Marcas.TMarcas;

public class SAProductosImp implements SAProductos {

	@Override
	public int create(TProductos tProd) {
		int id = -1;

		DAOProductos daoProd = FactoriaIntg.getInstance().generarDAOProductos();
		DAOMarcas daoMarcas = FactoriaIntg.getInstance().generarDAOMarcas();

		TProductos producto = daoProd.readByName(tProd.getNombre());
		TMarcas leidoMarca = daoMarcas.read(tProd.getIDmarca());

		if (producto == null) {
			if (leidoMarca != null && leidoMarca.getActivo()) { //SI NO EXISTE LO CREA
				id = daoProd.create(tProd);
				leidoMarca.aumentarProductos();;
				daoMarcas.update(leidoMarca);
			}
		} else {
			if(!leidoMarca.getID().equals(producto.getIDmarca())) { //SI EXISTE CON OTRA MARCA LO CREA
				id = daoProd.create(tProd);
				leidoMarca.aumentarProductos();;
				daoMarcas.update(leidoMarca);
			}
			else if (!producto.getActivo() && leidoMarca.getActivo()) { // SI EXISTE NO ACTIVO CON MARCA ACTIVA, LO ACTIVA
				producto.setActivo(true);
				leidoMarca.aumentarProductos();
				daoMarcas.update(leidoMarca);
			}
		}
		return id;
	}
	
	//------------------------------------------

	@Override
	public TProductos read(int id) {
		DAOProductos daoProd = FactoriaIntg.getInstance().generarDAOProductos();
		return daoProd.read(id);
	}

	//------------------------------------------
	
	@Override
	public List<TProductos> readAll() {
		return FactoriaIntg.getInstance().generarDAOProductos().readAll();
	}
	
	//------------------------------------------

	@Override
	public int update(TProductos tProd) {
		DAOProductos daoProd = FactoriaIntg.getInstance().generarDAOProductos();
		
		TProductos producto = daoProd.read(tProd.getId());
		
		if(producto.getActivo()){
			if (!tProd.getNombre().isEmpty())
				producto.setNombre(tProd.getNombre());
			
			if (tProd.getCantidad() != null)
				producto.setCantidad(tProd.getCantidad());
			
			if (tProd.getPrecio() != null)
				producto.setPrecio(tProd.getPrecio());
			
			if (tProd.getIDmarca() != null && tProd.getIDmarca() != producto.getIDmarca()) {
				DAOMarcas daoMarcas = FactoriaIntg.getInstance().generarDAOMarcas();
				TMarcas viejo = daoMarcas.read(producto.getIDmarca());
				TMarcas nuevo = daoMarcas.read(tProd.getIDmarca());
			
				if(nuevo.getActivo()){
					viejo.disminuirProductos();
					daoMarcas.update(viejo);
					nuevo.aumentarProductos();
					daoMarcas.update(nuevo);
					
					producto.setIDmarca(tProd.getIDmarca());
				}
				else
					return -1;
			}
		}
		else
			return -1;
		
		return daoProd.update(producto);
	
	}
	
	//------------------------------------------

	@Override
	public int delete(int id) {
		DAOProductos daoProd = FactoriaIntg.getInstance().generarDAOProductos();
		TProductos producto = daoProd.read(id);
		
		if(producto != null && producto.getActivo()) {
			DAOMarcas daoMarcas = FactoriaIntg.getInstance().generarDAOMarcas();
			TMarcas leidoMarca = daoMarcas.read(producto.getIDmarca());
			
			daoProd.delete(id);
			
			leidoMarca.disminuirProductos();;
			daoMarcas.update(leidoMarca);
			
			return id;
		}
		else 
			return -1;

	}
	
	//------------------------------------------
	
	public List<TProductos> readProductosDeMarca(int idMarca){
		
		DAOProductos daoProd = FactoriaIntg.getInstance().generarDAOProductos();
		DAOMarcas daoMarcas = FactoriaIntg.getInstance().generarDAOMarcas();
		
		if(daoMarcas.read(idMarca) == null) {
			return null;
		}
		
		List<TProductos> prodMarca = new ArrayList<TProductos>(); 
		
		List<TProductos> listaProductos = daoProd.readAll();
		
		for(TProductos prod: listaProductos) {
			if (prod.getIDmarca()== idMarca) {
				prodMarca.add(prod);
			}
		}
		
		return prodMarca;
	}

}