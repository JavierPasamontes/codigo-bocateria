/**
 * 
 */
package Negocio.Proveedores;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author pedro
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TProvNacional extends TProveedores {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private String comunidad;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProvNacional(String com) {
		this.comunidad = com;
	}
	
	@Override
	public String getOrigen() {
		return this.comunidad;
	}
}