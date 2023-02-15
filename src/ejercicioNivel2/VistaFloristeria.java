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


	public void mostrarCantidadesStock(String a, String b, String c) throws FileNotFoundException, IOException {
		System.out.println("Numero Arboles = " + a.length());
		System.out.println("Numero Flores = " + b.length());
		System.out.println("Numero Decoraciones = " + c.length());

	}

	public void mostrarValorTotal(String a, String b, String c) throws FileNotFoundException, IOException {
		double valorArboles = (double) a.length() * arbol.getPrecio();
		double valorFlores = (double) b.length() * flor.getPrecio();
		double valorDecoracion = (double) c.length() * arbol.getPrecio();

		System.out.println("Valor Arboles = " + valorArboles);
		System.out.println("Valor Flores = " + valorFlores);
		System.out.println("Valor Decoraciones = " + valorDecoracion);
		System.out.println("Valor Total Floristeria: " + (valorArboles + valorFlores + valorDecoracion));
	}

	public void mostrarCantidadesStock(String name) throws FileNotFoundException, IOException {
		String arboles, flores, decoraciones;
		try (FileReader fr = new FileReader(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\arbol.txt");
				BufferedReader br = new BufferedReader(fr)) {

			while ((arboles = br.readLine()) != null)
				System.out.println("Número árboles: " + arboles.length());
		} catch (IOException e) {

		}
		try (FileReader fr = new FileReader(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\flor.txt");
				BufferedReader br = new BufferedReader(fr)) {

			while ((flores = br.readLine()) != null)
				System.out.println("Número flores: " + flores.length());
		} catch (IOException e) {

		}
		try (FileReader fr = new FileReader(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\decoracion.txt");
				BufferedReader br = new BufferedReader(fr)) {

			while ((decoraciones = br.readLine()) != null)
				System.out.println("Numero Decoraciones: " + decoraciones.length());
		} catch (IOException e) {

		}
	}

	public void imprimirTicketCompra(String name, int arboles, int flores, int decoraciones) {
		double totalArboles = (double) arboles * arbol.getPrecio();
		double totalFlores = (double) flores * flor.getPrecio();
		double totalDecoraciones = (double) decoraciones * decoracion.getPrecio();
		double totalTicket = totalArboles + totalFlores + totalDecoraciones;
		sumatorioVentas(name, totalTicket);
		String fecha = new SimpleDateFormat("yyyy-MM-dd__HH-mm").format(new Date());
		try (FileWriter fw = new FileWriter(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\tickets\\ticket " + fecha + ".txt");
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println("FLORISTERIA:   " + name + "\n");
			out.println("Fecha y hora de la compra:   " + fecha + "\n");
			out.println("Arboles comprados: " + arboles + "         Precio: " + totalArboles + "\n");
			out.println("Flores compradas: " + flores + "           Precio: " + totalFlores + "\n");
			out.println("Decoraciones compradas: " + decoraciones + "     Precio: " + totalDecoraciones);
		} catch (IOException e) {
			System.out.println(e.getMessage());
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

	public void listadoCompras(String name) {
		File directorio = new File(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\tickets");
		File[] tickets = directorio.listFiles();
		System.out.println("Listado Compras anteriores:\n");
		for (int i = 0; i < tickets.length; i++) {
			File archivo = tickets[i];
			System.out.println(archivo.getName());
		}
	}

	public void gananciasTotales(String name) {
		String linea;
		try (FileReader fr = new FileReader("C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\"
				+ "lib\\src\\main\\java\\Floristeria " + name + "\\tickets\\sumatorioVentas.txt");
				BufferedReader br = new BufferedReader(fr)) {

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
