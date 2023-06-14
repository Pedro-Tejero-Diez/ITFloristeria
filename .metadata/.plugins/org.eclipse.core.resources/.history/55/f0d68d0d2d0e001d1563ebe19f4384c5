package examenejercicio4;

import java.util.ArrayList;
import java.util.Scanner;

public class ExamenEjercicio4 {

	static Scanner sc = new Scanner(System.in);// como lo voy a usar varias veces a lo largo del main, lo hago static

	public static void main(String[] args, String nombre, String apellido, Equipo equipo) {
		// declaro los jugadores. Los usare repetidos para que me sirvan de prueba
		Jugador jugador1 = new Jugador("Pepe", "Perez", "ecuador", 17);
		Jugador jugador2 = new Jugador("Piter", "Perez", "españa", 20);
		Jugador jugador3 = new Jugador("Jean", "Perez", "chile", 20);
		Jugador jugador4 = new Jugador("Xarles", "Perez", "portugal", 19);
		Jugador jugador5 = new Jugador("Xavier", "Perez", "ecuador", 20);
		Jugador jugador6 = new Jugador("manolo", "Perez", "ecuador", 20);
		Jugador jugador7 = new Jugador("Juan", "Perez", "argentina", 18);
		Jugador jugador8 = new Jugador("Jose", "Perez", "ecuador", 20);
		Jugador jugador9 = new Jugador("Julian", "Perez", "ecuador", 20);
		Jugador jugador10 = new Jugador("Ronaldo", "Perez", "ecuador", 20);
		Jugador jugador11 = new Jugador("Fran", "Perez", "ecuador", 16);

		// Array list de jugadores por cada equipo
		ArrayList<Jugador> jugadores1 = new ArrayList<Jugador>();
		ArrayList<Jugador> jugadores2 = new ArrayList<Jugador>();
		ArrayList<Jugador> jugadores3 = new ArrayList<Jugador>();

		// añadimos los jugadores a los arraylist de jugadores. Hago solo tres para la
		// prueba
		jugadores1.add(jugador1);
		jugadores1.add(jugador2);
		jugadores1.add(jugador3);
		jugadores1.add(jugador4);
		jugadores1.add(jugador5);
		jugadores1.add(jugador6);
		jugadores1.add(jugador7);
		jugadores1.add(jugador8);
		jugadores1.add(jugador9);
		jugadores1.add(jugador10);
		jugadores1.add(jugador11);

		jugadores2.add(jugador1);
		jugadores2.add(jugador2);
		jugadores2.add(jugador3);
		jugadores2.add(jugador4);
		jugadores2.add(jugador5);
		jugadores2.add(jugador6);
		jugadores2.add(jugador7);
		jugadores2.add(jugador8);
		jugadores2.add(jugador9);
		jugadores2.add(jugador10);
		jugadores2.add(jugador11);

		jugadores3.add(jugador1);
		jugadores3.add(jugador2);
		jugadores3.add(jugador3);
		jugadores3.add(jugador4);
		jugadores3.add(jugador5);
		jugadores3.add(jugador6);
		jugadores3.add(jugador7);
		jugadores3.add(jugador8);
		jugadores3.add(jugador9);
		jugadores3.add(jugador10);
		jugadores3.add(jugador11);

		// Declaramos los equipos
		Equipo equipo1 = new Equipo("Atletico", "madrid", "calderon", jugadores1);
		Equipo equipo2 = new Equipo("barca", "barcelona", "nou camp", jugadores2);

		// hago un array list de equipos de prueba

		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		equipos.add(equipo1);
		equipos.add(equipo2);

		// ya tengo los array list, comienzo el programa en sí. Lo primero el switch y a
		// continuación el menu de
		// opciones según lo determinado en el switch

		boolean sortir = false;
		do {
			switch (menu()) {
			case 1:
				jugadoresMenosVeinte(equipo);
				break;
			case 2:
				buscarJugador(equipos);
				break;
			case 0:
				System.out.println("gracias por usar este programa. Adios");
				sortir = true;
				break;
			}
		} while (!sortir);

	}

	private static int menu() {

		byte opcio;
		final byte MINIMO = 0;
		final byte MAXIMO = 2;

		do {
			System.out.println("\n******MENÚ PRINCIPAL*****");
			System.out.println("1. Opció 1. Jugadores -20 años equipo");
			System.out.println("2. Opció 2. Datos de Un jugador");
			System.out.println("Escoja una opción: ");
			opcio = sc.nextByte();
			sc.nextLine();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escull una opció vàlida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	public static void jugadoresMenosVeinte(Equipo equipo) {
		ArrayList<Jugador> jugadoresmenor20 = new ArrayList<Jugador>();
		boolean encontrado = false;
		int i = 0;
		int size = equipo.getJugadores().size();
		while (!encontrado && i < size) {
			if (equipo.getJugadores().get(i).getEdad() < 20) {
				jugadoresmenor20.add(equipo.getJugadores().get(i));
			}
			System.out.println(jugadoresmenor20);
		}
	}

	public static void buscarJugador(ArrayList<Equipo> equipos) {
		System.out.println("Introduzca nombre Jugador");
		String nombre = sc.nextLine();
		System.out.println("Introduzca apellido Jugador");
		String apellido = sc.nextLine();
		if (searchJugador(nombre, apellido, equipos) != null) {
			System.out.println(searchJugador(nombre, apellido, equipos));
		} else {
			System.out.println("Eñ jugador no se encuentra en la base de datos");
		}
	}

	public static Jugador searchJugador(String nombre, String apellido, ArrayList<Equipo> equipos) {

		Equipo equipo = null;
		Jugador jugador = null;
		int size = equipos.size();
		int i = 0, j = 0;
		while (equipo == null && i < size) {
			Equipo equipo2 = equipos.get(i);// cogemos el objeto escuderia posicion "i" en el array
			int size2 = equipo2.getJugadores().size();// cogemos el tamaño del array jugadores de ese equipo
			if (size2 > 0) {
				// si no hay ningun jugador en ese equipo devuelve null,(para evitar errores)
				while (j < size2 && equipo == null) {
					if (equipo2.getJugadores().get(j).getNombre().equalsIgnoreCase(nombre)
							&& equipo2.getJugadores().get(j).getApellido().equalsIgnoreCase(apellido)) {
						equipo = equipo2;
						jugador = equipo2.getJugadores().get(j);
					}
					j++;
				}
				i++;
				j = 0;
			}
		}
		return jugador;
	}

}
