/**
 * 
 */
package Presentacion.Departamentos.MostrarDept;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import javax.swing.JPanel;
import javax.swing.JTable;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author usuario_local
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIMostrarDepts extends JFrame {
	
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	
	public GUIMostrarDepts(){
		super("Mostrar todos los departamentos");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout(10,10));
		
		tabla = new JTable();
		
		modeloTabla = new DefaultTableModel(){
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
			
		};
		
		//esto a lo mejor no hace falta hacerlo, hay que ver como se actualiza la ventana, o si hay que poner un boton para que 
		//aparezcan las cosas
		modeloTabla.setColumnCount(0);
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Sede");
		modeloTabla.addColumn("Descripcion");
		tabla.setModel(modeloTabla);
		
		p.add(tabla);
		
		//Controlador.getInstance().accion(Eventos.LISTAR_DEPS, null);
		
		this.setContentPane(p);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocation(400,400);
	}
	
	/*
	public void update (ArrayList<TDepartamentos> dep){
		 modeloTabla.setRowCount(0);
		 for (int i = 0; i < dep.size(); i++) {
			if (dep.get(i) instanceof TDepartamentos){
				modeloTabla.insertRow(i, new Object[] 
						{ i, dep.get(i).getId(), dep.get(i).getNombre(), dep.get(i).getSede(), dep.get(i).getDescripcion()});
			}
		}
		 tabla.setModel(modeloTabla);
	}
	*/
	
	
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new GUIMostrarDepts();
			}
		});


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
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void resetGUI() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}