package usuario;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import restaurante.Restaurante;
import restaurante.TipoComida;

public class UsuarioTest {
private static Usuario usuario;
	
	@BeforeClass
	public static void inicializarClase() {
		usuario = new Usuario();
	}
	@Test
	public void testgetNombre() {
		Usuario usuario1 = new Usuario("Jon", "jon9@gmail.com", "2014Queso", 687475003, TipoUsuario.CLIENTE);
		assertEquals(usuario1.getNombreUsuario(), "Jon");
	}
	
	@Test
	public void testGetCorreo(){
		Usuario usuario1 = new Usuario("Jon", "jon9@gmail.com", "2014Queso", 687475003, TipoUsuario.CLIENTE);
		assertEquals(usuario1.getCorreo(), "jon9@gmail.com");
	}
	
	@Test
	public void testGetContrasenya() {
		Usuario usuario1 = new Usuario("Jon", "jon9@gmail.com", "2014Queso", 687475003, TipoUsuario.CLIENTE);
		assertEquals(usuario1.getContrasenya(), "2014Queso");
		
	}
	@Test
	public void testgetDireccion() {
		Usuario usuario1 = new Usuario("Jon", "jon9@gmail.com", "2014Queso", 687475003, TipoUsuario.CLIENTE);
		assertEquals(usuario1.getTelefono(), 687475003);
	}
	
	@Test
	public void testGetTipoUsuario(){
		Usuario usuario1 = new Usuario("Jon", "jon9@gmail.com", "2014Queso", 687475003, TipoUsuario.CLIENTE);
		assertEquals(usuario1.getTipo(), TipoUsuario.CLIENTE);
	}
}
