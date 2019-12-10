package usuario;

public class Usuario {
	private static int contador = 0;
	
	private int id_usuario;
	private String nombreUsuario;
	private String correo;
	private String contrasenya;
	private int telefono;
	//private int tarjetaCredito;
	private String direccion;
	private TipoUsuario tipo;
	
	
	public Usuario( String nombreUsuario, String correo, String contrasenya, int telefono,
			 String direccion, TipoUsuario tipo) {
		super();
		this.id_usuario = contador;
		contador++;
		this.correo = correo;
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
		this.correo = "";
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
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
		return "Usuario [id_usuario=" + id_usuario + ", correo=" + correo + ", nombreUsuario=" + nombreUsuario
				+ ", contrasenya=" + contrasenya + ", telefono=" + telefono + ", direccion=" + direccion + ", tipo="
				+ tipo + "]";
	}
	
	
}
