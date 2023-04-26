package Presentacion.Productos.BajaProductos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Marcas.BajaMarca.GUIBajaMarca;

public class GUIBajaProductos extends JFrame{
	private JTextField campoID;
	private JButton cancelar;
	private JButton aceptar;
	
	public GUIBajaProductos() {
		super("Baja Producto");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID a dar de baja: ");
		campoID=new JTextField(36);
		id.add(idLabel);
		id.add(campoID);
		
		JPanel botones=new JPanel();
		cancelar=new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
			
			
		});
		aceptar=new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!campoID.getText().equalsIgnoreCase("")) {
					//Controlador.getInstance().accion(Eventos.BAJA_PRODUCTO, Integer.parseInt(campoID.getText()));
					dispose();
				}
			}
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(id);
		p.add(botones);
		this.setContentPane(p);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocation(400,400);
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new GUIBajaProductos();
			}
		});


	}
}
