package Integracion.MarcasProv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class DAOProv_MarcasImp implements DAOProv_Marcas{
	
	
	private final static String _path = "resources/proveedores/marcasProv.JSON";
	
	@Override
	public int vincularMarca(TMarcasProv r) {
		
		JSONObject out = new JSONObject();
		
		List<TMarcasProv> relList = this.readAll();
		
		int aux = positionAt(r.getProv(), r.getMarca());
		
		if(aux != 0) {
			relList.remove(aux);
		}
		
		relList.add(r);
		
		try(BufferedWriter salida = new BufferedWriter(new FileWriter(_path))){
			
			JSONArray rels = new JSONArray();
			for(TMarcasProv mp :relList) {
				JSONObject o = new JSONObject();
				
				o.put("PROVEEDOR", mp.getProv());
				o.put("MARCA", mp.getMarca());
				o.put("ACTIVO", mp.getActivo());
				rels.put(o);
			}
		
			
			out.put("MARCASPROVS", rels);
			salida.write(out.toString());
			salida.close();
		} catch (IOException e) {

			//e.printStackTrace();
		}
		return 1;
	}

	

	@Override
	public int desvincularMarca(TMarcasProv r) {
		List<TMarcasProv> lista = readAll();
		TMarcasProv eliminado = null;
		boolean cambiado = false;
		int i = 0;
		while(i < lista.size() && !cambiado) {
			if(lista.get(i).getMarca() == r.getMarca() && lista.get(i).getProv() == r.getProv()) {
				lista.get(i).setActivo(false);
				eliminado = lista.get(i);
				cambiado = true;
			}
			i++;
		}
		
		lista.remove(eliminado);
		
		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) { // sobrescribimos el archivo de texto
			JSONObject out = new JSONObject();
			JSONArray rels = new JSONArray();
			for(TMarcasProv mp :lista) {
				JSONObject o = new JSONObject();
				
				o.put("PROVEEDOR", mp.getProv());
				o.put("MARCA", mp.getMarca());
				o.put("ACTIVO", mp.getActivo());
				rels.put(o);
			}
		
			
			out.put("MARCASPROVS", rels);
			salida.write(out.toString());
			salida.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		
		return 0;
	}

	private List<TMarcasProv> readAll() {
		List<TMarcasProv> relacion = new ArrayList<TMarcasProv>();
		
		try (BufferedReader entrada = new BufferedReader(new FileReader(_path))) {
			
			String line = entrada.readLine();
			
			if(line != null ) {
				JSONObject jsonInput = new JSONObject(line);
		
				JSONArray aux= jsonInput.getJSONArray("MARCASPROVS");
			
				for(int i = 0; i< aux.length(); i++) {
					JSONObject in = aux.getJSONObject(i);
					
					Integer marca = in.getInt("MARCA");
					Integer proveedor = in.getInt("PROVEEDOR");
					Boolean activo = in.getBoolean("ACTIVO");

					TMarcasProv marcaProc = new TMarcasProv(proveedor, marca,activo);
					
					
					

				relacion.add(marcaProc);
				}
			
			}
			entrada.close();
		} catch (IOException e) {
			//e.printStackTrace();
		} 
		return relacion;
	}



	@Override
	public List<TMarcasProv> readByID(Integer ID) {
		List<TMarcasProv> lista = readAll();
		List<TMarcasProv> dev = new ArrayList<TMarcasProv>();
	
		for(TMarcasProv mp: lista) {
			if(mp.getProv() == ID)
				dev.add(mp);
		}
		
		return dev;
	}
	@Override
	public boolean vinculado(Integer prov, Integer marca) {
		List<TMarcasProv> dev = readByID(prov);
		
		boolean si = false;
		int i = 0;
		while(!si && i< dev.size()) {
			TMarcasProv aux = dev.get(i);
			
			if(aux.getMarca() == marca && aux.getActivo())
				return true;
			
			i++;
		}
		
		return false;
		
	}
	
	private Integer positionAt(Integer prov, Integer marca) {
		List<TMarcasProv> dev = readByID(prov);
		boolean si = false;
		int i = 0;
		while(!si && i< dev.size()) {
			TMarcasProv aux = dev.get(i);
			
			if(aux.getMarca() == marca)
				return i;
			
			i++;
		}
		
		return 0;
	}
}
