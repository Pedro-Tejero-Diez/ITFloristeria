package pooclase2;

import java.util.ArrayList;
import java.util.Scanner;

public class POOClase2 {

	public static void main(String[] args) {
		
		ArrayList<Ordenador> listado = new ArrayList<Ordenador>();
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<6; i++) {
			String marca = "HP";
			String modelo = "4700P";
			String procesador = "pentium";
			int ram = 16;
			int discoduroMb = 512;
						
			Ordenador cpu = new Ordenador(marca, modelo, procesador, ram, discoduroMb);
			listado.add(cpu);
			
		}
		
		System.out.println("Introduzca Marca:");
		String marca = sc.nextLine();
		System.out.println("Introduzca Modelo:");
		String modelo = sc.nextLine();
		
		int size = listado.size();
		int i=0;
		boolean iguales = false;
		while (iguales && i<size) {
			String marcalista = listado.get(i).getMarca();
			if (marca.equals(marcalista)) {
				iguales = true;
			}
			i++;
		}
		// solucion profe
		//if (listado.get(i).getMarca().equalsIgnoreCase(marca) && listado.get(i).getModelo.equalsIgnoreCase(modelo)) {
		//cpu = listado.get(i);
		//iguales = true;
		//}
		//i++;
		//}
		//if (iguales) {
		//sysou est an la base!!
		// else 
		//no esta en la base!
		
		if (iguales) {
				System.out.println("La Marca "+marca+" ESTá en la base de datos");
		} else {
			System.out.println("La Marca "+marca+" NO ESTA  en la base de datos");
		}
		}

	/*
	 * bucle usado por el profe para mostrar lo que hay en el array list: int size =
	 * listado.size(); for (int i=0; i<size;i++) {
	 * System.out.println(listado.get(i)); }
	 */
}