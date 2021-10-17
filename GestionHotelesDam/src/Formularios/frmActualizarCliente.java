package Formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Mantenimiento.gestionUsuario;
import bean.Usuario;

public class frmActualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtFecha;
	private JTextField txtFoto;
	private JPasswordField pssClave;

	public frmActualizarCliente(Usuario usu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNombre = new JLabel("Nombre: ");
		lbNombre.setBounds(66, 47, 46, 14);
		contentPane.add(lbNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(122, 44, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(66, 83, 46, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(122, 75, 86, 20);
		contentPane.add(txtApellidos);
		
		JLabel lbClave = new JLabel("Clave:");
		lbClave.setBounds(236, 47, 46, 14);
		contentPane.add(lbClave);
		
		JLabel lbNombre_1_1 = new JLabel("DNI:");
		lbNombre_1_1.setBounds(236, 83, 46, 14);
		contentPane.add(lbNombre_1_1);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(281, 80, 86, 20);
		contentPane.add(txtDni);
		
		JLabel lbFecha = new JLabel("Fecha Nacimiento:");
		lbFecha.setBounds(26, 118, 86, 14);
		contentPane.add(lbFecha);
		
		JLabel lbFoto = new JLabel("Foto:");
		lbFoto.setBounds(236, 118, 46, 14);
		contentPane.add(lbFoto);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(122, 115, 86, 20);
		contentPane.add(txtFecha);
		
		txtFoto = new JTextField();
		txtFoto.setColumns(10);
		txtFoto.setBounds(281, 115, 86, 20);
		contentPane.add(txtFoto);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar(usu);
			}
		});
		btnNewButton.setBounds(168, 172, 114, 41);
		contentPane.add(btnNewButton);
		
		pssClave = new JPasswordField();
		pssClave.setBounds(281, 44, 86, 20);
		contentPane.add(pssClave);
	}

	protected void actualizar(Usuario usu) {
	 
		gestionUsuario actCliente = new gestionUsuario();
		Usuario usu2 = new Usuario();
		
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String clave = String.valueOf(pssClave.getPassword());
		String dni = txtDni.getText();
		String fecha_nac = txtFecha.getText();
		String foto = txtFoto.getText();
		
		
		usu2.setUsuario(nombre);
		usu2.setApellidos(apellidos);
		usu2.setDni(dni);
		usu2.setClave(clave);
		usu2.setFecha_nac(fecha_nac);
		usu2.setImagen(foto);
		usu2.setRoll("cliente");
		usu2.setId(usu.getId());
		
		
		if(actCliente.actualizarUsuario(usu2)) {
			JOptionPane.showMessageDialog(contentPane, "ACTUALIZADO");
			this.dispose();
			
		}
		else {
			JOptionPane.showMessageDialog(contentPane, "Error al actualizarse");
		}
		
	}
}
