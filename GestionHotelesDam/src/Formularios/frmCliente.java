package Formularios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Usuario;

public class frmCliente extends JFrame {

	private JPanel contentPane;
	private JTable contentPane1;
	private JTable table;

	public frmCliente(Usuario usu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 300);
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
		
		btnLeer.setBounds(35, 44, 143, 23);
		contentPane.add(btnLeer);
		
		JButton btnNewButton_1 = new JButton("Actualizar datos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar(usu);
			}
		});
		
		btnNewButton_1.setBounds(305, 44, 143, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Reservar habitacion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservar();
			}
		});
		btnNewButton.setBounds(35, 78, 143, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Cancelar reserva");
		btnNewButton_2.setBounds(35, 112, 143, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Historial de reservas");
		btnNewButton_3.setBounds(305, 78, 143, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Valorar Hoteles");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorar(usu);
			}
		});
		btnNewButton_4.setBounds(305, 112, 143, 23);
		contentPane.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 165, 419, 47);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Apellidos", "Clave", "Dni", "Fecha Nacimiento"
			}
		));
		scrollPane.setViewportView(table);
	}

	protected void reservar() {
		
		frmReservaHab reserv = new frmReservaHab();
		reserv.setVisible(true);
		
	}

	protected void valorar(Usuario usu) {
		
	}

	protected void actualizar(Usuario usu) {
		
		frmActualizarCliente actualizar = new frmActualizarCliente(usu);
		actualizar.setVisible(true);
	}

	protected void visualizarCliente(Usuario usu) {
		
		DefaultTableModel tabla2 = (DefaultTableModel) table.getModel();
		
		table.setModel(tabla2);
		tabla2.setRowCount(0);
		
		String[] datos = new String[5];
		
		datos[0] = usu.getUsuario();
		datos[1] = usu.getApellidos();
		datos[2] = usu.getClave();
		datos[3] = usu.getDni();
		datos[4] = usu.getFecha_nac();
		
		tabla2.addRow(datos);		
	}
}
