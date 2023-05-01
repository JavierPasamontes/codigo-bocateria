/**
 * 
 */
package Presentacion.Proveedores.ModificarProv;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Negocio.Proveedores.TProvComunitario;
import Negocio.Proveedores.TProvNacional;
import Negocio.Proveedores.TProveedores;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

@SuppressWarnings("serial")
public class GUIModProv extends JFrame {
	private JTextField campoNombre;
	private JTextField campoOrigen;
	private JTextField campoID;
	private JButton cancelar;
	private JButton aceptar;
	private List<String> tipoProvs;
	
	public GUIModProv() {
		super("Modificar Proveedor");
		tipoProvs = new ArrayList<String>();
		tipoProvs.add("Comunitario");
		tipoProvs.add("Nacionales");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id = new JPanel();
		JLabel idLabel = new JLabel("ID: ");
		campoID=new JTextField(2);
		id.add(idLabel);
		id.add(campoID);
		
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
				if(campoID.getText().equalsIgnoreCase("")) {
					correcto=false;
				}
				if(correcto) {
					if(((String)elegir.getSelectedItem()).equals("Nacionales")) {
						TProveedores prov = new TProvNacional(Integer.parseInt(campoID.getText()), campoNombre.getText(),0, true, campoOrigen.getText());
						prov.setTipo('N');
						
						Controlador.getInstance().accion(Eventos.MODIFICAR_PROVEEDOR, prov);
						dispose();
					}
					else {
						TProveedores prov = new TProvComunitario(Integer.parseInt(campoID.getText()), campoNombre.getText(),0, true, campoOrigen.getText());
						prov.setTipo('C');
						
						Controlador.getInstance().accion(Eventos.MODIFICAR_PROVEEDOR, prov);
						dispose();
					}
				}
			}
			
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(id);
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
	
}