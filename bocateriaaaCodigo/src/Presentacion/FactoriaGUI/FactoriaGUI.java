package Presentacion.FactoriaGUI;

public abstract class FactoriaGUI implements ObservadorGUI{
	
	private static FactoriaGUI instance;
	
	public static FactoriaGUI getInstance() {
		if(instance == null) {
			instance = new FactoriaGUIImp();
		}
		return instance;
	}
	
	public abstract ObservadorGUI generarGUI(int evento);
	
}
