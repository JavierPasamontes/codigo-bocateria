package Presentacion.Marcas.MostrarMarcas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import Negocio.Marcas.TMarcas;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

@SuppressWarnings("serial")
public class GUIMostrarMarcas extends JFrame{
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JButton mostrar;
	private JButton cerrar;
	
	public GUIMostrarMarcas(){
		super("Mostrar todas las marcas");
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
				Controlador.getInstance().accion(Eventos.MOSTRAR_MARCAS, null);
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
		modeloTabla.addColumn("Pais");
		modeloTabla.addColumn("Num. de productos");
		modeloTabla.addColumn("Activa");
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView (tabla);
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
	
	
	public void actualizar (ArrayList<TMarcas> mar){
		modeloTabla.setRowCount(0);
		modeloTabla.insertRow(0, new String[] {"ID", "Nombre", "Pais", "Num. de productos", "Activa"});
		for (int i = 0; i < mar.size(); i++) {
				modeloTabla.insertRow(i+1, new Object[] 
						{ mar.get(i).getID(), mar.get(i).getNombre(), mar.get(i).getPais(), mar.get(i).getCont(), mar.get(i).getActivo()});
		}
		tabla.setModel(modeloTabla);
		this.pack();
	}
	
	
	
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new GUIMostrarMarcas();
			}
		});


	}
}
