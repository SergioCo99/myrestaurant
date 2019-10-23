package Alimentacion;

public class Plato {
	
	protected String nombrePlato;
	protected double precioPlato;
	
	
	public Plato() {
		
		this.nombrePlato = "";
		this.precioPlato = 0;
		
	}
	public Plato (Plato a ) {
		
		this.nombrePlato = a.nombrePlato;
		this.precioPlato = a.precioPlato;
		
	}
	public Plato( String nombre,double precio ) {
		super();
		this.nombrePlato = nombrePlato;
		this.precioPlato = precioPlato;
		
	}
	
	public String getNombrePlato() {
		return nombrePlato;
	}

	public void setNombre(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}
	
	public double getPrecioPlato() {
		return precioPlato;
	}

	public void setPrecioPlato(double precioPlato) {
		if (precioPlato >= 0) {
			this.precioPlato = precioPlato;
		}
		this.precioPlato = precioPlato;
	}
	
	/*                FALTA ESTO 
	//to string modificado para ayudar en la BD, las comillas las deja colocadas para que los valores entren directamente en la BD
		@Override
		public String toString() {
			return "'" + nombrePlato + "'," + precioPlato ;
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
*/
	
}
