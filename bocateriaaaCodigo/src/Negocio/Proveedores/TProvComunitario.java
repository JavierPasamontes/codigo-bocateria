package Negocio.Proveedores;

@SuppressWarnings("serial")
public class TProvComunitario extends TProveedores {

	private String pais;


	public TProvComunitario(Integer id, String nombre, Integer contMarcas, boolean activo ,String pais) {
		super(id,nombre,contMarcas,activo);
		this.pais = pais;
	}
	
	
	@Override
	public String getOrigen() {
		return this.pais;
	}
	
	public void setOrigen(String pais) {
		this.pais = pais;
	}
}