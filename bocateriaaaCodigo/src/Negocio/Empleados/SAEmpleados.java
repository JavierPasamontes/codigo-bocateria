/**
 * 
 */
package Negocio.Empleados;

import java.util.List;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface SAEmpleados {
	
	public int create(TEmpleados tEmp);

	public TEmpleados read(int id);

	public List<TEmpleados> readAll();

	public int update(TEmpleados tEmp);

	public int delete(int id);
}