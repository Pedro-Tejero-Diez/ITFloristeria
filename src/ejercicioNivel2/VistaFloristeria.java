package ejercicioNivel2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VistaFloristeria {

	private Arbol arbol = new Arbol();
	private Flor flor = new Flor();
	private Decoracion decoracion = new Decoracion();

	public void mostrarFloristeria(Floristeria floristeria) {
		System.out.println("Floristeria: " + floristeria.getNombre());

	}

	public void mostrarStock(String name) throws SQLException {

		ResultSet almacenArbol = Repository.bringStockArbol(name);
		System.out.println("STOCK ARBOLES: ");
		while (almacenArbol.next()) {
			float alt = almacenArbol.getFloat("altura");
			float prc = almacenArbol.getFloat("precio");
			System.out.println("altura" + "             " + "precio");
			System.out.println(alt + "                 " + prc);
		}

		ResultSet aF = Repository.bringStockFlor(name);
		System.out.println("STOCK FLORES: ");
		while (aF.next()) {
			String color = aF.getString("color");
			float prc = aF.getFloat("precio");
			System.out.println("color" + "             " + "precio");
			System.out.println(color + "                 " + prc);
		}

		ResultSet almacenDecor = Repository.bringStockDecor(name);
		System.out.println("STOCK DECORACIONES: ");
		while (almacenDecor.next()) {
			String tipo = almacenDecor.getString("tipo");
			float prc = almacenDecor.getFloat("precio");
			System.out.println("tipo" + "             " + "precio");
			System.out.println(tipo + "                 " + prc);
		}
	}

	public void mostrarValorTotal(String name) throws SQLException {

		float total = 0;
		ResultSet rA = Repository.mostrarCantidadArbol(name);
		while (rA.next()) {
			float qtpr = rA.getInt(1) * rA.getFloat(3);

			total += qtpr;
		}
		ResultSet rF = Repository.mostrarCantidadFlor(name);
		while (rF.next()) {
			float qtpr = rF.getInt(1) * rF.getFloat(3);

			total += qtpr;
		}
		ResultSet rD = Repository.mostrarCantidadDecor(name);
		while (rD.next()) {
			float qtpr = rD.getInt(1) * rD.getFloat(3);

			total += qtpr;
		}
		System.out.println("El total del stock en euros es: " + total);
	}

	public void mostrarCantidadesStock(String name) throws SQLException {
		ResultSet rA = Repository.mostrarCantidadArbol(name);
		int qt = 0;
		while (rA.next()) {
			float alt = rA.getFloat(2);
			qt = rA.getInt(1);
			System.out.println("Altura árbol: " + alt + "        Cantidad: " + qt);
		}
		ResultSet rF = Repository.mostrarCantidadFlor(name);
		while (rF.next()) {
			String color = rF.getString(2);
			qt = rF.getInt(1);
			System.out.println("Color flor: " + color + "        Cantidad: " + qt);
		}
		ResultSet rD = Repository.mostrarCantidadDecor(name);
		while (rD.next()) {
			String tipo = rD.getString(2);
			qt = rD.getInt(1);
			System.out.println("Tipo Decoración: " + tipo + "        Cantidad: " + qt);
		}
	}

	public void sumatorioVentas(String name, double total) {
		double ventaAnterior = 0.0;
		try (FileReader fr = new FileReader("C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\"
				+ "lib\\src\\main\\java\\Floristeria " + name + "\\tickets\\sumatorioVentas.txt");
				BufferedReader br = new BufferedReader(fr)) {

			ventaAnterior = Double.parseDouble(br.readLine());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		total = total + ventaAnterior;
		String sumatorio = String.valueOf(total);

		try (FileWriter fw = new FileWriter("C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\"
				+ "lib\\src\\main\\java\\Floristeria " + name + "\\tickets\\sumatorioVentas.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {

			out.write(sumatorio);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void listadoComprasAnteriores(String name) throws SQLException {

		ResultSet rV = Repository.listadoCompras(name);
		System.out.println("LISTADO COMPRAS REALIZADAS");
		while (rV.next()) {
			System.out.println("fecha ticket: " + rV.getString("fecha"));
			System.out.println("tipo Abol: " + rV.getInt("tipo_arbol") + " Cantidad: " + rV.getInt("cantidad_arbol")
					+ "  Precio: " + rV.getFloat("precio_arbol") + "   TOTAL: "
					+ rV.getInt("cantidad_arbol") * rV.getFloat("precio_arbol"));
			System.out.println("tipo Flor: " + rV.getInt("tipo_flor") + " Cantidad: " + rV.getInt("cantidad_flor")
					+ "  Precio: " + rV.getFloat("precio_flor") + "   TOTAL: "
					+ rV.getInt("cantidad_flor") * rV.getFloat("precio_flor"));
			System.out.println("tipo Decoración: " + rV.getInt("tipo_decor") + " Cantidad: "
					+ rV.getInt("cantidad_decor") + "  Precio: " + rV.getFloat("precio_decor") + "   TOTAL: "
					+ rV.getInt("cantidad_decor") * rV.getFloat("precio_decor"));
			System.out.println("---------------------------------------------------------");
		}
	}

	public void vistaGananciasTotales(String name) throws SQLException {
		ResultSet rV = Repository.listadoCompras(name);
		float totales=0.0f;
		System.out.println("GANANCIAS OBTENIDAS");
		while (rV.next()) {
			float totalarbol = rV.getInt("cantidad_arbol") * rV.getFloat("precio_arbol");
			float totalflor = rV.getInt("cantidad_flor") * rV.getFloat("precio_flor");
			float totaldecor = rV.getInt("cantidad_decor") * rV.getFloat("precio_decor");
			totales += (totalarbol + totalflor + totaldecor);
			System.out.println("fecha ticket: " + rV.getString("fecha"));
			System.out.println("TOTAL ARBOLES: " + totalarbol);
			System.out.println("TOTAL FLORES: " + totalflor);
			System.out.println("TOTAL DECOR: " + totaldecor);
			System.out.println("TOTAL TICKET: " + (totalarbol + totalflor + totaldecor));
			System.out.println("---------------------------------------------------------");
		}
		System.out.println("TOTAL GANANCIAS OBTENIDAS: "+totales);
	}

}
