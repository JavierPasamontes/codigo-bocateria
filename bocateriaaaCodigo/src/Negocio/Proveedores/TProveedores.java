/**
 * 
 */
package Negocio.Proveedores;

import java.io.Serializable;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author pedro
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class TProveedores implements Serializable {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	protected Integer id;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	protected String nombre;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	protected Boolean activo;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	protected Integer contMarcas;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	protected Character tipo;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer getID() {
		return this.id;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getNombre() {
		return this.nombre;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getOrigen() {
		return null;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Boolean getActivo() {
		return this.activo;
	}
	
	public void setCont(int i) {
		this.contMarcas = i;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer getCont() {
		return this.contMarcas;
	}
	
	
	public void setId(Integer Id) {
		this.id = Id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param activo
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void incrementarMarcas() {
		this.contMarcas++;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void decrementarMarcas() {
		this.contMarcas--;
	}
	
	public Character getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return this.id.toString() + ":" + this.nombre + ":" + getTipo() + ":" + getOrigen() + ":" +getCont().toString() + ":"+ 
	((this.activo) ? "true" : "false") + "\r\n" ; // el \r\n es para forzar utf8, sino japonés
				
	}
	
	public static TProveedores parseProv(String[] aux) {
		if(aux[2].equals("N")) {
			TProveedores prov = new TProvNacional(aux[3]);
			prov.setId(Integer.parseInt(aux[0]));
			prov.setNombre(aux[1]);
			
			prov.setTipo(aux[2].charAt(0));
			prov.setCont(Integer.parseInt(aux[4]));
			
			return prov;
		}
		else {
			TProveedores prov = new TProvComunitario(aux[3]);
			prov.setId(Integer.parseInt(aux[0]));
			prov.setNombre(aux[1]);
			
			prov.setTipo(aux[2].charAt(0));
			prov.setCont(Integer.parseInt(aux[4]));
			prov.setActivo(Boolean.parseBoolean(aux[5]));
			return prov;
		}
	}

}