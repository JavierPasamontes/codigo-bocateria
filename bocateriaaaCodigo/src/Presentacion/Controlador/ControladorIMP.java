package Presentacion.Controlador;

import java.util.List;
import java.util.Map;

import Integracion.MarcasProv.TMarcasProv;
import Negocio.Departamentos.SADepartamento;
import Negocio.Departamentos.TDept;
import Negocio.Empleados.SAEmpleados;
import Negocio.Empleados.TEmpleados;
import Negocio.Factoria.FactoriaNeg;
import Negocio.Marcas.SAMarcas;
import Negocio.Marcas.TMarcas;
import Negocio.Productos.SAProductos;
import Negocio.Productos.TProductos;
import Negocio.Proveedores.SAProv;
import Negocio.Proveedores.TProveedores;
import Negocio.Ventas.SAVentas;
import Negocio.Ventas.TVentas;
import Presentacion.FactoriaGUI.FactoriaGUI;

public class ControladorIMP extends Controlador {

	@SuppressWarnings("unchecked")
	public void accion(int evento, Object datos) {

		int resultado;
		TDept tDept;
		SADepartamento saDept;
		TProveedores tProv;
		SAProv saProv;
		TEmpleados tEmp;
		SAEmpleados saEmp;
		TMarcas tMarcas;
		SAMarcas saMarcas;
		TProductos tProd;
		SAProductos saProd;
		TVentas tVentas;
		SAVentas saVentas;

		switch (evento) {
		
		//GUI PRINCIPAL-----------------------------------------
		
		case Eventos.VISTA_PRINCIPAL:
			FactoriaGUI.getInstance().generarGUI(evento);
			break;

		// DEPARTAMENTOS----------------------------------------

		case Eventos.VISTA_DEPARTAMENTOS:
			FactoriaGUI.getInstance().generarGUI(evento);
			break;

		case Eventos.ALTA_DEPARTAMENTO:

			tDept = (TDept) datos;

			saDept = FactoriaNeg.getInstance().generarSADept();

			resultado = saDept.create(tDept);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_DEPARTAMENTO_OK, resultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_DEPARTAMENTO_KO, null);
			}
			break;

		case Eventos.BAJA_DEPARTAMENTO:

			saDept = FactoriaNeg.getInstance().generarSADept();

