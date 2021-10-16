package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ConexionBD.Conexion;
import bean.Hoteles;
import bean.Usuario;

public class gestionHoteles extends Conexion {

	public boolean registrarHotel(Hoteles hotel) {

		PreparedStatement stm = null;
		Connection con = Conexion.conectar();

		String sql = "INSERT INTO HOTELES (nombre, descripcion, ciudad, direccion, telefono) VALUES ( ? ,? , ? , ? , ?)";

		try {

			stm = con.prepareStatement(sql);

			stm.setString(1, hotel.getNombre());
			stm.setString(2, hotel.getDescripcion());
			stm.setString(3, hotel.getCiudad());
			stm.setString(4, hotel.getDireccion());
			stm.setString(5, hotel.getTelefono());

			stm.executeUpdate();

			return true;

		} catch (Exception e) {
			System.out.println("Error al insertar el HOTEL");

			return false;
		}

	}

}
