/**
 * 
 */
package Presentacion.Proveedores.MostrarProv;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import Negocio.Departamentos.TDept;
import Negocio.Proveedores.TProveedores;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Departamentos.MostrarDept.GUIMostrarDepts;

import javax.swing.JPanel;
import javax.swing.JTable;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author pedro
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIMostrarProvs extends JFrame {
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JButton mostrar;
	private JButton cerrar;
	
	public GUIMostrarProvs(){
		super("Mostrar todos los proveedores");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout(10,10));
		JPanel botonPanel=new JPanel();
		JPanel tablaPanel=new JPanel();
		JPanel cerrarPanel=new JPanel();
		mostrar=new JButton("Mostrar");
		mostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(Eventos.MOSTRAR_PROVS, null);
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
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Tipo");
		modeloTabla.addColumn("Origen");
		modeloTabla.addColumn("Marcas");
		tabla.setModel(modeloTabla);
		
		tablaPanel.add(tabla);
		botonPanel.add(mostrar);
		cerrarPanel.add(cerrar);
		p.add(botonPanel, BorderLayout.PAGE_START);
		p.add(tablaPanel, BorderLayout.CENTER);
		p.add(cerrarPanel, BorderLayout.PAGE_END);
		
		
		this.setContentPane(p);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocation(400,400);
	}
	
	
	public void actualizar (ArrayList<TProveedores> prov){
		modeloTabla.setColumnCount(0);
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Tipo");
		modeloTabla.addColumn("Origen");
		modeloTabla.addColumn("Marcas");
		modeloTabla.setRowCount(0);
		modeloTabla.insertRow(0, new String[]{"ID", "Nombre", "Tipo", "Origen", "Marcas"});
		for (int i = 0; i < prov.size(); i++) {
			if (prov.get(i) instanceof TProveedores){
				modeloTabla.insertRow(i+1, new Object[] 
						{ prov.get(i).getID(), prov.get(i).getNombre(), prov.get(i).getTipo(), prov.get(i).getOrigen(), prov.get(i).getCont()});
			}
		}
		tabla.setModel(modeloTabla);
		this.pack();
	}
	
	
	
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new GUIMostrarProvs();
			}
		});


	}
}