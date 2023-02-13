package ejercicioNivel2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Repository {
	Scanner sc = new Scanner(System.in);
	
	public void nuevaFloristeria(String name) throws SQLException {
		
		Connection con = null;
		System.out.println("introduce usuario base de datos: ");
		String username = sc.nextLine();
		System.out.println("introduce password base de datos: ");
		String password = sc.nextLine();

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/floristeria", username, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		java.sql.Statement st = con.createStatement();
		ResultSet mar = st.executeQuery("CREATE DATABASE "+name);
		

}

}
