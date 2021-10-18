package Formularios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Mantenimiento.gestionReservas;
import bean.Hoteles;

public class frmReservaHab extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String nombreHotel;
	private String tipo;
	private int idHotel,id;

	public frmReservaHab() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setBounds(46, 111, 31, 22);
		contentPane.add(lblNewLabel);
		
		JComboBox cmBxHoteles = new JComboBox();
		nombreHotel = cmBxHoteles.getSelectedItem().toString();
		gestionReservas cmHtl = new gestionReservas();
		cmHtl.comboxHoteles(cmBxHoteles);
		cmBxHoteles.setBounds(84, 62, 89, 22);
		contentPane.add(cmBxHoteles);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo = cbxTipo.getSelectedItem().toString();
			}
		});
		cbxTipo.addItem("Simple");
		cbxTipo.addItem("Doble");
		cbxTipo.addItem("Suite");
		cbxTipo.setBounds(85, 111, 88, 22);
		contentPane.add(cbxTipo);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00BA Hab:");
		lblNewLabel_1.setBounds(31, 159, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox cbxHab = new JComboBox();
		cbxHab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionReservas gtHab = new gestionReservas();
				idHotel = gtHab.identHotel(nombreHotel);
			}
		});
		gestionReservas reserva = new gestionReservas();
		reserva.comboxHab(cbxHab, idHotel);
		cbxHab.setBounds(84, 155, 89, 22);
		contentPane.add(cbxHab);

		
		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.setBounds(163, 211, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("RESERVAS");
		lblNewLabel_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(142, 11, 151, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PRECIO");
		lblNewLabel_3.setBounds(247, 159, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(307, 156, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Hotel");
		lblNewLabel_4.setBounds(46, 66, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Fechas:");
		lblNewLabel_4_1.setBounds(241, 66, 46, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Desde:");
		lblNewLabel_4_1_1.setBounds(268, 83, 46, 14);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Hasta:");
		lblNewLabel_4_1_1_1.setBounds(268, 115, 46, 14);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JDateChooser dtDesde = new JDateChooser();
		String fecha1 = ((JTextField)dtDesde.getDateEditor().getUiComponent()).getText();
		dtDesde.setBounds(307, 77, 98, 20);
		contentPane.add(dtDesde);
		
		JDateChooser dtHasta = new JDateChooser();
		String fecha2 = ((JTextField)dtHasta.getDateEditor().getUiComponent()).getText();
		dtHasta.setBounds(307, 113, 98, 20);
		contentPane.add(dtHasta);
		

	}
}
