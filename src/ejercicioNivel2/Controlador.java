package ejercicioNivel2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Scanner;

public class Controlador {

	private static Scanner sc = new Scanner(System.in);
	private Floristeria floristeria;
	private VistaFloristeria vista;

	public Controlador(Floristeria floristeria, VistaFloristeria vista) {
		this.floristeria = floristeria;
		this.vista = vista;
	}

	public void setNombreFloristeria(String name) {
		floristeria.setNombre(name);

	}

	public String getNombre() {
		return floristeria.getNombre();
	}

	public VistaFloristeria getVista() {
		return vista;
	}

	public void setVista(VistaFloristeria vista) {
		this.vista = vista;
	}

	public String extraerFloristeria() {
		System.out.println("Introduzca nombre Floristeria: ");
		String name = sc.nextLine();
		return name;
	}

	public Floristeria crearFloristeria() throws SQLException {
		String name = extraerFloristeria();
		setNombreFloristeria(name);
		Repository rp = new Repository();
		rp.nuevaFloristeria(name);
		return floristeria;
	}
	public void añadirArbol() throws FileNotFoundException, IOException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Número Arboles: ");
		int numero = sc.nextInt();
		sc.nextLine();

		try (FileWriter fw = new FileWriter(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\arbol.txt",
				true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {
			for (int i = 0; i <= numero; i++) {
				out.write('A');
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void añadirFlor() throws FileNotFoundException, IOException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Número Flores: ");
		int numero = sc.nextInt();
		sc.nextLine();
		try (FileWriter fw = new FileWriter(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\flor.txt",
				true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {
			for (int i = 0; i <= numero; i++) {
				out.write("F");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void añadirDecoracion() throws FileNotFoundException, IOException {
		String name = extraerFloristeria();
		System.out.println("Introduzca tipo decoracion (madera/plastico) :");
		String tipo = sc.nextLine();
		System.out.println("Introduzca Cantidad: ");
		int numero = sc.nextInt();
		sc.nextLine();
		try (FileWriter fw = new FileWriter(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\decoracion.txt",
				true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {
			if (tipo.equalsIgnoreCase("madera")) {
				for (int i = 0; i <= numero; i++) {
					out.write("M");
				}
			}
			if (tipo.equalsIgnoreCase("plastico")) {
					for (int i = 0; i <= numero; i++) {
						out.write("P");
					}
				}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String StockArboles(String name) throws FileNotFoundException, IOException {

		String arboles = "";
		try (FileReader fr = new FileReader(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\arbol.txt");
				BufferedReader br = new BufferedReader(fr)) {

			arboles = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return arboles;
	}

	public String StockFlores(String name) throws FileNotFoundException, IOException {

		String flores = "";
		try (FileReader fr = new FileReader(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\flor.txt");
				BufferedReader br = new BufferedReader(fr)) {

			flores = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return flores;
	}

	public String StockDecoraciones(String name) throws FileNotFoundException, IOException {

		String decoraciones = "";

		try (FileReader fr = new FileReader(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\decoracion.txt");
				BufferedReader br = new BufferedReader(fr)) {

			decoraciones = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return decoraciones;
	}

	public void mostrarStockFloristeria() throws FileNotFoundException, IOException {
		String name = extraerFloristeria();
		vista.mostrarStock(StockArboles(name), StockFlores(name), StockDecoraciones(name));
	}

	public void mostrarCantidadesStockFloristeria() throws FileNotFoundException, IOException {
		String name = extraerFloristeria();
		vista.mostrarCantidadesStock(name);
	}

	public void retirarArbol() throws FileNotFoundException, IOException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Número Arboles a retirar: ");
		int numero = sc.nextInt();
		sc.nextLine();
		restarArbol(name, numero);

	}

	public void restarArbol(String name, int numero) {
		String buffer = "";
		try (FileReader fr = new FileReader(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\arbol.txt");
				BufferedReader br = new BufferedReader(fr)) {
			buffer = br.readLine();
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

	public void retirarFlor() throws FileNotFoundException, IOException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Número Flores a retirar: ");
		int numero = sc.nextInt();
		sc.nextLine();
		restarFlor(name, numero);

	}

	public void restarFlor(String name, int numero) {

		String buffer = "";
		try (FileReader fr = new FileReader(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\flor.txt");
				BufferedReader br = new BufferedReader(fr)) {
			buffer = br.readLine();
			if (buffer.length() < numero)
				System.out.println("numero mayor que stock");
			String result = buffer.substring(0, (buffer.length() - numero));
			try (FileWriter fw = new FileWriter(
					"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
							+ name + "\\flor.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw)) {
				out.println(result);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void retirarDecoracion() throws FileNotFoundException, IOException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Número decoraciones a retirar: ");
		int numero = sc.nextInt();
		sc.nextLine();
		restarDecoracion(name, numero);

	}

	public void restarDecoracion(String name, int numero) {

		String buffer = "";
		try (FileReader fr = new FileReader(
				"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
						+ name + "\\decoracion.txt");
				BufferedReader br = new BufferedReader(fr)) {
			buffer = br.readLine();
			if (buffer.length() < numero)
				System.out.println("numero mayor que stock");
			String result = buffer.substring(0, (buffer.length() - numero));
			try (FileWriter fw = new FileWriter(
					"C:\\Users\\pedro\\eclipse-workspace\\S03T03N01PedroTejeroDiez\\lib\\src\\main\\java\\Floristeria "
							+ name + "\\decoracion.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw)) {
				out.println(result);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void mostrarValorTotalFloristeria() throws FileNotFoundException, IOException {
		String name = extraerFloristeria();
		vista.mostrarValorTotal(StockArboles(name), StockFlores(name), StockDecoraciones(name));
	}

	public void crearTicketCompra() {
		String name = extraerFloristeria();
		System.out.println("Cuántos Arboles compra?:");
		int arboles = sc.nextInt();
		sc.nextLine();
		restarArbol(name, arboles);
		System.out.println("Cuántas flores compra?:");
		int flores = sc.nextInt();
		sc.nextLine();
		restarFlor(name, flores);
		System.out.println("Cuántas decoraciones compra?:");
		int decoraciones = sc.nextInt();
		sc.nextLine();
		restarDecoracion(name, decoraciones);
		vista.imprimirTicketCompra(name, arboles, flores, decoraciones);
	}
	
	public void listadoComprasAnteriores() {
		String name = extraerFloristeria();
		vista.listadoCompras(name);
	}
	
	public void gananciasTotalesFloristeria() {
		String name = extraerFloristeria();
		vista.gananciasTotales(name);
	}

	public void updateView() {
		vista.mostrarFloristeria(floristeria);
	}
}
