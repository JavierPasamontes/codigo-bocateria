/**
 * 
 */
package Negocio.Proveedores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import Integracion.FactoriaIntegracion.FactoriaIntg;
import Integracion.Proveedores.DAOProv;
import Integracion.MarcasProv.TMarcasProv;


/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author pedro
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SAProvImp implements SAProv {
	/** 
	* (non-Javadoc)
	* @see SAProv#create(TProveedores prov)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int create(TProveedores prov) {
		
		DAOProv dao = FactoriaIntg.getInstance().generarDAOProv();
		
		TProveedores aux;
		
		aux = dao.readByName(prov.getNombre());
		
		if(aux == null) {
			int id = dao.create(prov);
			return id;
		}
		else {
			if(prov.getActivo()) {
				dao.update(prov);
				return aux.getID();
			}
			else {
				prov.setActivo(true);
				dao.update(prov);
				return aux.getID();
			}
		}
		
		
		
	}

	/** 
	* (non-Javadoc)
	* @see SAProv#read(Integer id)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProveedores read(Integer id) {
		return FactoriaIntg.getInstance().generarDAOProv().read(id);
		
	}

	/** 
	* (non-Javadoc)
	* @see SAProv#readAll()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Collection<TProveedores> readAll() {
		return FactoriaIntg.getInstance().generarDAOProv().readAll();
	}

	/** 
	* (non-Javadoc)
	* @see SAProv#update(TProveedores prov)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer update(TProveedores prov) {
		DAOProv daoProv;
		daoProv = FactoriaIntg.getInstance().generarDAOProv() ;
		
		TProveedores aux =  daoProv.read(prov.getID()) ;
		
		if (prov.getNombre().isEmpty()) {
			prov.setNombre(aux.getNombre());
		}
		if (prov.getOrigen().isEmpty()) {
			//prov.setOrigen(aux.getOrigen());
		}
		if (prov.getTipo() == null )  {
			prov.setTipo(aux.getTipo());
		}
		
		return daoProv.update(prov);
	}

	/** 
	* (non-Javadoc)
	* @see SAProv#delete(Integer id)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
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
	public Collection<String> mostrarMarcasdeProv(String prov) {
		Collection<String> marcas = new ArrayList<String>(); 
		
		
		return marcas;
	}

	/** 
	* (non-Javadoc)
	* @see SAProv#vincularMarca(TMarcaProv relacion)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer vincularMarca(TMarcasProv relacion) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SAProv#desvincularMarca(TMarcaProv relacion)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	
}