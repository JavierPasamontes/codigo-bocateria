/**
 * 
 */
package Integracion.Proveedores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Negocio.Proveedores.TProvComunitario;
import Negocio.Proveedores.TProvNacional;
import Negocio.Proveedores.TProveedores;


public class DAOProvImp implements DAOProv {
	
	//private static final String archivo = "proveedores.txt";
	private final static String _path = "resources/proveedores/proveedores.JSON";


	@Override
	public Integer create(TProveedores tProv) {
		int id = -1;
		int pointer = 1;
		// abrir fichero en este caso un documento de texto
		
		JSONObject out = new JSONObject();

		List<TProveedores> provList = this.readAll();
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		for(TProveedores prov :provList) {
			ids.add(prov.getID());
		}
		
		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) {
			
			if(! ids.contains(tProv.getID()) ) {
				if(tProv.getID() == null || tProv.getID() < 1 || provList.size() > 1) {//si el departamento no tiene id, se lo asignamos
					
					boolean hayID = false;
			
					while (hayID == false) {
						if(ids.contains(pointer)) {
							pointer++;
						}
						else hayID = true;
					}
					id = pointer;
					tProv.setId(pointer);
				}
				else
					id = tProv.getID();

						
				provList.add(tProv);
					
				JSONArray provs = new JSONArray();
				
				for(TProveedores prov :provList) {
					JSONObject o = new JSONObject();
					//Anadimos los datos
					o.put("ID", prov.getID());
					o.put("NOMBRE", prov.getNombre());
					o.put("CONTMARCAS", prov.getCont());
					o.put("ACTIVO", prov.getActivo());
					
					if(prov instanceof TProvComunitario ) { // si es un proveedor comunitario
						o.put("PAIS", ((TProvComunitario) prov).getOrigen());
					}
					else if (prov instanceof TProvNacional ){ // si es un proveedor nacional
						o.put("COMUNIDAD",((TProvNacional) prov).getOrigen());
					}
				
					provs.put(o);
				}
							
				out.put("PROVEEDORES", provs);
				salida.write(out.toString());
				salida.close();
			}
			else {
				throw new IOException("YA EXISTE UN PROVEEDOR CON EL ID: " + tProv.getID());
			}

		} catch (IOException e) {
			//e.printStackTrace();
		}
					
		return id;
	}

	@Override
	public TProveedores read(Integer id) {
		 //al tratarse de un JSON es mas conveniente leerlo todo,
		//convertirlo en objeto y luego trabajar con este
		TProveedores proveedor = null;
		
		List<TProveedores> provList = new ArrayList<TProveedores>();
		
		provList = this.readAll();
		
		int i = 0;
		boolean salida = false;
		
		while (salida == false && i < provList.size()) {
			if(provList.get(i).getID() == id) {
				proveedor = provList.get(i);
				salida = true;
			}
			i++;
		}

		return proveedor;
	}
	
	@Override
	public TProveedores readByName(String nombre) {
		TProveedores proveedor = null;

		List<TProveedores> provList = new ArrayList<TProveedores>();
		
		provList = this.readAll();
		
		int i = 0;
		boolean salida = false;
		
		while (salida == false && i < provList.size()) {
			if(provList.get(i).getNombre().equals(nombre)) {
				proveedor = provList.get(i);
				salida = true;
			}
			i++;
		}

		return proveedor;
	}

	@Override
	public List<TProveedores> readAll() {
		List<TProveedores> provList = new ArrayList<TProveedores>();
		
		try (BufferedReader entrada = new BufferedReader(new FileReader(_path))) {
			
			String line = entrada.readLine();
			
			if(line != null ) {
				JSONObject jsonInput = new JSONObject(line);
		
				JSONArray provs= jsonInput.getJSONArray("PROVEEDORES");
			
				for(int i = 0; i< provs.length(); i++) {
					JSONObject in = provs.getJSONObject(i);
					
					Integer auxId = in.getInt("ID");
					String nombre = in.getString("NOMBRE");
					Integer contMarcas = in.getInt("CONTMARCAS");
					Boolean activo = in.getBoolean("ACTIVO");

					TProveedores proveedor = new TProveedores(auxId,nombre,contMarcas,activo);
					
					
					if(in.has("PAIS")) { //si es un proveedor comunitario
						String pais = in.getString("PAIS");
						proveedor = new TProvComunitario(auxId,nombre,contMarcas,activo,pais);
						proveedor.setTipo('C');
						
					}else {//si es un proveedor nacional
						String comunidad = in.getString("COMUNIDAD");
						proveedor = new TProvNacional(auxId,nombre,contMarcas,activo,comunidad);
						proveedor.setTipo('N');
					}

				provList.add(proveedor);
				}
			
			}
			entrada.close();
		} catch (IOException e) {
			//e.printStackTrace();
		} 

		return provList;
	}

	@Override
	public Integer update(TProveedores tProv) {
		List<TProveedores> provList = new ArrayList<TProveedores>();

		provList = this.readAll();
		
		
		for(int i = 0; i < provList.size();i++) {
			if (provList.get(i).getID() == tProv.getID()) {
				provList.get(i).setNombre(tProv.getNombre());
				provList.get(i).setCont(tProv.getCont());;
				provList.get(i).setActivo(tProv.getActivo());

				//si es un empleado a tiempo parcial
				if(provList.get(i) instanceof TProvComunitario ) {
					((TProvComunitario) provList.get(i)).setOrigen(((TProvComunitario)tProv).getOrigen());
				}
				else if (provList.get(i) instanceof TProvNacional ) {
					((TProvNacional) provList.get(i)).setOrigen(((TProvNacional)tProv).getOrigen());
				} //muchos cast's, pero espero que funcionen
				
			}
		}

		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) { // sobrescribimos el archivo de texto
			for (TProveedores proveedor : provList) {
				this.create(proveedor);
			}
		} catch (IOException e) {
			//e.printStackTrace();
		}

		return tProv.getID();
	}


	@Override
	public int delete(Integer id) {
		TProveedores eliminado = read(id);
		
		//Para modificar y poner el activo a false
		eliminado.setActivo(false);
		
		this.update(eliminado);

		
		return id;
	}

	
	
}