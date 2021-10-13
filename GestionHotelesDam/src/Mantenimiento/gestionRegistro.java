package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ConexionBD.Conexion;
import bean.Usuario;

public class gestionRegistro extends Conexion {

	public boolean registrarUsuario(Usuario usu) {
		
		PreparedStatement  stm = null; 
		Connection con = Conexion.conectar();
		
		String sql = "INSERT INTO USUARIO (usuario, clave, apellidos, dni, imagen, fecha_nac, roll) VALUES ( ? ,? , ? , ? , ? , ? , 'cliente')";
		
		
		try {
			
			stm = con.prepareStatement(sql);
			
			stm.setString(1, usu.getUsuario());
			stm.setString(2, usu.getClave());
			stm.setString(3, usu.getApellidos());
			stm.setString(4, usu.getDni());
			stm.setString(5, usu.getFecha_nac());
			stm.setString(6, usu.getImagen());
			
			stm.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al insertar el USUARIO");
			
			return false;
		}
		
	}
}
