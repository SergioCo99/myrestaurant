package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurante.TipoComida;
import usuario.TipoUsuario;
import baseDeDatos.BdMyRestaurants;
public class BdMyRestaurantsTest {

	Connection conexion = BdMyRestaurants.initBD();

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
			assertTrue(BdMyRestaurants.logIn(st, "jokin", "123Deusto"));
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
			BdMyRestaurants.crearUsuario(1, "jokin", "jokin87@gmail.com", "123Deusto", 685740319, TipoUsuario.GESTOR);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void existeRestauranteTest() {
		Statement st;
		try {
			st = conexion.createStatement();
			assertTrue(BdMyRestaurants.existeRestaurante(st, "Como en casa"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void nuevoRestauranteTest() {
		Statement st;
		try {
			st = conexion.createStatement();
			BdMyRestaurants.crearRestaurante(1, "Como en Casa", 8.00, 23.00, "Calle Agapito", 900000000, TipoComida.COMIDACASERA);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
