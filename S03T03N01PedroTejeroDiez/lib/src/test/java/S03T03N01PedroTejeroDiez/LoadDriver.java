package S03T03N01PedroTejeroDiez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadDriver {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println(ex.getMessage()+" causa: ·"+ex.getCause());
        }
    }
}