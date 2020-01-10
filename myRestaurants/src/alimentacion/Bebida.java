package alimentacion;

public class Bebida extends Producto{
	private String nombre;
	private String descripcion;
	private int precio;
	private boolean conAlcohol;
	
	public Bebida(String nombre, String descripcion, int precio, String nombre2, String descripcion2, int precio2,
			boolean conAlcohol) {
		super(nombre, descripcion, precio);
		nombre = nombre2;
		descripcion = descripcion2;
		precio = precio2;
		this.conAlcohol = conAlcohol;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean isConAlcohol() {
		return conAlcohol;
	}

	public void setConAlcohol(boolean conAlcohol) {
		this.conAlcohol = conAlcohol;
	}

	@Override
	public String toString() {
		return "Bebida [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", conAlcohol="
				+ conAlcohol + "]";
	}
	
	

}