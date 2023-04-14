/**
 * 
 */
package Integracion.Proveedores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import Integracion.FactoriaIntegracion.FactoriaIntg;
import Negocio.Departamentos.TDept;
import Negocio.Proveedores.TProvComunitario;
import Negocio.Proveedores.TProveedores;


public class DAOProvImp implements DAOProv {
	
	private static final String archivo = "proveedores.txt";
	
	private static int actId = -1;
	
	public Integer create(TProveedores prov) {
		try (FileOutputStream output = new FileOutputStream(archivo, true);
		        Writer writer = new OutputStreamWriter(output)) {
			int id = generadorId();
			
			prov.setId(id);
			prov.setActivo(true);
			prov.setCont(0);
			
		    writer.write(prov.toString());
		    
		    
		    return id;
		} catch (IOException e) {
			
			return -1;
		}
		
	}


	public TProveedores read(Integer id) {
		
		try(FileInputStream file = new FileInputStream(archivo); Scanner scn = new Scanner(file) ) {
			
			if(!scn.hasNext()) {
				return null;
			}
			while(scn.hasNext()) {
				
				String line = scn.nextLine();
				
				String[] aux = line.split(":") ;
				if((Integer.parseInt(aux[0])) == id ){
					
					
					return TProveedores.parseProv(aux);
				}
				
			}
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		
		
		return null;
		
	}


	public List<TProveedores> readAll() {
		List<TProveedores> proveedores = new ArrayList<TProveedores>();
		
		try(FileInputStream file = new FileInputStream(archivo); Scanner scn = new Scanner(file) ) {
			
			if(!scn.hasNext()) {
				return null;
			}
			while(scn.hasNext()) {
				
				String line = scn.nextLine();
				
				String[] aux = line.split(":") ;
				
				TProveedores prov = TProveedores.parseProv(aux);
				
				proveedores.add(prov);
				
			}
			
			return proveedores;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}

	}


	public Integer update(TProveedores prov) {
		
		TProveedores aux = readByName(prov.getNombre());
		if(prov != null) {
		
			List<TProveedores> lista = new ArrayList<TProveedores>();
			
			lista = readAll();
			
			lista.remove(aux);
			
			lista.add(prov);
			
			
			
			try(FileOutputStream file = new FileOutputStream(archivo, false); Writer wr = new OutputStreamWriter(file)){	
				for(TProveedores prove : lista) {
					wr.write(prove.toString());
				}
			}
			catch (IOException e) {
				
				e.printStackTrace();
			}
			
			return prov.getID();
			
		}
		
		
		return -1;
		// end-user-code
	}

	
	public TProveedores readByName(String nombre) {
		
		
		try(FileInputStream file = new FileInputStream(archivo); Scanner scn = new Scanner(file) ) {
			
			while(scn.hasNext()) {
				
				String line = scn.nextLine();
				
				String[] aux = line.split(":") ;
				
				String name = aux[1];
		
				if(nombre.equalsIgnoreCase(name)) {
					
					return  TProveedores.parseProv(aux);
				}
			}
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		
		return null;
	}


	public int delete(Integer id) {
		
		TProveedores prov = read(id);
		
		if(prov != null) {
		
			List<TProveedores> lista = new ArrayList<TProveedores>();
			
			lista = readAll();
			
			lista.remove(prov);
			
			prov.setActivo(false);
			
			
			try(FileOutputStream file = new FileOutputStream(archivo, false); Writer wr = new OutputStreamWriter(file)){	
				for(TProveedores prove : lista) {
					wr.write(prove.toString());
				}
			}
			catch (IOException e) {
				
				e.printStackTrace();
			}
			
			return id;
			
		}
			
		
		return -1;
	}
	
	
	private static int  generadorId() {
		if(actId == -1) {
			try(FileInputStream file = new FileInputStream(archivo); Scanner scn = new Scanner(file) ) {
				int auxId = -1;
				if(!scn.hasNext()) {
					return 10;
				}
				while(scn.hasNext()) {
					
					String line = scn.nextLine();
					
					String[] aux = line.split(":") ;
					
					
					
					
					auxId = Integer.parseInt(aux[0]);
				}
				
				actId = auxId+1;
				
				
				return actId;
			} catch (FileNotFoundException e) {
				return -1;
			} catch (IOException e) {
				return -1;
			}
		}
			
			else
				return ++actId;
		
		
	}
	
	
}