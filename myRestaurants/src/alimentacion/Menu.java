package alimentacion;

public class Menu extends Producto{
	private int numeroMenu;

	public Menu(String nombre, String descripcion, double precio, int numeroMenu) {
		super(nombre, descripcion, precio);
		this.numeroMenu = numeroMenu;
	}
	public Menu() {
		super();
		this.numeroMenu = 0;
	}

	public Menu(int numeroMenu) {
		super();
		this.numeroMenu = 0;
	}

	public int getNumeroMenu() {
		return numeroMenu;
	}

	public void setNumeroMenu(int numeroMenu) {
		this.numeroMenu = numeroMenu;
	}

	@Override
	public String toString() {
		return "Menu [numeroMenu=" + numeroMenu + "]";
	}
	
}
