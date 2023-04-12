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
public class TProvComunitario extends TProveedores {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private String pais;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProvComunitario(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String getOrigen() {
		return this.pais;
	}
}