package Presentacion.Productos.ModificarProducto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Negocio.Productos.TProductos;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Productos.AltaProductos.GUIAltaProductos;

@SuppressWarnings("serial")
public class GUIModificarProducto extends JFrame{
	private JTextField campoId;
	private JTextField campoNombre;
	private JTextField campoCantidad;
	private JTextField campoPrecio;
	private JTextField campoMarca;
	private JButton cancelar;
	private JButton aceptar;
	
	public GUIModificarProducto() {
		super("Modificar Producto");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID: ");
		campoId=new JTextField(12);
		id.add(idLabel);
		id.add(campoId);
		
		JPanel nombre=new JPanel();
		JLabel nombreLabel=new JLabel("Nombre: ");
		campoNombre=new JTextField(12);
		nombre.add(nombreLabel);
		nombre.add(campoNombre);
		
		JPanel cantidad=new JPanel();
		JLabel cantidadLabel=new JLabel("Cantidad: ");
		campoCantidad=new JTextField(12);
		cantidad.add(cantidadLabel);
		cantidad.add(campoCantidad);
		
		JPanel precio=new JPanel();
		JLabel precioLabel=new JLabel("Precio: ");
		campoPrecio=new JTextField(12);
		precio.add(precioLabel);
		precio.add(campoPrecio);
		
		JPanel marca=new JPanel();
		JLabel marcaLabel=new JLabel("Marca(ID): ");
		campoMarca=new JTextField(12);
		marca.add(marcaLabel);
		marca.add(campoMarca);
		
		JPanel botones=new JPanel();
		cancelar=new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
			
		});
		aceptar=new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean correcto=true;
				if(campoId.getText().equalsIgnoreCase("")) {
					correcto=false;
				}
				if(correcto) {
						Controlador.getInstance().accion(Eventos.MODIFICAR_PRODUCTO, 
								new TProductos(Integer.parseInt(campoId.getText()), campoNombre.getText(), Integer.parseInt(campoCantidad.getText()), Double.parseDouble(campoPrecio.getText()), true,Integer.parseInt(campoMarca.getText())));
						dispose();
				}
			}
			
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(id);
		p.add(nombre);
		p.add(cantidad);
		p.add(precio);
		p.add(marca);
		p.add(botones);
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
				new GUIAltaProductos();
			}
		});


	}
}
