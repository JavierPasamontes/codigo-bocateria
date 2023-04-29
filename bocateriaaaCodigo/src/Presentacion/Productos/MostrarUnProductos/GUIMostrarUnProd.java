package Presentacion.Productos.MostrarUnProductos;

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
import Presentacion.Marcas.MostrarUnaMarca.GUIMostrarUnaMarca;

@SuppressWarnings("serial")
public class GUIMostrarUnProd extends JFrame{
	private JTextField campoID;
	private JButton cancelar;
	private JButton aceptar;
	private JLabel idProd=new JLabel("ID: ");
	private JLabel nombreProd=new JLabel("Nombre: ");
	private JLabel cantProd=new JLabel("Cantidad: ");
	private JLabel precioProd=new JLabel("Precio: ");
	private JLabel marcaProd=new JLabel("ID Marca: ");
	
	public GUIMostrarUnProd() {
		super("Mostrar producto por ID");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID del producto a mostrar: ");
		campoID=new JTextField(12);
		id.add(idLabel);
		id.add(campoID);
		
		JPanel datos=new JPanel();
		datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));
		datos.add(idProd);
		datos.add(nombreProd);
		datos.add(cantProd);
		datos.add(precioProd);
		datos.add(marcaProd);
		
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
				if(!campoID.getText().equalsIgnoreCase("")) {
					Controlador.getInstance().accion(Eventos.MOSTRAR_PRODUCTO, Integer.parseInt(campoID.getText()));
				}
			}
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(id);
		p.add(datos);
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
				new GUIMostrarUnaMarca();
			}
		});


	}
	
	
	public void actualizar(TProductos prod) {
		idProd.setText("ID: "+prod.getId());
		nombreProd.setText("Nombre: "+prod.getNombre());
		cantProd.setText("Cantidad: "+prod.getCantidad());
		precioProd.setText("Precio: "+prod.getPrecio());
		marcaProd.setText("ID Marca: "+prod.getIDmarca());
		initGUI();
	}
	
}
