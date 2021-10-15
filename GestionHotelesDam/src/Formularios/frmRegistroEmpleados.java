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

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import ConexionBD.Conexion;
import Mantenimiento.gestionRegistro;
import Mantenimiento.gestionRegistroEmpleado;
import bean.Usuario;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class frmRegistroEmpleados extends JFrame {

	private JPanel contentPane;
	private JTable tblEmpleados;
	private JTextField txtDni;
	private JTextField txtUsuario;
	private JTextField txtApellidos;
	private JTextField txtFecha_nac;
	private JTextField txtPoblacion;
	private JPasswordField passwordField;
	private JTextField txtId;


	/**
	 * Create the frame.
	 */
	public frmRegistroEmpleados() {
		setTitle("Panel administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 61, 347, 237);
		contentPane.add(scrollPane);

		tblEmpleados = new JTable();
		tblEmpleados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					int fila = tblEmpleados.getSelectedRow();
					int id = Integer.parseInt(tblEmpleados.getValueAt(fila, 0).toString());

					PreparedStatement ps;
					ResultSet rs;
					Connection con = Conexion.conectar();

					ps = con.prepareStatement(
							"SELECT  dni, usuario, apellidos, fecha_nac, poblacion, clave FROM usuario WHERE id = ? ");
					ps.setInt(1, id);
					rs = ps.executeQuery();
					while (rs.next()) {
						txtId.setText(String.valueOf(id));
						txtDni.setText(rs.getString("dni"));
						txtUsuario.setText(rs.getString("usuario"));
						txtApellidos.setText(rs.getString("apellidos"));
						txtFecha_nac.setText(rs.getString("fecha_nac"));
						txtPoblacion.setText(rs.getString("poblacion"));
						passwordField.setText(rs.getString("clave"));

					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e.toString());
				}

			}
		});
		tblEmpleados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Dni", "Usuario", "Apellidos", "Fecha", "Poblacion"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblEmpleados.getColumnModel().getColumn(0).setResizable(false);
		tblEmpleados.getColumnModel().getColumn(1).setResizable(false);
		tblEmpleados.getColumnModel().getColumn(2).setResizable(false);
		tblEmpleados.getColumnModel().getColumn(3).setResizable(false);
		tblEmpleados.getColumnModel().getColumn(4).setResizable(false);
		tblEmpleados.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(tblEmpleados);
		cargarTabla();

		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmpleados.setBounds(24, 25, 139, 29);
		contentPane.add(lblEmpleados);

		JLabel lblDni = new JLabel("Dni");
		lblDni.setBackground(new Color(51, 0, 51));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDni.setBounds(430, 61, 66, 22);
		contentPane.add(lblDni);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(410, 93, 86, 22);
		contentPane.add(lblUsuario);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidos.setBounds(410, 125, 86, 22);
		contentPane.add(lblApellidos);

		JLabel lblfecha_nac = new JLabel("Nacimiento");
		lblfecha_nac.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblfecha_nac.setBounds(400, 157, 108, 22);
		contentPane.add(lblfecha_nac);

		JLabel lblPoblacion = new JLabel("Poblacion");
		lblPoblacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPoblacion.setBounds(410, 189, 86, 22);
		contentPane.add(lblPoblacion);

		txtDni = new JTextField();
		txtDni.setBounds(495, 65, 214, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(495, 97, 214, 20);
		contentPane.add(txtUsuario);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(495, 129, 214, 20);
		contentPane.add(txtApellidos);

		txtFecha_nac = new JTextField();
		txtFecha_nac.setColumns(10);
		txtFecha_nac.setBounds(495, 161, 214, 20);
		contentPane.add(txtFecha_nac);

		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBounds(495, 193, 214, 20);
		contentPane.add(txtPoblacion);

		passwordField = new JPasswordField();
		passwordField.setBounds(495, 221, 214, 22);
		contentPane.add(passwordField);

		txtId = new JTextField();
		txtId.setVisible(false);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse();
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardar.setBounds(400, 277, 96, 21);
		contentPane.add(btnGuardar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(txtId.getText());
				String dni = txtDni.getText();
				String usuario = txtUsuario.getText();
				String apellidos = txtApellidos.getText();
				String fecha_nac = txtFecha_nac.getText();
				String poblacion = txtPoblacion.getText();
				String clave = String.valueOf(passwordField.getPassword());

				try {
					Connection con = Conexion.conectar();
					PreparedStatement ps = con.prepareStatement(
							"UPDATE usuario SET dni=?, usuario=?, apellidos=?, fecha_nac=?, poblacion=?, clave=? WHERE id = ?");
					ps.setString(1, dni);
					ps.setString(2, usuario);
					ps.setString(3, apellidos);
					ps.setString(4, fecha_nac);
					ps.setString(5, poblacion);
					ps.setString(6, clave);
					ps.setInt(7, id);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro modificado");
					limpiar();
					cargarTabla();

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e.toString());
				}

			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModificar.setBounds(540, 277, 102, 21);
		contentPane.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(204, 0, 51));
		btnEliminar.setBackground(new Color(255, 204, 102));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(txtId.getText());

				try {
					Connection con = Conexion.conectar();
					PreparedStatement ps = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
					ps.setInt(1, id);

					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro eliminado");
					limpiar();
					cargarTabla();

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e.toString());
				}

			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(683, 277, 102, 21);
		contentPane.add(btnEliminar);

		JLabel lblClave = new JLabel("Clave");
		lblClave.setHorizontalAlignment(SwingConstants.LEFT);
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClave.setBounds(410, 221, 63, 22);
		contentPane.add(lblClave);

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

		if (regEmp.registrarUsuario(usuario1)) {
			JOptionPane.showMessageDialog(contentPane, "REGISTRADO");
			limpiar();
			cargarTabla();
		} else {
			JOptionPane.showMessageDialog(contentPane, "Error al registrarse");
		}

	}

	private void limpiar() {
		txtDni.setText("");
		txtUsuario.setText("");
		txtApellidos.setText("");
		txtFecha_nac.setText("");
		txtPoblacion.setText("");
		passwordField.setText("");

	}

	private void cargarTabla() {

		DefaultTableModel modeloTabla = (DefaultTableModel) tblEmpleados.getModel();
		modeloTabla.setRowCount(0);
		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;
		int columnas;

		try {
			Connection con = Conexion.conectar();
			ps = con.prepareStatement(
					"SELECT id, dni, usuario, apellidos, fecha_nac, poblacion, clave FROM usuario WHERE roll = 'empleado' ");
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
}
