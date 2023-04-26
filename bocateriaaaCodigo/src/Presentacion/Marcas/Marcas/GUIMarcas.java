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

import Negocio.Marcas.TMarcas;
//import Negocio.Departamentos.TMarca;
import Presentacion.Controlador.Eventos;
import Presentacion.Controlador.MensajeGUI;
import Presentacion.Marcas.AltaMarca.GUIAltaMarca;
import Presentacion.Marcas.BajaMarca.GUIBajaMarca;
import Presentacion.Marcas.Marcas.GUIMarcas;
import Presentacion.Marcas.ModificarMarca.GUIModificarMarca;
import Presentacion.Marcas.MostrarMarcas.GUIMostrarMarcas;
import Presentacion.Marcas.MostrarUnaMarca.GUIMostrarUnaMarca;

@SuppressWarnings("serial")
public class GUIMarcas extends JFrame{
	static JButton altaBoton;
	static JButton bajaBoton;
	static JButton modBoton;
	static JButton mostrarTodoBoton;
	static JButton mostrarPorIDBoton;
	static JButton volverBoton;
	private GUIAltaMarca GUIAltaMarca;
	private GUIBajaMarca GUIBajaMarca;
	private GUIModificarMarca GUIModificarMarca;
	private GUIMostrarMarcas GUIMostrarMarcas;
	private GUIMostrarUnaMarca GUIMostrarUnaMarca;
	
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
		altaBoton.setPreferredSize(new Dimension(200,50));
		altaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIAltaMarca =new GUIAltaMarca();
			}
			
			
		});
		bajaBoton=new JButton("Baja");
		bajaBoton.setPreferredSize(new Dimension(200,50));
		bajaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIBajaMarca =new GUIBajaMarca();
			}
			
			
		});
		modBoton=new JButton("Modificar");
		modBoton.setPreferredSize(new Dimension(200,50));
		modBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIModificarMarca =new GUIModificarMarca();
			}
			
			
		});
		mostrarTodoBoton=new JButton("Mostrar todo");
		mostrarTodoBoton.setPreferredSize(new Dimension(200,50));
		mostrarTodoBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarMarcas =new GUIMostrarMarcas();			
			}
			
			
		});
		mostrarPorIDBoton=new JButton("Mostrar por ID");
		mostrarPorIDBoton.setPreferredSize(new Dimension(200,50));
		mostrarPorIDBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarUnaMarca =new GUIMostrarUnaMarca();
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
				dispose();
			}
			
			
		});
		superior.add(altaBoton);
		superior.add(bajaBoton);
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
				new GUIMarcas();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public void actualizar(int evento, Object datos) {
		
		MensajeGUI a=new MensajeGUI();
		switch (evento) {
		case Eventos.ALTA_MARCAS_OK:
			a.showMessage("Se ha dado de alta la marca con ID: " + (int)datos,"Alta marca", false);
			break;
		case Eventos.ALTA_MARCAS_KO:
			a.showMessage("No se ha podido dar de alta la marca", "Alta marca", true);
			break;
		case Eventos.BAJA_MARCAS_OK:
			a.showMessage("Se ha dado de baja la marca con ID: "+(int)datos, "Baja marca", false);
			break;
		case Eventos.BAJA_MARCAS_KO:
			a.showMessage("No se ha podido dar de baja la marca con ID: "+(int)datos, "Baja marca", true);
			break;
		case Eventos.MODIFICAR_MARCAS_OK:
			a.showMessage("Se ha modificado la marca correctamente", "Modificar marca", false);
			break;
		case Eventos.MODIFICAR_MARCAS_KO:
			a.showMessage("No se ha podido modificar la marca", "Modificar marca", true);
			break;
		case Eventos.MOSTRAR_MARCAS_OK:
			GUIMostrarMarcas.actualizar((ArrayList<TMarcas>)datos);
			break;
		case Eventos.MOSTRAR_MARCAS_KO:
			a.showMessage("No se pudo mostrar la lista de marcas", "Mostrar marcas", true);
			break;
		case Eventos.MOSTRAR_MARCA_OK:
			GUIMostrarUnaMarca.actualizar((TMarcas)datos);
			break;
		case Eventos.MOSTRAR_MARCA_KO:
			a.showMessage("No se pudo mostrar la marca especificada", "Buscar marca", true);
			break;
		}
		
	}
}
