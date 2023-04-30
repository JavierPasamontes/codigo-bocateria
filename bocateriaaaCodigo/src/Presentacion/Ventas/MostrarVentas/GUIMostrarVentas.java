package Presentacion.Ventas.MostrarVentas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Negocio.Ventas.TVentas;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

@SuppressWarnings("serial")
public class GUIMostrarVentas extends JFrame{
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JButton mostrar;
	private JButton cerrar;
	
	
	public GUIMostrarVentas(){
		super("Mostrar todas las ventas");
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
				Controlador.getInstance().accion(Eventos.MOSTRAR_VENTAS, null);
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
		modeloTabla.addColumn("ID Empleado");
		modeloTabla.addColumn("Fecha");
		modeloTabla.addColumn("Precio");
		modeloTabla.addColumn("Productos");
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
	
	
	public void actualizar (ArrayList<TVentas> ven){
		modeloTabla.setRowCount(0);
		modeloTabla.insertRow(0, new String[] {"ID", "ID Empleado", "Fecha", "Precio", "Productos"});
		for (int i = 0; i < ven.size(); i++) {
			String prod=new String();
			prod="";
			for(int j=0;i<ven.get(i).getListaProductos().size();j++) {
				prod=prod+ven.get(i).getListaProductos().get(j);
			}
				modeloTabla.insertRow(i+1, new Object[] 
						{ ven.get(i).getId(), ven.get(i).getIdEmpleado(), ven.get(i).getFechaVenta(), ven.get(i).getPrecioFinal(), prod});
		}
		tabla.setModel(modeloTabla);
		this.pack();
	}
}
