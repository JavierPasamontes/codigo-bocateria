package Presentacion.Controlador;

import java.util.List;

import Integracion.MarcasProv.TMarcasProv;
import Negocio.Departamentos.SADepartamento;
import Negocio.Departamentos.TDept;
import Negocio.Empleados.SAEmpleados;
import Negocio.Empleados.TEmpleados;
import Negocio.Factoria.FactoriaNeg;
import Negocio.Marcas.SAMarcas;
import Negocio.Marcas.TMarcas;
import Negocio.Proveedores.SAProv;
import Negocio.Proveedores.TProveedores;
import Presentacion.FactoriaGUI.FactoriaGUI;

public class ControladorIMP extends Controlador {

	public void accion(int evento, Object datos) {

		TDept tDept;
		SADepartamento saDept;
		int resultado;
		TProveedores prov;
		SAProv saProv;
		TEmpleados tEmp;
		SAEmpleados saEmp;
		SAMarcas saMarcas;
		TMarcas tMarcas;

		switch (evento) {

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

			TDept tResultado = saDept.read((Integer) datos);

			if (tResultado != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTO_OK, tResultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTO_KO, datos);
			}
			break;

		case Eventos.MOSTRAR_DEPARTAMENTOS:

			saDept = FactoriaNeg.getInstance().generarSADept();

			List<TDept> ltResultado = saDept.readAll();

			if (ltResultado.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTOS_OK, ltResultado);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_DEPARTAMENTOS_KO, null);
			}
			break;

			
			
			//Proveedores
			case Eventos.VISTA_PROV:
				FactoriaGUI.getInstance().generarGUI(evento);
				break;
			case Eventos.ALTA_PROV:
				prov = (TProveedores) datos;
				
				saProv = FactoriaNeg.getInstance().generarSAProv();
				
				resultado = saProv.create(prov);
				
				if (resultado >= 0) {
					FactoriaGUI.getInstance().actualizar(Eventos.ALTA_PROV_OK, resultado);
				} else {
					FactoriaGUI.getInstance().actualizar(Eventos.ALTA_PROV_KO, null);
				}
				break;
			case Eventos.BAJA_PROV:
				saProv = FactoriaNeg.getInstance().generarSAProv();

				resultado = saProv.delete((Integer) datos);

				if (resultado >= 0) {
					FactoriaGUI.getInstance().actualizar(Eventos.BAJA_PROV_OK, datos);
				} else {
					FactoriaGUI.getInstance().actualizar(Eventos.BAJA_PROV_KO, datos);
				}
				break;
				
				
			case Eventos.MODIFICAR_PROV:

				prov = (TProveedores) datos;

				saProv = FactoriaNeg.getInstance().generarSAProv();
				
				resultado = saProv.update(prov, false);

				if (resultado >= 0) {
					FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_PROV_OK, prov);
				} else {
					FactoriaGUI.getInstance().actualizar(Eventos.MODIFICAR_PROV_KO, prov);
				}
				break;
				
			case Eventos.BUSCAR_PROV:
				saProv = FactoriaNeg.getInstance().generarSAProv();

				TProveedores tResultadoP = saProv.read((Integer) datos);

				if (tResultadoP != null) {
					FactoriaGUI.getInstance().actualizar(Eventos.BUSCAR_PROV_OK, tResultadoP);
				} else {
					FactoriaGUI.getInstance().actualizar(Eventos.BUSCAR_PROV_KO, datos);
				}
				break;
				
			case Eventos.MOSTRAR_PROVS:

				saProv = FactoriaNeg.getInstance().generarSAProv();

				List<TProveedores> ltResultado3 = saProv.readAll();

				if (ltResultado3.size() > 0) {
					FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PROVS_OK, ltResultado3);
				} else {
					FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_PROVS_KO, null);
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
				
			case Eventos.MOSTRAR_M_DE_P:
				
				Integer id = (Integer) datos;
				
				saProv = FactoriaNeg.getInstance().generarSAProv();
				
				List <String> resultadoMP = saProv.mostrarMarcasdeProv(id);
				
				if (resultadoMP.size() > 0) {
					FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_M_DE_P_OK, resultadoMP);
				} else {
					FactoriaGUI.getInstance().actualizar(Eventos.VINCULAR_MARCA_KO, resultadoMP);
				}
				
				
				
				break;
			
				
		//Parte de empleados del switch
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

			resultado =  saEmp.delete((Integer) datos);

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

			List<TEmpleados> ltResultado1 = saEmp.readAll();

			if (ltResultado1.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADOS_OK, ltResultado1);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADOS_KO, null);
			}
			break;
		case Eventos.MOSTRAR_EMPLEADOS_POR_DEPARTAMENTO:

			saEmp = FactoriaNeg.getInstance().generarSAEmp();

			List<TEmpleados> ltResultado2 = saEmp.readAll();

			if (ltResultado2 != null) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADOS_POR_DEPARTAMENTO_OK, ltResultado2);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_EMPLEADOS_POR_DEPARTAMENTO_KO, null);
			}
			break;
		
			
			
			
		//MARCAS
			
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

			List<TMarcas> ltResultadoM = saMarcas.readAll();

			if (ltResultadoM.size() > 0) {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_MARCAS_OK, ltResultadoM);
			} else {
				FactoriaGUI.getInstance().actualizar(Eventos.MOSTRAR_MARCAS_KO, null);
			}
			break;
			
			
			
		}
		
	}
}