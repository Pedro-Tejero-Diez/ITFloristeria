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
	public void añadirArbol() throws  SQLException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Número Arboles: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca Altura Arboles: ");
		float altura = sc.nextFloat();
		sc.nextLine();
		System.out.println("Introduzca Precio Arbol: ");
		float precio = sc.nextFloat();
		sc.nextLine();
		Repository.nuevoStockArbol(name, numero, altura, precio);
	

	}

	public void añadirFlor() throws  SQLException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Color Flores: ");
		String color = sc.nextLine();
		System.out.println("Introduzca Precio Flores: ");
		float precio = sc.nextFloat();
		sc.nextLine();
		System.out.println("Introduzca Cantidad Flores: ");
		int numero = sc.nextInt();
		sc.nextLine();
		Repository.nuevoStockFlor(name, numero, color, precio);
		

		}

	public void añadirDecoracion() throws SQLException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Tipo Decoracion (plastico/madera): ");
		String tipo = sc.nextLine();
		System.out.println("Introduzca Precio Decoracion: ");
		float precio = sc.nextFloat();
		sc.nextLine();
		System.out.println("Introduzca Cantidad: ");
		int numero = sc.nextInt();
		sc.nextLine();
		Repository.nuevoStockFlor(name, numero, tipo, precio);
	}


	public void mostrarStockFloristeria() throws SQLException {
		String name = extraerFloristeria();
		vista.mostrarStock(name);
	}

	public void mostrarCantidadesStockFloristeria() throws SQLException {
		String name = extraerFloristeria();
		vista.mostrarCantidadesStock(name);
	}

	public void retirarArbol() throws SQLException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Número Arboles a retirar: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca Altura de Arboles a retirar: ");
		float altura = sc.nextFloat();
		Repository.restarArbol(name, numero, altura);

	}


	public void retirarFlor() throws SQLException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Número Flores a retirar: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca Color Flores a retirar: ");
		String color = sc.nextLine();
		Repository.restarFlor(name, numero, color);

	}


	public void retirarDecoracion() throws  SQLException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Número decoraciones a retirar: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca Tipo Decoracion a retirar: ");
		String tipo = sc.nextLine();
		Repository.restarDecoracion(name, numero, tipo);

	}

	public void mostrarValorTotalFloristeria() throws FileNotFoundException, IOException {
		String name = extraerFloristeria();
		//vista.mostrarValorTotal();
	}

	public void crearTicketCompra() {
		String name = extraerFloristeria();
		System.out.println("Cuántos Arboles compra?:");
		int arboles = sc.nextInt();
		sc.nextLine();
		//restarArbol(name, arboles);
		System.out.println("Cuántas flores compra?:");
		int flores = sc.nextInt();
		sc.nextLine();
		//restarFlor(name, flores);
		System.out.println("Cuántas decoraciones compra?:");
		int decoraciones = sc.nextInt();
		sc.nextLine();
		//restarDecoracion(name, decoraciones);
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
