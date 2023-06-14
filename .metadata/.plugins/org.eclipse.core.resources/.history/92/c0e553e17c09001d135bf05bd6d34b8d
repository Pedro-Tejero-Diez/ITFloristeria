package pooejercicio834;

import java.util.ArrayList;
import java.util.Scanner;
import herencias.Cine;
import herencias.Edificio;
import herencias.Hospital;
import herencias.Hotel;

public class POOEjercicio834 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Edificio> listado = new ArrayList<Edificio>();

		Cine cine1 = new Cine("Montecarlo", 1, 6400, 500);
		Cine cine2 = new Cine("Principal", 2, 124500, 1200);
		Hotel hotel1 = new Hotel("Hilton", 20, 73588, 535);
		Hotel hotel2 = new Hotel("Manolita", 12, 535, 12);
		Hospital hospital1 = new Hospital("Hospital de Vilafranca", 3, 1950, 26);
		Hospital hospital2 = new Hospital("Hospital General", 10, 25600, 315);

		listado.add(cine1);
		listado.add(cine2);
		listado.add(hotel1);
		listado.add(hotel2);
		listado.add(hospital1);
		listado.add(hospital2);

		boolean sortir = false;
		do {
			switch (menu()) {
			case 1:
				crearEdificio(listado);
				break;
			case 2:
				eliminarEdificio(listado);
				break;
			case 3:
				mostrarEdificio(listado);
				break;

			case 0:
				System.out.println("gracias por usar este programa. Adios");
				sortir = true;
				break;
			}
		} while (!sortir);

		System.out.println(listado);
	}

	private static int menu() {

		byte opcio;
		final byte MINIMO = 0;
		final byte MAXIMO = 3;

		do {
			System.out.println("\n******MENÚ PRINCIPAL*****");
			System.out.println("1. Opció 1. Dar de Alta Edificio");
			System.out.println("2. Opció 2. Dar de Baja Hotel");
			System.out.println("3. Opció 3. Mostrar Edificio");
			System.out.println("0. Sortir de l'aplicació.\n");
			System.out.println("Escoja una opción: ");
			opcio = sc.nextByte();
			sc.nextLine();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escull una opció vàlida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	public static Edificio buscarEdificio(ArrayList<Edificio> listado, String name) {
		int size = listado.size(), i = 0;
		Edificio edificio1 = null;
		while (i < size && edificio1 == null) {
			if (listado.get(i).getNombre().equalsIgnoreCase(name)) {
				edificio1 = listado.get(i);
			}
			i++;
		}
		return (edificio1);
	}

	public static void crearEdificio(ArrayList<Edificio> listado) {
		System.out.println("Introduzca Nombre Edificio a añadir");
		String name = sc.nextLine();

		if (buscarEdificio(listado, name) == null) {
			System.out.println("Introduzca numero de Plantas");
			int numeroPlantas = sc.nextInt();
			System.out.println("Introduzca Superficie");
			int superficie = sc.nextInt();

			System.out.println("Elija el tipo de Edificio que quiere crear: ");
			System.out.println("1. Hotel\n 2.Cine\n 3.Hospital");
			System.out.println("Introduzca su eleccion:");
			byte eleccion = sc.nextByte();
			do {
				switch (eleccion) {
				case 1:
					System.out.println("introduzca numero de Habitaciones");
					int numeroHabitaciones = sc.nextInt();
					Hotel hotel = new Hotel(name, numeroPlantas, superficie, numeroHabitaciones);
					listado.add(hotel);
					System.out.println("El hotel "+hotel.getNombre()+" ha sido añadido a la base de datos");
					break;
				case 2:
					System.out.println("introduzca Aforo Maximo");
					int aforoMaximo = sc.nextInt();
					Cine cine = new Cine(name, numeroPlantas, superficie, aforoMaximo);
					listado.add(cine);
					System.out.println("El Cine "+cine.getNombre()+" ha sido añadido a la base de datos");
					break;
				case 3:
					System.out.println("introduzca numero de Enfermos");
					int numeroEnfermos = sc.nextInt();
					Hospital hospital = new Hospital(name, numeroPlantas, superficie, numeroEnfermos);
					listado.add(hospital);
					System.out.println("El Hospital "+hospital.getNombre()+" ha sido añadido a la base de datos");
					break;

				default:
					System.out.println("Por favor, introduzca un numero valido");
				}

			} while (eleccion < 1 || eleccion > 3);
			

		} else
			System.out.println("El Edificio ya existe en la base de datos");

	}

	public static void eliminarEdificio(ArrayList<Edificio> listado) {
		System.out.println("Introduzca Nombre Edificio");
		String name = sc.nextLine();

		if (buscarEdificio(listado, name) == null) {
			System.out.println("El Edificio " + name + " NO está en nuestra base de datos");
		} else {
			System.out.println("El Edificio ha sido borrado de la base de datos");
			listado.remove(buscarEdificio(listado, name));
		}
	}

	public static void mostrarEdificio(ArrayList<Edificio> listado) {
		System.out.println("Introduzca Nombre Edificio a buscar");
		String name = sc.nextLine();
		if (buscarEdificio(listado, name) != null) {
			Edificio edificio = (buscarEdificio(listado, name));
			System.out.println(edificio);
		} else
			System.out.println("Este Edificio no se encuentra en nuestra base de datos");
	}
}