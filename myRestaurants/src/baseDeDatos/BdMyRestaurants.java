/*package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import usuario.TipoUsuario;

public class BdMyRestaurants {
	
	private static boolean LOGGING = true;

	public static void main(String[] args) {

		Connection con =null;
		try {
			Class.forName("org.sqlite.JDBC");
			con= DriverManager.getConnection("DBProg3.db");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("myrestaurant.db");
			log( Level.INFO, "Conectada base de datos ", null );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {
			log( Level.SEVERE, "Error en conexión de base de datos " + nombreBD, e );
			return null;
		}
	}

	public static Connection conectar() {
		try {
			Class.forName(CONTROLADOR);
			Connection conexion = DriverManager.getConnection(URL,USUARIO,CLAVE);
			ventanas.VentanaRegistro.BDLogger.log(Level.INFO, "Te has conectado");
		}catch(ClassNotFoundException | SQLException e) {
			ventanas.VentanaRegistro.BDLogger.log(Level.INFO, "ERROR en la conexion!",e);
			e.printStackTrace();
		}
		return null;
	}
	
	public static void cerrarBD(final Connection con, final Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			ventanas.VentanaRegistro.BDLogger.log(Level.SEVERE, "Error al cerrar la base de datos.", e);
			e.printStackTrace();
		}
	}
	public static void CrearUsuario(int id_usuario, String nombreUsuario, String correo, String contrasenya, int telefono,
			 String direccion, TipoUsuario tipo) {

		BdMyRestaurants conexion = new BdMyRestaurants();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		PreparedStatement ps;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM Usuario");
			ps = cn.prepareStatement(
					"INSERT INTO Usuario(id_usuario, correo, nombreUsuario, contrasenya, direccion, telefono, tipo) VALUES(?,?,?,?,?,?)");

			ps.setString(1, nombreUsuario);
			

			int res = ps.executeUpdate();

			if (res > 0) {
				JOptionPane.showMessageDialog(null, "El usuario creado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "ERROR al crear el usuario!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static boolean logIn(Statement st, String user, String passw) {
		String SentSQL = "select * from Usuario where nombreUsuario = '" + user + "' and contrasena = '" + passw + "'";
		try {
			ResultSet rs = st.executeQuery(SentSQL);
			rs.next();

			String a = rs.getString("contrasena");
			if (a.equals(passw)) {
				System.out.println(SentSQL);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			ventanas.VentanaRegistro.BDLogger.log(Level.SEVERE, "Error logIn\n" + SentSQL, e);
			e.printStackTrace();
			return false;
		}

	}
	
	public static boolean existeUsuario(Statement st, String nombreUs) {
		String SentSQL = "select nombreUsuario from Usuario where nombreUsuario = " + "'" + nombreUs + "';";
		System.out.println(SentSQL);

		try {
			ResultSet rs = st.executeQuery(SentSQL);

			rs.next();

			String b = rs.getString("nombreUsuario");
			System.out.println(b);
			if (b.equals(nombreUs)) {
				System.out.println("Usuario existente");
				return false;
			} else {
				System.out.println("Usuario no existente");
				return true;
			}

		} catch (SQLException e) {
			System.out.println("catch de -> BdMyRestaurants.existeUsuario, por lo tanto, el usuario no existe");
			return true;
		}
	}
	public static void nuevoUsuario(Statement st,int id_us, String nombreUs, String cor, String contr, int tel,
			 String direc, TipoUsuario tipo) {
		String SentSQL = "insert into Usuario(id_usuario, correo, nombreUsuario, contrasenya, telefono, tipo) values('" + id_us
				+ "','" + nombreUs +"," + cor + "'," + tel + "'," + direc + "'," + tipo + "," + contr + ");";
		System.out.println(SentSQL);
		try {
			st.executeUpdate(SentSQL);
		} catch (SQLException e) {
			ventanas.VentanaRegistro.BDLogger.log(Level.SEVERE, "Error nuevoUsuario\n" + SentSQL, e);
			e.printStackTrace();
		}
	}
	public static void eliminarUsuario(Statement st, String nomb_usu) {
		String SentSQL = "delete from Usuario where nombre_usuario = '" + nomb_usu + "';";
		System.out.println(SentSQL);
		try {
			st.executeUpdate(SentSQL);
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Catch BdMyRestaurants.eliminarUsuario");
			ventanas.VentanaRegistro.BDLogger.log(Level.SEVERE, "Error eliminarUsuario\n" + SentSQL, e);
			e.printStackTrace();
		}
	}
	public static void cambiarContrasenya(Statement st, String passw, String nomb_usu) {
		String SentSQL = "UPDATE usuario SET contrasenya = '" + passw + "' WHERE nombre_usuario = '" + nomb_usu + "';";
		System.out.println(SentSQL);
		try {
			st.executeUpdate(SentSQL);
		} catch (SQLException e) {
			ventanas.VentanaRegistro.BDLogger.log(Level.SEVERE, "Error cambiarContrase�a\n" + SentSQL, e);
			e.printStackTrace();
		}
	}
	
}


*/

