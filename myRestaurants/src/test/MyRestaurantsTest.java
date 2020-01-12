package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import restaurante.TipoComida;
import restaurante.Restaurante;

public class MyRestaurantsTest {
	@Test
	public void test() {
		Restaurante rest = new Restaurante("Como en Casa", 8, 23, "Calle Agapito", 900000000, TipoComida.COMIDACASERA);
		
		String nombre = rest.getNombre();
		assertEquals("Como en Casa", nombre);
		
		int hAper = rest.getHorarioApertura();
		assertEquals(8, hAper);
		
		int hCier = rest.getHorarioCierre();
		assertEquals(23, hCier);
		
		String calle = rest.getDireccion();
		assertEquals("Calle Agapito", calle);
		
		int telf = rest.getTelefono();
		assertEquals(900000000, telf);
		
		TipoComida tipo = rest.getTipocomida();
		assertEquals(TipoComida.COMIDACASERA, tipo);
		
	}
}
