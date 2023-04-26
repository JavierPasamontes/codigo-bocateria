/**
 * 
 */
package Presentacion.Departamentos.ModificarDept;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Negocio.Departamentos.TDept;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

import javax.swing.JPanel;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author usuario_local
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class GUIModificarDept extends JFrame {
	
	private JTextField campoID;
	private JTextField campoNombre;
	private JTextField campoSede;
	private JTextField campoDesc;
	private JButton cancelar;
	private JButton aceptar;
	
	public GUIModificarDept() {
		super("Modificar Departamento");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID del departamento a modificar: ");
		campoID=new JTextField(12);
		id.add(idLabel);
		id.add(campoID);
		
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
				Controlador.getInstance().accion(Eventos.MODIFICAR_DEPARTAMENTO, 
						new TDept(Integer.parseInt(campoID.getText()), campoNombre.getText(), campoSede.getText(),true, campoDesc.getText()));
				dispose();
			}
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(id);
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
				new GUIModificarDept();
			}
		});


	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Object id;

	/** 
	* @return the id
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Object getId() {
		// begin-user-code
		return id;
		// end-user-code
	}

	/** 
	* @param id the id to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setId(Object id) {
		// begin-user-code
		this.id = id;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private String nombre;

	/** 
	* @return the nombre
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getNombre() {
		// begin-user-code
		return nombre;
		// end-user-code
	}

	/** 
	* @param nombre the nombre to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setNombre(String nombre) {
		// begin-user-code
		this.nombre = nombre;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private String sede;

	/** 
	* @return the sede
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getSede() {
		// begin-user-code
		return sede;
		// end-user-code
	}

	/** 
	* @param sede the sede to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setSede(String sede) {
		// begin-user-code
		this.sede = sede;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private String descrp;

	/** 
	* @return the descrp
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getDescrp() {
		// begin-user-code
		return descrp;
		// end-user-code
	}

	/** 
	* @param descrp the descrp to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setDescrp(String descrp) {
		// begin-user-code
		this.descrp = descrp;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JButton jButton;

	/** 
	* @return the jButton
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public JButton getjButton() {
		// begin-user-code
		return jButton;
		// end-user-code
	}

	/** 
	* @param jButton the jButton to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setjButton(JButton jButton) {
		// begin-user-code
		this.jButton = jButton;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JLabel jLabel;

	/** 
	* @return the jLabel
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public JLabel getjLabel() {
		// begin-user-code
		return jLabel;
		// end-user-code
	}

	/** 
	* @param jLabel the jLabel to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setjLabel(JLabel jLabel) {
		// begin-user-code
		this.jLabel = jLabel;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JTextField jTextField;

	/** 
	* @return the jTextField
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public JTextField getjTextField() {
		// begin-user-code
		return jTextField;
		// end-user-code
	}

	/** 
	* @param jTextField the jTextField to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setjTextField(JTextField jTextField) {
		// begin-user-code
		this.jTextField = jTextField;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JPanel jPanel;

	/** 
	* @return the jPanel
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public JPanel getjPanel() {
		// begin-user-code
		return jPanel;
		// end-user-code
	}

	/** 
	* @param jPanel the jPanel to set
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setjPanel(JPanel jPanel) {
		// begin-user-code
		this.jPanel = jPanel;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void iniGUI() {
		// begin-user-code

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void resetGUI() {
		// begin-user-code

		// end-user-code
	}
}