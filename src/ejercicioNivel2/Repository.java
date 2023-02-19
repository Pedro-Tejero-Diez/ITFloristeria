package ejercicioNivel2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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

	public static void nuevaFloristeria(String name) throws SQLException {

		String arbol = "CREATE TABLE stockarbol " + "(arbol_id INT NOT NULL AUTO_INCREMENT, " + " altura DECIMAL, "
				+ " precio_arbol DECIMAL, " + " cantidad INT, " + " PRIMARY KEY ( arbol_id ), UNIQUE INDEX arbol_id_UNIQUE (arbol_id ASC, altura ASC, precio_arbol ASC, cantidad ASC) VISIBLE, INDEX `precio_arbol` (`precio_arbol` ASC) VISIBLE);";
		String flor = "CREATE TABLE stockflor " + "(flor_id INT NOT NULL AUTO_INCREMENT, " + " color VARCHAR(50), "
				+ " precio_flor DECIMAL, " + " cantidad INT, " + " PRIMARY KEY ( flor_id ), UNIQUE INDEX `flor_id_UNIQUE` (`flor_id` ASC, `color` ASC, `precio_flor` ASC, `cantidad` ASC) VISIBLE, INDEX `precio_flor` (`precio_flor` ASC) VISIBLE);";
		String decor = "CREATE TABLE stockdecor " + "(decor_id INT NOT NULL AUTO_INCREMENT, " + " tipo VARCHAR(50), "
				+ " precio_decor DECIMAL, " + " cantidad INT, " + " PRIMARY KEY ( decor_id ), UNIQUE INDEX `decor_id_UNIQUE` (`decor_id` ASC, `tipo` ASC, `precio_decor` ASC, `cantidad` ASC) VISIBLE, INDEX `precio_decor` (`precio_decor` ASC) VISIBLE);";

		nuevaConexion();
		Statement st = con.createStatement();
		st.executeUpdate("CREATE DATABASE " + name);
		st.execute("USE " + name);
		st.executeUpdate(arbol);
		st.executeUpdate(flor);
		st.executeUpdate(decor);
	}

	public static void nuevoStockArbol(String name, int numero, float altura, float precio) throws SQLException {

		String tree = "INSERT INTO stockarbol (altura,precio_arbol,cantidad)" + "VALUES (" + altura + "," + precio + ","
				+ numero + ");";

		nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		st.executeUpdate(tree);

	}

	public static void nuevoStockFlor(String name, int numero, String color, float precio) throws SQLException {

		String flower = "INSERT INTO stockflor (color,precio_flor,cantidad)" + "VALUES (" + "'" + color + "'" + "," + precio
				+ "," + numero + ");";

		// Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		st.executeUpdate(flower);

	}

	public static void nuevoStockDecor(String name, int numero, String tipo, float precio) throws SQLException {

		String decor = "INSERT INTO stockdecor (tipo,precio_decor,cantidad)" + "VALUES (" + "'" + tipo + "'" + "," + precio
				+ "," + numero + ");";

		nuevaConexion();
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
		nuevaConexion();
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

	public static void restarFlor(String name, int numero, int tipoflor) throws SQLException {
		ResultSet sF = bringStockFlor(name);
		int qt = 0;
		while (sF.next() && qt == 0) {
			int col = sF.getInt("flor_id");
			if (col==tipoflor) {
				qt = sF.getInt("cantidad");
			}
		}
		int diferencia =  qt - numero;
		if (diferencia < 0) {
			System.out.println("La cantidad elegida es superior al stock");
		} else {
			Statement st = con.createStatement();
			st.execute("USE " + name);
			st.executeUpdate(
					"UPDATE stockflor SET cantidad = " + diferencia + " WHERE (flor_id = " + "'" + tipoflor + "'" + ");");
		}

	}

	public static void restarDecoracion(String name, int numero, int tipodecor) throws SQLException {
		ResultSet sD = bringStockDecor(name);
		int qt = 0;
		while (sD.next() && qt == 0) {
			int tip = sD.getInt("decor_id");
			if (tip==tipodecor) {
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
					"UPDATE stockdecor SET cantidad = " + diferencia + " WHERE (decor_id = " + "'" + tipodecor + "'" + ");");
		}
	}

	public static ResultSet mostrarCantidades(String name) throws SQLException {
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		ResultSet totales = st
				.executeQuery("SELECT * FROM stockarbol, stockflor, stockdecor;");
		return totales;

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

	public static void crearTicketCompra(String name, int arbol, int arboles, int tipoflor, int flores, int tipodecor,
		int decoraciones) throws SQLException {
		String fecha = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		st.execute("CREATE TABLE IF NOT EXISTS ticket ( "
				+ "  `ticket_id` INT NOT NULL AUTO_INCREMENT ,"
				+ "  `fecha` DATETIME NOT NULL ,"
				+ "  `tipo_arbol` INT NULL,"
				+ "  `cantidad_arbol` INT NULL,"
				+ "  `precio_arbol` DECIMAL(10,0) NULL,"
				+ "  `tipo_flor` INT NULL,"
				+ "  `cantidad_flor` INT NULL,"
				+ "  `precio_flor` DECIMAL(10,0) NULL,"
				+ "  `tipo_decor` INT NULL,"
				+ "  `cantidad_decor` INT NULL,"
				+ "  `precio_decor` DECIMAL(10,0) NULL,"
				+ "  PRIMARY KEY (`ticket_id`),"
				/*+ "  UNIQUE INDEX `ticket_id_UNIQUE` (`ticket_id` ASC, `tipo_arbol` ASC, `cantidad_arbol` ASC, `precio_arbol` ASC,  `tipo_flor` ASC, `cantidad_flor` ASC, `precio_flor` ASC,  `tipo_decor` ASC, `cantidad_decor` ASC, `precio_decor` ASC) INVISIBLE,"
				+ "  INDEX `tipo_arbol_idx` (`tipo_arbol` ASC) VISIBLE,"
				+ "  INDEX `tipo_flor_idx` (`tipo_flor` ASC) VISIBLE,"
				+ "  INDEX `tipo_decor_idx` (`tipo_decor` ASC) VISIBLE,"*/
				+ "  INDEX `precio_arbol_idx` (`precio_arbol` ASC) VISIBLE,"
				+ "  INDEX `precio_flor_idx` (`precio_flor` ASC) VISIBLE,"
				+ "  INDEX `precio_decor_idx` (`precio_decor` ASC) VISIBLE,"
				+ "  CONSTRAINT `tipo_arbol`"
				+ "    FOREIGN KEY (`tipo_arbol`)"
				+ "    REFERENCES `"+name+"`.`stockarbol` (`arbol_id`)"
				+ "    ON DELETE NO ACTION"
				+ "    ON UPDATE NO ACTION,"
				+"CONSTRAINT `precio_arbol`"
				+ "    FOREIGN KEY (`precio_arbol`)"
				+ "    REFERENCES `"+name+"`.`stockarbol` (`precio_arbol`)"
				+ "    ON DELETE NO ACTION"
				+ "    ON UPDATE NO ACTION,"
				+ "  CONSTRAINT `tipo_flor`"
				+ "    FOREIGN KEY (`tipo_flor`)"
				+ "    REFERENCES `"+name+"`.`stockflor`(`flor_id`)"
				+ "    ON DELETE NO ACTION"
				+ "    ON UPDATE NO ACTION,"
				+"CONSTRAINT `precio_flor`"
				+ "    FOREIGN KEY (`precio_flor`)"
				+ "    REFERENCES `"+name+"`.`stockflor` (`precio_flor`)"
				+ "    ON DELETE NO ACTION"
				+ "    ON UPDATE NO ACTION,"
				+ "  CONSTRAINT `tipo_decor`"
				+ "    FOREIGN KEY (`tipo_decor`)"
				+ "    REFERENCES `"+name+"`.`stockdecor`(`decor_id`)"
				+ "	ON DELETE NO ACTION"
				+ "    ON UPDATE NO ACTION,"
				+ "CONSTRAINT `precio_decor`"
				+ "FOREIGN KEY (`precio_decor`)"
				+ "	 REFERENCES `"+name+"`.`stockdecor` (`precio_decor`)"
				+ "	ON DELETE NO ACTION"
				+ "	ON UPDATE NO ACTION);");
		st.executeUpdate("INSERT INTO ticket (fecha, tipo_arbol, cantidad_arbol, tipo_flor, cantidad_flor, tipo_decor, cantidad_decor) VALUES ('"+fecha+"' ,"+arbol+", "+arboles+","+tipoflor+","+flores+","+tipodecor+","+decoraciones+");");
		st.executeUpdate("UPDATE "+name+".ticket SET precio_arbol = (SELECT precio_arbol FROM stockarbol WHERE arbol_id = "+arbol+");");
		st.executeUpdate("UPDATE "+name+".ticket SET precio_flor = (SELECT precio_flor FROM stockflor WHERE flor_id = "+tipoflor+");");
		st.executeUpdate("UPDATE "+name+".ticket SET precio_decor = (SELECT precio_decor FROM stockdecor WHERE decor_id = "+tipodecor+");");
		
		//eliminamos del stock lo comprado: arboles
		ResultSet rA = st.executeQuery("SELECT cantidad FROM stockarbol WHERE arbol_id ="+arbol+";");
		rA.next();
		int rest = rA.getInt("cantidad")-arboles;
		st.executeUpdate("UPDATE stockarbol SET cantidad = " + rest + " WHERE (arbol_id = " + "'" + arbol + "'" + ");");
		//eliminamos del stock lo comprado: flores
		ResultSet rF = st.executeQuery("SELECT cantidad FROM stockflor WHERE flor_id ="+tipoflor+";");
		rF.next();
		int resta = rF.getInt("cantidad")-flores;
		st.executeUpdate("UPDATE stockflor SET cantidad = " + resta + " WHERE (flor_id = " + "'" + tipoflor + "'" + ");");
		//eliminamos del stock lo comprado: decoraciones
		ResultSet rS = st.executeQuery("SELECT cantidad FROM stockdecor WHERE decor_id ="+tipodecor+";");
		rS.next();
		int diferencia = rS.getInt("cantidad")-decoraciones;
		st.executeUpdate("UPDATE stockdecor SET cantidad = " + diferencia + " WHERE (decor_id = " + "'" + tipodecor + "'" + ");");
		
		//ahora imprimimos ticket
	st.execute("USE " + name);
	ResultSet rT = st.executeQuery("SELECT * FROM ticket WHERE fecha = '"+fecha+"';");
		
		System.out.println("Ticket fecha: "+fecha);
		rT.next();
			int tip = rT.getInt("tipo_arbol");
			int cant = rT.getInt("cantidad_arbol");
			int prc = rT.getInt("precio_arbol");
			System.out.println("Tipo Arbol:  "+tip);
			System.out.println("Cantidad Arbol:  "+cant);
			System.out.println("precio Arbol:  "+prc);
			System.out.println("Total Arbol:  "+prc*cant+" euros");
			System.out.println("---------------------------------");
			int fl = rT.getInt("tipo_flor");
			int cantfl = rT.getInt("cantidad_flor");
			int prcfl = rT.getInt("precio_flor");
			System.out.println("Tipo Flor:  "+fl);
			System.out.println("Cantidad Flor:  "+cantfl);
			System.out.println("precio Flor:  "+prcfl);
			System.out.println("Total Flores:  "+prcfl*cantfl+" euros");
			System.out.println("---------------------------------");
			int tipdc = rT.getInt("tipo_decor");
			int cantdc = rT.getInt("cantidad_decor");
			int prcdc = rT.getInt("precio_decor");
			System.out.println("Tipo Decoracion:  "+tipdc);
			System.out.println("Cantidad Decoracion:  "+cantdc);
			System.out.println("precio Decoracion:  "+prcdc);
			System.out.println("Total Decoracion:  "+prcdc*cantdc+" euros");
			System.out.println("---------------------------------");
			}
	
	public static ResultSet listadoCompras (String name) throws SQLException {
		Connection con = nuevaConexion();
		Statement st = con.createStatement();
		st.execute("USE " + name);
		ResultSet compras = st.executeQuery("SELECT * FROM ticket;");
		return compras;
		
		
	}
		}
		
	

