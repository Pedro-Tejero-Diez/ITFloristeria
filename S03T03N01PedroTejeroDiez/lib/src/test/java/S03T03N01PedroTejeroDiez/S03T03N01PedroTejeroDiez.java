package S03T03N01PedroTejeroDiez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class S03T03N01PedroTejeroDiez {

	public static void main(String[] args) {

		Connection conn = null;
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost:3306/test?" +
		                                   "user=root&password=Pedret@2");

		 
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}


	}

}
