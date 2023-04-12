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

import Negocio.Departamentos.TDept;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Departamentos.MostrarUnDept.GUIMostrarUnDept;

public class GUIMostrarUnaMarca extends JFrame{
	private JTextField campoID;
	private JButton cancelar;
	private JButton aceptar;
	private JLabel idDep=new JLabel("ID: ");
	private JLabel nombreDep=new JLabel("Nombre: ");
	private JLabel descDep=new JLabel("Descripcion: ");
	
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
		datos.add(idDep);
		datos.add(nombreDep);
		datos.add(descDep);
		
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
					//Controlador.getInstance().accion(Eventos.MOSTRAR_MARCA, Integer.parseInt(campoID.getText()));
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
				// TODO Auto-generated method stub
				new GUIMostrarUnaMarca();
			}
		});


	}
	
	public void actualizar(TDept dept) {
		idDep.setText("ID: "+dept.getId());
		nombreDep.setText("Nombre: "+dept.getNombre());
		descDep.setText("Descripcion: "+dept.getDescripcion());
		initGUI();
	}
}
