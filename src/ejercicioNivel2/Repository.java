package ejercicioNivel2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.mysql.cj.protocol.Resultset;

public class Repository {

	static Scanner sc = new Scanner(System.in);
	static Connection con = null;

	public static Connection nuevaConexion() {

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

		// Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		st.executeUpdate(tree);

	}

	public static void nuevoStockFlor(String name, int numero, String color, float precio) throws SQLException {

		String flower = "INSERT INTO stockflor (color,precio,cantidad)" + "VALUES (" + "'" + color + "'" + "," + precio
				+ "," + numero + ");";

		// Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		st.executeUpdate(flower);

	}

	public static void nuevoStockDecor(String name, int numero, String tipo, float precio) throws SQLException {

		String decor = "INSERT INTO stockdecor (tipo,precio,cantidad)" + "VALUES (" + "'" + tipo + "'" + "," + precio
				+ "," + numero + ");";

		// Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		st.executeUpdate(decor);

	}

	public static ResultSet bringStockArbol(String name) throws SQLException {

		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		ResultSet almacenArbol = st.executeQuery("SELECT * FROM stockarbol");
		return almacenArbol;

	}

	public static ResultSet bringStockFlor(String name) throws SQLException {
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

	public static void restarArbol(String name, int numero, float altura) throws SQLException {
		ResultSet sA = bringStockArbol(name);
		int qt = 0;
		while (sA.next() && qt == 0) {
			float alt = sA.getFloat("altura");
			if (alt == altura) {
				qt = sA.getInt("cantidad");
			}
		}
		int diferencia = qt - numero;
		if (diferencia < 0) {
			System.out.println("La cantidad elegida es superior al stock");
		} else {
			Statement st = con.createStatement();
			st.execute("USE " + name);
			st.executeUpdate("UPDATE stockarbol SET cantidad = " + diferencia + " WHERE (altura = " + altura + ");");
		}
	}

	public static void restarFlor(String name, int numero, String color) throws SQLException {
		ResultSet sF = bringStockFlor(name);
		int qt = 0;
		while (sF.next() && qt == 0) {
			String col = sF.getString("color");
			if (col.equalsIgnoreCase(color)) {
				qt = sF.getInt("cantidad");
			}
		}
		int diferencia = qt - numero;
		if (diferencia < 0) {
			System.out.println("La cantidad elegida es superior al stock");
		} else {
			Statement st = con.createStatement();
			st.execute("USE " + name);
			st.executeUpdate(
					"UPDATE stockflor SET cantidad = " + diferencia + " WHERE (color = " + "'" + color + "'" + ");");
		}
<<<<<<< HEAD
	}

	public static void restarDecoracion(String name, int numero, String tipo) throws SQLException {
		ResultSet sD = bringStockDecor(name);
		int qt = 0;
		while (sD.next() && qt == 0) {
			String tip = sD.getString("tipo");
			if (tip.equalsIgnoreCase(tipo)) {
				qt = sD.getInt("cantidad");
			}
		}
		int diferencia = qt - numero;
		if (diferencia < 0) {
			System.out.println("La cantidad elegida es superior al stock");
		} else {
			Statement st = con.createStatement();
			st.execute("USE " + name);
			st.executeUpdate(
					"UPDATE stockdecor SET cantidad = " + diferencia + " WHERE (tipo = " + "'" + tipo + "'" + ");");
		}
	}

	public static ResultSet mostrarCantidades(String name) throws SQLException {
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		ResultSet totales = st
				.executeQuery("SELECT stockarbol.cantidad, stockarbol.altura, stockflor.color, stockflor.cantidad, ,"
						+ "stockdecor.tipo, stockdecor.cantidad FROM stockarbol, stockflor, stockdecor");
		return totales;

	}
=======
	}

	public static void restarDecoracion(String name, int numero, String tipo) throws SQLException {
		ResultSet sD = bringStockDecor(name);
		int qt = 0;
		while (sD.next() && qt == 0) {
			String tip = sD.getString("tipo");
			if (tip.equalsIgnoreCase(tipo)) {
				qt = sD.getInt("cantidad");
			}
		}
		int diferencia = qt - numero;
		if (diferencia < 0) {
			System.out.println("La cantidad elegida es superior al stock");
		} else {
			Statement st = con.createStatement();
			st.execute("USE " + name);
			st.executeUpdate(
					"UPDATE stockdecor SET cantidad = " + diferencia + " WHERE (tipo = " + "'" + tipo + "'" + ");");
		}
	}

