package Presentacion.Departamentos.Departamentos;

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

import Negocio.Departamentos.TDept;
import Presentacion.Controlador.Eventos;
import Presentacion.Controlador.MensajeGUI;
import Presentacion.Departamentos.AltaDepartamentos.*;
import Presentacion.Departamentos.BajaDepts.*;
import Presentacion.Departamentos.ModificarDept.*;
import Presentacion.Departamentos.MostrarDept.*;
import Presentacion.Departamentos.MostrarUnDept.*;

@SuppressWarnings("serial")
public class GUIDepartamentos extends JFrame{
	static JButton altaBoton;
	static JButton bajaBoton;
	static JButton modBoton;
	static JButton mostrarTodoBoton;
	static JButton mostrarPorIDBoton;
	static JButton volverBoton;
	private GUIAltaDepartamento GUIAltaDepartamento;
	private GUIBajaDepts GUIBajaDepts;
	private GUIModificarDept GUIModificarDept;
	private GUIMostrarDepts GUIMostrarDepts;
	private GUIMostrarUnDept GUIMostrarUnDept;
	
	public GUIDepartamentos() {
		super("Departamentos");
		initGUI();
	}
	
	public void initGUI() {
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JPanel superior = new JPanel();
		superior.setBackground(Color.YELLOW);
		JPanel medio = new JPanel();
		medio.setBackground(Color.YELLOW);
		JPanel inferior = new JPanel();
		inferior.setBackground(Color.YELLOW);
		
		altaBoton=new JButton("Alta");
		altaBoton.setPreferredSize(new Dimension(200,50));
		altaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIAltaDepartamento =new GUIAltaDepartamento();
			}
			
			
		});
		bajaBoton=new JButton("Baja");
		bajaBoton.setPreferredSize(new Dimension(200,50));
		bajaBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIBajaDepts =new GUIBajaDepts();
			}
			
			
		});
		modBoton=new JButton("Modificar");
		modBoton.setPreferredSize(new Dimension(200,50));
		modBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIModificarDept =new GUIModificarDept();
			}
			
			
		});
		mostrarTodoBoton=new JButton("Mostrar todo");
		mostrarTodoBoton.setPreferredSize(new Dimension(200,50));
		mostrarTodoBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarDepts =new GUIMostrarDepts();			
			}
			
			
		});
		mostrarPorIDBoton=new JButton("Mostrar por ID");
		mostrarPorIDBoton.setPreferredSize(new Dimension(200,50));
		mostrarPorIDBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIMostrarUnDept =new GUIMostrarUnDept();
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
				new GUIDepartamentos();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public void actualizar(int evento, Object datos) {
		MensajeGUI a=new MensajeGUI();
		switch (evento) {
		case Eventos.ALTA_DEPARTAMENTO_OK:
			a.showMessage("Se ha dado de alta al departamento con ID: " + (int)datos,"Alta departamento", false);
			break;
		case Eventos.ALTA_DEPARTAMENTO_KO:
			a.showMessage("No se ha podido dar de alta al departamento", "Alta departamento", true);
			break;
		case Eventos.BAJA_DEPARTAMENTO_OK:
			a.showMessage("Se ha dado de baja al departamento con ID: "+(int)datos, "Baja departamento", false);
			break;
		case Eventos.BAJA_DEPARTAMENTO_KO:
			a.showMessage("No se ha podido dar de baja al departamento con ID: "+(int)datos, "Baja departamento", true);
			break;
		case Eventos.MODIFICAR_DEPARTAMENTO_OK:
			a.showMessage("Se ha modificado el departamento correctamente", "Modificar departamento", false);
			break;
		case Eventos.MODIFICAR_DEPARTAMENTO_KO:
			a.showMessage("No se ha podido modificar el departamento", "Modificar departamento", true);
			break;
		case Eventos.MOSTRAR_DEPARTAMENTOS_OK:
			GUIMostrarDepts.actualizar((ArrayList<TDept>)datos);
			break;
		case Eventos.MOSTRAR_DEPARTAMENTOS_KO:
			a.showMessage("No se pudo mostrar la lista de departamentos", "Mostrar departamentos", true);
			break;
		case Eventos.MOSTRAR_DEPARTAMENTO_OK:
			GUIMostrarUnDept.actualizar((TDept)datos);
			break;
		case Eventos.MOSTRAR_DEPARTAMENTO_KO:
			a.showMessage("No se pudo mostrar el departamento especificado", "Buscar departamento", true);
		}
	}
}
