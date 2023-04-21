/**
 * 
 */
package Presentacion.Proveedores.DesvincularMarca;

import javax.swing.JFrame;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Controlador.MensajeGUI;
import Presentacion.FactoriaGUI.ObservadorGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Integracion.MarcasProv.TMarcasProv;

import javax.swing.JPanel;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author pedro
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIDesvincularMarca extends JFrame implements ObservadorGUI {
	private JTextField campoProv;
	private JTextField campoMarca;
	private JButton cancelar;
	private JButton aceptar;
	
	public GUIDesvincularMarca() {
		super("Desvincular Marca y Proveedor");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel prov=new JPanel();
		JLabel nombreLabel=new JLabel("ID Proveedor: ");
		campoProv=new JTextField(7);
		prov.add(nombreLabel);
		prov.add(campoProv);
		
		
		
		JPanel marca=new JPanel();
		JLabel origenLabel=new JLabel("ID Marca:");
		campoMarca=new JTextField(7);
		marca.add(origenLabel);
		marca.add(campoMarca);
		
		
		
		
		
		
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
				if(campoProv.getText().equalsIgnoreCase("")||campoMarca.getText().equalsIgnoreCase("")) {
					correcto=false;
				}
				if(correcto) {
					try {
						TMarcasProv rel = new TMarcasProv(Integer.parseInt(campoProv.getText()),Integer.parseInt(campoMarca.getText()), true);
						Controlador.getInstance().accion(Eventos.DESVINCULAR_MARCA, rel);
						dispose();
					}
					catch (Exception o) {
						MensajeGUI a = new MensajeGUI();
						a.showMessage("Algo fue mal..." + o.getMessage(), "Desvincular Marca", true);
					}
					
					
					
				}
			}
			
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(prov);
		p.add(marca);
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
				new GUIDesvincularMarca();
			}
		});


	}

	@Override
	public void actualizar(int evento, Object datos) {
	}
}