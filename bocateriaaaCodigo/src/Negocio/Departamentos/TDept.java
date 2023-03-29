/**
 * 
 */
package Negocio.Departamentos;

import java.io.Serializable;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author usuario_local
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class TDept implements Serializable {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Integer id;

	public Integer getId() {
		// begin-user-code
		return id;
		// end-user-code
	}

	/** 
	* @param id the id to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setId(Integer id) {
		// begin-user-code
		this.id = id;
		// end-user-code
	}

	
	private String sede;

	/** 
	* @return the sede
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getSede() {
		// begin-user-code
		return sede;
		// end-user-code
	}

	/** 
	* @param sede the sede to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setSede(String sede) {
		// begin-user-code
		this.sede = sede;
		// end-user-code
	}

	
	private String nombre;

	/** 
	* @return the nombre
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getNombre() {
		// begin-user-code
		return nombre;
		// end-user-code
	}

	/** 
	* @param nombre the nombre to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setNombre(String nombre) {
		// begin-user-code
		this.nombre = nombre;
		// end-user-code
	}

	private String descripcion;

	/** 
	* @return the descripcion
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getDescripcion() {
		// begin-user-code
		return descripcion;
		// end-user-code
	}

	/** 
	* @param descripcion the descripcion to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setDescripcion(String descripcion) {
		// begin-user-code
		this.descripcion = descripcion;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Boolean activo;

	/** 
	* @return the activo
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Boolean isActivo() {
		// begin-user-code
		return activo;
		// end-user-code
	}

	/** 
	* @param activo the activo to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setActivo(Boolean activo) {
		// begin-user-code
		this.activo = activo;
		// end-user-code
	}

	private Integer contEmpleados;

	/** 
	* @return the contEmpleados
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer getContEmpleados() {
		// begin-user-code
		return contEmpleados;
		// end-user-code
	}

	/** 
	* @param contEmpleados the contEmpleados to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setContEmpleados(Integer contEmpleados) {
		// begin-user-code
		this.contEmpleados = contEmpleados;
		// end-user-code
	}

	
	public void Constructor() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	
	public void aumentarEmpleados() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	
	public void disminuirEmpleados() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}