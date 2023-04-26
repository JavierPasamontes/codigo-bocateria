package Presentacion.Ventas.Ventas;

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

import Presentacion.Productos.AltaProductos.GUIAltaProductos;
import Presentacion.Productos.BajaProductos.GUIBajaProductos;
import Presentacion.Productos.ModificarProducto.GUIModificarProducto;
import Presentacion.Productos.MostrarProdDeMarca.GUIMostrarProdDeMarca;
import Presentacion.Productos.MostrarProductos.GUIMostrarProductos;
import Presentacion.Productos.MostrarUnProductos.GUIMostrarUnProd;
import Presentacion.Productos.Productos.GUIProductos;

public class GUIVentas extends JFrame{
	static JButton altaBoton;
	static JButton cerrarBoton;
	static JButton modBoton;
	static JButton mostrarTodoBoton;
	static JButton mostrarPorIDBoton;
	static JButton mostrarVentasEmp;
	static JButton mostrarProdDeVenta;
	static JButton anadirQuitarProd;
	static JButton volverBoton;
	//private GUIAltaVenta GUIAltaVenta;
	//private GUICerrarVenta GUICerrarVenta;
	//private GUIModificarVenta GUIModificarVenta;
	//private GUIMostrarVentas GUIMostrarVentas;
	//private GUIMostrarUnaVenta GUIMostrarUnaVenta;
	//private GUIMostrarVentasEmp GUIMostrarVentasEmp;
	//private GUIMostrarProdDeVenta GUIMostrarProdDeVenta;
	//private GUIAnadirQuitarProd GUIAnadirQuitarProd;
	
	public GUIVentas() {
		super("Ventas");
		initGUI();
	}
	
	public void initGUI() {
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JPanel superior = new JPanel();
		superior.setBackground(Color.YELLOW);
		JPanel medio = new JPanel();
		medio.setBackground(Color.YELLOW);
		JPanel inferior = new JPanel();
		inferior.setBackground(Color.YELLOW);
		
		altaBoton=new JButton("Alta");
		altaBoton.setPreferredSize(new Dimension(150,50));
		altaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIAltaVenta =new GUIAltaVenta();
			}
			
			
		});
		cerrarBoton=new JButton("Baja");
		cerrarBoton.setPreferredSize(new Dimension(150,50));
		cerrarBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUICerrarVenta =new GUICerrarVenta();
			}
			
			
		});
		modBoton=new JButton("Modificar");
		modBoton.setPreferredSize(new Dimension(150,50));
		modBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIModificarVenta =new GUIModificarVenta();
			}
			
			
		});
		mostrarTodoBoton=new JButton("Mostrar todo");
		mostrarTodoBoton.setPreferredSize(new Dimension(150,50));
		mostrarTodoBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//GUIMostrarVentas =new GUIMostrarVentas();			
			}
			
			
		});
		mostrarPorIDBoton=new JButton("Mostrar por ID");
		mostrarPorIDBoton.setPreferredSize(new Dimension(150,50));
		mostrarPorIDBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GUIMostrarUnaVenta =new GUIMostrarUnaVenta();
			}
			
			
		});
		
		mostrarProdDeMarca=new JButton("Mostrar Prod. de Marca");
		mostrarProdDeMarca.setPreferredSize(new Dimension(150,50));
		mostrarProdDeMarca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
				// TODO Auto-generated method stub
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
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new GUIVentas();
			}
		});
	}

	/*
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
			GUIMostrarProds.actualizar((ArrayList<TProductos>)datos);
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
		case Eventos.MOSTRAR_PROD_DE_MARCA_OK:
			GUIMostrarProdDeMarca.actualizar((String)datos);
			break;
		case Eventos.MOSTRAR_PROD_DE_MARCA_KO:
			a.showMessage("No se pudieron mostrar los productos de la marca especificada", "Mostrar Productos de Una Marca", true);
			break;
		}
	}
	*/
}
