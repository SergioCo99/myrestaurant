package Alimentacion;

public class Postre {
	
	protected String nombrePostre;
	protected int precioPostre;
	
	public Postre(String nombrePostre, int precioPostre) {
		super();
		this.nombrePostre = nombrePostre;
		this.precioPostre = precioPostre;
	}
	public Postre() {
		super();
		this.nombrePostre = "";
		this.precioPostre = 0;
	}
	
	public String getNombrePostre() {
		return nombrePostre;
	}
	public void setNombrePostre(String nombrePostre) {
		this.nombrePostre = nombrePostre;
	}
	public int getPrecioPostre() {
		return precioPostre;
	}
	public void setPrecioPostre(int precioPostre) {
		this.precioPostre = precioPostre;
	}
	@Override
	public String toString() {
		return "Postre [nombrePostre=" + nombrePostre + ", precioPostre=" + precioPostre + "]";
	}
	
	
}
