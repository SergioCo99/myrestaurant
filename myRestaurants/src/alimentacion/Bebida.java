package alimentacion;

public class Bebida extends Producto{
	private String nombre;
	private String descripcion;
	private double precio;
	private boolean conAlcohol;
	
	public Bebida(String nombre, String descripcion, double precio,boolean conAlcohol) {
		super(nombre, descripcion, precio);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.conAlcohol = conAlcohol;
	}
	public Bebida() {
		nombre = "";
		descripcion = "";
		precio = 0;
		conAlcohol = false;
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

	public double getPrecio() {
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