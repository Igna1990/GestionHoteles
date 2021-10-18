package bean;

public class Reservas {

	private String fecha_inicio, fecha_fin, nombre_hotel;
	private int num_hab,id,id_hotel,id_hab,id_cliente;
	
	public Reservas(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Reservas(String fecha_inicio, String fecha_fin, String nombre_hotel, int num_hab, int id, int id_hotel,
			int id_hab, int id_cliente) {
		super();
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.nombre_hotel = nombre_hotel;
		this.num_hab = num_hab;
		this.id = id;
		this.id_hotel = id_hotel;
		this.id_hab = id_hab;
		this.id_cliente = id_cliente;
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

	public String getNombre_hotel() {
		return nombre_hotel;
	}

	public void setNombre_hotel(String nombre_hotel) {
		this.nombre_hotel = nombre_hotel;
	}

	public int getNum_hab() {
		return num_hab;
	}

	public void setNum_hab(int num_hab) {
		this.num_hab = num_hab;
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

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
}
