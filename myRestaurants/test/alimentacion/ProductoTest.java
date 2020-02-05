package alimentacion;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProductoTest {
	private static Producto producto;
	@BeforeClass
	public static void inicializarClase() {
		producto = new Producto();
	}

	
	@Test
	public void testgetNombre() {
		Producto producto1 = new Producto("Producto1", "1er producto", 2.50);
		assertEquals(producto1.getNombre(), "Producto1");
	}
	
	@Test
	public void testGetDescripcion(){
		Producto producto1 = new Producto("Producto1", "1er producto", 2.50);
		assertEquals(producto1.getDescripcion(), "1er producto");
	}
	
	@Test
	public void testGetPrecio() {
		Producto producto1 = new Producto("Producto1", "1er producto", 2.50);
		assertEquals(producto1.getPrecio(),2.50, 0);
		
	}
}
