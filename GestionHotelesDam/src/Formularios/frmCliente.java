package Formularios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Usuario;

public class frmCliente extends JFrame {

	private JPanel contentPane;
	private JTable contentPane1;

	public frmCliente(Usuario usu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(99, 11, 216, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnLeer = new JButton("Visualizar datos");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizarCliente(usu);
			}
		});
		
		btnLeer.setBounds(240, 44, 143, 23);
		contentPane.add(btnLeer);
		
		JButton btnNewButton_1 = new JButton("Actualizar datos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnNewButton_1.setBounds(240, 72, 143, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Reservar habitacion");
		btnNewButton.setBounds(240, 103, 143, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Cancelar reserva");
		btnNewButton_2.setBounds(240, 137, 143, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Historial de reservas");
		btnNewButton_3.setBounds(51, 200, 143, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Valorar Hoteles");
		btnNewButton_4.setBounds(254, 166, 116, 23);
		contentPane.add(btnNewButton_4);
	}

	protected void visualizarCliente(Usuario usu) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JTable tabla = new JTable();
		tabla.setBounds(10, 266, 436, -259);
		contentPane.add(tabla);
		
		String[] columnas = {"USUARIO","APELLIDOS","CLAVE","DNI","FECHA NACIMIENTO"};
		DefaultTableModel tabla2 = new DefaultTableModel(columnas,0);
		
		tabla.setModel(tabla2);
		
		String[] datos = new String[5];
		
		datos[0] = usu.getUsuario();
		datos[1] = usu.getApellidos();
		datos[2] = usu.getClave();
		datos[3] = usu.getDni();
		datos[4] = usu.getFecha_nac();
		
		tabla2.addRow(datos);		
	}
}
