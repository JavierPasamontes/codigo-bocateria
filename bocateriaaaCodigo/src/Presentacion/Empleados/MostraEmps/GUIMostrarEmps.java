package Presentacion.Empleados.MostraEmps;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import Negocio.Empleados.TEmpleados;
import Negocio.Empleados.TEmpleadosTC;
import Negocio.Empleados.TEmpleadosTP;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

@SuppressWarnings("serial")
public class GUIMostrarEmps extends JFrame{
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JButton mostrar;
	private JButton cerrar;
	
	public GUIMostrarEmps(){
		super("Mostrar todos los empleados");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout(10,10));
		JPanel botonPanel=new JPanel();
		JPanel tablaPanel=new JPanel();
		JPanel cerrarPanel=new JPanel();
		mostrar=new JButton("Mostrar");
		mostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(Eventos.MOSTRAR_EMPLEADOS, null);
			}
			
			
		});
		
		cerrar=new JButton("Cerrar");
		cerrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
			
		});
		
		tabla = new JTable();
		
		modeloTabla = new DefaultTableModel(){
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
			
		};
		
		modeloTabla.setColumnCount(0);
		modeloTabla.addColumn("Tipo");
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Apellidos");
		modeloTabla.addColumn("DNI");
		modeloTabla.addColumn("ID dept.");
		modeloTabla.addColumn("Salario");
		modeloTabla.addColumn("Horas");
		modeloTabla.addColumn("Euros/Hora");
		modeloTabla.addColumn("Activo");
		tabla.setModel(modeloTabla);
		
		tablaPanel.add(tabla);
		botonPanel.add(mostrar);
		cerrarPanel.add(cerrar);
		p.add(botonPanel, BorderLayout.PAGE_START);
		p.add(tablaPanel, BorderLayout.CENTER);
		p.add(cerrarPanel, BorderLayout.PAGE_END);
		
		
		this.setContentPane(p);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocation(400,400);
	}
	
	
	public void actualizar (ArrayList<TEmpleados> emp){
		modeloTabla.setColumnCount(0);
		modeloTabla.addColumn("Tipo");
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Apellidos");
		modeloTabla.addColumn("DNI");
		modeloTabla.addColumn("ID dept.");
		modeloTabla.addColumn("Salario");
		modeloTabla.addColumn("Horas");
		modeloTabla.addColumn("Euros/Hora");
		modeloTabla.addColumn("Activo");
		modeloTabla.setRowCount(0);
		modeloTabla.insertRow(0, new String[]{"Tipo", "ID", "Nombre", "Apellidos", "DNI",  "ID dept.", "Salario", "Horas", "Euros/Hora", "Activo"});
		for (int i = 0; i < emp.size(); i++) {
			if(emp.get(i).getJornada()==1) {
				modeloTabla.insertRow(i+1, new Object[] 
						{ "T. Completo", emp.get(i).getId(), emp.get(i).getNombre(), emp.get(i).getApellidos(), emp.get(i).getDNI(), emp.get(i).getIdDept(), ((TEmpleadosTC) emp.get(i)).getSalario()
								, "N/A", "N/A", emp.get(i).getActivo()});
			}
			else {
				modeloTabla.insertRow(i+1, new Object[] 
						{ "T. Parcial",emp.get(i).getId(), emp.get(i).getNombre(), emp.get(i).getApellidos(), emp.get(i).getDNI(), emp.get(i).getIdDept(), "N/A"
								, ((TEmpleadosTP) emp.get(i)).getHoras(), ((TEmpleadosTP) emp.get(i)).getEurosHora(), emp.get(i).getActivo()});
			}
		}
		tabla.setModel(modeloTabla);
		this.pack();
	}
	
	
	
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new GUIMostrarEmps();
			}
		});


	}
}
