package m6ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class M6Ejercicio2 {

	public static double media(ArrayList<Integer> e, int j) {
	int suma = 0;
		for (i=0; i<j; i++) {
			int x = e.get(i);
			suma = suma + x;
		}
		return suma/e.size();
					
		}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> listado = new ArrayList<Integer>();
		Scanner sc =new Scanner(System.in);
		System.out.println("introduzca numero de personas para calcular la media :");
		int a = sc.nextInt();
		sc.nextLine();
		
		for (int i=0; i<a; i++) {
			
			System.out.println("introduzca una edad :");
			int edad = sc.nextInt();
			listado.add(edad);
			

		}
		System.out.println(media(listado, a));

		
	}

}
