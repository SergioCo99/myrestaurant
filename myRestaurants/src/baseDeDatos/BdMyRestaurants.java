package baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import usuario.TipoUsuario;

public class BdMyRestaurants {

	public static void CrearUsuario(int id_usuario, String nombre, String apellidos, String nombre_usuario, String contrasenya, 
			int telefono, TipoUsuario tipo) {

		ConexionBd conexion = new ConexionBd();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		PreparedStatement ps;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuario");
			ps = cn.prepareStatement(
					"INSERT INTO usuario(id_usuario, nombre, apellidos, nombre_usuario, contrasenya, telefono, tipo) VALUES(?,?,?,?,?,?)");

			ps.setString(1, nombre_usuario);
			// ps.setString(2, txtCrearCorreo.getText());

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
}
