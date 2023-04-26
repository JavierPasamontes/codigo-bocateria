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
				// TODO Auto-generated method stub
				//GUIAltaVenta =new GUIAltaVenta();
			}
			
			
		});
		cerrarBoton=new JButton("Cerrar Venta");
		cerrarBoton.setPreferredSize(new Dimension(200,50));
		cerrarBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUICerrarVenta =new GUICerrarVenta();
			}
			
			
		});
		modBoton=new JButton("Modificar");
		modBoton.setPreferredSize(new Dimension(200,50));
		modBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIModificarVenta =new GUIModificarVenta();
			}
			
			
		});
		mostrarTodoBoton=new JButton("Mostrar todo");
		mostrarTodoBoton.setPreferredSize(new Dimension(200,50));
		mostrarTodoBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//GUIMostrarVentas =new GUIMostrarVentas();			
			}
			
			
		});
		mostrarPorIDBoton=new JButton("Mostrar por ID");
		mostrarPorIDBoton.setPreferredSize(new Dimension(200,50));
		mostrarPorIDBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIMostrarUnaVenta =new GUIMostrarUnaVenta();
			}
			
			
		});
		
		mostrarVentasEmp=new JButton("Mostrar Ventas de Empleados");
		mostrarVentasEmp.setPreferredSize(new Dimension(200,50));
		mostrarVentasEmp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIMostrarVentasEmp =new GUIMostrarVentasEmp();
			}
			
			
		});
		
		mostrarProdDeVenta=new JButton("Mostrar Productos de Una venta");
		mostrarProdDeVenta.setPreferredSize(new Dimension(200,50));
		mostrarProdDeVenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIMostrarProdDeVenta =new GUIMostrarProdDeVenta();
			}
			
			
		});
		
		anadirQuitarProd=new JButton("Añadir/Quitar productos");
		anadirQuitarProd.setPreferredSize(new Dimension(200,50));
		anadirQuitarProd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GUIAnadirQuitarProd =new GUIAnadirQuitarProd();
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
		superior.add(cerrarBoton);
		superior.add(mostrarVentasEmp);
		medio.add(modBoton);
		medio.add(mostrarTodoBoton);
		medio.add(mostrarPorIDBoton);
		medio2.add(mostrarProdDeVenta);
		medio2.add(anadirQuitarProd);
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
