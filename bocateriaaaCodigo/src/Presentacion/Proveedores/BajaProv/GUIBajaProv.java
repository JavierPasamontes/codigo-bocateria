/**
 * 
 */
package Presentacion.Proveedores.BajaProv;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author pedro
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class GUIBajaProv extends JFrame {
		
		private JTextField campoID;
		private JButton cancelar;
		private JButton aceptar;
		
		public GUIBajaProv() {
			super("Baja Departamento");
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
					dispose();
					
				}
				
				
			});
			aceptar=new JButton("Aceptar");
			aceptar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!campoID.getText().equalsIgnoreCase("")) {
						Controlador.getInstance().accion(Eventos.BAJA_PROVEEDOR, Integer.parseInt(campoID.getText()));
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
					new GUIBajaProv();
				}
			});


		}

}