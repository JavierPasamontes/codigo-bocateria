/**
 * 
 */
package Presentacion.Proveedores.MostrarUnProv;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Negocio.Proveedores.TProveedores;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author pedro
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class GUIBuscarProv extends JFrame {
	private JTextField campoID;
	private JButton cancelar;
	private JButton aceptar;
	private JLabel idProv=new JLabel("ID: ");
	private JLabel nombreProv=new JLabel("Nombre: ");
	private JLabel tipoProv=new JLabel("Tipo: ");
	private JLabel origenProv=new JLabel("Origen: ");
	private JLabel contProv=new JLabel("Marcas: ");
	
	public GUIBuscarProv() {
		super("Mostrar proveedor por ID");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID del proveedor a mostrar: ");
		campoID=new JTextField(12);
		id.add(idLabel);
		id.add(campoID);
		
		JPanel datos=new JPanel();
		datos.add(idProv);
		datos.add(nombreProv);
		datos.add(tipoProv);
		datos.add(origenProv);
		datos.add(contProv);
		
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
					Controlador.getInstance().accion(Eventos.BUSCAR_PROV , Integer.parseInt(campoID.getText()));
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
				new GUIBuscarProv();
			}
		});


	}
	
	public void actualizar(TProveedores prov) {
		idProv.setText("ID: "+prov.getID());
		nombreProv.setText("Nombre: "+prov.getNombre());
		tipoProv.setText("Tipo: "+ prov.getTipo() );
		origenProv.setText("Origen: " + prov.getOrigen());
		contProv.setText("Marcas: " + prov.getCont());
		
		initGUI();
	}
}