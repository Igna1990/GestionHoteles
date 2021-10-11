package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/gestionhoteles";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";
	
	public static Connection conectar() {
		
		Connection con = null;
		try {
			Class.forName(CONTROLADOR);
			con = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("CONNECT");
			
		} catch (ClassNotFoundException e) {
				System.out.println("Error al cargar el controlador");
				e.printStackTrace();

		} catch (SQLException e) {
				System.out.println("Error con la conexión a la  BBDD");
				e.printStackTrace();
			}
		
		return con;
	}
}
