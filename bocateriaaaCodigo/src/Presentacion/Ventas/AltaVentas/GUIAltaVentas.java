package Presentacion.Ventas.AltaVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUIAltaVentas extends JFrame{
	private JTextField campoIdEmp;
	private JButton cancelar;
	private JButton aceptar;
	
	public GUIAltaVentas() {
		super("Alta Venta");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID del empleado que hace la venta: ");
		campoIdEmp=new JTextField(12);
		id.add(idLabel);
		id.add(campoIdEmp);
		
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
				if(campoIdEmp.getText().equalsIgnoreCase("")) {
					correcto=false;
				}
				if(correcto) {
					Date date = new Date();
						//Controlador.getInstance().accion(Eventos.ALTA_VENTAS, 
							//new TVentas(0, campoIdEmp.getText(), date.toString(), 0,null));
						dispose();
				}
			}
			
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(id);
		p.add(botones);
		this.setContentPane(p);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocation(400,400);
	}
	
}
