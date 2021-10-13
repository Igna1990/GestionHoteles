package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ConexionBD.Conexion;
import bean.Usuario;

public class gestionUsuario {

	public Usuario obtenerUsuario(Usuario usu) {
		
		Usuario usuario = null;	
		Connection con = null;	
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = Conexion.conectar();
			String sql = "SELECT * FROM USUARIO WHERE USUARIO = ? AND CLAVE = ? ";
			pst = con.prepareStatement(sql);
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getClave());
			rs = pst.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario(rs.getString("usuario"),rs.getString("clave"),rs.getString("apellidos"),
						rs.getString("dni"),rs.getString("imagen"),rs.getString("fecha_nac"), rs.getString("poblacion"),rs.getString("roll"));
			}
			
		} catch (Exception e) {
			System.out.println("Error en obtener USUARIO");
		}
		
		
		return usuario;
	}
}
