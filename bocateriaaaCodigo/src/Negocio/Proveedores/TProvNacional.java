package Negocio.Proveedores;

@SuppressWarnings("serial")
public class TProvNacional extends TProveedores {

	private String comunidad;
	

	public TProvNacional(Integer id, String nombre, Integer contMarcas, boolean activo,String comunidad) {
		super(id, nombre, contMarcas, activo);
		this.comunidad = comunidad;
	}
	
	
	@Override
	public String getOrigen() {
		return this.comunidad;
	}
	
	public void setOrigen(String comunidad) {
		this.comunidad = comunidad;
	}
	
}