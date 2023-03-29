/**
 * 
 */
package Negocio.Factoria;

import Negocio.Departamentos.SADepartamento;
import Negocio.Departamentos.SADeptImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaNegImp extends FactoriaNeg {

	@Override
	public SADepartamento generarSADept() {
		return new SADeptImp();
	}
}