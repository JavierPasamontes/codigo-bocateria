package Integracion.Productos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

public class DAOProductoImp implements DAOProductos {
	
private final static String _path = "resources/productos/productos.JSON";
	
	@Override
	public int create(TProductos tProducto) {
		int id = -1;
		int pointer = 1;
		// abrir fichero en este caso un documento de texto
		
		JSONObject out = new JSONObject();

		List<TProductos> prodList = this.readAll();
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		for(TProductos producto :prodList) {
			ids.add(producto.getIdProducto());
		}
		
		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) {
			
			if(! ids.contains(tProducto.getIdProducto()) ) {
				if(tProducto.getIdProducto() == null || tProducto.getIdProducto() < 1 || prodList.size() > 1) {//si el departamento no tiene id, se lo asignamos
					
					boolean hayID = false;
			
					while (hayID == false) {
						if(ids.contains(pointer)) {
							pointer++;
						}
						else hayID = true;
					}
					id = pointer;
					tProducto.setIdProducto(pointer);
				}
				else
					id = tProducto.getIdProducto();
				
				prodList.add(tProducto);
			
				JSONArray prods = new JSONArray();
				
				for(TProductos producto :prodList) {
					JSONObject o = new JSONObject();
					o.put("ID", producto.getIdProducto());
					o.put("NOMBRE", producto.getNombreProducto());
					o.put("CANTIDAD", producto.getCantidadProducto());
					o.put("PRECIO", producto.getPrecioProducto());
					o.put("ACTIVO", producto.getActivo());
					o.put("ID MARCA", producto.getIDmarca());
					
					prods.put(o);
				}
							
				out.put("PRODUCTOS", prods);
				salida.write(out.toString());
				salida.close();
			}
			else {
				throw new IOException("YA EXISTE UN PRODUCTO CON EL ID: " + tProducto.getIdProducto());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
					
		return id;
	}

	@Override
	public TProductos read(int id) {
		TProductos producto = null;
		
		List<TProductos> prodList = new ArrayList<TProductos>();
		
		prodList = this.readAll();
		
		int i = 0;
		boolean salida = false;
		
		while (salida == false && i < prodList.size()) {
			if(prodList.get(i).getIdProducto() == id) {
				producto = prodList.get(i);
				salida = true;
			}
			i++;
		}

		return producto;
	}
	
	@Override
	public TProductos readByName(String nombre) {
		TProductos producto = null;
		
		List<TProductos> prodList = new ArrayList<TProductos>();
		
		prodList = this.readAll();
		
		int i = 0;
		boolean salida = false;
		
		while (salida == false && i < prodList.size()) {
			if(prodList.get(i).getNombreProducto().equalsIgnoreCase(nombre)) {
				producto = prodList.get(i);
				salida = true;
			}
			i++;
		}

		return producto;
	}
	

	@Override
	public List<TProductos> readAll() {
		List<TProductos> prodList = new ArrayList<TProductos>();
		
		try (BufferedReader entrada = new BufferedReader(new FileReader(_path))) {
			
			String line = entrada.readLine();
			
			if(line != null ) {
				JSONObject jsonInput = new JSONObject(line);
		
				JSONArray prods= jsonInput.getJSONArray("PRODUCTOS");
			
				for(int i = 0; i< prods.length(); i++) {
					JSONObject in = prods.getJSONObject(i);
					
					int prodId = in.getInt("ID");;
					String nombre = in.getString("NOMBRE");
					int numProd = in.getInt("CANTIDAD");
					double precio = in.getDouble("PRECIO");
					Boolean activo = in.getBoolean("ACTIVO");
					int marcaId = in.getInt("ID MARCA");
					
					TProductos producto = new TProductos(prodId, nombre, numProd, precio, activo, marcaId);
					// leemos el id y lo insertamos en la lista
					prodList.add(producto);
				}
			
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return prodList;
	}

	@Override
	public int update(TProductos tProducto) {
		List<TProductos> prodList = new ArrayList<TProductos>();

		prodList = this.readAll();
		
		for(int i = 0; i < prodList.size();i++) {
			if (prodList.get(i).getIdProducto() == tProducto.getIdProducto()) {
				prodList.get(i).setNombreProducto(tProducto.getNombreProducto());
				prodList.get(i).setCantidadProducto(tProducto.getCantidadProducto());
				prodList.get(i).setPrecioProducto(tProducto.getPrecioProducto());
				prodList.get(i).setActivo(tProducto.getActivo());
				prodList.get(i).setIDmarca(tProducto.getIDmarca());
				}
		}

		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) { // sobrescribimos el archivo de texto
			for (TProductos producto : prodList) {
				this.create(producto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tProducto.getIdProducto();
	}


	@Override
	public int delete(int id) {
		TProductos eliminado = read(id);
		
		//Para modificar y poner el activo a false
		eliminado.setActivo(false);
		
		this.update(eliminado);
		
		return id;
	}
	
}