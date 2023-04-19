/**
 * 
 */
package Presentacion.Departamentos.AltaDepartamentos;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Negocio.Departamentos.TDept;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.FactoriaGUI.ObservadorGUI;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author usuario_local
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIAltaDepartamento extends JFrame{
	
	private JTextField campoNombre;
	private JTextField campoSede;
	private JTextField campoDesc;
	private JButton cancelar;
	private JButton aceptar;
	
	public GUIAltaDepartamento() {
		super("Alta Departamento");
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
		
		JPanel sede=new JPanel();
		JLabel sedeLabel=new JLabel("Sede: ");
		campoSede=new JTextField(12);
		sede.add(sedeLabel);
		sede.add(campoSede);
		
		JPanel desc=new JPanel();
		JLabel descLabel=new JLabel("Descripcion: ");
		campoDesc=new JTextField(36);
		desc.add(descLabel);
		desc.add(campoDesc);
		
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
				// TODO Auto-generated method stub
				boolean correcto=true;
				if(campoNombre.getText().equalsIgnoreCase("")||campoSede.getText().equalsIgnoreCase("")||campoDesc.getText().equalsIgnoreCase("")) {
					correcto=false;
				}
				if(correcto) {
						Controlador.getInstance().accion(Eventos.ALTA_DEPARTAMENTO, 
							new TDept(0, campoNombre.getText(), campoSede.getText(), true, campoDesc.getText()));
						dispose();
				}
			}
			
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(nombre);
		p.add(sede);
		p.add(desc);
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
				new GUIAltaDepartamento();
			}
		});


	}

	
	private JButton jButton;

	public JButton getjButton() {
		// begin-user-code
		return jButton;
		// end-user-code
	}

	public void setjButton(JButton jButton) {
		this.jButton = jButton;
	}

	private JFrame jFrame;

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}

	private JLabel jLabel;

	public JLabel getjLabel() {
		return jLabel;
	}

	public void setjLabel(JLabel jLabel) {
		this.jLabel = jLabel;
	}

	private JPanel jPanel;

	public JPanel getjPanel() {
		return jPanel;
	}

	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}

	private JTextField jTextField;

	public JTextField getjTextField() {
		return jTextField;
	}

	public void setjTextField(JTextField jTextField) {
		this.jTextField = jTextField;
	}

	public void iniGUI() {

	}

	public void resetGUI() {

	}

	public void Aceptar() {

	}

}