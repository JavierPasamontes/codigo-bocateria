/**
 * 
 */
package Presentacion.Proveedores.AltaProv;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import Negocio.Proveedores.TProvComunitario;
import Negocio.Proveedores.TProvNacional;
import Negocio.Proveedores.TProveedores;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.FactoriaGUI.ObservadorGUI;

import javax.swing.JPanel;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author pedro
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class GUIAltaProv extends JFrame implements ObservadorGUI {
	private JTextField campoNombre;
	private JTextField campoOrigen;
	private JButton cancelar;
	private JButton aceptar;
	private List<String> tipoProvs;
	
	public GUIAltaProv() {
		super("Alta Proveedores");
		tipoProvs = new ArrayList<String>();
		tipoProvs.add("Comunitario");
		tipoProvs.add("Nacionales");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel nombre=new JPanel();
		JLabel nombreLabel=new JLabel("Nombre: ");
		campoNombre=new JTextField(12);
		nombre.add(nombreLabel);
		nombre.add(campoNombre);
		
		DefaultComboBoxModel<String> modeloProvs = new DefaultComboBoxModel<>();	
		
		for(String o : tipoProvs)
			modeloProvs.addElement(o);
			
		JComboBox<String> elegir = new JComboBox<String>(modeloProvs);
		
		JPanel origen=new JPanel();
		JLabel origenLabel=new JLabel("Origen:");
		campoOrigen=new JTextField(12);
		origen.add(origenLabel);
		origen.add(campoOrigen);
		
		JPanel tipo = new JPanel();
		JLabel tipoLabel = new JLabel("Tipo Proveedor: ");
		tipo.add(tipoLabel);
		tipo.add(elegir);
		
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
				boolean correcto=true;
				if(campoNombre.getText().equalsIgnoreCase("")||campoOrigen.getText().equalsIgnoreCase("")) {
					correcto=false;
				}
				if(correcto) {
					if(((String)elegir.getSelectedItem()).equals("Nacionales")) {
						TProveedores prov = new TProvNacional(0, campoNombre.getText(),0, true, campoOrigen.getText());
						prov.setTipo('N');
						
						Controlador.getInstance().accion(Eventos.ALTA_PROVEEDOR, prov);
						dispose();
					}
					else {
						TProveedores prov = new TProvComunitario(0, campoNombre.getText(),0, true, campoOrigen.getText());
						prov.setTipo('C');
						
						Controlador.getInstance().accion(Eventos.ALTA_PROVEEDOR, prov);
						dispose();
					}
				}
			}
			
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(nombre);
		p.add(origen);
		p.add(tipo);
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
				new GUIAltaProv();
			}
		});


	}

	@Override
	public void actualizar(int evento, Object datos) {

	}
	
}