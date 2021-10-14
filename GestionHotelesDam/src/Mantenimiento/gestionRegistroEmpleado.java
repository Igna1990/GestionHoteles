package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ConexionBD.Conexion;
import bean.Usuario;

public class gestionRegistroEmpleado extends Conexion {

	public boolean registrarUsuario(Usuario usu) {
		
		PreparedStatement  stm = null; 
		Connection con = Conexion.conectar();
		
		String sql = "INSERT INTO USUARIO (dni, usuario, apellidos, fecha_nac, poblacion, clave, roll) VALUES ( ? ,? , ? , ? , ? , ? , 'empleado')";
		
		
		try {
			
			stm = con.prepareStatement(sql);
			
			stm.setString(1, usu.getDni());
			stm.setString(2, usu.getUsuario());
			stm.setString(3, usu.getApellidos());
			stm.setString(4, usu.getFecha_nac());
			stm.setString(5, usu.getPoblacion());
			stm.setString(6, usu.getClave());
			
			
			stm.executeUpdate();
			
			
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al insertar el USUARIO");
			
			return false;
		}
		
	}
	
	
	
}
