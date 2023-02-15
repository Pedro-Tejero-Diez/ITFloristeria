package ejercicioNivel2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Repository {

	static Scanner sc = new Scanner(System.in);

	public static Connection nuevaConexion() {

		Connection con = null;
		System.out.println("introduce usuario base de datos: ");
		String username = sc.nextLine();
		System.out.println("introduce password base de datos: ");
		String password = sc.nextLine();

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", username, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return con;
	}

	public void nuevaFloristeria(String name) throws SQLException {

		String arbol = "CREATE TABLE stockarbol " + "(arbol_id INT NOT NULL AUTO_INCREMENT, " + " altura FLOAT, "
				+ " precio FLOAT, " + " cantidad INT, " + " PRIMARY KEY ( arbol_id ));";
		String flor = "CREATE TABLE stockflor " + "(flor_id INT NOT NULL AUTO_INCREMENT, " + " color VARCHAR(50), "
				+ " precio FLOAT, " + " cantidad INT, " + " PRIMARY KEY ( flor_id ));";
		String decor = "CREATE TABLE stockdecor " + "(decor_id INT NOT NULL AUTO_INCREMENT, " + " tipo VARCHAR(50), "
				+ " precio FLOAT, " + " cantidad INT, " + " PRIMARY KEY ( decor_id ));";

		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.executeUpdate("CREATE DATABASE " + name);
		st.execute("USE " + name);
		st.executeUpdate(arbol);
		st.executeUpdate(flor);
		st.executeUpdate(decor);
	}

	public static void nuevoStockArbol(String name, int numero, float altura, float precio) throws SQLException {

		String tree = "INSERT INTO stockarbol (altura,precio,cantidad)" + "VALUES (" + altura + "," + precio + ","
				+ numero + ");";

		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		st.executeUpdate(tree);

	}

	public static void nuevoStockFlor(String name, int numero, String color, float precio) throws SQLException {

		String flower = "INSERT INTO stockflor (color,precio,cantidad)" + "VALUES (" + "'" + color + "'" + "," + precio
				+ "," + numero + ");";

		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		st.executeUpdate(flower);

	}

	public static void nuevoStockDecor(String name, int numero, String tipo, float precio) throws SQLException {

		String decor = "INSERT INTO stockdecor (tipo,precio,cantidad)" + "VALUES (" + "'" + tipo + "'" + "," + precio
				+ "," + numero + ");";

		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		st.executeUpdate(decor);

	}

	public static ResultSet bringStockArbol(String name) throws SQLException {

		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		ResultSet almacenArbol = st.executeQuery("SELECT * FROM stockarbol");
		return  almacenArbol;
	
	}

public static ResultSet bringStockFlor (String name) throws SQLException {
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		ResultSet almacenFlor = st.executeQuery("SELECT * FROM stockflor");
		return almacenFlor; 
}
			
	public static ResultSet bringStockDecor(String name) throws SQLException {
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		ResultSet almacenDecor = st.executeQuery("SELECT * FROM stockdecor");
		return almacenDecor;
	
	}
	public void restarArbol(String name, int numero, float altura) {
		ResultSet sA = bringStockArbol(name);
		int qt =0;
		 while (qt==0) { 
			  float alt = sA.getFloat("altura"); 
			 if (alt==altura) {
				  qt = sA.getInt("cantidad");
			 }
		 }  
			if (buffer.length() < numero)
				System.out.println("numero mayor que stock");
			String result = buffer.substring(0, (buffer.length() - numero));
			try (FileWriter fw = new FileWriter(
					"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
							+ name + "\\arbol.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw)) {
				out.println(result);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
