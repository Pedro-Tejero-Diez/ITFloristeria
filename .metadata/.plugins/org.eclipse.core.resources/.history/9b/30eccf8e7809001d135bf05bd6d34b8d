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
			Hospital hospital1 = new Hospital ("Hospital de Vilafranca",3,1950 ,26);
			Hospital hospital2 = new Hospital ("Hospital General",10,25600 ,315);
			
			listado.add(cine1);
			listado.add(cine2);
			listado.add(hotel1);
			listado.add(hotel2);
			listado.add(hospital1);
			listado.add(hospital2);
			
			boolean sortir = false;
			int posicion;
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
			
			
			public static Edificio buscarEdificio (ArrayList<Edificio>listado, String name) {
				int size = listado.size(), i=0;
				Edificio edificio1 = null;
				while (i<size && edificio1 == null ) {
					if (listado.get(i).getNombre().equalsIgnoreCase(name)) {
						edificio1 = listado.get(i);
					} 
					i++;
				}
				return (edificio1);
			}
			
			public static void crearEdificio (ArrayList<Edificio> listado, String name) {
				System.out.println("Introduzca Nombre Edificio a añadir");
				name = sc.nextLine();
				
				if (buscarEdificio(listado, name) == null) {
					System.out.println("Introduzca numero de Plantas");
					int numeroPlantas = sc.nextInt();
					System.out.println("Introduzca Superficie");
					int superficies = sc.nextInt();
					System.out.println("Elija el tipo de Edificio que quiere crear: ");
					System.out.println("1. Hotel\n 2.Cine\n 3.Hospital");
					byte eleccion = sc.nextByte();
					switch (eleccion) {
					case 1:
						System.out.println("introduzca numero de Habitaciones");
						int numeroHabitaciones= sc.nextInt();+bre

				} else {
					System.out.println("El Edificio ya existe en la base de datos");
					
				}
			}
		}
					System.out.println("El cliente NO se encuentra en la base de datos, a continucación introduzca los datos:");
					System.out.println("Introduzca Nombre cliente a añadir");
					String name = sc.nextLine();
					System.out.println("Introduzca Apellido cliente a añadir");
					String lastName = sc.nextLine();
				Cliente cliente = new Cliente(name, lastName);
				clientes.add(cliente);
				} else 
				System.out.println("Este cliente ya se encuentra en nuestra base de datos");
			}
			
			public static void eliminarEdificio(ArrayList<Edificio>listado, String name) {				
				System.out.println("Introduzca Nombre Edificio");
				name = sc.nextLine();
				
				if (buscarEdificio(listado, name) == null) {
					System.out.println("El Edificio "+name+" NO está en nuestra base de datos");
				} else {
					System.out.println("El Edificio ha sido borrado de la base de datos");
					listado.remove(buscarEdificio(listado, name);
				}
			}
		}
		public static void verClientes (ArrayList<Cliente> clientes) {
			int size = clientes.size();
			for (int i =0; i<size;i++) {
				System.out.println(clientes.get(i));
			}
		}
		}

		}
				
