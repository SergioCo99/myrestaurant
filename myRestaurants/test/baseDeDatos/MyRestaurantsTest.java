package baseDeDatos;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import restaurante.Restaurante;
import restaurante.TipoComida;
import usuario.TipoUsuario;

public class MyRestaurantsTest {
	
	
	private static Connection con = BdMyRestaurants.initBD();
	
	@BeforeClass
	public static void testInitBD() {
		if(con != null) {
			assertTrue(true, "Test funciona");
		}else {
			fail();
		}
	}
	
	@AfterClass
	public static void testCerrarBD() {
		if (con != null) {
			assertTrue(true, "Test funciona ");
		}else {
			fail();
		}
	}
	
	@Test 
	public void testCrearUsuario() {//faltat
		try {
			BdMyRestaurants.crearUsuario(6, "antton15", "antton15@gmail.com", "Test1", 624120789, TipoUsuario.CLIENTE);

			PreparedStatement Stmt = con.prepareStatement(
					"select nombreUsuario from usuario where correo = antton15@gmail.com");
			ResultSet rs = Stmt.executeQuery();

			int id;
			String nombreUsuario;
			String contrasenya;
			String correo;
			int telefono;
			TipoUsuario tipo;

			while (rs.next()) {
				id = rs.getInt("id_usuario");
				nombreUsuario = rs.getString("nombreUsuario");
				correo = rs.getString("correo");
				contrasenya = rs.getString("contrasenya");
				telefono = rs.getInt("telefono");
				tipo = TipoUsuario.valueOf(rs.getString("tipo"));
				

				assertEquals(6, id);
				assertEquals("antton15", nombreUsuario);
				assertEquals("antton15@gmail.com", correo);
				assertEquals("Test1", contrasenya);
				assertEquals(624120789, telefono);
				assertEquals(TipoUsuario.CLIENTE, tipo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@Test 
	public void testInicioSesion() {
		Statement st;
		try {
			st = con.createStatement();
			BdMyRestaurants.logIn(st, "jokin", "123Deusto");
			assertTrue(true, "Test funciona");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void testExisteUsuario() {
		Statement st;
		try {
			st = con.createStatement();
			assertTrue(BdMyRestaurants.existeUsuario(st, "jokin@gmail.com"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void testCrearRestaurante() {
		try {
			BdMyRestaurants.crearRestaurante(8, "lolo", 10.00, 22.00, "Eretxo kalea", 632104957, TipoComida.SIDRERIA);

			PreparedStatement Stmt = con.prepareStatement(
					"select nombre from restaurante where id_restaurante = 8");
			ResultSet rs = Stmt.executeQuery();

			int id_restaurante;
			String nombreRestaurante;
			double horaAp;
			double horaCer;
			String direccion;
			int telefono;
			TipoComida tipo;

			while (rs.next()) {
				id_restaurante = rs.getInt("id_restaurante");
				nombreRestaurante = rs.getString("nombre");
				horaAp = rs.getDouble("horaAp");
				horaCer = rs.getDouble("horaCer");
				direccion = rs.getString("direccion");
				telefono = rs.getInt("telefono");
				tipo = TipoComida.valueOf(rs.getString("tipo"));
				

				assertEquals(8, id_restaurante);
				assertEquals("lolo", nombreRestaurante);
				assertEquals(10.00, horaAp);
				assertEquals(22.00, horaCer);
				assertEquals("Eretxo kalea", direccion);
				assertEquals(632104957, telefono);
				assertEquals(TipoComida.SIDRERIA, tipo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void testExisteRestaurante() {
		Statement st;
		try {
			st = con.createStatement();
			assertTrue(BdMyRestaurants.existeRestaurante(st, "Como en casa"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
