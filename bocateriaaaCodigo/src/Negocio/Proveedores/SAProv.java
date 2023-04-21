/**
 * 
 */
package Negocio.Proveedores;

import java.util.List;

import Integracion.MarcasProv.TMarcasProv;


/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author pedro
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
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