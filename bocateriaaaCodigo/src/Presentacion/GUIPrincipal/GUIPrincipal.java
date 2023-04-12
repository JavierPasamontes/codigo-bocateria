package Presentacion.GUIPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

public class GUIPrincipal extends JFrame{
	private JButton departamentos;
	private JButton marcas;
	private JButton productos;
	private JButton proveedores;
	private JButton ventas;
	private JButton empleados;
	private JButton volverBoton;
	
	
	public GUIPrincipal() {
		super("Bocateria El Bocatin");
		initGUI();
	}
	
	public void initGUI() {
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JPanel superior = new JPanel();
		superior.setBackground(Color.RED);
		JPanel medio = new JPanel();
		medio.setBackground(Color.RED);
		JPanel inferior = new JPanel();
		inferior.setBackground(Color.RED);
		
		departamentos=new JButton("Departamentos");
		ImageIcon iconodep = new ImageIcon("resources/imgs/botonDep.png");
		departamentos=new JButton(iconodep);
		departamentos.setBorderPainted(false);
		departamentos.setContentAreaFilled(false);
		departamentos.setPreferredSize(new Dimension(200,100));
		departamentos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controlador.getInstance().accion(Eventos.VISTA_DEPARTAMENTOS, null);
				//GUIAltaDepartamento =new GUIAltaDepartamento();
			}
			
			
		});
		marcas=new JButton("Marcas");
		ImageIcon iconomarc = new ImageIcon("resources/imgs/botonMarcas.png");
		marcas=new JButton(iconomarc);
		marcas.setBorderPainted(false);
		marcas.setContentAreaFilled(false);
		marcas.setPreferredSize(new Dimension(200,100));
		marcas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIBajaDepts =new GUIBajaDepts();
			}
			
			
		});
		productos=new JButton("Productos");
		ImageIcon iconoprod = new ImageIcon("resources/imgs/botonProds.png");
		productos=new JButton(iconoprod);
		productos.setBorderPainted(false);
		productos.setContentAreaFilled(false);
		productos.setPreferredSize(new Dimension(200,100));
		productos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIModificarDept =new GUIModificarDept();
			}
			
			
		});
		proveedores=new JButton("Proveedores");
		ImageIcon iconoprov = new ImageIcon("resources/imgs/botonProv.png");
		proveedores=new JButton(iconoprov);
		proveedores.setBorderPainted(false);
		proveedores.setContentAreaFilled(false);
		proveedores.setPreferredSize(new Dimension(200,100));
		proveedores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIMostrarDepts =new GUIMostrarDepts();			
			}
			
			
		});
		ventas=new JButton("Ventas");
		ImageIcon iconovent = new ImageIcon("resources/imgs/botonVentas.png");
		ventas=new JButton(iconovent);
		ventas.setBorderPainted(false);
		ventas.setContentAreaFilled(false);
		ventas.setPreferredSize(new Dimension(200,100));
		ventas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIMostrarUnDept =new GUIMostrarUnDept();
			}
			
			
		});
		
		empleados=new JButton("Empleados");
		ImageIcon iconoemp = new ImageIcon("resources/imgs/botonEmp.png");
		empleados=new JButton(iconoemp);
		empleados.setBorderPainted(false);
		empleados.setContentAreaFilled(false);
		empleados.setPreferredSize(new Dimension(200,100));
		empleados.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIModificarDept =new GUIModificarDept();
			}
			
			
		});
		ImageIcon icono = new ImageIcon("resources/imgs/salir.png");
		volverBoton=new JButton(icono);
		volverBoton.setBorderPainted(false);
		volverBoton.setContentAreaFilled(false);
		volverBoton.setPreferredSize(new Dimension(150,75));
		volverBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			
		});
		superior.add(departamentos);
		superior.add(marcas);
		superior.add(empleados);
		medio.add(productos);
		medio.add(proveedores);
		medio.add(ventas);
		inferior.add(volverBoton);
		p.add(superior, BorderLayout.PAGE_START);
		p.add(medio, BorderLayout.CENTER);
		p.add(inferior, BorderLayout.PAGE_END);
		
		this.setContentPane(p);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocation(500,500);
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
		public void run() {
			// TODO Auto-generated method stub
			new GUIPrincipal();
			}
		});
	}


}
