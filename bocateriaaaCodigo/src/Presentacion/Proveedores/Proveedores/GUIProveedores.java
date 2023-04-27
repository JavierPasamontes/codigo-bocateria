package Presentacion.Proveedores.Proveedores;

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

import Negocio.Proveedores.TProveedores;
import Presentacion.Controlador.Eventos;
import Presentacion.Controlador.MensajeGUI;
import Presentacion.Proveedores.AltaProv.*;
import Presentacion.Proveedores.BajaProv.*;
import Presentacion.Proveedores.DesvincularMarca.GUIDesvincularMarca;
import Presentacion.Proveedores.ModificarProv.*;
import Presentacion.Proveedores.MostrarMarcasdeProv.GUIMostrarMdeP;
import Presentacion.Proveedores.MostrarProv.*;
import Presentacion.Proveedores.MostrarUnProv.GUIBuscarProv;
import Presentacion.Proveedores.VincularMarca.GUIVincularMarca;

@SuppressWarnings("serial")
public class GUIProveedores extends JFrame{
	static JButton altaBoton;
	static JButton bajaBoton;
	static JButton modBoton;
	static JButton mostrarTodoBoton;
	static JButton mostrarPorIDBoton;
	static JButton volverBoton;
	static JButton vincularBoton;
	static JButton desvincularBoton;
	static JButton mostrarMdePBoton;
	private GUIMostrarProvs guiMostrarProvs;
	private GUIBuscarProv guiBuscarProv;
	private GUIMostrarMdeP guiMostrarMdeP;
	public GUIProveedores() {
		super("Proveedores");
		initGUI();
	}
	
	public void initGUI() {
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JPanel superior = new JPanel();
		superior.setBackground(Color.GRAY);
		JPanel medio = new JPanel();
		medio.setBackground(Color.GRAY);
		JPanel inferior = new JPanel();
		inferior.setBackground(Color.GRAY );
		JPanel bajo = new JPanel();
		bajo.setBackground(Color.GRAY );
		
		altaBoton=new JButton("Alta");
		altaBoton.setPreferredSize(new Dimension(200,50));
		altaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GUIAltaProv();
			}
			
			
		});
		bajaBoton=new JButton("Baja");
		bajaBoton.setPreferredSize(new Dimension(200,50));
		bajaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GUIBajaProv();
			}
			
			
		});
		modBoton=new JButton("Modificar");
		modBoton.setPreferredSize(new Dimension(200,50));
		modBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GUIModProv();
			}
			
			
		});
		mostrarTodoBoton=new JButton("Mostrar todo");
		mostrarTodoBoton.setPreferredSize(new Dimension(200,50));
		mostrarTodoBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guiMostrarProvs =  new GUIMostrarProvs();			
			}
			
			
		});
		mostrarPorIDBoton=new JButton("Mostrar por ID");
		mostrarPorIDBoton.setPreferredSize(new Dimension(200,50));
		mostrarPorIDBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guiBuscarProv = new GUIBuscarProv();
			}
			
			
		});
		
		vincularBoton=new JButton("Vincular marca por ID");
		vincularBoton.setPreferredSize(new Dimension(200,50));
		vincularBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GUIVincularMarca();
			}
			
			
		});
		
		desvincularBoton=new JButton("Desvincular marca por ID");
		desvincularBoton.setPreferredSize(new Dimension(200,50));
		desvincularBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 new GUIDesvincularMarca();
			}
			
			
		});
		
		mostrarMdePBoton =new JButton("Mostrar marcas de proveedor");
		mostrarMdePBoton.setPreferredSize(new Dimension(200,50));
		mostrarMdePBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guiMostrarMdeP = new GUIMostrarMdeP();
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
		bajo.add(vincularBoton);
		bajo.add(desvincularBoton);
		bajo.add(mostrarMdePBoton);
		inferior.add(volverBoton);
		p.add(superior, BorderLayout.PAGE_START);
		p.add(medio, BorderLayout.CENTER);
		p.add(bajo, BorderLayout.CENTER);
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
				new GUIProveedores();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public void actualizar(int evento, Object datos) {
		MensajeGUI a=new MensajeGUI();
		switch (evento) {
		case Eventos.ALTA_PROVEEDOR_OK:
			a.showMessage("Se ha dado de alta al Prov con ID: " + (int)datos,"Alta PROV", false);
			break;
		case Eventos.ALTA_PROVEEDOR_KO :
			a.showMessage("No se ha podido dar de alta al PROV", "Alta PROV", true);
			break;
		case Eventos.BAJA_PROVEEDOR_OK:
			a.showMessage("Se ha dado de baja al PROV con ID: "+(int)datos, "Baja PROV", false);
			break;
		case Eventos.BAJA_PROVEEDOR_KO:
			a.showMessage("No se ha podido dar de baja al PROV con ID: "+(int)datos, "Baja PROV", true);
			break;
		case Eventos.MODIFICAR_PROVEEDOR_OK:
			a.showMessage("Se ha modificado el PROV correctamente", "Modificar PROV", false);
			break;
		case Eventos.MODIFICAR_PROVEEDOR_KO:
			a.showMessage("No se ha podido modificar el PROV", "Modificar PROV", true);
			break;
		case Eventos.MOSTRAR_PROVEEDORES_OK:
			guiMostrarProvs.actualizar((ArrayList<TProveedores>)datos);
			break;
		case Eventos.MOSTRAR_PROVEEDORES_KO:
			a.showMessage("No se pudo mostrar la lista de proveedores", "Mostrar empleados", true);
			break;
		case Eventos.BUSCAR_PROVEEDOR_OK:
			guiBuscarProv.actualizar((TProveedores)datos);
			break;
		case Eventos.BUSCAR_PROVEEDOR_KO:
			a.showMessage("No se pudo mostrar el empleado especificado", "Buscar empleado", true);
		case Eventos.VINCULAR_MARCA_OK:
			a.showMessage("Marca y proveedor vinculados correctamente", "Vincular Marca", false);
			break;
		case Eventos.VINCULAR_MARCA_KO:
			if((Integer) datos == -2)
				a.showMessage("Marca ya vinculada al proveedor", "Vincular Marca", true);
			else if((Integer) datos == -1)
				a.showMessage("Marca o Proveedor no existente", "Vincular Marca", true);
			break;
		case Eventos.DESVINCULAR_MARCA_OK:
			a.showMessage("Se ha dado desvinculado la marca correctamente" ,"Desvincular Marca", false);
			break;
		case Eventos.DESVINCULAR_MARCA_KO:
			a.showMessage("No se ha podido desvincular la marca con el proveedor", "Desvincular Marca", true);
			break;
		case Eventos.MOSTRAR_MARCAS_DE_PROV_OK:
			guiMostrarMdeP.actualizar((ArrayList<String>)datos);
			break;
		case Eventos.MOSTRAR_MARCAS_DE_PROV_KO:
			a.showMessage("No se pudo mostrar la lista de marcas", "Mostrar empleados", true);
			break;
		}
	}
}

