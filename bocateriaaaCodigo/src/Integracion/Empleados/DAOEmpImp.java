package Integracion.Empleados;

import java.util.List;

import Negocio.Empleados.TEmpleadosTP;
import Negocio.Empleados.TransferEmpleados;

public class DAOEmpImp implements DAOEmpleados {
	
	private final static String _path = "resources/empleados/emp.JSON";

	@Override
	public int create(TransferEmpleados tEmp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TEmpleadosTP read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferEmpleados> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(TransferEmpleados tEmp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void mostrarEmpPorDep(TransferEmpleados tEmp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransferEmpleados readByDNI(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	
}