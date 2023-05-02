package Presentacion.Ventas.Ventas;

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
import Negocio.Productos.TProductos;
import Negocio.Ventas.TVentas;
import Presentacion.Controlador.Eventos;
import Presentacion.Controlador.MensajeGUI;
import Presentacion.Ventas.AltaVentas.*;
import Presentacion.Ventas.CerrarVenta.*;
import Presentacion.Ventas.ModificarVenta.*;
import Presentacion.Ventas.MostrarVentas.*;
import Presentacion.Ventas.MostrarUnaVenta.*;
import Presentacion.Ventas.MostrarVentasEmp.*;
import Presentacion.Ventas.MostrarProdDeVenta.*;
import Presentacion.Ventas.AnadirQuitarProd.*;
import Presentacion.Ventas.EliminarVenta.*;


@SuppressWarnings("serial")
public class GUIVentas extends JFrame{
	static JButton altaBoton;
	static JButton cerrarBoton;
	static JButton modBoton;
	static JButton mostrarTodoBoton;
	static JButton mostrarPorIDBoton;
	static JButton mostrarVentasEmp;
	static JButton mostrarProdDeVenta;
	static JButton anadirQuitarProd;
	static JButton eliminarVenta;
	static JButton volverBoton;
	@SuppressWarnings("unused")
	private GUIAltaVentas GUIAltaVentas;
	@SuppressWarnings("unused")
	private GUICerrarVenta GUICerrarVenta;
	@SuppressWarnings("unused")
	private GUIModificarVenta GUIModificarVenta;
	private GUIMostrarVentas GUIMostrarVentas;
	private GUIMostrarUnaVenta GUIMostrarUnaVenta;
	private GUIMostrarVentasEmp GUIMostrarVentasEmp;
	private GUIMostrarProdDeVenta GUIMostrarProdDeVenta;
	private GUIAnadirQuitarProd GUIAnadirQuitarProd;
	@SuppressWarnings("unused")
	private GUIEliminarVenta GUIEliminarVenta;
	
	
	
	public GUIVentas() {
		super("Ventas");
		initGUI();
	}
	
