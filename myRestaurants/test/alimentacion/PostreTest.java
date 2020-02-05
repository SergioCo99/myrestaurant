package alimentacion;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class PostreTest {
	private static Postre postre;
	@BeforeClass
	public static void inicializarClase() {
		 postre = new Postre();
	}

	
	@Test
	public void testgetNombre() {
		Postre postre1 = new Postre("Helado", "De chocolate", 3.50);
		assertEquals(postre1.getNombre(), "Helado");
	}
	
	@Test
	public void testGetDescripcion(){
		Postre postre1 = new Postre("Helado", "De chocolate", 3.50);
		assertEquals(postre1.getDescripcion(), "De chocolate");
	}
	
	@Test
	public void testGetPrecio() {
		Postre postre1 = new Postre("Helado", "De chocolate", 3.50);
		assertEquals(postre1.getPrecio(), 3.50, 0);
		
	}
}
