package Presentacion.Empleados.ModificarEmp;

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

@SuppressWarnings("serial")
public class GUIModificarEmp extends JFrame{
	private JTextField campoId;
	private JTextField campoNombre;
	private JTextField campoApellidos;
	private JTextField campoDNI;
	private JTextField campoSalario;
	private JTextField campoIDdept;
	@SuppressWarnings("unused")
	private JCheckBox checkTiempo;
	private boolean tCompleto=true;
	private JTextField campoHoras;
	private JTextField campoEurosHora;
	private JButton cancelar;
	private JButton aceptar;
	
	public GUIModificarEmp() {
		super("Modificar Empleado");
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
		campoSalario=new JTextField(1);
		jornada.add(jornadaLabel);
		jornada.add(campoSalario);
		
		JPanel iddept=new JPanel();
		JLabel iddeptLabel=new JLabel("ID del departamento: ");
		campoIDdept=new JTextField(2);
		iddept.add(iddeptLabel);
		iddept.add(campoIDdept);
		
		JPanel jornadaCompleta=new JPanel();
		JCheckBox checkTiempo=new JCheckBox("Tiempo Parcial", false);
		checkTiempo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(tCompleto==false) {
					tCompleto=true;

					campoSalario.setEnabled(true);
					campoHoras.setEnabled(false);
					campoEurosHora.setEnabled(false);
				}
				else {
					tCompleto=false;
					
					campoSalario.setEnabled(false);
					campoHoras.setEnabled(true);
					campoEurosHora.setEnabled(true);
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
				if(campoId.getText().equalsIgnoreCase("")) {
					correcto=false;
				}
				if(correcto) {
					if(tCompleto == true) {
						if(campoIDdept.getText().equalsIgnoreCase("")) {
							Controlador.getInstance().accion(Eventos.MODIFICAR_EMPLEADO, 
									new TEmpleadosTC(campoNombre.getText(),campoApellidos.getText(),campoDNI.getText(),Integer.parseInt(campoId.getText()),1,null, true,Integer.parseInt(campoSalario.getText())));
								dispose();
						}
						else {
							Controlador.getInstance().accion(Eventos.MODIFICAR_EMPLEADO, 
									new TEmpleadosTC(campoNombre.getText(),campoApellidos.getText(),campoDNI.getText(),Integer.parseInt(campoId.getText()),1,Integer.parseInt(campoIDdept.getText()), true,Integer.parseInt(campoSalario.getText())));
								dispose();
						}
					}
					else {
						if(campoHoras.getText().equalsIgnoreCase("")) {
							Controlador.getInstance().accion(Eventos.MODIFICAR_EMPLEADO, 
									new TEmpleadosTP(campoNombre.getText(),campoApellidos.getText(),campoDNI.getText(),Integer.parseInt(campoId.getText()),0,Integer.parseInt(campoIDdept.getText()), true, 
											0, Integer.parseInt(campoEurosHora.getText())));
								dispose();
						}
						else {
							if(campoEurosHora.getText().equalsIgnoreCase("")) {
								Controlador.getInstance().accion(Eventos.MODIFICAR_EMPLEADO, 
										new TEmpleadosTP(campoNombre.getText(),campoApellidos.getText(),campoDNI.getText(),Integer.parseInt(campoId.getText()),0,Integer.parseInt(campoIDdept.getText()), true, 
												Integer.parseInt(campoHoras.getText()), 0));
									dispose();
							}
							else {
								Controlador.getInstance().accion(Eventos.MODIFICAR_EMPLEADO, 
										new TEmpleadosTP(campoNombre.getText(),campoApellidos.getText(),campoDNI.getText(), Integer.parseInt(campoId.getText()),0,Integer.parseInt(campoIDdept.getText()), true, 
												Integer.parseInt(campoHoras.getText()), Integer.parseInt(campoEurosHora.getText())));
									dispose();
							}
						}
					}
				}
			}
			
		});
		botones.add(cancelar);
		botones.add(aceptar);
		
		p.add(id);
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
	
}
