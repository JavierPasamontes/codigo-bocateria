package Presentacion.Productos.AltaProductos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class GUIAltaProductos extends JFrame{
	private JTextField campoNombre;
	private JTextField campoCantidad;
	private JTextField campoPrecio;
	private JTextField campoMarca;
	private JButton cancelar;
	private JButton aceptar;
	
	public GUIAltaProductos() {
		super("Alta Productos");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
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
		JLabel marcaLabel=new JLabel("Marca: ");
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
				if(campoNombre.getText().equalsIgnoreCase("")||campoCantidad.getText().equalsIgnoreCase("")||campoPrecio.getText().equalsIgnoreCase("")||campoMarca.getText().equalsIgnoreCase("")) {
					correcto=false;
				}
				if(correcto) {
						//Controlador.getInstance().accion(Eventos.ALTA_PRODUCTO, 
							//new TProducto(0, campoNombre.getText(), campoCantidad.getText(), true, campoPrecio.getText(), campoMarca.getText()));
						dispose();
				}
			}
			
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
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
