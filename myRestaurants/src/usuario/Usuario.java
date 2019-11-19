package usuario;

public class Usuario {
	private static int contador = 0;
	
	private int id_usuario;
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
		this.id_usuario = contador;
		contador++;
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
		this.id_usuario = contador;
		contador++;
		this.nombre = "";
		this.apellidos = "";
		this.nombreUsuario = "";
		this.contrasenya = "";
		this.telefono = 0;
		this.direccion = "";
		this.tipo = null;
	}
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
		return "Usuario [id_usuario=" + id_usuario + ",=" + nombre + ", apellidos=" + apellidos + ", nombreUsuario=" + nombreUsuario
				+ ", contrasenya=" + contrasenya + ", telefono=" + telefono + ", direccion=" + direccion + ", tipo="
				+ tipo + "]";
	}
	
	
}
