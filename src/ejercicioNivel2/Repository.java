package ejercicioNivel2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Repository {
	
	static Scanner sc = new Scanner(System.in);

	
	public static Connection nuevaConexion ( ) {
	
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

		String arbol = "CREATE TABLE stockarbol " +
                "(arbol_id INT NOT NULL AUTO_INCREMENT, " +
                " altura FLOAT, " + 
                " precio FLOAT, " + 
                " cantidad INT, " + 
                " PRIMARY KEY ( arbol_id ));"; 
		String flor = "CREATE TABLE stockflor " +
                "(flor_id INT NOT NULL AUTO_INCREMENT, " +
                " color VARCHAR(50), " + 
                " precio FLOAT, "+
                " cantidad INT, " + 
                " PRIMARY KEY ( flor_id ));";
		String decor = "CREATE TABLE stockdecor " +
                "(decor_id INT NOT NULL AUTO_INCREMENT, " +
                " tipo VARCHAR(50), " + 
                " precio FLOAT, " + 
                " cantidad INT, " + 
                " PRIMARY KEY ( decor_id ));";
        
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		 st.executeUpdate("CREATE DATABASE "+name);
		 st.execute("USE "+name);
		 st.executeUpdate(arbol);
		 st.executeUpdate(flor);
		 st.executeUpdate(decor);
	}
	
	public static void nuevoStockArbol(String name, int numero, float altura, float precio) throws SQLException {
		
	String tree = "INSERT INTO stockarbol (altura,precio,cantidad)"+ 
			"VALUES ("+altura+","+precio+","+numero+");";
        
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		 st.execute("USE "+name);
		 st.executeUpdate(tree);
		
	}
	public static void nuevoStockFlor(String name, int numero, String color, float precio) throws SQLException {
		
		String flower = "INSERT INTO stockflor (color,precio,cantidad)"+ 
				"VALUES ("+"'"+color+"'"+","+precio+","+numero+");";
	        
			Connection con = nuevaConexion();
			Statement st = con.createStatement();
			 st.execute("USE "+name);
			 st.executeUpdate(flower);
			
		}
public static void nuevoStockDecor(String name, int numero, String tipo, float precio) throws SQLException {
		
		String decor = "INSERT INTO stockdecor (tipo,precio,cantidad)"+ 
				"VALUES ("+"'"+tipo+"'"+","+precio+","+numero+");";
	        
			Connection con = nuevaConexion();
			Statement st = con.createStatement();
			 st.execute("USE "+name);
			 st.executeUpdate(decor);
			
		}
}
