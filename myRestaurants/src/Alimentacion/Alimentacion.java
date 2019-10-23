package Alimentacion;

public class Alimentacion extends Plato{

protected int numeroPlato;
	
	public Alimentacion() {
		this.numeroPlato = 0;
	
	}

	public Alimentacion(Alimentacion a) {
		super(a);
		this.numeroPlato = a.numeroPlato;
	}

	public Alimentacion( String nombre, double precio, int numeroPlato) {
		super(nombre, precio);
		this.numeroPlato = numeroPlato;
	}

	public int getNumeroPlato() {
		return numeroPlato;
	}

	public void setNumeroPlato(int numeroPlato) {
		this.numeroPlato = numeroPlato;
	}
}
