package pruebinas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Driver;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		try {
			// The newInstance() call is a work around for some
			// broken Java implementations

			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			// handle the error
		}

		Connection con = null;
		System.out.println("introduce usuario base de datos: ");
		String username = sc.nextLine();
		System.out.println("introduce password base de datos: ");
		String password = sc.nextLine();

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/floristeria", username, password);

		System.out.println("Connected to database");

		java.sql.Statement st = con.createStatement();
		ResultSet mar = st.executeQuery("SELECT altura, precio FROM stockarbol");
		while (mar.next()) {
			float alt = mar.getFloat("altura");
			float prc = mar.getFloat("precio");
			System.out.println(alt + "                 " + prc);
		}
	}

}
