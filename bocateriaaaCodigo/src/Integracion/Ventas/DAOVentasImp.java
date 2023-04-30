
package Integracion.Ventas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Negocio.Productos.TProductos;
import Negocio.Ventas.TVentas;

public class DAOVentasImp implements DAOVentas {
	
	private final static String _path = "resources/ventas/ventas.JSON";


	@Override
	public int create(TVentas tVenta) {
		int id = -1;
		int pointer = 1;
		// abrir fichero en este caso un documento de texto
		
		JSONObject out = new JSONObject();

		List<TVentas> ventList = this.readAll();
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		for(TVentas venta :ventList) {
			ids.add(venta.getId());
		}
		
		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) {
			
			if(! ids.contains(tVenta.getId()) ) {
				if(tVenta.getId() == null || tVenta.getId() < 1 || ventList.size() > 1) {//si el departamento no tiene id, se lo asignamos
					
					boolean hayID = false;
			
					while (hayID == false) {
						if(ids.contains(pointer)) {
							pointer++;
						}
						else hayID = true;
					}
					id = pointer;
					tVenta.setId(pointer);
				}
				else
					id = tVenta.getId();
				
				ventList.add(tVenta);
			
				JSONArray vents = new JSONArray();
				
				for(TVentas venta :ventList) {
					JSONObject o = new JSONObject();
					o.put("ID", venta.getId());
					o.put("ID EMP", venta.getIdEmpleado());
					o.put("FECHA",venta.getFechaVenta());
										
					JSONArray prods = new JSONArray();
					//Añadimos la lista de productos con un JSONArray de productos(JSONObject)
					if(venta.getListaProductos() != null) {
						for(TProductos producto :venta.getListaProductos()) {
							JSONObject p = new JSONObject();
							p.put("ID", producto.getId());
							p.put("NOMBRE", producto.getNombre());
							p.put("CANTIDAD", producto.getCantidad());
							p.put("PRECIO", producto.getPrecio());
							p.put("ACTIVO", producto.getActivo());
							p.put("ID MARCA", producto.getIDmarca());
							
							prods.put(p);
						}
					}
													
					o.put("PRODUCTOS", prods);				
					o.put("PRECIO FINAL",venta.getPrecioFinal());

					//PONEMOS TODOS LOS JSON EN EL JSON GENERAL DE VENTAS
					vents.put(o);
				}
							
				out.put("VENTAS", vents);
				salida.write(out.toString());
				salida.close();
			}
			else {
				throw new IOException("YA EXISTE UN PRODUCTO CON EL ID: " + tVenta.getId());
			}

		} catch (IOException e) {
			//e.printStackTrace();
		}
					
		return id;
	}

	@Override
	public TVentas read(int id) {

		TVentas venta = null;
		
		List<TVentas> ventList = new ArrayList<TVentas>();
		
		ventList = this.readAll();
		
		int i = 0;
		boolean salida = false;
		
		while (salida == false && i < ventList.size()) {
			if(ventList.get(i).getId() == id) {
				venta = ventList.get(i);
				salida = true;
			}
			i++;
		}

		return venta;

	}

	@Override
	public List<TVentas> readAll() {
		List<TVentas> ventList = new ArrayList<TVentas>();
		
		try (BufferedReader entrada = new BufferedReader(new FileReader(_path))) {
			
			String line = entrada.readLine();
			
			if(line != null ) {
				JSONObject jsonInput = new JSONObject(line);
		
				JSONArray vents= jsonInput.getJSONArray("VENTAS");
			
				for(int i = 0; i< vents.length(); i++) {
					JSONObject in = vents.getJSONObject(i);
					
					int id = in.getInt("ID");
					int idEmp = in.getInt("ID EMP");
					String fecha = in.getString("FECHA");
					double precioFinal = in.getDouble("PRECIO FINAL");
					JSONArray prods = in.getJSONArray("PRODUCTOS");
					List<TProductos> prodList = new ArrayList<TProductos>();

					for(int j = 0; j< prods.length(); j++) {
						JSONObject aux = prods.getJSONObject(j);
						
						int prodId = aux.getInt("ID");;
						String nombre = aux.getString("NOMBRE");
						int numProd = aux.getInt("CANTIDAD");
						double precio = aux.getDouble("PRECIO");
						Boolean activo = aux.getBoolean("ACTIVO");
						int marcaId = aux.getInt("ID MARCA");
						
						TProductos producto = new TProductos(prodId, nombre, numProd, precio, activo, marcaId);
						// leemos el id y lo insertamos en la lista
						prodList.add(producto); 
					}
					
					
					TVentas venta = new TVentas(id, idEmp, fecha,precioFinal,prodList);
					// leemos el id y lo insertamos en la lista
					ventList.add(venta);
				}
			
			}
			entrada.close();
		} catch (IOException e) {
			//e.printStackTrace();
		} 

		return ventList;
	}

	@Override
	public int update(TVentas tVenta) {

		List<TVentas> ventList = new ArrayList<TVentas>();

		ventList = this.readAll();
		
		for(int i = 0; i < ventList.size();i++) {
			if (ventList.get(i).getId() == tVenta.getId()) {
				ventList.get(i).setIdEmpleado(tVenta.getIdEmpleado());
				ventList.get(i).setFechaVenta(tVenta.getFechaVenta());
				ventList.get(i).setPrecioFinal(tVenta.getPrecioFinal());
				ventList.get(i).setListaProductos(tVenta.getListaProductos());
				ventList.get(i).setAbierto(tVenta.getAbierto());
				}
		}

		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) { // sobrescribimos el archivo de texto
			for (TVentas venta : ventList) {
				this.create(venta);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tVenta.getId();

	}

	@Override
	public int delete(int id) {
		TVentas eliminado = read(id);
		
		// Para eliminar
		if (eliminado != null) {
			List<TVentas> ventList = this.readAll();
			
		
			ventList.remove(eliminado);
					
			try(BufferedWriter salida = new BufferedWriter(new FileWriter(_path)))
			{ //sobrescribimos el archivo de texto
				for(TVentas venta : ventList) {
					this.create(venta);
				}
			}
			catch(IOException e) {
				//e.printStackTrace();
			}
		}
		
		return id;
	}


}