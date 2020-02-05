package alimentacion;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;

public class MenuTest {
	private static Menu menu;
	
	@BeforeClass
	public static void inicializarClase() {
		menu = new Menu();
	}
	
	@Test
	public void testgetMenuNombre() {
		Menu menu1 = new Menu("Men� jabali", "Carne, agua y pan", 12.00, 3);
		assertEquals(menu1.getNombre(), "Men� jabali");
	}
	
	@Test
	public void testGetMenuDescripcion(){
		Menu menu1 = new Menu("Men� jabali", "Carne, agua y pan", 12.00, 3);
		assertEquals(menu1.getDescripcion(), "Men� jabali");
	}
	
	@Test
	public void testGetMenuPrecio() {
		Menu menu1 = new Menu("Men� jabali", "Carne, agua y pan", 12.00, 3);
		assertEquals(menu1.getPrecio(), "Men� jabali");
		
	}
	@Test
	public void testGetMenuNumero() {
		Menu menu1 = new Menu("Men� jabali", "Carne, agua y pan", 12.00, 3);
		assertEquals(menu1.getNumeroMenu(), "Men� jabali");
		
	}
}
