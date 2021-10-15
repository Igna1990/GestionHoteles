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
import javax.swing.UIManager;
import java.awt.SystemColor;

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
		lbUsuario.setBounds(31, 75, 72, 27);
		contentPane.add(lbUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(102, 79, 158, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lbClave = new JLabel("Clave :");
		lbClave.setForeground(Color.WHITE);
		lbClave.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
		lbClave.setBounds(40, 137, 63, 27);
		contentPane.add(lbClave);
		
		txtClave = new JPasswordField();
		txtClave.setColumns(10);
		txtClave.setBounds(102, 141, 158, 20);
		contentPane.add(txtClave);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
				}
			}
		);
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
		btnIngresar.setBackground(UIManager.getColor("Button.background"));
		btnIngresar.setBounds(31, 202, 119, 27);
		contentPane.add(btnIngresar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Segoe UI Historic", Font.PLAIN, 11));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(316, 203, 91, 27);
		contentPane.add(btnSalir);
		
		JButton btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse();
			}
		});
		
		btnRegistrarse.setForeground(Color.BLACK);
		btnRegistrarse.setFont(new Font("Segoe UI Historic", Font.PLAIN, 10));
		btnRegistrarse.setBackground(SystemColor.menu);
		btnRegistrarse.setBounds(175, 203, 111, 27);
		contentPane.add(btnRegistrarse);
	}
	protected void registrarse() {
		
		frmRegistroCliente RegistroCliente = new frmRegistroCliente();
		RegistroCliente.setVisible(true);
		
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
			
			if(usu.getRoll().equals("cliente")) {
				
				frmCliente cliente = new frmCliente(usu);
				cliente.setVisible(true);
			}
			if(usu.getRoll().equals("admin")) {
				
				frmRegistroEmpleados admin = new frmRegistroEmpleados();
				admin.setVisible(true);
			}
			
		}else {
			JOptionPane.showMessageDialog(contentPane, "No está registrado","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	protected void salir() {
		System.exit(0);
		
		
	}
}
