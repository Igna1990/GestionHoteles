package bean;

public class Hoteles {

	private String nombre, descripcion, ciudad, direccion, telefono;
	private int id;

	public Hoteles() {

	}

	public Hoteles(String nombre, String descripcion, String ciudad, String direccion, String telefono,int id) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.id = id;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Hoteles [nombre=" + nombre + ", descripcion=" + descripcion + ", ciudad=" + ciudad + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}


}
