package Presentacion.Marcas.ModificarMarca;

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
public class GUIModificarMarca extends JFrame{
	private JTextField campoID;
	private JTextField campoNombre;
	private JTextField campoPais;
	private JButton cancelar;
	private JButton aceptar;
	
	public GUIModificarMarca() {
		super("Modificar Marca");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID de la marca a modificar: ");
		campoID=new JTextField(12);
		id.add(idLabel);
		id.add(campoID);
		
		JPanel nombre=new JPanel();
		JLabel nombreLabel=new JLabel("Nombre: ");
		campoNombre=new JTextField(12);
		nombre.add(nombreLabel);
		nombre.add(campoNombre);
		
		JPanel pais=new JPanel();
		JLabel paisLabel=new JLabel("Pais: ");
		campoPais=new JTextField(36);
		pais.add(paisLabel);
		pais.add(campoPais);
		
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
				Controlador.getInstance().accion(Eventos.MODIFICAR_MARCAS, 
						new TMarcas(Integer.parseInt(campoID.getText()), campoNombre.getText(),true, 0, campoPais.getText()));
				dispose();
			}
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(id);
		p.add(nombre);
		p.add(pais);
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
				new GUIModificarMarca();
			}
		});


	}
}
