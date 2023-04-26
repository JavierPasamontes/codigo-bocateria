
package Negocio.Productos;

import java.util.List;

import Integracion.Departamentos.DAODept;
import Integracion.Empleados.DAOEmpleados;
import Integracion.FactoriaIntegracion.FactoriaIntg;
import Integracion.Marcas.DAOMarcas;
import Integracion.Productos.DAOProductos;
import Negocio.Departamentos.TDept;
import Negocio.Empleados.TEmpleados;

public class SAProductosImp implements SAProductos {

	@Override
	public int create(TProductos tProd) {
		int id = -1;

		DAOProductos daoProd = FactoriaIntg.getInstance().generarDAOProv();
		DAOMarcas daoMarcas = FactoriaIntg.getInstance().generarDAODepts();

		TEmpleados empleado = daoEmp.readByDNI(tEmp.getDNI());
		TDept leidoDept = daoDept.read(tEmp.getIdDept());

		if (empleado == null) {
			if (leidoDept != null && leidoDept.isActivo()) {
				id = daoEmp.create(tEmp);
				leidoDept.aumentarEmpleados();
				daoDept.update(leidoDept);
			}
		} else {
			if (!empleado.getActivo() && leidoDept.isActivo()) {
				empleado.setActivo(true);
				leidoDept.aumentarEmpleados();
				daoDept.update(leidoDept);
			}
		}
		return id;
	}

	@Override
	public TProductos read(int id) {

		return null;
	}

	@Override
	public List<TProductos> readAll() {

		return null;
	}

	@Override
	public int update(TProductos tProd) {

		return 0;
	}

	@Override
	public int delete(int id) {

		return 0;
	}

}