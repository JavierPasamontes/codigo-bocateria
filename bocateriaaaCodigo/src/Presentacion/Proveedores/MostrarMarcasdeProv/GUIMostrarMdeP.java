/**
 * 
 */
package Presentacion.Proveedores.MostrarMarcasdeProv;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Controlador.MensajeGUI;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author pedro
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class GUIMostrarMdeP extends JFrame {
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JButton mostrar;
	private JButton cerrar;
	
	public GUIMostrarMdeP() {
		super("Mostrar Marcas de un Proveedor");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout(10,10));
		JPanel top = new JPanel();
		JLabel idLabel = new JLabel("ID Proveedor: ");
		JTextField id = new JTextField(7);
		
		top.add(idLabel);
		top.add(id);
		
		JPanel tablaPanel=new JPanel();
		JPanel cerrarPanel=new JPanel();
		mostrar=new JButton("Mostrar");
		mostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
				Controlador.getInstance().accion(Eventos.MOSTRAR_MARCAS_DE_PROV, Integer.parseInt( (id.getText()))) ;
				}
				catch(Exception o){
					MensajeGUI a = new MensajeGUI();
					a.showMessage("Algo fue mal..." + o.getMessage(), "Mostrar Marcas de un Proveedor", true);
				}
			}
			
			
		});
		
		cerrar=new JButton("Cerrar");
		cerrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
			
		});
		
		tabla = new JTable();
		
		modeloTabla = new DefaultTableModel(){
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
			
		};
		
		modeloTabla.setColumnCount(0);
		modeloTabla.addColumn("Marca");
		tabla.setModel(modeloTabla);
		top.add(mostrar);
		tablaPanel.add(tabla);
		cerrarPanel.add(cerrar);
		p.add(top,BorderLayout.PAGE_START);
		p.add(tablaPanel, BorderLayout.CENTER);
		p.add(cerrarPanel, BorderLayout.PAGE_END);
		
		
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
				new GUIMostrarMdeP();
			}
		});


	}
	
	public void actualizar (ArrayList<String> marca){
		modeloTabla.setColumnCount(0);
		modeloTabla.addColumn("Marca");
		modeloTabla.setRowCount(0);
		modeloTabla.insertRow(0, new String[]{"Marca"});
		for (int i = 0; i < marca.size(); i++) {
			if (marca.get(i) instanceof String){
				modeloTabla.insertRow(i+1, new Object[] 
						{ marca.get(i).toString()});
			}
		}
		tabla.setModel(modeloTabla);
		this.pack();
	}
	
}