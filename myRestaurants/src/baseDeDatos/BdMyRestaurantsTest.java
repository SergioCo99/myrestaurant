package baseDeDatos;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import usuario.TipoUsuario;

public class BdMyRestaurantsTest {

	Connection conexion = BdMyRestaurants.conectar();

	@Before
	public void conexionTest() {
		if (conexion != null) {

		} else {
			fail();
		}
	}

	@After
	public void closeConexionTest() {
		if (conexion != null) {

		} else {
			fail();
		}
	}

	@Test
	public void logInTest() {
		Statement st;
		try {
			st = conexion.createStatement();
			assertTrue(BdMyRestaurants.logIn(st, "a", "a"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void existeUsuarioTest() {
		Statement st;
		try {
			st = conexion.createStatement();
			assertTrue(BdMyRestaurants.existeUsuario(st, "jokin@gmail.com"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void nuevoUsuarioTest() {
		Statement st;
		try {
			st = conexion.createStatement();
			BdMyRestaurants.nuevoUsuario(st, 1 , "jokin87", "lauram@gmail.com","123", 688547115, "Elezalde kalea", TipoUsuario.CLIENTE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void eliminarUsuarioTest() {
		Statement st;
		try {
			st = conexion.createStatement();
			BdMyRestaurants.eliminarUsuario(st, "lauram@gmail.com");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void cambiarContrasenyaTest() {
		Statement st;
		try {
			st = conexion.createStatement();
			BdMyRestaurants.cambiarContrasenya(st, "123", "lauram@gmail.com");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
