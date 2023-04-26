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

import Negocio.Empleados.TEmpleadosTC;
import Negocio.Empleados.TEmpleadosTP;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Controlador.MensajeGUI;

@SuppressWarnings("serial")
public class GUIAltaEmpleado extends JFrame{
	private JTextField campoNombre;
	private JTextField campoApellidos;
	private JTextField campoDNI;
	private JTextField campoSalario;
	private JTextField campoIDdept;
	@SuppressWarnings("unused")
	private JCheckBox checkTiempo;
	private boolean tParcial=false;
	private JTextField campoHoras;
	private JTextField campoEurosHora;
	private JButton cancelar;
	private JButton aceptar;
	
	public GUIAltaEmpleado() {
		super("Alta Empleado");
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
		JLabel jornadaLabel=new JLabel("Salario: ");
		campoSalario=new JTextField(4);
		jornada.add(jornadaLabel);
		jornada.add(campoSalario);
		
		JPanel iddept=new JPanel();
		JLabel iddeptLabel=new JLabel("ID del departamento: ");
		campoIDdept=new JTextField(4);
		iddept.add(iddeptLabel);
		iddept.add(campoIDdept);
		
		JPanel jornadaCompleta=new JPanel();
		JCheckBox checkTiempo=new JCheckBox("Tiempo Parcial", false);
		checkTiempo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(tParcial==false) {
					tParcial=true;
					campoSalario.setEnabled(false);
					campoHoras.setEnabled(true);
					campoEurosHora.setEnabled(true);
				}
				else {
					tParcial=false;
					campoSalario.setEnabled(true);
					campoHoras.setEnabled(false);
					campoEurosHora.setEnabled(false);
				}
			}
			
			
		});
		jornadaCompleta.add(checkTiempo);
		
		JPanel horas=new JPanel();
		JLabel horasLabel=new JLabel("Numero de horas: ");
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
				dispose();
				
			}
			
			
		});
		aceptar=new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean correcto=true;
				if(campoNombre.getText().equalsIgnoreCase("")||campoApellidos.getText().equalsIgnoreCase("")||campoDNI.getText().equalsIgnoreCase("")||campoIDdept.getText().equalsIgnoreCase("")) {
					correcto=false;
				}
				if(correcto) {
					if(tParcial==false) {
						if(campoSalario.getText().equalsIgnoreCase("")) {
							correcto=false;
						}
						else {
							Controlador.getInstance().accion(Eventos.ALTA_EMPLEADO, 
									new TEmpleadosTC(campoNombre.getText(),campoApellidos.getText(),campoDNI.getText(),0,1,Integer.parseInt(campoIDdept.getText()), true,Integer.parseInt(campoSalario.getText())));
								dispose();
						}
					}
					else {
						if(campoHoras.getText().equalsIgnoreCase("")||campoEurosHora.getText().equalsIgnoreCase("")) {
							correcto=false;
						}
						else {
							Controlador.getInstance().accion(Eventos.ALTA_EMPLEADO, 
									new TEmpleadosTP(campoNombre.getText(),campoApellidos.getText(),campoDNI.getText(),0,0,Integer.parseInt(campoIDdept.getText()), true, 
											Integer.parseInt(campoHoras.getText()), Integer.parseInt(campoEurosHora.getText())));
								dispose();
						}
					}
				}
				if(correcto==false) {
					MensajeGUI a=new MensajeGUI();
					a.showMessage("Faltan datos para el tipo de empleado deseado", "Alta empleado", true);
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
				new GUIAltaEmpleado();
			}
		});


	}
}
