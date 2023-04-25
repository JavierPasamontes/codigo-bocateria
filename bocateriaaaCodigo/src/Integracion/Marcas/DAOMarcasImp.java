/**
 * 
 */
package Integracion.Marcas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Negocio.Departamentos.TDept;
import Negocio.Marcas.TMarcas;


public class DAOMarcasImp implements DAOMarcas {
	
	private final static String _path = "resources/marcas/marcas.JSON";

	@Override
	public int create(TMarcas tMarca) {
		int id = -1;
		int pointer = 1;
		// abrir fichero en este caso un documento de texto
		
		JSONObject out = new JSONObject();

		List<TMarcas> marcaList = this.readAll();
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		for(TMarcas marca :marcaList) {
			ids.add(marca.getID());
		}
		
		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) {
			
			if(! ids.contains(tMarca.getID()) ) {
				if(tMarca.getID() == null || tMarca.getID() < 1 || marcaList.size() > 1) {//si el departamento no tiene id, se lo asignamos
					
					boolean hayID = false;
			
					while (hayID == false) {
						if(ids.contains(pointer)) {
							pointer++;
						}
						else hayID = true;
					}
					id = pointer;
					tMarca.setId(pointer);
				}
				else
					id = tMarca.getID();

				
				tMarca.aumentarEmpleados();
				
				marcaList.add(tMarca);
			
				JSONArray marcs = new JSONArray();
				
				for(TMarcas marca :marcaList) {
					JSONObject o = new JSONObject();
					o.put("ID", marca.getID());
					o.put("NOMBRE", marca.getNombre());
					o.put("PRODUCTOS", marca.getCont());
					o.put("ACTIVO", marca.getActivo());
					o.put("PAIS", marca.getPais());
					
					marcs.put(o);
				}
							
				out.put("MARCAS", marcs);
				salida.write(out.toString());
				salida.close();
			}
			else {
				throw new IOException("YA EXISTE UNA MARCA CON EL ID: " + tMarca.getID());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
					
		return id;
	}

	@Override
	public TMarcas read(Integer id) {
		TMarcas marca = null;
		
		List<TMarcas> marcaList = new ArrayList<TMarcas>();
		
		marcaList = this.readAll();
		
		int i = 0;
		boolean salida = false;
		
		while (salida == false && i < marcaList.size()) {
			if(marcaList.get(i).getID() == id) {
				marca = marcaList.get(i);
				salida = true;
			}
			i++;
		}

		return marca;
	}
	
	
	@Override
	public TMarcas readByName(String name) {
		TMarcas marca = null;
		
		List<TMarcas> marcaList = new ArrayList<TMarcas>();
		
		marcaList = this.readAll();
		
		int i = 0;
		boolean salida = false;
		
		while (salida == false && i < marcaList.size()) {
			if(marcaList.get(i).getNombre() == name) {
				marca = marcaList.get(i);
				salida = true;
			}
			i++;
		}

		return marca;
	}
	

	@Override
	public List<TMarcas> readAll() {
		List<TMarcas> marcaList = new ArrayList<TMarcas>();
		
		try (BufferedReader entrada = new BufferedReader(new FileReader(_path))) {
			
			String line = entrada.readLine();
			
			if(line != null ) {
				JSONObject jsonInput = new JSONObject(line);
		
				JSONArray marcs= jsonInput.getJSONArray("MARCAS");
			
				for(int i = 0; i< marcs.length(); i++) {
					JSONObject in = marcs.getJSONObject(i);
					
					Integer auxId = in.getInt("ID");;
					String nombre = in.getString("NOMBRE");
					Integer numProd = in.getInt("PRODUCTOS");
					Boolean activo = in.getBoolean("ACTIVO");
					String pais = in.getString("PAIS");
					
					TMarcas marca = new TMarcas(auxId, nombre, activo, numProd,pais);
					// leemos el id y lo insertamos en la lista
					marcaList.add(marca);
				}
			
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return marcaList;
	}

	@Override
	public int update(TMarcas tMarca) {
		List<TMarcas> marcaList = new ArrayList<TMarcas>();

		marcaList = this.readAll();
		
		for(int i = 0; i < marcaList.size();i++) {
			if (marcaList.get(i).getID() == tMarca.getID()) {
				marcaList.get(i).setNombre(tMarca.getNombre());
				marcaList.get(i).setActivo(tMarca.getActivo());
				marcaList.get(i).setCont(tMarca.getCont());
				}
		}

		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) { // sobrescribimos el archivo de texto
			for (TMarcas marca : marcaList) {
				this.create(marca);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tMarca.getID();
	}

	@Override
	public int delete(Integer id) {		
		TMarcas eliminado = read(id);
		
		//Para modificar y poner el activo a false
		eliminado.setActivo(false);
		
		this.update(eliminado);
		
		return id;
	}	
	
}