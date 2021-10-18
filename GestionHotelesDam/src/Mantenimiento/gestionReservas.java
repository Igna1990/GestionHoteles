package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import ConexionBD.Conexion;
import bean.Hoteles;

public class gestionReservas {
	

	
	public void comboxHoteles(JComboBox cbxHotel) {
		
		PreparedStatement  stm = null; 
		Connection con = Conexion.conectar();
		
		String sql = "SELECT nombre FROM hoteles";
		
		try {
			stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			cbxHotel.addItem("Seleccione");
			
			while(rs.next()) {
				cbxHotel.addItem(rs.getString("nombre"));
			}
	
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}
	
	public int identHotel(String nombreHotel) {
		
		PreparedStatement  stm = null; 
		Connection con = Conexion.conectar();
		
		int id = 0;
		
		String sql = "SELECT id FROM hoteles WHERE nombre = ? ";
		
		 try {
				 stm = con.prepareStatement(sql);
		         stm.setString(1,nombreHotel);
		         ResultSet rs = stm.executeQuery();

		        if (rs.next()) {
		            id = rs.getInt("id_hotel");
		        }

		    } catch (SQLException e) {
		        
		    	System.out.println("Error");
		    }
		    return id;
		}
		
	
	
	public void comboxHab(JComboBox cbxHab,int idHotel) {
		
		PreparedStatement  stm = null; 
		Connection con = Conexion.conectar();
		
		String sql = "SELECT num_hab FROM habitaciones WHERE id_hotel = ?";
		
		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, idHotel);
			ResultSet rs = stm.executeQuery();
			
			cbxHab.addItem("0");
			
			while(rs.next()) {
				cbxHab.addItem(rs.getInt("num_hab"));
			}
	
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}

}
