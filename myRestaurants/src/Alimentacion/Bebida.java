package Alimentacion;

public class Bebida {
	protected String nombreBebida;
	protected int precioBebida;
	
	
	public Bebida(String nombreBebida, int precioBebida) {
		super();
		this.nombreBebida = nombreBebida;
		this.precioBebida = precioBebida;
	}
	
	public Bebida() {
		super();
		this.nombreBebida = "";
		this.precioBebida = 0;
	}

	public String getNombreBebida() {
		return nombreBebida;
	}

	public void setNombreBebida(String nombreBebida) {
		this.nombreBebida = nombreBebida;
	}

	public int getPrecioBebida() {
		return precioBebida;
	}

	public void setPrecioBebida(int precioBebida) {
		this.precioBebida = precioBebida;
	}

	@Override
	public String toString() {
		return "Bebida [nombreBebida=" + nombreBebida + ", precioBebida=" + precioBebida + "]";
	}
	
}