	public void initGUI() {
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JPanel superior = new JPanel();
		superior.setBackground(Color.PINK);
		JPanel medio = new JPanel();
		medio.setBackground(Color.PINK);
		JPanel medio2 = new JPanel();
		medio2.setBackground(Color.PINK);
		JPanel inferior = new JPanel();
		inferior.setBackground(Color.PINK);
		
		altaBoton=new JButton("Alta");
		altaBoton.setPreferredSize(new Dimension(200,50));
		altaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIAltaVentas =new GUIAltaVentas();
			}
			
			
		});
		cerrarBoton=new JButton("Cerrar Venta");
		cerrarBoton.setPreferredSize(new Dimension(200,50));
		cerrarBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUICerrarVenta =new GUICerrarVenta();
			}
			
			
		});
		modBoton=new JButton("Modificar");
		modBoton.setPreferredSize(new Dimension(200,50));
		modBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIModificarVenta =new GUIModificarVenta();
			}
			
			
		});
		mostrarTodoBoton=new JButton("Mostrar todo");
		mostrarTodoBoton.setPreferredSize(new Dimension(200,50));
		mostrarTodoBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarVentas =new GUIMostrarVentas();			
			}
			
			
		});
		mostrarPorIDBoton=new JButton("Mostrar por ID");
		mostrarPorIDBoton.setPreferredSize(new Dimension(200,50));
		mostrarPorIDBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarUnaVenta =new GUIMostrarUnaVenta();
			}
			
			
		});
		
		mostrarVentasEmp=new JButton("<html><p>Mostrar ventas de</p><p>un empleado</p></html>");
		mostrarVentasEmp.setPreferredSize(new Dimension(200,50));
		mostrarVentasEmp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarVentasEmp =new GUIMostrarVentasEmp();
			}
			
			
		});
		
		mostrarProdDeVenta=new JButton("<html><p>Mostrar productos de</p><p>una venta</p></html>");
		mostrarProdDeVenta.setPreferredSize(new Dimension(200,50));
		mostrarProdDeVenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarProdDeVenta =new GUIMostrarProdDeVenta();
			}
			
			
		});
		
		anadirQuitarProd=new JButton("Añadir/Quitar productos");
		anadirQuitarProd.setPreferredSize(new Dimension(200,50));
		anadirQuitarProd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIAnadirQuitarProd =new GUIAnadirQuitarProd();
			}
			
			
		});
		
		eliminarVenta=new JButton("Eliminar");
		eliminarVenta.setPreferredSize(new Dimension(200,50));
		eliminarVenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIEliminarVenta =new GUIEliminarVenta();
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
		superior.add(cerrarBoton);
		superior.add(mostrarVentasEmp);
		medio.add(modBoton);
		medio.add(mostrarTodoBoton);
		medio.add(mostrarPorIDBoton);
		medio2.add(mostrarProdDeVenta);
		medio2.add(anadirQuitarProd);
		medio2.add(eliminarVenta);
		inferior.add(volverBoton);
		p.add(superior, BorderLayout.PAGE_START);
		p.add(medio, BorderLayout.CENTER);
		p.add(medio2, BorderLayout.CENTER);
		p.add(inferior, BorderLayout.PAGE_END);
		
		this.setContentPane(p);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocation(400,400);
	}
	
	@SuppressWarnings("unchecked")
	public void actualizar(int evento, Object datos) {
		MensajeGUI a=new MensajeGUI();
		switch (evento) {
		case Eventos.ALTA_VENTA_OK:
			a.showMessage("Se ha dado de alta la venta con ID: " + (int)datos,"Alta venta", false);
			break;
		case Eventos.ALTA_VENTA_KO:
			a.showMessage("No se ha podido dar de alta la venta", "Alta venta", true);
			break;
		case Eventos.CERRAR_VENTA_OK:
			a.showMessage("Se ha cerrado la venta con ID: "+(int)datos, "Cerrar venta", false);
			break;
		case Eventos.CERRAR_VENTA_KO:
			a.showMessage("No se ha podido cerrar la venta con ID: "+(int)datos, "Cerrar Venta", true);
			break;
		case Eventos.MODIFICAR_VENTA_OK:
			a.showMessage("Se ha modificado la venta correctamente", "Modificar venta", false);
			break;
		case Eventos.MODIFICAR_VENTA_KO:
			a.showMessage("No se ha podido modificar la venta", "Modificar venta", true);
			break;
		case Eventos.MOSTRAR_VENTAS_OK:
			GUIMostrarVentas.actualizar((ArrayList<TVentas>)datos);
			break;
		case Eventos.MOSTRAR_VENTAS_KO:
			a.showMessage("No se pudo mostrar la lista de ventas", "Mostrar ventas", true);
			break;
		case Eventos.MOSTRAR_VENTA_OK:
			GUIMostrarUnaVenta.actualizar((TVentas)datos);
			break;
		case Eventos.MOSTRAR_VENTA_KO:
			a.showMessage("No se pudo mostrar la venta especificada", "Buscar venta", true);
			break;
		case Eventos.MOSTRAR_PRODUCTOS_VENTA_OK:
			GUIMostrarProdDeVenta.actualizar((ArrayList<TProductos>)datos);
			break;
		case Eventos.MOSTRAR_PRODUCTOS_VENTA_KO:
			a.showMessage("No se pudieron mostrar los productos de la venta especificada", "Mostrar productos de una venta", true);
			break;
		case Eventos.MOSTRAR_VENTAS_EMPLEADO_OK:
			GUIMostrarVentasEmp.actualizar((ArrayList<TVentas>)datos);
			break;
		case Eventos.MOSTRAR_VENTAS_EMPLEADO_KO:
			a.showMessage("No se pudieron mostrar las ventas del empleado especificado", "Mostrar ventas de un empleado", true);
			break;
		case Eventos.MOSTRAR_PRODUCTOS_AUX_OK:
			GUIAnadirQuitarProd.actualizar((ArrayList<TProductos>)datos);
			break;
		case Eventos.MOSTRAR_PRODUCTOS_AUX_KO:
			a.showMessage("Error al mostrar la lista de productos", "Anadir o quitar productos", true);
			break;
		case Eventos.AGREGAR_PRODUCTO_VENTA_OK:
			a.showMessage("Se han añadido los productos correctamente", "Anadir productos", false);
			break;
		case Eventos.AGREGAR_PRODUCTO_VENTA_KO:
			a.showMessage("No se han podido añadir los productos", "Anadir productos", true);
			break;
		case Eventos.ELIMINAR_PRODUCTO_VENTA_OK:
			a.showMessage("Se han quitado los productos correctamente", "Quitar productos", false);
			break;
		case Eventos.ELIMINAR_PRODUCTO_VENTA_KO:
			a.showMessage("No se han podido quitar los productos", "Quitar productos", true);
			break;
		case Eventos.BAJA_VENTA_OK:
			a.showMessage("Se ha eliminado la venta con ID: "+(int)datos, "Eliminar venta", false);
			break;
		case Eventos.BAJA_VENTA_KO:
			a.showMessage("No se ha podido eliminar la venta", "Eliminar venta", true);
			break;
		}
	}
	
}
