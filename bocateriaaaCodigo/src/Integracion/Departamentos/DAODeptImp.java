package Integracion.Departamentos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Negocio.Departamentos.TDept;

public class DAODeptImp implements DAODept {

	private final static String _path = "resources/departamentos/dept.txt";

	//private  int ID = 1;

	public int create(TDept tDept) {
		int id = -1;
		int pointer = 1;
		// abrir fichero en este caso un documento de texto
		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path, true))) {
			// el true del FileWriter es para que se solapen las cosas y no se sobrescriba
			// el fichero
			
			if (read(tDept.getId()) == null) { // si no hay otro con ese id
				
				if(tDept.getId() == null || tDept.getId() < 1) { //si el departamento no tiene id, se lo asignamos
					boolean hayID = false;
					
					while (hayID == false) {
						if(read(pointer) != null) {
							pointer++;
						}
						else hayID = true;
					}
					id = pointer;
					tDept.setId(pointer);
				}
				else id = tDept.getId();
				
				tDept.aumentarEmpleados();
				salida.write(tDept.toString());
				salida.newLine();
				salida.close();
				
			} else
				throw new IOException("YA EXISTE ALGUIEN CON EL ID: " + tDept.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return id;
	}

	public TDept read(Integer id) {

		TDept departamento = null;

		Integer auxId;
		String sede;
		String nombre;
		String descripcion;
		Boolean activo;

		try (BufferedReader entrada = new BufferedReader(new FileReader(_path))) {// el true del FileWriter es para que
																					// se solapen las cosas y no se
																					// sobrescriba el fichero

			String linea;

			while ((linea = entrada.readLine()) != null) {
				String[] parts = linea.split(" ");// dividimos por cada espacio la entrada
				auxId = Integer.parseInt(parts[1]);

				if (auxId == id) { // si coincide el id pasamos los datos
					sede = parts[3];
					nombre = parts[5];

					if (parts[7].equals("true")) // se podria parsear a booleano
						activo = true;
					else
						activo = false;

					descripcion = parts[9];
					// en el caso de que la descripcion sea mas de una palabra
					if (parts.length > 9) {
						int descSize = 10;
						while (descSize < parts.length) {
							descripcion += " " + parts[descSize];
							descSize++;
						}
					}
					departamento = new TDept(id, nombre, sede, activo, descripcion);
				}
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return departamento;
	}

	public List<TDept> readAll() {
		List<TDept> deptList = new ArrayList<TDept>();

		try (BufferedReader entrada = new BufferedReader(new FileReader(_path))) {
			String linea;
			int auxId;

			while ((linea = entrada.readLine()) != null) {
				String[] parts = linea.split(" ");// dividimos por cada espacio la entrada
				auxId = Integer.parseInt(parts[1]);

				TDept departamento = this.read(auxId);
				// leemos el id y lo insertamos en la lista
				deptList.add(departamento);
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return deptList;
	}

	public TDept readByName(String nombre) {

		TDept departamento = null;

		try (BufferedReader entrada = new BufferedReader(new FileReader(_path))) {
			String linea;
			int auxId;

			while ((linea = entrada.readLine()) != null) {
				String[] parts = linea.split(" ");// dividimos por cada espacio la entrada
				auxId = Integer.parseInt(parts[1]);

				departamento = this.read(auxId);

				if (nombre.equals(departamento.getNombre())) { // si el nombre es igual entonces lo devolvemos
					return departamento;
				} // para que devuelva el primero que encuentre con ese nombre
				else {
					departamento = null;
				}
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return departamento;
	}

	public int update(TDept tDept) {

		List<TDept> deptList = new ArrayList<TDept>();

		deptList = this.readAll();
		
		for(int i = 0; i < deptList.size();i++) {
			if (deptList.get(i).getId() == tDept.getId()) {
				deptList.get(i).setNombre(tDept.getNombre());
				deptList.get(i).setSede(tDept.getSede());
				deptList.get(i).setDescripcion(tDept.getDescripcion());
				deptList.get(i).setActivo(tDept.isActivo());
			}
		}

		try (BufferedWriter salida = new BufferedWriter(new FileWriter(_path))) { // sobrescribimos el archivo de texto
			for (TDept departamento : deptList) {
				this.create(departamento);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tDept.getId();
	}

	public int delete(Integer id) {
		int r =-1;
		//ya se puede borrar por lectura, cambiar
		
		TDept eliminado = read(id);
		
		if (eliminado != null) {
			List<TDept> deptList = new ArrayList<TDept>();
			
			deptList = this.readAll();
		
			deptList.remove(eliminado);
			r=id;
					
			try(BufferedWriter salida = new BufferedWriter(new FileWriter(_path)))
			{ //sobrescribimos el archivo de texto
				for(TDept departamento : deptList) {
					this.create(departamento);
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
								
		return r;
	}
}