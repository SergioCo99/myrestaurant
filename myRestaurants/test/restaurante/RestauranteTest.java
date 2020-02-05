package restaurante;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;


public class RestauranteTest {
	private static Restaurante restaurante;
	
	@BeforeClass
	public static void inicializarClase() {
		restaurante = new Restaurante();
	}
	@Test
	public void testgetNombre() {
		Restaurante restaurante1 = new Restaurante("Pili", 14.00, 23.50, "Cristobal Colon 1", 698742103, TipoComida.COMIDACASERA);
		assertEquals(restaurante1.getNombre(), "Pili");
	}
	
	@Test
	public void testGetHorarioAp(){
		Restaurante restaurante1 = new Restaurante("Pili", 14.00, 23.50, "Cristobal Colon 1", 698742103, TipoComida.COMIDACASERA);
		assertEquals(restaurante1.getHorarioApertura(), 14.00, 0);
	}
	
	@Test
	public void testGetHorarioCer() {
		Restaurante restaurante1 = new Restaurante("Pili", 14.00, 23.50, "Cristobal Colon 1", 698742103, TipoComida.COMIDACASERA);
		assertEquals(restaurante1.getHorarioCierre(), 23.50, 0);
		
	}
	@Test
	public void testgetDireccion() {
		Restaurante restaurante1 = new Restaurante("Pili", 14.00, 23.50, "Cristobal Colon 1", 698742103, TipoComida.COMIDACASERA);
		assertEquals(restaurante1.getDireccion(), "Cristobal Colon 1");
	}
	
	@Test
	public void testGetTelefono(){
		Restaurante restaurante1 = new Restaurante("Pili", 14.00, 23.50, "Cristobal Colon 1", 698742103, TipoComida.COMIDACASERA);
		assertEquals(restaurante1.getTelefono(), 698742103);
	}
	
	@Test
	public void testGetTipoComida() {
		Restaurante restaurante1 = new Restaurante("Pili", 14.00, 23.50, "Cristobal Colon 1", 698742103, TipoComida.COMIDACASERA);
		assertEquals(restaurante1.getTipocomida(), TipoComida.COMIDACASERA);
		
	}


}
