package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class frmActualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public frmActualizarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNombre = new JLabel("Nombre: ");
		lbNombre.setBounds(66, 47, 46, 14);
		contentPane.add(lbNombre);
		
		textField = new JTextField();
		textField.setBounds(122, 44, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbNombre_1 = new JLabel("Nombre: ");
		lbNombre_1.setBounds(66, 83, 46, 14);
		contentPane.add(lbNombre_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 75, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lbNombre_2 = new JLabel("Nombre: ");
		lbNombre_2.setBounds(236, 47, 46, 14);
		contentPane.add(lbNombre_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(281, 44, 86, 20);
		contentPane.add(textField_2);
		
		JLabel lbNombre_1_1 = new JLabel("Nombre: ");
		lbNombre_1_1.setBounds(236, 83, 46, 14);
		contentPane.add(lbNombre_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(281, 80, 86, 20);
		contentPane.add(textField_3);
		
		JLabel lbNombre_1_2 = new JLabel("Nombre: ");
		lbNombre_1_2.setBounds(66, 118, 46, 14);
		contentPane.add(lbNombre_1_2);
		
		JLabel lbNombre_1_1_1 = new JLabel("Nombre: ");
		lbNombre_1_1_1.setBounds(236, 118, 46, 14);
		contentPane.add(lbNombre_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(122, 115, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(281, 115, 86, 20);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(168, 172, 114, 41);
		contentPane.add(btnNewButton);
	}
}
