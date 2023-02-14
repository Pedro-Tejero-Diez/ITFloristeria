package ejercicioNivel2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ITFloristeria {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		Floristeria floristeria = new Floristeria();
		VistaFloristeria vista = new VistaFloristeria();
		Controlador controller = new Controlador(floristeria, vista);

		boolean sortir = false;
		do {
			switch (menu()) {
			case 1:
				floristeria = controller.crearFloristeria();
				break;
			case 2:
				controller.añadirArbol();
				break;
			case 3:
				controller.añadirFlor();
				break;
			case 4:
				controller.añadirDecoracion();
				break;
			case 5:
				controller.mostrarStockFloristeria();
				break;
			case 6:
				controller.retirarArbol();
				break;
			case 7:
				controller.retirarFlor();
				break;
			case 8:
				controller.retirarDecoracion();
				break;
			case 9:
				controller.mostrarCantidadesStockFloristeria();
				break;
			case 10:
				controller.mostrarValorTotalFloristeria();
				break;

			case 11:
				controller.crearTicketCompra();
				break;
			case 12:
				controller.listadoComprasAnteriores();
				break;
			case 13:
				controller.gananciasTotalesFloristeria();
				break;

			case 0:
				System.out.println("gracias por usar este programa. Adios");
				sortir = true;
				break;
			}
		} while (!sortir);

	}

	// creamos el menu que saldrá por pantalla con las opciones a ejecutar
	private static int menu() {

		byte opcion;
		final byte MINIMO = 0;
		final byte MAXIMO = 13;

		do {
			System.out.println("\n******MENÚ PRINCIPAL*****");
			System.out.println("1. Opció 1. Crear Floristeria");
			System.out.println("2. Opció 2. Añadir Arbol");
			System.out.println("3. Opció 3. Añadir Flor");
			System.out.println("4. Opció 4. Añadir Decoración");
			System.out.println("5. Opció 5. Mostrar Stock");
			System.out.println("6. Opció 6. Eliminar Arbol");
			System.out.println("7. Opció 7. Eliminar Flor");
			System.out.println("8. Opció 8. Eliminar Decoración");
			System.out.println("9. Opció 9. Mostrar Cantidades Stock");
			System.out.println("10. Opció 10. Mostrar Valor Total");
			System.out.println("11. Opció 11. Crear Ticket de Compra");
			System.out.println("12. Opció 12. Listado compras anteriores");
			System.out.println("13. Opció 13. Ganancias totales");
			System.out.println("0. Salir de la aplicación.\n");
			System.out.println("Escoja una opción: ");
			opcion = sc.nextByte();
			sc.nextLine();
			if (opcion < MINIMO || opcion > MAXIMO) {
				System.out.println("Escoja una opción válida");
			}
		} while (opcion < MINIMO || opcion > MAXIMO);
		return opcion;
	}

	/*
	 * private static Student retriveStudentFromDatabase(){ Student student = new
	 * Student(); student.setName("Robert"); student.setRollNo("10"); return
	 * student; }
	 */



}

