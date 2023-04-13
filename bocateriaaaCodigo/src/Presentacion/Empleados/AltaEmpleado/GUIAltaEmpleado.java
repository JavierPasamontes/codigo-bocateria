package Presentacion.Empleados.AltaEmpleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Negocio.Empleados.TransferEmpleados;
import Negocio.Empleados.TransferEmpleadosTP;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Marcas.AltaMarca.GUIAltaMarca;

public class GUIAltaEmpleado extends JFrame{
	private JTextField campoNombre;
	private JTextField campoApellidos;
	private JTextField campoDNI;
	private JTextField campoJornada;
	private JTextField campoIDdept;
	private JCheckBox checkTiempo;
	private boolean tCompleto=false;
	private JTextField campoHoras;
	private JTextField campoEurosHora;
	private JButton cancelar;
	private JButton aceptar;
	
	public GUIAltaEmpleado() {
		super("Alta Marca");
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
		
		JPanel apellidos=new JPanel();
		JLabel apellidosLabel=new JLabel("Apellidos: ");
		campoApellidos=new JTextField(36);
		apellidos.add(apellidosLabel);
		apellidos.add(campoApellidos);
		
		JPanel dni=new JPanel();
		JLabel dniLabel=new JLabel("DNI: ");
		campoDNI=new JTextField(9);
		dni.add(dniLabel);
		dni.add(campoDNI);
		
		JPanel jornada=new JPanel();
		JLabel jornadaLabel=new JLabel("Jornada(Horas): ");
		campoJornada=new JTextField(1);
		jornada.add(jornadaLabel);
		jornada.add(campoJornada);
		
		JPanel iddept=new JPanel();
		JLabel iddeptLabel=new JLabel("ID del departamento: ");
		campoIDdept=new JTextField(2);
		iddept.add(iddeptLabel);
		iddept.add(campoIDdept);
		
		JPanel jornadaCompleta=new JPanel();
		JCheckBox checkTiempo=new JCheckBox("Tiempo Completo", false);
		checkTiempo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(tCompleto==false) {
					tCompleto=true;
					campoHoras.setEnabled(true);
					campoEurosHora.setEnabled(true);
				}
				else {
					tCompleto=false;
					campoHoras.setEnabled(false);
					campoEurosHora.setEnabled(false);
				}
			}
			
			
		});
		jornadaCompleta.add(checkTiempo);
		
		JPanel horas=new JPanel();
		JLabel horasLabel=new JLabel("Nº de horas: ");
		campoHoras=new JTextField(2);
		campoHoras.setEnabled(false);
		horas.add(horasLabel);
		horas.add(campoHoras);
		
		JPanel eurosHora=new JPanel();
		JLabel eurosHoraLabel=new JLabel("Euros por hora: ");
		campoEurosHora=new JTextField(3);
		campoEurosHora.setEnabled(false);
		eurosHora.add(eurosHoraLabel);
		eurosHora.add(campoEurosHora);
		
		JPanel botones=new JPanel();
		cancelar=new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
			
			
		});
		aceptar=new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean correcto=true;
				if(campoNombre.getText().equalsIgnoreCase("")||campoApellidos.getText().equalsIgnoreCase("")||campoDNI.getText().equalsIgnoreCase("")||campoJornada.getText().equalsIgnoreCase("")||campoIDdept.getText().equalsIgnoreCase("")) {
					correcto=false;
				}
				if(correcto) {
					if(tCompleto=true) {
						Controlador.getInstance().accion(Eventos.ALTA_EMPLEADO, 
							new TransferEmpleados(campoNombre.getText(),campoApellidos.getText(),campoDNI.getText(),Integer.parseInt(campoJornada.getText()),Integer.parseInt(campoIDdept.getText()), true));
						dispose();
					}
					else {
						Controlador.getInstance().accion(Eventos.ALTA_EMPLEADO, 
								new TransferEmpleadosTP(campoNombre.getText(),campoApellidos.getText(),campoDNI.getText(),Integer.parseInt(campoJornada.getText()),Integer.parseInt(campoIDdept.getText()), true, 
										Integer.parseInt(campoHoras.getText()), Integer.parseInt(campoEurosHora.getText())));
							dispose();
					}
				}
			}
			
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(nombre);
		p.add(apellidos);
		p.add(dni);
		p.add(jornada);
		p.add(iddept);
		p.add(jornadaCompleta);
		p.add(horas);
		p.add(eurosHora);
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
				// TODO Auto-generated method stub
				new GUIAltaEmpleado();
			}
		});


	}
}
