package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Hoteles;
import bean.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Mantenimiento.gestionHoteles;
import Mantenimiento.gestionRegistroEmpleado;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class frmEmpleados extends JFrame {
	private JTable table;
	private JTable table_1;
	private JTextField txtNombre;
	private JTextField txtCiudad;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDescripcion;
	
	/**
	 * Launch the application.
	 */
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frmEmpleados frame = new frmEmpleados(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public frmEmpleados(Usuario usu) {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 724, 492);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 467);
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 743, 332);
		getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Datos personales", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 26, 625, 69);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "DNI", "Usuario", "Apellidos", "Fecha nacimiento", "Poblacion" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(158);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(94);
		scrollPane.setViewportView(table);

		JButton btnIngresarDatos = new JButton("Mostrar datos");
		btnIngresarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizarEmpleado(usu);
			}
		});
		btnIngresarDatos.setBounds(282, 128, 131, 21);
		panel.add(btnIngresarDatos);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Hoteles", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblHoteles = new JLabel("Hoteles");
		lblHoteles.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHoteles.setBounds(10, 22, 176, 32);
		panel_1.add(lblHoteles);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 64, 423, 199);
		panel_1.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Nombre", "Ciudad", "Direccion", "Telefono", "Descripcion" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, Integer.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);

		JLabel lblNombre = new JLabel("Nombre del hotel");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(454, 27, 176, 25);
		panel_1.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(453, 51, 275, 19);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCiudad.setBounds(451, 78, 76, 19);
		panel_1.add(lblCiudad);

		txtCiudad = new JTextField();
		txtCiudad.setBounds(453, 99, 275, 19);
		panel_1.add(txtCiudad);
		txtCiudad.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccion.setBounds(453, 128, 131, 13);
		panel_1.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(453, 144, 275, 19);
		panel_1.add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(453, 173, 177, 13);
		panel_1.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(453, 188, 275, 19);
		panel_1.add(txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(453, 220, 156, 15);
		panel_1.add(lblNewLabel_3);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse();
			}
		});
		btnGuardar.setBounds(47, 273, 97, 21);
		panel_1.add(btnGuardar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(154, 273, 102, 22);
		panel_1.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(277, 273, 116, 22);
		panel_1.add(btnEliminar);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(453, 244, 275, 51);
		panel_1.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Habitaciones", null, panel_2, null);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Comentarios", null, panel_3, null);
	}

	protected void visualizarEmpleado(Usuario usu) {

		DefaultTableModel tabla = (DefaultTableModel) table.getModel();

		table.setModel(tabla);
		tabla.setRowCount(0);

		String[] datos = new String[5];

		datos[0] = usu.getDni();
		datos[1] = usu.getUsuario();
		datos[2] = usu.getApellidos();
		datos[3] = usu.getFecha_nac();
		datos[4] = usu.getPoblacion();

		tabla.addRow(datos);
	}

	protected void registrarse() {

		gestionHoteles regHotel = new gestionHoteles();
		Hoteles hotel = new Hoteles();

		String nombre = txtNombre.getText();
		String ciudad = txtCiudad.getText();
		String direccion = txtDireccion.getText();
		String telefono = txtTelefono.getText();
		String descripcion = txtDescripcion.getText();

		hotel.setNombre(nombre);
		hotel.setCiudad(ciudad);
		hotel.setDireccion(direccion);
		hotel.setTelefono(telefono);
		hotel.setDescripcion(descripcion);

		if (regHotel.registrarHotel(hotel)) {
			JOptionPane.showMessageDialog(getContentPane(), "REGISTRADO");

		} else {
			JOptionPane.showMessageDialog(getContentPane(), "Error al registrarse");
		}

	}

}
