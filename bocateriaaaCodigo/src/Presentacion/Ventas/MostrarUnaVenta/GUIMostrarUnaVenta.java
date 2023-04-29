package Presentacion.Ventas.MostrarUnaVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Negocio.Ventas.TVentas;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Marcas.MostrarUnaMarca.GUIMostrarUnaMarca;

@SuppressWarnings("serial")
public class GUIMostrarUnaVenta extends JFrame{
	private JTextField campoID;
	private JButton cancelar;
	private JButton aceptar;
	private JLabel idMar=new JLabel("ID: ");
	private JLabel empMar=new JLabel("ID del empleado: ");
	private JLabel fechaMar=new JLabel("Fecha: ");
	private JLabel precioMar=new JLabel("Precio: ");
	private JLabel productos=new JLabel ("Productos: ");
	
	public GUIMostrarUnaVenta() {
		super("Mostrar venta por ID");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID de la venta a mostrar: ");
		campoID=new JTextField(12);
		id.add(idLabel);
		id.add(campoID);
		
		JPanel datos=new JPanel();
		datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));
		datos.add(idMar);
		datos.add(empMar);
		datos.add(fechaMar);
		datos.add(precioMar);
		
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
					Controlador.getInstance().accion(Eventos.MOSTRAR_VENTA, Integer.parseInt(campoID.getText()));
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
	
	public void actualizar(TVentas ven) {
		String prod=new String();
		prod="";
		for(int i=0;i<ven.getListaProductos().size();i++) {
			prod=prod+ven.getListaProductos().get(i);
		}
		idMar.setText("ID: "+ven.getId());
		empMar.setText("ID del empleado: "+ven.getIdEmpleado());
		fechaMar.setText("Fecha: "+ven.getFechaVenta());
		precioMar.setText("Precio: "+ven.getPrecioFinal());
		productos.setText("Productos: "+prod);
		initGUI();
	}
}
