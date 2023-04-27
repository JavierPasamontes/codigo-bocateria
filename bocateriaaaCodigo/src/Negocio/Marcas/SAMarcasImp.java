/**
 * 
 */
package Negocio.Marcas;

import java.util.List;

import Integracion.FactoriaIntegracion.FactoriaIntg;
import Integracion.Marcas.DAOMarcas;

public class SAMarcasImp implements SAMarcas {
	

	public Integer create(TMarcas tMarca) {
		int id = -1;

		DAOMarcas daoMarca = FactoriaIntg.getInstance().generarDAOMarcas();

		TMarcas leido = daoMarca.readByName(tMarca.getNombre());

		if (leido == null) {
			id = daoMarca.create(tMarca);
		} else {
			if (leido.getActivo()) {
				return -1;
			} else {
				leido.setActivo(true);
				tMarca.setId(leido.getID());
				id = daoMarca.update(tMarca);
			}
		}
		return id;
	}
	
	//------------------------------------------

	public TMarcas read(Integer id) {
		return FactoriaIntg.getInstance().generarDAOMarcas().read(id);
	}
	
	//------------------------------------------

	public List<TMarcas> readAll() {
		return FactoriaIntg.getInstance().generarDAOMarcas().readAll();
	}
	
	//------------------------------------------

	public Integer update(TMarcas tMarca) {
		
		DAOMarcas daoMarca = FactoriaIntg.getInstance().generarDAOMarcas();

		TMarcas marca = daoMarca.read(tMarca.getID());

		if (marca.getActivo()) {
			if (tMarca.getNombre().isEmpty())
				tMarca.setNombre(marca.getNombre());
			if (tMarca.getPais().isEmpty())
				tMarca.setPais(marca.getPais());
		}
		else {
			return -1;
		}
		
		return daoMarca.update(tMarca);
	}
	
	//------------------------------------------

	public Integer delete(Integer id) {
		
		DAOMarcas daoMarca = FactoriaIntg.getInstance().generarDAOMarcas();
		
		if(daoMarca.read(id).getCont() == 0)
			return daoMarca.delete(id);
		else
			return -1;
	}
}