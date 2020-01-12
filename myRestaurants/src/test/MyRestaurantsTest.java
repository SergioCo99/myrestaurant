package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import restaurante.TipoComida;
import restaurante.Restaurante;

public class MyRestaurantsTest {
	@Test
	public void test() {
		Restaurante rest = new Restaurante("Como en Casa", 8.00, 23.00, "Calle Agapito", 900000000, TipoComida.COMIDACASERA);
		
		String nombre = rest.getNombre();
		assertEquals("Como en Casa", nombre);
		
		double hAper = rest.getHorarioApertura();
		assertEquals(8.00, hAper);
		
		double hCier = rest.getHorarioCierre();
		assertEquals(8.00, hCier);
		
		String calle = rest.getDireccion();
		assertEquals("Calle Agapito", calle);
		
		int telf = rest.getTelefono();
		assertEquals(900000000, telf);
		
		TipoComida tipo = rest.getTipocomida();
		assertEquals(TipoComida.COMIDACASERA, tipo);
		
	}
}
