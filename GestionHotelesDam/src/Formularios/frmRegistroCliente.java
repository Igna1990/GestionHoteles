package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmRegistroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtFoto;
	private JTextField txtFecha;
	private JPasswordField pssClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistroCliente frame = new frmRegistroCliente();
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
	public frmRegistroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FORMULARIO DE REGISTRO");
		lblNewLabel.setBounds(149, 11, 144, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(145, 45, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(225, 42, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellidos:");
		lblNewLabel_1_1.setBounds(145, 70, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_1_1_1.setBounds(95, 155, 103, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("DNI: ");
		lblNewLabel_1_1_1_1.setBounds(169, 98, 46, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Foto: ");
		lblNewLabel_1_1_1_2.setBounds(168, 180, 36, 14);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(225, 67, 86, 20);
		contentPane.add(txtApellidos);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(225, 92, 86, 20);
		contentPane.add(txtDni);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Clave:");
		lblNewLabel_1_1_1_3.setBounds(158, 123, 46, 14);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		txtFoto = new JTextField();
		txtFoto.setColumns(10);
		txtFoto.setBounds(225, 177, 86, 20);
		contentPane.add(txtFoto);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(225, 149, 86, 20);
		contentPane.add(txtFecha);
		
		pssClave = new JPasswordField();
		pssClave.setBounds(225, 120, 86, 20);
		contentPane.add(pssClave);
		
		JButton btnNewButton = new JButton("REGISTRARSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse();
			}
		});
		btnNewButton.setBounds(145, 208, 103, 2);
		contentPane.add(btnNewButton);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnSalir.setBounds(304, 208, 103, 23);
		contentPane.add(btnSalir);
	}

	protected void registrarse() {
		
		String usuario = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String dni = txtDni.getText();
		String clave = String.valueOf(pssClave.getPassword());
		
		
		
	}
}
