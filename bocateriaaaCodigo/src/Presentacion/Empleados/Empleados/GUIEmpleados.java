package Presentacion.Empleados.Empleados;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Negocio.Empleados.TEmpleados;
import Presentacion.Controlador.Eventos;
import Presentacion.Controlador.MensajeGUI;
import Presentacion.Empleados.AltaEmpleado.GUIAltaEmpleado;
import Presentacion.Empleados.BajaEmpleado.*;
import Presentacion.Empleados.ModificarEmp.*;
import Presentacion.Empleados.MostrarUnEmp.*;
import Presentacion.Empleados.MostraEmps.*;
import Presentacion.Empleados.MostrarEmpDeUnDep.*;


@SuppressWarnings("serial")
public class GUIEmpleados extends JFrame{
	static JButton altaBoton;
	static JButton bajaBoton;
	static JButton modBoton;
	static JButton mostrarTodoBoton;
	static JButton mostrarPorIDBoton;
	static JButton mostrarEmpDeUnDep;
	static JButton volverBoton;
	private GUIAltaEmpleado GUIAltaEmpleado;
	private GUIBajaEmpleado GUIBajaEmpleado;
	private GUIModificarEmp GUIModificarEmp;
	private GUIMostrarEmps GUIMostrarEmps;
	private GUIMostrarUnEmp GUIMostrarUnEmp;
	private GUIMostrarEmpDeUnDep GUIMostrarEmpDeUnDep;
	
	public GUIEmpleados() {
		super("Empleados");
		initGUI();
	}
	
	public void initGUI() {
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JPanel superior = new JPanel();
		superior.setBackground(Color.ORANGE);
		JPanel medio = new JPanel();
		medio.setBackground(Color.ORANGE);
		JPanel inferior = new JPanel();
		inferior.setBackground(Color.ORANGE);
		
		altaBoton=new JButton("Alta");
		altaBoton.setPreferredSize(new Dimension(200,50));
		altaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIAltaEmpleado =new GUIAltaEmpleado();
			}
			
			
		});
		bajaBoton=new JButton("Baja");
		bajaBoton.setPreferredSize(new Dimension(200,50));
		bajaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIBajaEmpleado =new GUIBajaEmpleado();
			}
			
			
		});
		modBoton=new JButton("Modificar");
		modBoton.setPreferredSize(new Dimension(200,50));
		modBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIModificarEmp =new GUIModificarEmp();
			}
			
			
		});
		mostrarTodoBoton=new JButton("Mostrar todo");
		mostrarTodoBoton.setPreferredSize(new Dimension(200,50));
		mostrarTodoBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarEmps =new GUIMostrarEmps();			
			}
			
			
		});
		mostrarPorIDBoton=new JButton("Mostrar por ID");
		mostrarPorIDBoton.setPreferredSize(new Dimension(200,50));
		mostrarPorIDBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarUnEmp =new GUIMostrarUnEmp();
			}
			
			
		});
		mostrarEmpDeUnDep=new JButton("Mostrar empleados de un departamento");
		mostrarEmpDeUnDep.setPreferredSize(new Dimension(200,50));
		mostrarEmpDeUnDep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarEmpDeUnDep =new GUIMostrarEmpDeUnDep();
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
				dispose();
			}
			
			
		});
		superior.add(altaBoton);
		superior.add(bajaBoton);
		superior.add(mostrarEmpDeUnDep);
		medio.add(modBoton);
		medio.add(mostrarTodoBoton);
		medio.add(mostrarPorIDBoton);
		inferior.add(volverBoton);
		p.add(superior, BorderLayout.PAGE_START);
		p.add(medio, BorderLayout.CENTER);
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
				new GUIEmpleados();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public void actualizar(int evento, Object datos) {
		MensajeGUI a=new MensajeGUI();
		switch (evento) {
		case Eventos.ALTA_EMPLEADO_OK:
			a.showMessage("Se ha dado de alta al empleado con ID: " + (int)datos,"Alta empleado", false);
			break;
		case Eventos.ALTA_EMPLEADO_KO:
			a.showMessage("No se ha podido dar de alta al empleado", "Alta empleado", true);
			break;
		case Eventos.BAJA_EMPLEADO_OK:
			a.showMessage("Se ha dado de baja al empleado con ID: "+(int)datos, "Baja empleado", false);
			break;
		case Eventos.BAJA_EMPLEADO_KO:
			a.showMessage("No se ha podido dar de baja al empleado con ID: "+(int)datos, "Baja empleado", true);
			break;
		case Eventos.MODIFICAR_EMPLEADO_OK:
			a.showMessage("Se ha modificado el empleado correctamente", "Modificar empleado", false);
			break;
		case Eventos.MODIFICAR_EMPLEADO_KO:
			a.showMessage("No se ha podido modificar el empleado", "Modificar empleado", true);
			break;
		case Eventos.MOSTRAR_EMPLEADOS_OK:
			GUIMostrarEmps.actualizar((ArrayList<TEmpleados>)datos);
			break;
		case Eventos.MOSTRAR_EMPLEADOS_KO:
			a.showMessage("No se pudo mostrar la lista de empleados", "Mostrar empleados", true);
			break;
		case Eventos.MOSTRAR_EMPLEADO_OK:
			GUIMostrarUnEmp.actualizar((TEmpleados)datos);
			break;
		case Eventos.MOSTRAR_EMPLEADO_KO:
			a.showMessage("No se pudo mostrar el empleado especificado", "Buscar empleado", true);
			break;
		case Eventos.MOSTRAR_EMPLEADOS_POR_DEPARTAMENTO_OK:
			GUIMostrarEmpDeUnDep.actualizar((ArrayList<TEmpleados>) datos);
			break;
		case Eventos.MOSTRAR_EMPLEADOS_POR_DEPARTAMENTO_KO:
		a.showMessage("No se ha podido mostrar la lista de empleados especificada", "Mostrar empleados de un departamento", true);
		}
	}
}
