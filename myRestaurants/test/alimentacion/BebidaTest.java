package alimentacion;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;

public class BebidaTest {
	private static Bebida bebida;
	
	@BeforeClass
	public static void inicializarClase() {
		bebida = new Bebida();
	}

	
	@Test
	public void testgetNombre() {
		Bebida bebida1 = new Bebida("Agua", "de manantial", 1.20, false);
		assertEquals(bebida1.getNombre(), "Agua");
	}
	
	@Test
	public void testGetDescripcion(){
		Bebida bebida1 = new Bebida("Agua", "de manantial", 1.20, false);
		assertEquals(bebida1.getDescripcion(), "de manantial");
	}
	
	@Test
	public void testGetPrecio() {
		Bebida bebida1 = new Bebida("Agua", "de manantial", 1.20, false);
		assertEquals(bebida1.getPrecio(), 1.20, 0);
		
	}
	@Test
	public void testIsConAlcohol() {
		Bebida bebida1 = new Bebida("Agua", "de manantial", 1.20, false);
		assertEquals(bebida1.isConAlcohol(),false);
		
	}
}
