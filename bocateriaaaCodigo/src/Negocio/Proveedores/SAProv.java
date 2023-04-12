/**
 * 
 */
package Negocio.Proveedores;

import java.util.Collection;

import Integracion.MarcasProv.TMarcasProv;


/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author pedro
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface SAProv {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param prov
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int create(TProveedores prov);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProveedores read(Integer id);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	 * @return 
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Collection<TProveedores> readAll();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param prov
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer update(TProveedores prov);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer delete(Integer id);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param relacion
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public default Integer vincularMarca(TMarcasProv relacion) {
		
		return null;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param relacion
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public default Integer desvincularMarca(TMarcasProv relacion){
		
		
		return null;
	}
	

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param prov
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public  Collection<String> mostrarMarcasdeProv(String prov);
}