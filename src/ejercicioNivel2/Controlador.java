package ejercicioNivel2;

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
		Repository.nuevaFloristeria(name);
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
		Repository.nuevoStockDecor(name, numero, tipo, precio);
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
		System.out.println("Introduzca Id Flores a retirar: ");
		int id = sc.nextInt();
		sc.nextLine();
		Repository.restarFlor(name, numero, id);

	}


	public void retirarDecoracion() throws  SQLException {
		String name = extraerFloristeria();
		System.out.println("Introduzca Número decoraciones a retirar: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca Id Decoracion a retirar: ");
		int tipo = sc.nextInt();
		sc.nextLine();
		Repository.restarDecoracion(name, numero, tipo);

	}

	public void mostrarValorTotalFloristeria() throws SQLException {
		String name = extraerFloristeria();
		vista.mostrarValorTotal(name);
	}

	public void crearTicketCompra() throws SQLException {
		
		String name = extraerFloristeria();
		System.out.println("Id de arbol a comprar: ");
		int arbol = sc.nextInt();
		sc.nextLine();
		System.out.println("Cuántos Arboles compra?:");
		int cantarbol = sc.nextInt();
		sc.nextLine();
		System.out.println("Id flores a comprar: ");
		int flor = sc.nextInt();
		sc.nextLine();
		System.out.println("Cuántas flores compra?:");
		int cantflor = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Id Decoración a comprar: ");
		int dec = sc.nextInt();
		sc.nextLine();
		System.out.println("Cuántas decoraciones compra?:");
		int cantdecor = sc.nextInt();
		sc.nextLine();
		
		Repository.crearTicketCompra(name, arbol, cantarbol, flor, cantflor, dec, cantdecor);
	}
	
	public void listadoComprasAnteriores() throws SQLException {
		String name = extraerFloristeria();
		vista.listadoComprasAnteriores(name);
	}
	
	public void gananciasTotalesFloristeria() throws SQLException {
		String name = extraerFloristeria();
		vista.vistaGananciasTotales(name);
	}

}
