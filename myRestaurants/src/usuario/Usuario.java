package usuario;

public class Usuario {
	private String nombre;
	private String apellidos;
	private String nombreUsuario;
	private String contrasenya;
	private int telefono;
	//private int tarjetaCredito;
	private String direccion;
	private TipoUsuario tipo;
	
	
	public Usuario(String nombre, String apellidos, String nombreUsuario, String contrasenya, int telefono,
			 String direccion, TipoUsuario tipo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.contrasenya = contrasenya;
		this.telefono = telefono;

		this.direccion = direccion;
		this.tipo = tipo;
	}
	public Usuario() {
		super();
		this.nombre = "";
		this.apellidos = "";
		this.nombreUsuario = "";
		this.contrasenya = "";
		this.telefono = 0;
		this.direccion = "";
		this.tipo = null;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public TipoUsuario getTipo() {
		return tipo;
	}
	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", nombreUsuario=" + nombreUsuario
				+ ", contrasenya=" + contrasenya + ", telefono=" + telefono + ", direccion=" + direccion + ", tipo="
				+ tipo + "]";
	}
	
	
}
