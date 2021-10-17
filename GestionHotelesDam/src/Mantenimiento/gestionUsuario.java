package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ConexionBD.Conexion;
import bean.Usuario;

public class gestionUsuario {

	Usuario usuario = null;	
	Connection con = null;	
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public Usuario obtenerUsuario(Usuario usu) {
		
		try {
			con = Conexion.conectar();
			String sql = "SELECT * FROM USUARIO WHERE USUARIO = ? AND CLAVE = ? ";
			pst = con.prepareStatement(sql);
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getClave());
			rs = pst.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario(rs.getString("usuario"),rs.getString("clave"),rs.getString("apellidos"),
						rs.getString("dni"),rs.getString("imagen"),rs.getString("fecha_nac"), rs.getString("poblacion"),rs.getString("roll"),rs.getInt("Id"));
			}
			
		} catch (Exception e) {
			System.out.println("Error en obtener USUARIO");
		}
		
		
		return usuario;
	}
	
	public boolean actualizarUsuario(Usuario usu) {
		
		try {
			con = Conexion.conectar();
			String sql = "UPDATE usuario SET usuario = ?, clave = ?, apellidos = ? , dni = ? , imagen = ?, fecha_nac = ? , roll = ? WHERE id = ? ";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getClave());
			pst.setString(3, usu.getApellidos());
			pst.setString(4, usu.getDni());
			pst.setString(5, usu.getImagen());
			pst.setString(6, usu.getFecha_nac());
			pst.setString(7, usu.getRoll());
			pst.setInt(8, usu.getId());
			
			pst.executeUpdate();
			
			return true;
			
			
		} catch (Exception e) {
			
			System.out.println("Error al actualizar el Usuario");
			
			return false;
		}
		
	}
}
