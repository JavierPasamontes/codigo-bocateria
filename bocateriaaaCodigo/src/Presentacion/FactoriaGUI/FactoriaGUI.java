package Presentacion.FactoriaGUI;

public abstract class FactoriaGUI {
	private FactoriaGUI instance;
	
	public FactoriaGUI getInstance() {
		if(this.instance == null) {
			return new FactoriaGUIImp();
		}
		return this.instance;
	}
	
	public abstract ObservadorGUI generarGUI(int evento);
	
}
