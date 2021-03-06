package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.*;


import javax.swing.JOptionPane;
import restaurante.Restaurante;
import restaurante.TipoComida;
import usuario.TipoUsuario;
import usuario.Usuario;

public class BdMyRestaurants {
	
	private static boolean LOGGING = true;
	private static Exception lastError = null;

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL =  "jdbc:mysql://localhost:3306/myrestaurants?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USUARIO = "root";
	private static final String CLAVE = "1234Clave";
	private static Thread hilo = null;
	private static Vector<Runnable> tareasPendientes;  // Vector es synchronized con lo que se puede a la vez manejar desde varios hilos
	static {
		tareasPendientes = new Vector<>();
	}
	private static void initHilo() {
		hilo = new Thread() {
			@Override
			public void run() {
				while (!interrupted()) {
					while (!tareasPendientes.isEmpty()) {
						Runnable r = tareasPendientes.remove(0);
						r.run();
					}
					try { Thread.sleep( 10 ); } catch (InterruptedException e) { break; }
				}
				hilo = null;
				System.out.println( "Cierre de hilo." );
			}
		};
		hilo.start();
	}

	private static Exception error = null;
	
	public static Connection initBD() {
		if (hilo == null) initHilo();
		try {
			Class.forName(CONTROLADOR);
			Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE);
			log( Level.INFO, "Conectada base de datos " + "myrestaurants.sql", null );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en conexi�n de base de datos " + "myrestaurants.sql", e );
			e.printStackTrace();
			return null;
		}
	

}
	
	
	/** Devuelve statement para usar la base de datos
	 * @param con	Conexi�n ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */

	public static Statement usarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en uso de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual
	 * @param con	Conexi�n ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */

	public static void cerrarBD(final Connection con, final Statement st) {
		tareasPendientes.add( new Runnable() { @Override public void run() {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			ventanas.VentanaRegistro.BDLogger.log(Level.SEVERE, "Error al cerrar la base de datos.", e);
			e.printStackTrace();
		}
		if (hilo!=null) hilo.interrupt();
		}
		});
	}
	public static void crearUsuario(int id_usuario, String nombreUsuario, String correo, String contrasenya, int telefono,
			 TipoUsuario tipo){
		tareasPendientes.add( new Runnable() { @Override public void run() {
		BdMyRestaurants conexion = new BdMyRestaurants();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		PreparedStatement ps;

		try {
			cn = conexion.initBD();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuario");
			ps = cn.prepareStatement(
					"INSERT INTO usuario(id_usuario, nombreUsuario, correo, contrasenya, telefono, tipo) VALUES(?,?,?,?,?,?)");

			ps.setInt(1, id_usuario);
			ps.setString(1, nombreUsuario);
			ps.setString(3, correo);
			ps.setString(4, contrasenya);
			ps.setInt(5, telefono);
			ps.setString(5, tipo.name());

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
				}if (stm != null) {
					stm.close();
				}if (cn != null) {
					cn.close();
				}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		}});
	}
	
	public static boolean logIn(Statement st, String user, String passw) {
		String SentSQL = "select * from Usuario where nombreUsuario = '" + user + "' and contrasenya = '" + passw + "'";
		try {
			ResultSet rs = st.executeQuery(SentSQL);
			rs.next();

			String a = rs.getString("contrasenya");
			if (a.equals(passw)) {
				System.out.println(SentSQL);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			//ventanas.VentanaRegistro.BDLogger.log(Level.SEVERE, "Error logIn\n" + SentSQL, e);
			e.printStackTrace();
			return false;
		}

	}
	
	public static boolean existeUsuario(Statement st, String correo) {
		String SentSQL = "select nombreUsuario from usuario where correo = " + "'" + correo + "';";
		System.out.println(SentSQL);

		try {
			ResultSet rs = st.executeQuery(SentSQL);

			rs.next();

			String b = rs.getString("nombreUsuario");
			System.out.println(b);
			if (b.equals(correo)) {
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
	public static void crearRestaurante(int id_restaurante, String nombre, double horarioApertura, double horarioCierre, String direccion, int telefono,
			TipoComida tipocomida){
		tareasPendientes.add( new Runnable() { @Override public void run() {
		BdMyRestaurants conexion = new BdMyRestaurants();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		PreparedStatement ps;

		try {
			cn = conexion.initBD();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM restaurante");
			ps = cn.prepareStatement(
					"INSERT INTO restaurante(id_restaurante, nombre, horarioApertura, horarioCierre, direccion, telefono, tipoComida) VALUES(?,?,?,?,?,?)");

			ps.setInt(1, id_restaurante);
			ps.setString(2, nombre);
			ps.setDouble(3, horarioApertura);
			ps.setDouble(4, horarioCierre);
			ps.setString(5, direccion);
			ps.setInt(6, telefono);
			ps.setString(7, tipocomida.name());

			int res = ps.executeUpdate();
			
			if (res > 0) {
				JOptionPane.showMessageDialog(null, "El restaurante ha sido creado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "ERROR al crear el restaurante!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}if (stm != null) {
					stm.close();
				}if (cn != null) {
					cn.close();
				}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		}});
	}	
	public static List<Restaurante> loadRestaurantes(Statement st){
		List<Restaurante> restaurantes = new ArrayList<>();
		String sentSQL = "select * from restaurante";
		try {
			ResultSet rs = st.executeQuery(sentSQL);
			while(rs.next()) {
				int id_restaurante = rs.getInt("id_restaurante");
				String nombreRestaurante = rs.getString("nombre");
				double horaAp = rs.getDouble("horaAp");
				double horaCer = rs.getDouble("horaCer");
				String direccion = rs.getString("direccion");
				int telefono = rs.getInt("telefono");
				TipoComida tipo = TipoComida.valueOf(rs.getString("tipo"));
				Restaurante restaurante = new Restaurante(nombreRestaurante, horaAp, horaCer, direccion, telefono, tipo);
				restaurantes.add(restaurante);
				log(Level.INFO, "fila leida:" + restaurante, null);
			}
			log(Level.INFO, "Bd consultada" + sentSQL, null);
		}catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			
		}
		
		
		return restaurantes;
	}
	
	public static boolean existeRestaurante(Statement st, String nombre) {
		String SentSQL = "select nombre from restaurante where nombre = " + "'" + nombre + "';";
		System.out.println(SentSQL);

		try {
			ResultSet rs = st.executeQuery(SentSQL);

			rs.next();

			String b = rs.getString("nombre");
			System.out.println(b);
			if (b.equals(nombre)) {
				System.out.println("Restaurante existente");
				return false;
			} else {
				System.out.println("Restaurante no existente");
				return true;
			}

		} catch (SQLException e) {
			System.out.println("catch de -> BdMyRestaurants.existeRestaurante, por lo tanto, el restaurante no existe");
			return true;
		}
	}
	private static Logger logger = null;
	public static void setLogger( Logger logger ) {
		BdMyRestaurants.logger = logger;
	}

	private static void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  
			logger = Logger.getLogger( BdMyRestaurants.class.getName() ); 
			logger.setLevel( Level.ALL );  
			try {
				
				logger.addHandler( new FileHandler( "BDLogger.xml", true ) ); 
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}
	
}
