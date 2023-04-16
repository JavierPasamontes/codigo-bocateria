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
	
	public int create(TransferEmpleados tEmp);

	public TransferEmpleados read(int id);

	public List<TransferEmpleados> readAll();

	public int update(TransferEmpleados tEmp);

	public int delete(int id);
}