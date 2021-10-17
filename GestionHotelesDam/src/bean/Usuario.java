package bean;

import java.util.Date;

public class Usuario {
	
	private String usuario,clave,apellidos,dni,imagen,fecha_nac,poblacion,roll;
	private int id;
	
	public Usuario() {
		
	}

	public Usuario(String usuario, String clave, String apellidos, String dni, String imagen, String fecha_nac,
			String poblacion, String roll, int id) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.apellidos = apellidos;
		this.dni = dni;
		this.imagen = imagen;
		this.fecha_nac = fecha_nac;
		this.poblacion = poblacion;
		this.roll = roll;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
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




}
