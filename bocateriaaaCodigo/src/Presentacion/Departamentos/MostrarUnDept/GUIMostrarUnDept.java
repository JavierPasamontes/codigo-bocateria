/**
 * 
 */
package Presentacion.Departamentos.MostrarUnDept;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
public class GUIMostrarUnDept extends JFrame {
	
	private JTextField campoID;
	private JButton cancelar;
	private JButton aceptar;
	private JLabel idDep=new JLabel("ID: ");
	private JLabel nombreDep=new JLabel("Nombre: ");
	private JLabel sedeDep=new JLabel("Sede: ");
	private JLabel descDep=new JLabel("Descripcion: ");
	private JLabel numEmp=new JLabel("Numero de empleados: ");
	
	public GUIMostrarUnDept() {
		super("Mostrar Departamento por ID");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID del departamento a mostrar: ");
		campoID=new JTextField(12);
		id.add(idLabel);
		id.add(campoID);
		
		JPanel datos=new JPanel();
		datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));
		datos.add(idDep);
		datos.add(nombreDep);
		datos.add(sedeDep);
		datos.add(descDep);
		datos.add(numEmp);
		
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
					Controlador.getInstance().accion(Eventos.MOSTRAR_DEPARTAMENTO, Integer.parseInt(campoID.getText()));
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
	
	public void actualizar(TDept dept) {
		idDep.setText("ID: "+dept.getId());
		nombreDep.setText("Nombre: "+dept.getNombre());
		sedeDep.setText("Sede: "+dept.getSede());
		descDep.setText("Descripcion: "+dept.getDescripcion());
		numEmp.setText("Numero de empleados: "+ dept.getContEmpleados() );
		initGUI();
	}
	
}