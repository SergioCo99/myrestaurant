package restaurante;

public class Restaurante {
	private static int contador = 0;

	private int id_restaurante;
	private String nombre;
	private int horarioApertura;
	private int horarioCierre;
	private String direccion;
	private int telefono;
	//enum
	private TipoComida tipocomida;
	
	public Restaurante(String nombre, int horarioApertura, int horarioCierre, String direccion, int telefono, TipoComida tipocomida) {
		super();
		this.id_restaurante = contador;
		contador++;
		this.nombre = nombre;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipocomida = tipocomida;
	}
	
	public Restaurante() {
		super();
		this.id_restaurante = contador;
		contador++;
		this.nombre = "";
		this.horarioApertura = 8;
		this.horarioCierre = 9;
		this.direccion = "";
		this.telefono = 0;
		this.tipocomida = null;
	}
	public int getId_restaurante() {
		return id_restaurante;
	}

	public void setId_restaurante(int id_restaurante) {
		this.id_restaurante = id_restaurante;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(int horarioApertura) {
		this.horarioApertura = horarioApertura;
	}
	
	public int getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioCierre(int horarioCierre) {
		this.horarioCierre = horarioCierre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public TipoComida getTipocomida() {
		return tipocomida;
	}

	public void setTipocomida(TipoComida tipocomida) {
		this.tipocomida = tipocomida;
	}

	@Override
	public String toString() {
		return "Restaurante [id_restaurante=" + id_restaurante + "nombre=" + nombre + ", horarioApertura=" + horarioApertura + ", horarioCierre=" +horarioCierre+ ", direccion=" + direccion + ", telefono="
				+ telefono + ", tipocomida=" + tipocomida + "]";
	}
	

}
