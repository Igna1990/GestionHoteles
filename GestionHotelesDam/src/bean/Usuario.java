package bean;

import java.util.Date;

public class Usuario {
	
	private String usuario,clave,apellidos,dni,imagen,poblacion,roll;
	private Date fecha_nac;
	
	public Usuario() {
		
	}

	public Usuario(String usuario, String clave, String apellidos, String dni, String imagen, String poblacion,
			String roll, Date fecha_nac) {

		this.usuario = usuario;
		this.clave = clave;
		this.apellidos = apellidos;
		this.dni = dni;
		this.imagen = imagen;
		this.poblacion = poblacion;
		this.roll = roll;
		this.fecha_nac = fecha_nac;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

}
