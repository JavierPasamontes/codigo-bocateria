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
		departamentos.setPreferredSize(new Dimension(150,50));
		departamentos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controlador.getInstance().accion(Eventos.VISTA_DEPARTAMENTOS, null);
				//GUIAltaDepartamento =new GUIAltaDepartamento();
			}
			
			
		});
		marcas=new JButton("Marcas");
		marcas.setPreferredSize(new Dimension(150,50));
		marcas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIBajaDepts =new GUIBajaDepts();
			}
			
			
		});
		productos=new JButton("Productos");
		productos.setPreferredSize(new Dimension(150,50));
		productos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIModificarDept =new GUIModificarDept();
			}
			
			
		});
		proveedores=new JButton("Proveedores");
		proveedores.setPreferredSize(new Dimension(150,50));
		proveedores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIMostrarDepts =new GUIMostrarDepts();			
			}
			
			
		});
		ventas=new JButton("Ventas");
		ventas.setPreferredSize(new Dimension(150,50));
		ventas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIMostrarUnDept =new GUIMostrarUnDept();
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