	public static ResultSet mostrarCantidadArbol(String name) throws SQLException {
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		ResultSet totales = st
				.executeQuery("SELECT stockarbol.cantidad, stockarbol.altura, stockarbol.precio" + " FROM stockarbol;");
		return totales;
	}

	public static ResultSet mostrarCantidadFlor(String name) throws SQLException {
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		ResultSet totales = st
				.executeQuery("SELECT stockflor.cantidad, stockflor.color, stockflor.precio FROM stockflor;");
		return totales;
	}

	public static ResultSet mostrarCantidadDecor(String name) throws SQLException {
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		ResultSet totales = st
				.executeQuery("SELECT stockdecor.cantidad, stockdecor.tipo, stockdecor.precio FROM stockdecor;");
		return totales;
	}

	public static void crearTicketCompra(String name, int arbol, int arboles, String color, int flores, String tipo,
			int decoraciones) throws SQLException {
		String fecha = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		st.execute("CREATE TABLE IF NOT EXISTS ticket (\r\n"
				+ "  `ticket_id` INT NOT NULL AUTO_INCREMENT ,"
				+ "  `fecha` DATETIME NOT NULL ,"
				+ "  `tipo_arbol` INT NULL,"
				+ "  `cantidad_arbol` INT NULL,"
				+ "  `tipo_flor` INT NULL,"
				+ "  `cantidad_flor` INT NULL,"
				+ "  `tipo_decor` INT NULL,"
				+ "  `cantidad_decor` INT NULL,"
				+ "  PRIMARY KEY (`ticket_id`),"
				+ "  UNIQUE INDEX `ticket_id_UNIQUE` (`ticket_id` ASC) VISIBLE,"
				+ "  INDEX `tipo_arbol_idx` (`tipo_arbol` ASC) VISIBLE,"
				+ "  INDEX `tipo_flor_idx` (`tipo_flor` ASC) VISIBLE,"
				+ "  INDEX `tipo_decor_idx` (`tipo_decor` ASC) VISIBLE,"
				+ "  CONSTRAINT `tipo_arbol`"
				+ "    FOREIGN KEY (`tipo_arbol`)"
				+ "    REFERENCES `juliancito`.`stockarbol` (`idstockarbol`)"
				+ "    ON DELETE NO ACTION"
				+ "    ON UPDATE NO ACTION,"
				+ "  CONSTRAINT `tipo_flor`"
				+ "    FOREIGN KEY (`tipo_flor`)"
				+ "    REFERENCES `juliancito`.`stockflor` (`flor_id`)"
				+ "    ON DELETE NO ACTION"
				+ "    ON UPDATE NO ACTION,"
				+ "  CONSTRAINT `tipo_decor`"
				+ "    FOREIGN KEY (`tipo_decor`)"
				+ "    REFERENCES `juliancito`.`stockdecor` (`decor_id`)"
				+ "	ON DELETE NO ACTION"
				+ "    ON UPDATE NO ACTION);");
		st.executeUpdate("INSERT INTO ticket (fecha, tipo_arbol, cantidad_arbol, tipo_flor, cantidad_flor, tipo_decor, cantidad_decor) VALUES ('"+fecha+"' ,"+arbol+", "+arboles+","+color+","+flores+","+tipo+","+decoraciones+");");

		restarArbol(name, arbol, arboles);
		restarFlor(name, flores, color);
		restarDecoracion(name, decoraciones, tipo);
		vista.imprimirTicketCompra(fecha, name);
		
	}
public ResultTest imprimirTicket(Date fecha, String name) {
	Connection con = nuevaConexion();
	Statement st = con.createStatement();
	st.execute("USE " + name);
	ResultSet ticket = st.executeQuery("SELECT * FROM ticket;");
	return ticket;
	
}