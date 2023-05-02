package Presentacion.Productos.Productos;

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
import Presentacion.Controlador.Eventos;
import Presentacion.Controlador.MensajeGUI;
import Presentacion.Productos.AltaProductos.*;
import Presentacion.Productos.BajaProductos.*;
import Presentacion.Productos.ModificarProducto.*;
import Presentacion.Productos.MostrarProductos.*;
import Presentacion.Productos.MostrarUnProductos.*;
import Presentacion.Productos.MostrarProdDeMarca.*;

@SuppressWarnings("serial")
public class GUIProductos extends JFrame{
	static JButton altaBoton;
	static JButton bajaBoton;
	static JButton modBoton;
	static JButton mostrarTodoBoton;
	static JButton mostrarPorIDBoton;
	static JButton mostrarProdDeMarca;
	static JButton volverBoton;
	private GUIMostrarProductos GUIMostrarProductos;
	private GUIMostrarUnProd GUIMostrarUnProd;
	private GUIMostrarProdDeMarca GUIMostrarProdDeMarca;
	
	public GUIProductos() {
		super("Productos");
		initGUI();
	}
	
	public void initGUI() {
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JPanel superior = new JPanel();
		superior.setBackground(Color.CYAN);
		JPanel medio = new JPanel();
		medio.setBackground(Color.CYAN);
		JPanel inferior = new JPanel();
		inferior.setBackground(Color.CYAN);
		
		altaBoton=new JButton("Alta");
		altaBoton.setPreferredSize(new Dimension(200,50));
		altaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GUIAltaProductos();
			}
			
			
		});
		bajaBoton=new JButton("Baja");
		bajaBoton.setPreferredSize(new Dimension(200,50));
		bajaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GUIBajaProductos();
			}
			
			
		});
		modBoton=new JButton("Modificar");
		modBoton.setPreferredSize(new Dimension(200,50));
		modBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GUIModificarProducto();
			}
			
			
		});
		mostrarTodoBoton=new JButton("Mostrar todo");
		mostrarTodoBoton.setPreferredSize(new Dimension(200,50));
		mostrarTodoBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarProductos =new GUIMostrarProductos();			
			}
			
			
		});
		mostrarPorIDBoton=new JButton("Mostrar por ID");
		mostrarPorIDBoton.setPreferredSize(new Dimension(200,50));
		mostrarPorIDBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarUnProd =new GUIMostrarUnProd();
			}
			
			
		});
		
		mostrarProdDeMarca=new JButton("<html><p>Mostrar productos de</p><p>una marca</p></html>");
		mostrarProdDeMarca.setPreferredSize(new Dimension(200,50));
		mostrarProdDeMarca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarProdDeMarca =new GUIMostrarProdDeMarca();
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
		superior.add(mostrarProdDeMarca);
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

	@SuppressWarnings("unchecked")
	public void actualizar(int evento, Object datos) {
		MensajeGUI a=new MensajeGUI();
		switch (evento) {
		case Eventos.ALTA_PRODUCTO_OK:
			a.showMessage("Se ha dado de alta el producto con ID: " + (int)datos,"Alta productos", false);
			break;
		case Eventos.ALTA_PRODUCTO_KO:
			a.showMessage("No se ha podido dar de alta el producto", "Alta productos", true);
			break;
		case Eventos.BAJA_PRODUCTO_OK:
			a.showMessage("Se ha dado de baja al producto con ID: "+(int)datos, "Baja productos", false);
			break;
		case Eventos.BAJA_PRODUCTO_KO:
			a.showMessage("No se ha podido dar de baja el producto con ID: "+(int)datos, "Baja productos", true);
			break;
		case Eventos.MODIFICAR_PRODUCTO_OK:
			a.showMessage("Se ha modificado el producto correctamente", "Modificar producto", false);
			break;
		case Eventos.MODIFICAR_PRODUCTO_KO:
			a.showMessage("No se ha podido modificar el producto", "Modificar producto", true);
			break;
		case Eventos.MOSTRAR_PRODUCTOS_OK:
			GUIMostrarProductos.actualizar((ArrayList<TProductos>)datos);
			break;
		case Eventos.MOSTRAR_PRODUCTOS_KO:
			a.showMessage("No se pudo mostrar la lista de productos", "Mostrar productos", true);
			break;
		case Eventos.MOSTRAR_PRODUCTO_OK:
			GUIMostrarUnProd.actualizar((TProductos)datos);
			break;
		case Eventos.MOSTRAR_PRODUCTO_KO:
			a.showMessage("No se pudo mostrar el producto especificado", "Buscar producto", true);
			break;
		case Eventos.MOSTRAR_PRODUCTOS_MARCA_OK:
			GUIMostrarProdDeMarca.actualizar((ArrayList<TProductos>)datos);
			break;
		case Eventos.MOSTRAR_PRODUCTOS_MARCA_KO:
			a.showMessage("No se pudieron mostrar los productos de la marca especificada", "Mostrar Productos de Una Marca", true);
			break;
		}
	}
}
