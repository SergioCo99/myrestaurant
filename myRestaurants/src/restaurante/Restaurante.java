package restaurante;

public class Restaurante {

	private String nombre;
	private String horario;
	private String direccion;
	private int telefono;
	//enum
	private TipoComida tipocomida;
	
	public Restaurante(String nombre, String horario, String direccion, int telefono, TipoComida tipocomida) {
		super();
		this.nombre = nombre;
		this.horario = horario;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipocomida = tipocomida;
	}
	
	public Restaurante() {
		super();
		this.nombre = "";
		this.horario = "";
		this.direccion = "";
		this.telefono = 0;
		this.tipocomida = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
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
		return "Restaurante [nombre=" + nombre + ", horario=" + horario + ", direccion=" + direccion + ", telefono="
				+ telefono + ", tipocomida=" + tipocomida + "]";
	}
	

}
