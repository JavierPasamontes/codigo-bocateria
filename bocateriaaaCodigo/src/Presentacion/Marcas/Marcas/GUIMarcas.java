package Presentacion.Marcas.Marcas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//import Negocio.Departamentos.TMarca;
import Presentacion.Controlador.Eventos;
import Presentacion.Controlador.MensajeGUI;
import Presentacion.Marcas.AltaMarca.GUIAltaMarca;
import Presentacion.Marcas.BajaMarca.GUIBajaMarca;
import Presentacion.Marcas.Marcas.GUIMarcas;
import Presentacion.Marcas.ModificarMarca.GUIModificarMarca;
import Presentacion.Marcas.MostrarMarcas.GUIMostrarMarcas;
import Presentacion.Marcas.MostrarUnaMarca.GUIMostrarUnaMarca;
import Presentacion.Marcas.MostrarProductosDeMarcas.*;

public class GUIMarcas extends JFrame{
	static JButton altaBoton;
	static JButton bajaBoton;
	static JButton modBoton;
	static JButton mostrarTodoBoton;
	static JButton mostrarPorIDBoton;
	static JButton volverBoton;
	static JButton prodDeMarcBoton;
	private GUIAltaMarca GUIAltaMarca;
	private GUIBajaMarca GUIBajaMarca;
	private GUIModificarMarca GUIModificarMarca;
	private GUIMostrarMarcas GUIMostrarMarcas;
	private GUIMostrarUnaMarca GUIMostrarUnaMarca;
	private GUIMostrarProdDeMarc GUIMostrarProdDeMarc;
	
	public GUIMarcas() {
		super("Marcas");
		initGUI();
	}
	
	public void initGUI() {
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JPanel superior = new JPanel();
		superior.setBackground(Color.GREEN);
		JPanel medio = new JPanel();
		medio.setBackground(Color.GREEN);
		JPanel inferior = new JPanel();
		inferior.setBackground(Color.GREEN);
		
		altaBoton=new JButton("Alta");
		altaBoton.setPreferredSize(new Dimension(150,50));
		altaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GUIAltaMarca =new GUIAltaMarca();
			}
			
			
		});
		bajaBoton=new JButton("Baja");
		bajaBoton.setPreferredSize(new Dimension(150,50));
		bajaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GUIBajaMarca =new GUIBajaMarca();
			}
			
			
		});
		modBoton=new JButton("Modificar");
		modBoton.setPreferredSize(new Dimension(150,50));
		modBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GUIModificarMarca =new GUIModificarMarca();
			}
			
			
		});
		mostrarTodoBoton=new JButton("Mostrar todo");
		mostrarTodoBoton.setPreferredSize(new Dimension(150,50));
		mostrarTodoBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				GUIMostrarMarcas =new GUIMostrarMarcas();			
			}
			
			
		});
		mostrarPorIDBoton=new JButton("Mostrar por ID");
		mostrarPorIDBoton.setPreferredSize(new Dimension(150,50));
		mostrarPorIDBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GUIMostrarUnaMarca =new GUIMostrarUnaMarca();
			}
			
			
		});
		
		prodDeMarcBoton=new JButton("Productos de una marca");
		prodDeMarcBoton.setPreferredSize(new Dimension(150,50));
		prodDeMarcBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GUIMostrarProdDeMarc =new GUIMostrarProdDeMarc();
			}
			
			
		});
		ImageIcon icono = new ImageIcon("resources/imgs/volver.png");
		volverBoton=new JButton(icono);
		volverBoton.setBorderPainted(false);
		volverBoton.setContentAreaFilled(false);
		volverBoton.setPreferredSize(new Dimension(150,75));
		volverBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
			
		});
		superior.add(altaBoton);
		superior.add(bajaBoton);
		superior.add(prodDeMarcBoton);
		medio.add(modBoton);
		medio.add(mostrarTodoBoton);
		medio.add(mostrarPorIDBoton);
		inferior.add(volverBoton);
		p.add(superior, BorderLayout.PAGE_START);
		p.add(medio, BorderLayout.CENTER);
		p.add(inferior, BorderLayout.PAGE_END);
		
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
				// TODO Auto-generated method stub
				new GUIMarcas();
			}
		});
	}

	public void actualizar(int evento, Object datos) {
		/*
		MensajeGUI a=new MensajeGUI();
		switch (evento) {
		case Eventos.ALTA_MARCA_OK:
			a.showMessage("Se ha dado de alta la marca con ID: " + (int)datos,"Alta marca", false);
			break;
		case Eventos.ALTA_MARCA_KO:
			a.showMessage("No se ha podido dar de alta la marca", "Alta marca", true);
			break;
		case Eventos.BAJA_MARCA_OK:
			a.showMessage("Se ha dado de baja la marca con ID: "+(int)datos, "Baja marca", false);
			break;
		case Eventos.BAJA_MARCA_KO:
			a.showMessage("No se ha podido dar de baja la marca con ID: "+(int)datos, "Baja marca", true);
			break;
		case Eventos.MODIFICAR_MARCA_OK:
			a.showMessage("Se ha modificado la marca correctamente", "Modificar marca", false);
			break;
		case Eventos.MODIFICAR_MARCA_KO:
			a.showMessage("No se ha podido modificar la marca", "Modificar marca", true);
			break;
		case Eventos.MOSTRAR_MARCAS_OK:
			GUIMostrarMarcas.actualizar((ArrayList<TMarca>)datos);
			break;
		case Eventos.MOSTRAR_MARCAS_KO:
			a.showMessage("No se pudo mostrar la lista de marcas", "Mostrar marcas", true);
			break;
		case Eventos.MOSTRAR_MARCA_OK:
			GUIMostrarUnaMarca.actualizar((TMarca)datos);
			break;
		case Eventos.MOSTRAR_MARCA_KO:
			a.showMessage("No se pudo mostrar la marca especificada", "Buscar marca", true);
			break;
		case Eventos.MOSTRAR_PROD_DE_MARCA_OK:
			GUIMostrarProdDeMarc.actualizar((String)datos);
			break;
		case Eventos.MOSTRAR_PROD_DE_MARCA_KO:
			a.showMessage("No se han podido mostrar los productos de la marca especificada", "Mostrar Productos de una Marca", true);
			break;
			
			puede que falte algun evento
		}
		*/
	}
}
