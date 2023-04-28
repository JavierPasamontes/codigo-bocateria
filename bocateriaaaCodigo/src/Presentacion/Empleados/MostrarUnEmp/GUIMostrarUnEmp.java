package Presentacion.Empleados.MostrarUnEmp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Negocio.Empleados.TEmpleados;
import Negocio.Empleados.TEmpleadosTC;
import Negocio.Empleados.TEmpleadosTP;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

@SuppressWarnings("serial")
public class GUIMostrarUnEmp extends JFrame{
	private JTextField campoID;
	private JButton cancelar;
	private JButton aceptar;
	private JLabel idEmp=new JLabel("ID: ");
	private JLabel nombreEmp=new JLabel("Nombre: ");
	private JLabel apellidoEmp=new JLabel("Apellidos: ");
	private JLabel dniEmp = new JLabel("DNI: ");
	private JLabel idDepEmp=new JLabel("ID de su departamento");
	private JLabel salarioEmp=new JLabel("Salario: ");
	private JLabel horasEmp=new JLabel("Horas: ");
	private JLabel eurosHoraEmp=new JLabel("Euros por hora: ");
	
	public GUIMostrarUnEmp() {
		super("Mostrar Empleado por ID");
		initGUI();
	}
	
	public void initGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JPanel id=new JPanel();
		JLabel idLabel=new JLabel("ID del empleado a mostrar: ");
		campoID=new JTextField(12);
		id.add(idLabel);
		id.add(campoID);
		
		JPanel datos=new JPanel();
		datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));
		datos.add(idEmp);
		datos.add(nombreEmp);
		datos.add(apellidoEmp);
		datos.add(dniEmp);
		datos.add(idDepEmp);
		datos.add(salarioEmp);
		datos.add(horasEmp);
		datos.add(eurosHoraEmp);
		
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
					Controlador.getInstance().accion(Eventos.MOSTRAR_EMPLEADO, Integer.parseInt(campoID.getText()));
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
				new GUIMostrarUnEmp();
			}
		});


	}
	
	public void actualizar(TEmpleados emp) {
		idEmp.setText("ID: "+emp.getId());
		nombreEmp.setText("Nombre: "+emp.getNombre());
		apellidoEmp.setText("Apellidos: "+emp.getApellidos());
		dniEmp.setText("DNI: "+emp.getDNI());
		idDepEmp.setText("ID de su departamento: "+emp.getIdDept());
		if(emp.getJornada()==1) {
			salarioEmp.setText("Salario: "+((TEmpleadosTC) emp).calcularSalario());
			horasEmp.setText("Horas: No aplicable");
			eurosHoraEmp.setText("Euros por hora: No aplicable");
		}
		else {
			salarioEmp.setText("Salario: No aplicable");
			horasEmp.setText("Horas: "+((TEmpleadosTP) emp).getHoras());
			eurosHoraEmp.setText("Horas: "+((TEmpleadosTP) emp).getEurosHora());
		}
		initGUI();
	}
}
