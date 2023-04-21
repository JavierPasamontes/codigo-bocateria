package Integracion.MarcasProv;

public class TMarcasProv {
	Integer prov;
	Integer marca;
	boolean activo;
	
	public TMarcasProv(Integer prov, Integer marca, Boolean activo) {
		this.prov = prov;
		this.marca = marca;
		this.activo = activo;
	}

	public Integer getProv() {
		return prov;
	}

	public void setProv(Integer prov) {
		this.prov = prov;
	}

	public Integer getMarca() {
		return marca;
	}

	public void setMarca(Integer marca) {
		this.marca = marca;
	}
	
	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
