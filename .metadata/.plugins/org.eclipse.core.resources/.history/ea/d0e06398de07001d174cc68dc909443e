package pooclase3ejercico8_1;

import java.util.ArrayList;
import java.util.Scanner;

public class POOClase3Ejercicio8_1 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Hotel> listado = new ArrayList<Hotel>();
		Hotel hotel1 = new Hotel("Ritz", 300, 30, 10000);
		Hotel hotel4 = new Hotel("H10", 300, 30, 10000);
		Hotel hotel5 = new Hotel("Ilunion", 300, 30, 10000);

		listado.add(hotel1);
		listado.add(hotel4);
		listado.add(hotel5);
		verHoteles(listado);

		boolean sortir = false;
		int posicion;
		do {
			switch (menu()) {
			case 1:
				posicion = buscarHotel(listado);
				crearHotel(listado, posicion);
				verHoteles(listado);
				break;
			case 2:
				posicion = buscarHotel(listado);
				darDeBajaHotel(listado, posicion);
				verHoteles(listado);
				break;
			case 3:
				posicion = buscarHotel(listado);
				verHotel(listado, posicion);
				break;
			case 4:
				posicion = buscarHotel(listado);
				modificarHotel(listado, posicion);
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
		final byte MAXIMO = 4;

		do {
			System.out.println("\n******MENÚ PRINCIPAL*****");
			System.out.println("1. Opció 1. Crear Hotel");
			System.out.println("2. Opció 2.Dar de Baja Hotel");
			System.out.println("3. Opció 3.Ver Hotel");
			System.out.println("4. Opció 4.Modificar Hotel");
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

	public static int buscarHotel(ArrayList<Hotel> listado) {
		System.out.println("Introduzca nombre Hotel");
		String nombre = sc.nextLine();
		boolean encontrado = false;
		int posicion = -1;
		int i = 0;
		int size = listado.size();
		while (i < size && !encontrado) {
			if (listado.get(i).getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
				posicion = i;
			}
			i++;
		}
		return posicion;
	}

	public static void crearHotel(ArrayList<Hotel> listado, int posicion) {
		if (posicion == -1) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduzca el nombre del Hotel");
			String nombre = sc.nextLine();

			System.out.println("Introduzca el numero de Habitaciones");
			int numeroHab = sc.nextInt();
			System.out.println("Introduzca el numero de plantas");
			int numeroPlantas = sc.nextInt();

			System.out.println("Introduzca la superficie total del Hotel");
			int superficieTotal = sc.nextInt();

			Hotel hotel = new Hotel(nombre, numeroHab, numeroPlantas, superficieTotal);

			listado.add(hotel);
			hotel.calcularManteniment();

		} else {
			System.out.println("El Hotel ya está en nuestra base de datos");
		}
	}

	public static void verHoteles(ArrayList<Hotel> listado) {
		for (Hotel hotel : listado) {
			System.out.println(hotel);
		}
	}

	public static void darDeBajaHotel(ArrayList<Hotel> listado, int posicion) {

		if (posicion == -1) {

			System.out.println("El hotel no está en nuestra base de datos");
		} else {
			listado.remove(posicion);
			System.out.println("El Hotel ha sido borrado de la base de datos");
		}
	}

	public static void verHotel(ArrayList<Hotel> listado, int posicion) {
		if (posicion == -1) {
			System.out.println("El Hotel no está en nuestra Base de datos");
		} else {
			System.out.println(listado.get(posicion));
			listado.get(posicion).calcularManteniment();
		}
	}

	public static void modificarHotel(ArrayList<Hotel> listado, int posicion) {
		if (posicion == -1) {
			System.out.println("El nombre de Hotel no se encuentra en la base de datos");
		} else {
			char modificar;
			byte input;
			System.out.println(
					"Qué parámetro desea modificar?: \n 1. Numero Habitaciones \n 2. Numero Plantas \n 3.Superficie total");
			input = sc.nextByte();

			while (input < 0 || input > 3) {
				System.out.println("Por favor, introduzca un numero valido");
			
			switch (input) {
			case 1:
				System.out.println("Introduzca NUEVO numero de habitaciones: ");
				int numeroHabitaciones = sc.nextInt();
				listado.get(posicion).setNumeroHab(numeroHabitaciones);
				System.out.println("El numero de habitaciones del Hotel "+listado.get(posicion).getNombre()+" ha sido modificado a"+numeroHabitaciones);
				break;
			case 2:
				System.out.println("Introduzca NUEVO numero de PLANTAS: ");
				int numeroPlantas = sc.nextInt();
				listado.get(posicion).setNumeroPlantas(numeroPlantas);
				System.out.println("El numero de plantas del Hotel "+listado.get(posicion).getNombre()+" ha sido modificado a"+numeroPlantas);
				break;
			case 3:
				System.out.println("Introduzca NUEVA superficie total: ");
				int superficieTotal = sc.nextInt();
				listado.get(posicion).setSuperficieTotal(superficieTotal);
				System.out.println("La superficie Total del Hotel "+listado.get(posicion).getNombre()+" ha sido modificada a "+superficieTotal);
				break;
			}
			}
		}
		/*
		 * si hay hoteles repetidos no usamos el truco de la posición sino un iterador:
		 * import java.util.Iterator; Iterator<Hotel> it = listado.iterator(); Hotel
		 * hotel = it.next(); while (it.hasNext()) { if
		 * (nombre.equalsIgnoreCase(hotel.getNombre()){ it.remove(); encontrado = true;
		 * system.out(El hotel ha sido eliminado) } else { sysou(El hotel no existe en
		 * nuestra base de datos");
		 */

	}
}
