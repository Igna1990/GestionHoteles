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

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import ConexionBD.Conexion;
import Mantenimiento.gestionHoteles;
import Mantenimiento.gestionRegistroEmpleado;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;

public class frmEmpleados extends JFrame {
	private JTable table;
	private JTable tblHoteles;
	private JTextField txtNombre;
	private JTextField txtCiudad;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDescripcion;
	private JTextField txtId;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		getContentPane().setBackground(new Color(51, 102, 204));
		JFrame frame = new JFrame();
		setTitle("Panel empleados");
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
		scrollPane.setBounds(61, 26, 625, 44);
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
		btnIngresarDatos.setBounds(285, 91, 131, 21);
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

		tblHoteles = new JTable();
		tblHoteles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					int fila = tblHoteles.getSelectedRow();
					int id = Integer.parseInt(tblHoteles.getValueAt(fila, 0).toString());

					PreparedStatement ps;
					ResultSet rs;
					Connection con = Conexion.conectar();

					ps = con.prepareStatement(
							"SELECT nombre, descripcion, ciudad, direccion, telefono FROM hoteles WHERE id = ?");

					ps.setInt(1, id);

					rs = ps.executeQuery();

					while (rs.next()) {
						txtId.setText(String.valueOf(id));
						txtNombre.setText(rs.getString("nombre"));
						txtCiudad.setText(rs.getString("ciudad"));
						txtDireccion.setText(rs.getString("direccion"));
						txtTelefono.setText(rs.getString("telefono"));
						txtDescripcion.setText(rs.getString("descripcion"));

					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e.toString());
				}

			}
		});

		tblHoteles.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Nombre", "Ciudad", "Direccion", "Telefono", "Descripcion"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblHoteles.getColumnModel().getColumn(0).setPreferredWidth(23);
		tblHoteles.getColumnModel().getColumn(1).setPreferredWidth(56);
		tblHoteles.getColumnModel().getColumn(2).setPreferredWidth(54);
		tblHoteles.getColumnModel().getColumn(3).setPreferredWidth(72);
		tblHoteles.getColumnModel().getColumn(4).setPreferredWidth(56);
		tblHoteles.getColumnModel().getColumn(5).setPreferredWidth(107);
		scrollPane_1.setViewportView(tblHoteles);
		cargarTabla();

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

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(txtId.getText());
				String nombre = txtNombre.getText();
				String descripcion = txtDescripcion.getText();
				String ciudad = txtCiudad.getText();
				String direccion = txtDireccion.getText();
				String telefono = txtTelefono.getText();

				try {
					Connection con = Conexion.conectar();
					PreparedStatement ps = con.prepareStatement(
							"UPDATE hoteles SET nombre=?, descripcion=?, ciudad=?, direccion=?, telefono=? WHERE id = ?");
					ps.setString(1, nombre);
					ps.setString(2, descripcion);
					ps.setString(3, ciudad);
					ps.setString(4, direccion);
					ps.setString(5, telefono);
					ps.setInt(6, id);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro modificado");
					limpiar();
					cargarTabla();

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e.toString());
				}

			}
		});

		btnModificar.setBounds(154, 273, 102, 22);
		panel_1.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(277, 273, 116, 22);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(txtId.getText());

				try {
					Connection con = Conexion.conectar();
					PreparedStatement ps = con.prepareStatement("DELETE FROM hoteles WHERE id = ?");
					ps.setInt(1, id);

					if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el registro, ¿desea continuar?",
							"Eliminar Registro", JOptionPane.WARNING_MESSAGE,
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

						JOptionPane.showMessageDialog(null, "Hotel eliminado");
						ps.executeUpdate();

						limpiar();
						cargarTabla();

					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e.toString());
				}

			}
		});
		panel_1.add(btnEliminar);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(453, 244, 275, 51);
		panel_1.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		txtId = new JTextField();
		txtId.setVisible(false);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Habitaciones", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblHabitaciones = new JLabel("Habitaciones");
		lblHabitaciones.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHabitaciones.setBounds(10, 24, 140, 27);
		panel_2.add(lblHabitaciones);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 61, 256, 131);
		panel_2.add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Id", "N\u00BA habitacion", "Tipo habitacion", "Precio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(table_1);
		
		JLabel lblNhabitacion = new JLabel("N\u00BA habitacion");
		lblNhabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNhabitacion.setBounds(299, 59, 108, 27);
		panel_2.add(lblNhabitacion);
		
		JLabel lblTipo = new JLabel("Tipo habitacion");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipo.setBounds(299, 103, 125, 27);
		panel_2.add(lblTipo);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(337, 151, 70, 27);
		panel_2.add(lblPrecio);
		
		textField = new JTextField();
		textField.setBounds(427, 65, 210, 19);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(427, 109, 210, 19);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(427, 157, 210, 19);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnGuardar1 = new JButton("Guardar");
		btnGuardar1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGuardar1.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar1.setBounds(299, 212, 108, 27);
		panel_2.add(btnGuardar1);
		
		JButton btnModificar1 = new JButton("Modificar");
		btnModificar1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModificar1.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificar1.setBounds(427, 212, 108, 27);
		panel_2.add(btnModificar1);
		
		JButton btnEliminar1 = new JButton("Eliminar");
		btnEliminar1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminar1.setBounds(565, 212, 108, 27);
		panel_2.add(btnEliminar1);

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
			limpiar();
			cargarTabla();

		} else {
			JOptionPane.showMessageDialog(getContentPane(), "Error al registrarse");
		}

	}

	private void cargarTabla() {

		DefaultTableModel modeloTabla = (DefaultTableModel) tblHoteles.getModel();
		modeloTabla.setRowCount(0);
		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;
		int columnas;

		try {
			Connection con = Conexion.conectar();
			ps = con.prepareStatement("SELECT id, nombre, descripcion, ciudad, direccion, telefono FROM hoteles");
			rs = ps.executeQuery();
			rsmd = (ResultSetMetaData) rs.getMetaData();
			columnas = rsmd.getColumnCount();

			while (rs.next()) {
				Object[] fila = new Object[columnas];

				for (int indice = 0; indice < columnas; indice++) {
					fila[indice] = rs.getObject(indice + 1);
				}
				modeloTabla.addRow(fila);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}

	}

	private void limpiar() {
		txtNombre.setText("");
		txtCiudad.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtDescripcion.setText("");
	}

}
