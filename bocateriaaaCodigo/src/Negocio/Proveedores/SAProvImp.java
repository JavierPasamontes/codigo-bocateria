/**
 * 
 */
package Negocio.Proveedores;

import java.util.ArrayList;
import java.util.List;

import Integracion.FactoriaIntegracion.FactoriaIntg;
import Integracion.Proveedores.DAOProv;
import Integracion.MarcasProv.TMarcasProv;
import Negocio.Marcas.TMarcas;


/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author pedro
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SAProvImp implements SAProv {
	
	public int create(TProveedores prov) {
		
		DAOProv dao = FactoriaIntg.getInstance().generarDAOProv();
		
		TProveedores aux;
		prov.setCont(0);
		aux = dao.readByName(prov.getNombre());
		
		if(aux == null) {
			int id = dao.create(prov);
			return id;
		}
		else {
			if(aux.getActivo()) {
				dao.update(prov);
				return aux.getID();
			}
			else {
				prov.setActivo(true);
				prov.setId(aux.getID());
				dao.update(prov);
				return aux.getID();
			}
		}
		
		
		
	}

	@Override
	public TProveedores read(Integer id) {
		return FactoriaIntg.getInstance().generarDAOProv().read(id);
		
	}

	@Override
	public List<TProveedores> readAll() {
		return FactoriaIntg.getInstance().generarDAOProv().readAll();
	}

	@Override
	public Integer update(TProveedores prov, boolean vinculado) {
		String nombre;
		String origen;
		Integer cont;
		DAOProv daoProv;
		daoProv = FactoriaIntg.getInstance().generarDAOProv() ;
		TProveedores aux =  daoProv.read(prov.getID()) ;
		if(aux != null && aux.getActivo()) {
			if (prov.getNombre().isEmpty()) {
				nombre = aux.getNombre();
			}
			else {
				nombre = prov.getNombre();
			}
			
			if(vinculado)
				cont = prov.getCont();
			else
				cont = aux.getCont();
			
			if(prov.getOrigen().isEmpty() ) {
				origen = aux.getOrigen();
			}
			else {
				origen = prov.getOrigen();
			}
		
			TProveedores provDAO;
			if(prov.getTipo().equals('N')) {
				provDAO = new TProvNacional(prov.getID(), nombre, aux.getCont(), true, origen);
				provDAO.setTipo('N');
			}
			else {
				provDAO = new TProvComunitario(prov.getID(), nombre, aux.getCont(), true, origen);
				provDAO.setTipo('C');
			}
			
			provDAO.setCont(cont);
		
		
		return daoProv.update(provDAO);
		}
		return -1;
	}
	
	@Override
	public Integer delete(Integer id) {
		TProveedores aux = read(id);
		
		if(aux == null) {
			return -1;
		}
		else {
			if(aux.getCont() == 0) {
				 FactoriaIntg.getInstance().generarDAOProv().delete(id);
				 return 0;
			}
			else {
				return -2; // -2 -> no borrable, marcas asignadas
			}
		}
	}

	@Override
	public List<String> mostrarMarcasdeProv(Integer prov) {
		List<TMarcasProv> aux;
		List<String> marcas = new ArrayList<String>();
		aux = FactoriaIntg.getInstance().generarDAOProvMarcas().readByID(prov);
		
		for(TMarcasProv rel: aux) {
			String nombre = FactoriaIntg.getInstance().generarDAOMarcas().read(rel.getMarca()).getNombre();
			
			marcas.add(nombre);
		}
		
		
		
		if(marcas.isEmpty())
			return null;
		
		
		return marcas;
	}

	@Override
	public Integer vincularMarca(TMarcasProv relacion) {
		Integer prov = relacion.getProv() ;
		Integer marca = relacion.getMarca();
		
		TProveedores tProv = FactoriaIntg.getInstance().generarDAOProv().read(prov);
		TMarcas  tMarca =  FactoriaIntg.getInstance().generarDAOMarcas().read(marca);
		if( tProv != null && tMarca != null) {
			if(!tProv.getActivo() || !tMarca.getActiva())
				return -1;
			
			if(FactoriaIntg.getInstance().generarDAOProvMarcas().vinculado(prov, marca))
				return -2;//ya esta vinculado
			
			FactoriaIntg.getInstance().generarDAOProvMarcas().vincularMarca(relacion);
			
			tProv.incrementarMarcas();
			
			update(tProv, true);
			
			
			return 1;
		}
		else //no existe la marca o el prov
			return -1;
		
	}

	@Override
	public Integer desvincularMarca(TMarcasProv relacion) {
		Integer prov = relacion.getProv() ;
		Integer marca = relacion.getMarca();
		
		TProveedores tProv = FactoriaIntg.getInstance().generarDAOProv().read(prov);
		TMarcas  tMarca =  FactoriaIntg.getInstance().generarDAOMarcas().read(marca);
		
		if( tProv != null && tMarca != null) {
			if(!tProv.getActivo() || !tMarca.getActiva())
				return -1;
			
			if(!FactoriaIntg.getInstance().generarDAOProvMarcas().vinculado(prov, marca))
				return -2;//no esta vinculado
			
			FactoriaIntg.getInstance().generarDAOProvMarcas().desvincularMarca(relacion);
			
			tProv.decrementarMarcas();
			
			update(tProv, true);
			return 1;
		}
		else //no existe la marca o el prov
			return -1;
		
	}
	
	
	
}