			resultado = saDept.delete((Integer) datos);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_DEPARTAMENTO_OK, datos);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_DEPARTAMENTO_KO, datos);
			}
			break;
		case Eventos.MODIFICAR_DEPARTAMENTO:

			tDept = (TDept) datos;

			saDept = FactoriaNeg.getInstance().generarSADept();

			resultado = saDept.update(tDept);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_DEPARTAMENTO_OK, tDept);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_DEPARTAMENTO_KO, tDept);
			}
			break;
		case Eventos.MOSTRAR_DEPARTAMENTO:

			saDept = FactoriaNeg.getInstance().generarSADept();

			TDept tResultadoDept = saDept.read((Integer) datos);

			if (tResultadoDept != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTO_OK, tResultadoDept);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTO_KO, datos);
			}
			break;

		case Eventos.MOSTRAR_DEPARTAMENTOS:

			saDept = FactoriaNeg.getInstance().generarSADept();

			List<TDept> ltResultadoDept = saDept.readAll();

			if (ltResultadoDept.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTOS_OK, ltResultadoDept);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTOS_KO, null);
			}
			break;

		// PROVEEDORES----------------------------------------

		case Eventos.VISTA_PROVEEDOR:
			FactoriaGUI.getInstance().generarGUI(evento);
			break;

		case Eventos.ALTA_PROVEEDOR:
			tProv = (TProveedores) datos;
			saProv = FactoriaNeg.getInstance().generarSAProv();

			resultado = saProv.create(tProv);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_PROVEEDOR_OK, resultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_PROVEEDOR_KO, null);
			}
			break;

		case Eventos.BAJA_PROVEEDOR:
			saProv = FactoriaNeg.getInstance().generarSAProv();
			resultado = saProv.delete((Integer) datos);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_PROVEEDOR_OK, datos);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_PROVEEDOR_KO, datos);
			}
			break;

		case Eventos.MODIFICAR_PROVEEDOR:
			tProv = (TProveedores) datos;
			saProv = FactoriaNeg.getInstance().generarSAProv();

			resultado = saProv.update(tProv, false);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_PROVEEDOR_OK, tProv);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_PROVEEDOR_KO, tProv);
			}
			break;

		case Eventos.BUSCAR_PROVEEDOR:
			saProv = FactoriaNeg.getInstance().generarSAProv();

			tProv = saProv.read((Integer) datos);

			if (tProv != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.BUSCAR_PROVEEDOR_OK, tProv);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.BUSCAR_PROVEEDOR_KO, datos);
			}
			break;

		case Eventos.MOSTRAR_PROVEEDORES:
			saProv = FactoriaNeg.getInstance().generarSAProv();

			List<TProveedores> ltResultadoProv = saProv.readAll();

			if (ltResultadoProv.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PROVEEDORES_OK, ltResultadoProv);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PROVEEDORES_KO, null);
			}
			break;

		case Eventos.VINCULAR_MARCA:
			TMarcasProv rel = (TMarcasProv) datos;
			saProv = FactoriaNeg.getInstance().generarSAProv();

			resultado = saProv.vincularMarca(rel);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.VINCULAR_MARCA_OK, resultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.VINCULAR_MARCA_KO, resultado);
			}
			break;

		case Eventos.DESVINCULAR_MARCA:
			TMarcasProv rel1 = (TMarcasProv) datos;
			saProv = FactoriaNeg.getInstance().generarSAProv();

			resultado = saProv.desvincularMarca(rel1);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.DESVINCULAR_MARCA_OK, resultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.DESVINCULAR_MARCA_KO, resultado);
			}
			break;

		case Eventos.MOSTRAR_MARCAS_DE_PROV:
			Integer id = (Integer) datos;

			saProv = FactoriaNeg.getInstance().generarSAProv();

			List<String> resultadoMarcasProv = saProv.mostrarMarcasdeProv(id);

			if (resultadoMarcasProv.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_MARCAS_DE_PROV_OK, resultadoMarcasProv);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.VINCULAR_MARCA_KO, resultadoMarcasProv);
			}
			break;

		// EMPLEADOS----------------------------------------

		case Eventos.VISTA_EMPLEADOS:
			FactoriaGUI.getInstance().generarGUI(evento);
			break;

		case Eventos.ALTA_EMPLEADO:
			tEmp = (TEmpleados) datos;
			saEmp = FactoriaNeg.getInstance().generarSAEmp();

			resultado = saEmp.create(tEmp);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_EMPLEADO_OK, resultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_EMPLEADO_KO, null);
			}
			break;

		case Eventos.BAJA_EMPLEADO:
			saEmp = FactoriaNeg.getInstance().generarSAEmp();

			resultado = saEmp.delete((Integer) datos);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_EMPLEADO_OK, datos);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_EMPLEADO_KO, datos);
			}
			break;

		case Eventos.MODIFICAR_EMPLEADO:
			tEmp = (TEmpleados) datos;
			saEmp = FactoriaNeg.getInstance().generarSAEmp();

			resultado = saEmp.update(tEmp);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_EMPLEADO_OK, tEmp);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_EMPLEADO_KO, tEmp);
			}
			break;

		case Eventos.MOSTRAR_EMPLEADO:
			saEmp = FactoriaNeg.getInstance().generarSAEmp();

			TEmpleados tResultado1 = saEmp.read((Integer) datos);

			if (tResultado1 != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADO_OK, tResultado1);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADO_KO, datos);
			}
			break;

		case Eventos.MOSTRAR_EMPLEADOS:
			saEmp = FactoriaNeg.getInstance().generarSAEmp();

			List<TEmpleados> ltResultadoEmp = saEmp.readAll();

			if (ltResultadoEmp.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADOS_OK, ltResultadoEmp);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADOS_KO, null);
			}
			break;

		case Eventos.MOSTRAR_EMPLEADOS_DEPARTAMENTO:
			saEmp = FactoriaNeg.getInstance().generarSAEmp();

			List<TEmpleados> ltResultadoEmp1 = saEmp.readEmpleadosDeDepartamento((Integer) datos);

			if (ltResultadoEmp1 != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADOS_DEPARTAMENTO_OK, ltResultadoEmp1);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADOS_DEPARTAMENTO_KO, null);
			}
			break;

		// MARCAS----------------------------------------

		case Eventos.VISTA_MARCAS:
			FactoriaGUI.getInstance().generarGUI(evento);
			break;

		case Eventos.ALTA_MARCAS:
			tMarcas = (TMarcas) datos;
			saMarcas = FactoriaNeg.getInstance().generarSAMarcas();

			resultado = saMarcas.create(tMarcas);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_MARCAS_OK, resultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_MARCAS_KO, null);
			}
			break;

		case Eventos.BAJA_MARCAS:
			saMarcas = FactoriaNeg.getInstance().generarSAMarcas();

			resultado = saMarcas.delete((Integer) datos);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_MARCAS_OK, datos);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_MARCAS_KO, datos);
			}
			break;

		case Eventos.MODIFICAR_MARCAS:
			tMarcas = (TMarcas) datos;
			saMarcas = FactoriaNeg.getInstance().generarSAMarcas();

			resultado = saMarcas.update(tMarcas);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_MARCAS_OK, tMarcas);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_MARCAS_KO, tMarcas);
			}
			break;

		case Eventos.MOSTRAR_MARCA:
			saMarcas = FactoriaNeg.getInstance().generarSAMarcas();

			TMarcas tResultadoM = saMarcas.read((Integer) datos);

			if (tResultadoM != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_MARCA_OK, tResultadoM);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_MARCA_KO, datos);
			}
			break;

		case Eventos.MOSTRAR_MARCAS:
			saMarcas = FactoriaNeg.getInstance().generarSAMarcas();

			List<TMarcas> ltResultadoMarca = saMarcas.readAll();

			if (ltResultadoMarca.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_MARCAS_OK, ltResultadoMarca);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_MARCAS_KO, null);
			}
			break;

		// PRODUCTOS----------------------------------------

		case Eventos.VISTA_PRODUCTOS:
			FactoriaGUI.getInstance().generarGUI(evento);
			break;

		case Eventos.ALTA_PRODUCTO:
			tProd = (TProductos) datos;
			saProd = FactoriaNeg.getInstance().generarSAProductos();

			resultado = saProd.create(tProd);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_PRODUCTO_OK, resultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_PRODUCTO_KO, null);
			}
			break;

		case Eventos.BAJA_PRODUCTO:
			saProd = FactoriaNeg.getInstance().generarSAProductos();

			resultado = saProd.delete((Integer) datos);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_PRODUCTO_OK, datos);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_PRODUCTO_KO, datos);
			}
			break;

		case Eventos.MODIFICAR_PRODUCTO:
			tProd = (TProductos) datos;
			saProd = FactoriaNeg.getInstance().generarSAProductos();

			resultado = saProd.update(tProd);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_PRODUCTO_OK, tProd);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_PRODUCTO_KO, tProd);
			}
			break;

		case Eventos.MOSTRAR_PRODUCTO:
			saProd = FactoriaNeg.getInstance().generarSAProductos();

			TProductos tResultadoProd = saProd.read((Integer) datos);

			if (tResultadoProd != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PRODUCTO_OK, tResultadoProd);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PRODUCTO_KO, datos);
			}
			break;

		case Eventos.MOSTRAR_PRODUCTOS:
			saProd = FactoriaNeg.getInstance().generarSAProductos();

			List<TProductos> ltResultadoProd = saProd.readAll();

			if (ltResultadoProd.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PRODUCTOS_OK, ltResultadoProd);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PRODUCTOS_KO, null);
			}
			break;

		case Eventos.MOSTRAR_PRODUCTOS_MARCA:
			saProd = FactoriaNeg.getInstance().generarSAProductos();

			List<TProductos> ltResultadoProd1 = saProd.readProductosDeMarca((Integer) datos);

			if (ltResultadoProd1 != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PRODUCTOS_MARCA_OK, ltResultadoProd1);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PRODUCTOS_MARCA_KO, null);
			}
			break;

		// VENTAS----------------------------------------

		case Eventos.VISTA_VENTAS:
			FactoriaGUI.getInstance().generarGUI(evento);
			break;

		case Eventos.ALTA_VENTA:
			tVentas = (TVentas) datos;
			saVentas = FactoriaNeg.getInstance().generarSAVentas();

			resultado = saVentas.create(tVentas);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_VENTA_OK, resultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.ALTA_VENTA_KO, null);
			}
			break;

		case Eventos.BAJA_VENTA:
			saVentas = FactoriaNeg.getInstance().generarSAVentas();

			resultado = saVentas.delete((Integer) datos);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_VENTA_OK, datos);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.BAJA_VENTA_KO, datos);
			}
			break;

		case Eventos.CERRAR_VENTA:
			saVentas = FactoriaNeg.getInstance().generarSAVentas();

			resultado = saVentas.cerrar((Integer) datos);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.CERRAR_VENTA_OK, datos);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.CERRAR_VENTA_KO, datos);
			}
			break;

		case Eventos.MODIFICAR_VENTA:
			tVentas = (TVentas) datos;
			saVentas = FactoriaNeg.getInstance().generarSAVentas();

			resultado = saVentas.update(tVentas);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_VENTA_OK, tVentas);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_VENTA_KO, tVentas);
			}
			break;

		case Eventos.AGREGAR_PRODUCTO_VENTA:
			saVentas = FactoriaNeg.getInstance().generarSAVentas();

			Map<Integer, List<TProductos>> mapaVentas = (Map<Integer, List<TProductos>>) datos;

			resultado = saVentas.agregarProd(mapaVentas);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.AGREGAR_PRODUCTO_VENTA_OK, resultado);
			} 
			else {
				FactoriaGUI.getInstance().actualizar(Eventos.AGREGAR_PRODUCTO_VENTA_KO, null);
			}
			break;

		case Eventos.ELIMINAR_PRODUCTO_VENTA:
			saVentas = FactoriaNeg.getInstance().generarSAVentas();

			Map<Integer, List<TProductos>> mapaVentas1 = (Map<Integer, List<TProductos>>) datos;

			resultado = saVentas.eliminarProd(mapaVentas1);

			if (resultado >= 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.ELIMINAR_PRODUCTO_VENTA_OK, resultado);
			} 
			else {
				FactoriaGUI.getInstance().actualizar(Eventos.ELIMINAR_PRODUCTO_VENTA_KO, null);
			}
			break;

		case Eventos.MOSTRAR_VENTA:
			saVentas = FactoriaNeg.getInstance().generarSAVentas();

			TVentas tResultadoVentas = saVentas.read((Integer) datos);

			if (tResultadoVentas != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_VENTA_OK, tResultadoVentas);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_VENTA_KO, datos);
			}
			break;

		case Eventos.MOSTRAR_VENTAS:
			saVentas = FactoriaNeg.getInstance().generarSAVentas();

			List<TVentas> ltResultadoVentas = saVentas.readAll();

			if (ltResultadoVentas.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_VENTAS_OK, ltResultadoVentas);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_VENTAS_KO, null);
			}
			break;

		case Eventos.MOSTRAR_VENTAS_EMPLEADO:
			saVentas = FactoriaNeg.getInstance().generarSAVentas();

			List<TVentas> ltResultadoVentas1 = saVentas.mostrarVentasEmp((Integer) datos);

			if (ltResultadoVentas1 != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_VENTAS_EMPLEADO_OK, ltResultadoVentas1);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_VENTAS_EMPLEADO_KO, null);
			}
			break;

		case Eventos.MOSTRAR_PRODUCTOS_VENTA:
			saVentas = FactoriaNeg.getInstance().generarSAVentas();
			
			List<TProductos> ltProductosVenta = saVentas.mostrarProductosVenta((Integer) datos);
			if (ltProductosVenta != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PRODUCTOS_VENTA_OK, ltProductosVenta);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PRODUCTOS_VENTA_KO, null);
			}
			break;
			
		case Eventos.MOSTRAR_PRODUCTOS_AUX:
			saProd = FactoriaNeg.getInstance().generarSAProductos();

			List<TProductos> ltResultadoProdAux = saProd.readAll();

			if (ltResultadoProdAux.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PRODUCTOS_AUX_OK, ltResultadoProdAux);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PRODUCTOS_AUX_KO, null);
				
			}
			break;

		}

	}
}