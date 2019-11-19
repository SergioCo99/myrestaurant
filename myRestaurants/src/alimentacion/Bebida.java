package alimentacion;

public class Bebida extends Producto{
	private boolean conAlcohol;

	
	public Bebida(String nombre, String descripcion, int precio, boolean conAlcohol) {
		super(nombre, descripcion, precio);
		this.conAlcohol = conAlcohol;
	}


	public Bebida() {
		super();
		this.conAlcohol = false;
	}


	public boolean isConAlcohol() {
		return conAlcohol;
	}


	public void setConAlcohol(boolean conAlcohol) {
		this.conAlcohol = conAlcohol;
	}


	@Override
	public String toString() {
		return "Bebida [conAlcohol=" + conAlcohol + "]";
	}
	
	
	
}
