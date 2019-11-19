package alimentacion;

public class Postre extends Producto{
	private boolean esFrio;

	public Postre(String nombre, String descripcion, int precio, boolean esFrio) {
		super(nombre, descripcion, precio);
		this.esFrio = esFrio;
	}

	public Postre(boolean esFrio) {
		super();
		this.esFrio = false;
	}

	public boolean isEsFrio() {
		return esFrio;
	}

	public void setEsFrio(boolean esFrio) {
		this.esFrio = esFrio;
	}

	@Override
	public String toString() {
		return "Postre [esFrio=" + esFrio + "]";
	}
	
}
