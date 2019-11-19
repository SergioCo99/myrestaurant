package alimentacion;

import java.util.Arrays;

public class Pedido {
	private static int contador = 1;
	private int id;
	private Producto[] productos;
	
	
	public Pedido(int id, Producto[] productos) {
		super();
		contador++;
		this.id = contador;
		this.productos = productos;
	}
	
	public Pedido() {
		super();
		contador++;
		this.id = contador;
		this.productos = null;
	}

	public static int getContador() {
		return contador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto[] getProductos() {
		return productos;
	}

	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", productos=" + Arrays.toString(productos) + "]";
	}
	
}
