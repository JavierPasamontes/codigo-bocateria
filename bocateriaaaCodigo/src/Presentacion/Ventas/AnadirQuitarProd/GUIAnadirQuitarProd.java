package Presentacion.Ventas.AnadirQuitarProd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import Presentacion.Controlador.MensajeGUI;


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
		productos=new ArrayList<TProductos>();
		JPanel botonPanel=new JPanel();
		JPanel comboPanel=new JPanel();
		prodPanel=new JPanel();
		prodPanel.setLayout(new GridLayout(3,3));
		JPanel cerrarPanel=new JPanel();
		aceptar=new JButton("Aceptar");
		aceptar.setEnabled(false);
		id=new JTextField(5);
		mostrar=new JButton("Mostrar productos");
		modelo = new DefaultComboBoxModel<>();
		modelo.addElement("Anadir");
		modelo.addElement("Quitar");
		quitarAnadir=new JComboBox(modelo);
		quitarAnadir.setSelectedIndex(0);
		quitarAnadir.setEnabled(false);
		mostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!id.getText().isEmpty()) {
					Controlador.getInstance().accion(Eventos.MOSTRAR_PRODUCTOS_AUX, null);
					aceptar.setEnabled(true);
					quitarAnadir.setEnabled(true);
					
					mostrar.setEnabled(false);
				}
				else {
					MensajeGUI a=new MensajeGUI();
					a.showMessage("Inserte id de venta", "Anadir Eliminar Producto", true);
				}
				
			}
			
			
		});
		
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!id.getText().equalsIgnoreCase("")) {
					Map<Integer, ArrayList<TProductos>> map=new HashMap<>();
					map.put(Integer.parseInt(id.getText()), productos);
					
					if(quitarAnadir.getSelectedItem().equals("Anadir")) {
						Controlador.getInstance().accion(Eventos.AGREGAR_PRODUCTO_VENTA, map);
					}
					else {
						Controlador.getInstance().accion(Eventos.ELIMINAR_PRODUCTO_VENTA, map);
					}
				}
				dispose();
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
			if(prod.get(i).getActivo()) {
				String nombre=prod.get(i).getNombre();
				TProductos boxProducto = prod.get(i);
				JCheckBox b = new JCheckBox(nombre);
				b.addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange()==ItemEvent.DESELECTED) {
							productos.remove(boxProducto);
						}
						
						if(e.getStateChange()==ItemEvent.SELECTED) {
							productos.add(boxProducto);
						}
					}
					
				});
				prodPanel.add(b);
			}
			
		}
		this.pack();
	}
	
	
}
