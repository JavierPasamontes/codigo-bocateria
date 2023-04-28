package Integracion.Ventas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Integracion.Ventas.DAOVentas;
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
			
				JSONArray prods = new JSONArray();
				
				for(TVentas venta :ventList) {
					JSONObject o = new JSONObject();
					o.put("ID", venta.getId());
					//JSONARRAY DE PRODUCTOS??????????
				
					
					prods.put(o);
				}
							
				out.put("PRODUCTOS", prods);
				salida.write(out.toString());
				salida.close();
			}
			else {
				throw new IOException("YA EXISTE UN PRODUCTO CON EL ID: " + tVenta.getId());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
					
		return id;
	}

	@Override
	public TVentas read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TVentas> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(TVentas tVenta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}