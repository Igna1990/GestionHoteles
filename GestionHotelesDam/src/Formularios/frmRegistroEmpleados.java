package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Mantenimiento.gestionRegistro;
import Mantenimiento.gestionRegistroEmpleado;
import bean.Usuario;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class frmRegistroEmpleados extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtDni;
	private JTextField txtUsuario;
	private JTextField txtApellidos;
	private JTextField txtFecha_nac;
	private JTextField txtPoblacion;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistroEmpleados frame = new frmRegistroEmpleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmRegistroEmpleados() {
		setTitle("Panel administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 61, 270, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Dni", "Usuario", "Apellidos", "Nacimiento", "Poblacion"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(table);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmpleados.setBounds(24, 25, 139, 29);
		contentPane.add(lblEmpleados);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDni.setBounds(307, 61, 66, 22);
		contentPane.add(lblDni);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(307, 93, 86, 22);
		contentPane.add(lblUsuario);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidos.setBounds(307, 125, 86, 22);
		contentPane.add(lblApellidos);
		
		JLabel lblfecha_nac = new JLabel("Nacimiento");
		lblfecha_nac.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblfecha_nac.setBounds(307, 157, 108, 22);
		contentPane.add(lblfecha_nac);
		
		JLabel lblPoblacion = new JLabel("Poblacion");
		lblPoblacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPoblacion.setBounds(307, 189, 86, 22);
		contentPane.add(lblPoblacion);
		
		txtDni = new JTextField();
		txtDni.setBounds(403, 65, 214, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(403, 95, 214, 20);
		contentPane.add(txtUsuario);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(403, 125, 214, 20);
		contentPane.add(txtApellidos);
		
		txtFecha_nac = new JTextField();
		txtFecha_nac.setColumns(10);
		txtFecha_nac.setBounds(403, 157, 214, 20);
		contentPane.add(txtFecha_nac);
		
		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBounds(403, 189, 214, 20);
		contentPane.add(txtPoblacion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse();
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardar.setBounds(329, 277, 86, 21);
		contentPane.add(btnGuardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModificar.setBounds(437, 277, 102, 21);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(559, 277, 86, 21);
		contentPane.add(btnEliminar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpiar.setBounds(437, 321, 102, 21);
		contentPane.add(btnLimpiar);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClave.setBounds(304, 218, 63, 22);
		contentPane.add(lblClave);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(403, 219, 214, 22);
		contentPane.add(passwordField);
	}

	protected void registrarse() {
		
			
		gestionRegistroEmpleado regEmp = new gestionRegistroEmpleado(); 
			Usuario usuario1 = new Usuario();
			
			String dni = txtDni.getText();
			String usuario = txtUsuario.getText();
			String apellidos = txtApellidos.getText();
			String fecha_nac = txtFecha_nac.getText();
			String poblacion = txtPoblacion.getText();
			
			String clave = String.valueOf(passwordField.getPassword());
			
			
			usuario1.setDni(dni);
			usuario1.setUsuario(usuario);
			usuario1.setApellidos(apellidos);
			
			usuario1.setFecha_nac(fecha_nac);
			usuario1.setPoblacion(poblacion);
			usuario1.setClave(clave);
			usuario1.setRoll("empleado");
			
			
			
			if(regEmp.registrarUsuario(usuario1)) {
				JOptionPane.showMessageDialog(contentPane, "REGISTRADO");
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error al registrarse");
			}
			
		}
		
	}

