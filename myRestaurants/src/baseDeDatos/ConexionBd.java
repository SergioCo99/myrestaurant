package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBd {
	
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bd_ejemplo";
	private static final String USUARIO = "root";
	private static final String CLAVE = "Portu129";
	
	static {
		try {
			Class.forName(CONTROLADOR);//com.mysql.jdbc.Driver <- este es el que pone en la web, pero eclipse me recomienda utilizar este.	
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR al cargar el controlador!");
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexion OK");
		}catch(SQLException e) {
			System.out.println("ERROR en la conexion!");
			e.printStackTrace();
		}
		return conexion;
	}
	
	
	public static void main(String[] args) {
		
	}
}