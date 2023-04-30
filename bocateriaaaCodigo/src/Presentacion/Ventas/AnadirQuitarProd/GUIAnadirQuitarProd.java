package Presentacion.Ventas.AnadirQuitarProd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Productos.TProductos;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;


@SuppressWarnings("serial")
public class GUIAnadirQuitarProd extends JFrame{
	private JButton mostrar;
	private JButton cerrar;
	private JButton aceptar;
	private JTextField id;
	@SuppressWarnings("rawtypes")
	private JComboBox quitarAnadir;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelo;
	private ArrayList<TProductos> productos;
	JPanel prodPanel;
	
	public GUIAnadirQuitarProd(){
		super("Anadir o quitar productos de una venta");
		initGUI();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		productos=new ArrayList<>();
		JPanel botonPanel=new JPanel();
		JPanel comboPanel=new JPanel();
		prodPanel=new JPanel();
		prodPanel.setLayout(new GridLayout(3,3));
		JPanel cerrarPanel=new JPanel();
		aceptar=new JButton("Aceptar");
		aceptar.setEnabled(false);
		id=new JTextField(5);
		id.setEnabled(false);
		mostrar=new JButton("Mostrar");
		modelo = new DefaultComboBoxModel<>();
		modelo.addElement("A�adir");
		modelo.addElement("Quitar");
		quitarAnadir=new JComboBox(modelo);
		quitarAnadir.setSelectedIndex(0);
		quitarAnadir.setEnabled(false);
		mostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(Eventos.MOSTRAR_PRODUCTOS_AUX, null);
				aceptar.setEnabled(true);
				id.setEnabled(true);
				quitarAnadir.setEnabled(true);
				mostrar.setEnabled(false);
			}
			
			
		});
		
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!id.getText().equalsIgnoreCase("")) {
					HashMap<Integer, ArrayList<TProductos>> map=new HashMap<>();
					map.put(Integer.parseInt(id.getText()), productos);
					
					if(quitarAnadir.getSelectedItem().equals("A�adir")) {
						Controlador.getInstance().accion(Eventos.AGREGAR_PRODUCTO_VENTA, map);
					}
					else {
						Controlador.getInstance().accion(Eventos.ELIMINAR_PRODUCTO_VENTA, map);
					}
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
		
		
		botonPanel.add(mostrar);
		comboPanel.add(quitarAnadir);
		comboPanel.add(id);
		cerrarPanel.add(cerrar);
		cerrarPanel.add(aceptar);
		p.add(botonPanel);
		p.add(comboPanel);
		p.add(prodPanel);
		p.add(cerrarPanel);
		
		
		this.setContentPane(p);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocation(400,400);
	}
	
	
	public void actualizar (ArrayList<TProductos> prod){
		for (int i = 0; i < prod.size(); i++) {
			String nombre=prod.get(i).getNombre();
			JCheckBox b = new JCheckBox(nombre);
			b.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(e.getStateChange()==ItemEvent.DESELECTED) {
						for(int j=0;j<prod.size();j++) {
							if(prod.get(j).getNombre().equalsIgnoreCase(nombre)) {
								productos.remove(prod.get(j));
							}
						}
					}
					
					if(e.getStateChange()==ItemEvent.SELECTED) {
						for(int j=0;j<prod.size();j++) {
							if(prod.get(j).getNombre().equalsIgnoreCase(nombre)) {
								productos.add(prod.get(j));
							}
						}
					}
				}
				
			});
			prodPanel.add(b);
		}
		this.pack();
	}
	
	
}
