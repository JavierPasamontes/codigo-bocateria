package Presentacion.Marcas.MostrarUnaMarca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Negocio.Marcas.TMarcas;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

@SuppressWarnings("serial")
public class GUIMostrarUnaMarca extends JFrame{
	private JTextField campoID;
	private JButton cancelar;
	private JButton aceptar;
	private JLabel idMar=new JLabel("ID: ");
	private JLabel nombreMar=new JLabel("Nombre: ");
	private JLabel paisMar=new JLabel("Pais: ");
	private JLabel numPMar=new JLabel("Num. de productos: ");
	
	public GUIMostrarUnaMarca() {
		super("Mostrar marca por ID");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID de la marca a mostrar: ");
		campoID=new JTextField(12);
		id.add(idLabel);
		id.add(campoID);
		
		JPanel datos=new JPanel();
		datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));
		datos.add(idMar);
		datos.add(nombreMar);
		datos.add(paisMar);
		datos.add(numPMar);
		
		JPanel botones=new JPanel();
		cancelar=new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
			
		});
		aceptar=new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!campoID.getText().equalsIgnoreCase("")) {
					Controlador.getInstance().accion(Eventos.MOSTRAR_MARCA, Integer.parseInt(campoID.getText()));
				}
			}
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(id);
		p.add(datos);
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
				new GUIMostrarUnaMarca();
			}
		});


	}
	
	public void actualizar(TMarcas mar) {
		idMar.setText("ID: "+mar.getID());
		nombreMar.setText("Nombre: "+mar.getNombre());
		paisMar.setText("Pais: "+mar.getPais());
		numPMar.setText("Num. de productos: "+mar.getCont());
		initGUI();
	}
}
