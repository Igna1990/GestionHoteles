package bean;

public class Habitaciones {
	
	private int id, id_hotel,id_hab,num_hab,precio;
	private String tipo,extras,fecha_inicio,fecha_fin;
	
	public Habitaciones() {
	}

	public Habitaciones(int id, int id_hotel, int id_hab, int num_hab, int precio, String tipo, String extras,
			String fecha_inicio, String fecha_fin) {
		super();
		this.id = id;
		this.id_hotel = id_hotel;
		this.id_hab = id_hab;
		this.num_hab = num_hab;
		this.precio = precio;
		this.tipo = tipo;
		this.extras = extras;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}

	public int getId_hab() {
		return id_hab;
	}

	public void setId_hab(int id_hab) {
		this.id_hab = id_hab;
	}

	public int getNum_hab() {
		return num_hab;
	}

	public void setNum_hab(int num_hab) {
		this.num_hab = num_hab;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
}
