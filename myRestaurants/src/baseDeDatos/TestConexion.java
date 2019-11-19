package baseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;

public class TestConexion {
	public static void main(String[] args) {
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
				String usuario = rs.getString(2);
				String clave = rs.getString(3);
				
				System.out.println(idUsuario + " _ " + usuario + " _ " + clave);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}if(stm != null) {
					stm.close();
				}if(cn != null) {
					cn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
}
