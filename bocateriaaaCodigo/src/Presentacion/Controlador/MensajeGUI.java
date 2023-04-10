package Presentacion.Controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MensajeGUI {
	public void showMessage(String message,String message2, boolean error) {
		if(!error){
			JOptionPane.showMessageDialog(new JFrame(),message	, message2, JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(new JFrame(),message	, message2, JOptionPane.ERROR_MESSAGE);
	}
}
