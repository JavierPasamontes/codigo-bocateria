package Presentacion.Ventas.ModificarVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Ventas.TVentas;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

@SuppressWarnings("serial")
public class GUIModificarVenta extends JFrame{
	private JTextField campoIdEmp;
	private JTextField campoId;
	private JButton cancelar;
	private JButton aceptar;
	
	
	public GUIModificarVenta() {
		super("Modificar Venta");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID de la venta: ");
		campoId=new JTextField(12);
		id.add(idLabel);
		id.add(campoId);
		
		JPanel idemp=new JPanel();
		JLabel idempLabel=new JLabel("ID del nuevo empleado que hace la venta: ");
		campoIdEmp=new JTextField(12);
		idemp.add(idempLabel);
		idemp.add(campoIdEmp);
		
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
				if(campoId.getText().equalsIgnoreCase("")||campoIdEmp.getText().equalsIgnoreCase("")) {
					correcto=false;
				}
				if(correcto) {
						Controlador.getInstance().accion(Eventos.MODIFICAR_VENTA, 
							new TVentas(Integer.parseInt(campoId.getText()), Integer.parseInt(campoIdEmp.getText()), "", 0,null));
						dispose();
				}
			}
			
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(id);
		p.add(idemp);
		p.add(botones);
		this.setContentPane(p);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocation(400,400);
	}
}
