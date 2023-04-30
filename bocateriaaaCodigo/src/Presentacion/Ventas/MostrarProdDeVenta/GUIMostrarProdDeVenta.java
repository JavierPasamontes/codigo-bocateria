package Presentacion.Ventas.MostrarProdDeVenta;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Negocio.Productos.TProductos;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

@SuppressWarnings("serial")
public class GUIMostrarProdDeVenta extends JFrame{
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JButton mostrar;
	private JButton cerrar;
	private JTextField id;
	
	public GUIMostrarProdDeVenta(){
		super("Mostrar todos los productos de una venta");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout(10,10));
		JPanel botonPanel=new JPanel();
		JPanel tablaPanel=new JPanel();
		JPanel cerrarPanel=new JPanel();
		JLabel idlabel=new JLabel("ID de la venta: ");
		id=new JTextField(5);
		botonPanel.add(idlabel);
		botonPanel.add(id);
		mostrar=new JButton("Mostrar");
		mostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!id.getText().equalsIgnoreCase("")) {
					Controlador.getInstance().accion(Eventos.MOSTRAR_PRODUCTOS_VENTA, Integer.parseInt(id.getText()));
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
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Cantidad");
		modeloTabla.addColumn("Precio");
		modeloTabla.addColumn("ID Marca");
		modeloTabla.addColumn("Activo");
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
	
	
	public void actualizar (ArrayList<TProductos> prod){
		modeloTabla.setRowCount(0);
		modeloTabla.insertRow(0, new String[] {"ID", "Nombre", "Cantidad", "Precio", "ID Marca", "Activo"});
		for (int i = 0; i < prod.size(); i++) {
				modeloTabla.insertRow(i+1, new Object[] 
						{ prod.get(i).getId(), prod.get(i).getNombre(), prod.get(i).getCantidad(), prod.get(i).getPrecio(), prod.get(i).getIDmarca(), prod.get(i).getActivo()});
		}
		tabla.setModel(modeloTabla);
		this.pack();
	}
	
}
