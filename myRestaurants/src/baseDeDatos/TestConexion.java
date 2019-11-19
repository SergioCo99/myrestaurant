package baseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import java.sql.ResultSet;

public class TestConexion {

	static Logger BDLogger;

	public static void main(String[] args) {

		
		try {
			BDLogger = Logger.getLogger("BDLogger");
			BDLogger.addHandler(new FileHandler("BDLogger.xml", true));
		} catch (Exception e) {
		}
		

		ConexionBd conexion = new ConexionBd();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuario");

			while (rs.next()) {
				int idUsuario = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				String usuario = rs.getString(4);
				int telefono = rs.getInt(5);
				String correo = rs.getString(6);
				boolean administrador = rs.getBoolean(7);

				System.out.println(
						idUsuario + " - " + nombre + " - " + apellidos + " _ " + usuario +
						" _ " + telefono + " _ " + correo + " - " + administrador);
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

}