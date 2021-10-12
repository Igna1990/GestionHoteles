package Formularios;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

public class Logeo extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logeo frame = new Logeo();
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
	public Logeo() {
		setBackground(Color.WHITE);
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbLogeo = new JLabel("LOGIN");
		lbLogeo.setForeground(Color.WHITE);
		lbLogeo.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
		lbLogeo.setBounds(175, 11, 131, 46);
		contentPane.add(lbLogeo);
		
		JLabel lbUsuario = new JLabel("Usuario : ");
		lbUsuario.setForeground(Color.WHITE);
		lbUsuario.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
		lbUsuario.setBounds(91, 75, 84, 27);
		contentPane.add(lbUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(168, 79, 158, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lbClave = new JLabel("Clave :");
		lbClave.setForeground(Color.WHITE);
		lbClave.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
		lbClave.setBounds(70, 137, 84, 27);
		contentPane.add(lbClave);
		
		txtClave = new JPasswordField();
		txtClave.setColumns(10);
		txtClave.setBounds(168, 141, 158, 20);
		contentPane.add(txtClave);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
				}
			}
		);
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.setFont(new Font("Segoe UI Historic", Font.BOLD, 13));
		btnIngresar.setBackground(Color.DARK_GRAY);
		btnIngresar.setBounds(70, 196, 107, 38);
		contentPane.add(btnIngresar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(227, 196, 99, 38);
		contentPane.add(btnSalir);
	}

	protected void ingresar() {
		
		String usuario = txtUsuario.getText();
		String clave = String.valueOf(txtClave.getText());
		
		gestionUsuario gestUs = new gestionUsuario();
		
		Usuario usuario2 = new Usuario();
		usuario2.setUsuario(usuario);
		usuario2.setClave(clave);
		
		Usuario usu = gestUs.obtenerUsuario(usuario2);
		
		if(usu!=null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			
			this.dispose();
			
			frmBienvenida frmBienvenida = new frmBienvenida();
			frmBienvenida.setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(contentPane, "Datos inválidos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	protected void salir() {
		System.exit(0);
		
	}
}
