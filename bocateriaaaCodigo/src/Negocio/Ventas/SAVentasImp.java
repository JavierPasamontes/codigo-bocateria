
package Negocio.Ventas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import Integracion.Empleados.DAOEmpleados;
import Integracion.FactoriaIntegracion.FactoriaIntg;
import Integracion.Ventas.DAOVentas;
import Negocio.Empleados.TEmpleados;
import Negocio.Productos.TProductos;

public class SAVentasImp implements SAVentas {

	@Override
	public Integer create(TVentas tVenta) {
		DAOVentas daoVentas = FactoriaIntg.getInstance().generarDAOVentas();
		DAOEmpleados daoEmp = FactoriaIntg.getInstance().generarDAOEmpleados();
		
		TEmpleados empleado = daoEmp.read(tVenta.getIdEmpleado());
		
		if(empleado != null && empleado.getActivo()) {
			return daoVentas.create(tVenta);
		}
		else
			return -1;
	}
	
	//------------------------------------------

	@Override
	public TVentas read(Integer id) {
		return FactoriaIntg.getInstance().generarDAOVentas().read(id);
	}
	
	//------------------------------------------

	@Override
	public List<TVentas> readAll() {
		return FactoriaIntg.getInstance().generarDAOVentas().readAll();
	}
	
	//------------------------------------------

	@Override
	public Integer update(TVentas tVenta) {
		DAOVentas daoVentas = FactoriaIntg.getInstance().generarDAOVentas();
		
		TVentas venta = daoVentas.read(tVenta.getId());
		
		if(venta != null && venta.getIdEmpleado() != tVenta.getIdEmpleado() && venta.getAbierto()) {
			venta.setIdEmpleado(tVenta.getIdEmpleado());
			return daoVentas.update(venta);
		}
		else
			return -1;
	}
	
	//------------------------------------------

	@Override
	public Integer delete(Integer id) {//HABLAR A WASHINGTON
		return 0;
	}
	
	//------------------------------------------

	@Override
	public Integer agregarProd(Map<Integer, List<TProductos>> datos) {
		DAOVentas daoVentas = FactoriaIntg.getInstance().generarDAOVentas();
		
		Integer idVenta = (Integer)datos.keySet().toArray()[0];
		TVentas tVenta = daoVentas.read(idVenta);
		
		if(tVenta != null && tVenta.getAbierto()) {
			for(TProductos producto : datos.get(idVenta)) {
				if(tVenta.getListaProductos().contains(producto)) {
					tVenta.agregarProducto(producto);
					tVenta.aumentarPrecio(producto.getPrecio());
				}
				else
					return -1;
			}
			
			return daoVentas.update(tVenta);
		}
		
		return -1;
	}
	
	//------------------------------------------

	@Override
	public Integer eliminarProd(Map<Integer, List<TProductos>> datos) {
		DAOVentas daoVentas = FactoriaIntg.getInstance().generarDAOVentas();
		
		Integer idVenta = (Integer)datos.keySet().toArray()[0];
		TVentas tVenta = daoVentas.read(idVenta);
		
		if(tVenta != null && tVenta.getAbierto()) {
			for(TProductos producto : datos.get(idVenta)) {
				if(tVenta.getListaProductos().contains(producto)) {
					tVenta.eliminarProducto(producto);
					tVenta.disminuirPrecio(producto.getPrecio());
				}
				else
					return -1;
			}
			return daoVentas.update(tVenta);
		}
		else
			return -1;
	}
	
	//------------------------------------------

	@Override
	public Integer cerrar(Integer id) {
		DAOVentas daoVentas = FactoriaIntg.getInstance().generarDAOVentas();
		
		TVentas tVenta = daoVentas.read(id);
		
		if(tVenta != null && tVenta.getAbierto()) {
			tVenta.setAbierto(false);
			
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			tVenta.setFechaVenta(timeStamp);
			
			return daoVentas.update(tVenta);
		}
		else
			return -1;
	}
	
	//------------------------------------------

	@Override
	public List<TVentas> mostrarVentasEmp(Integer idEmp) {
		DAOVentas daoVentas = FactoriaIntg.getInstance().generarDAOVentas();
		
		List<TVentas> ltVentasEmp = new ArrayList<TVentas>();
		
		for(TVentas venta : daoVentas.readAll()) {
			if(venta.getIdEmpleado() == idEmp) {
				ltVentasEmp.add(venta);
			}
		}
		return ltVentasEmp;
	}
	
	//------------------------------------------

	@Override
	public List<TProductos> mostrarProductosVenta(Integer idVenta) {
		DAOVentas daoVentas = FactoriaIntg.getInstance().generarDAOVentas();
		
		TVentas tVenta = daoVentas.read(idVenta);
		
		if(tVenta != null)
			return tVenta.getListaProductos();
		else
			return null;
	}

}