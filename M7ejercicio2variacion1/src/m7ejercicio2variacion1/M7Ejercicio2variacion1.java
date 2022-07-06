package m7ejercicio2variacion1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class M7Ejercicio2variacion1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numNotas;
		int i = 0, nota, total = 0;
		ArrayList<Integer> listado = new ArrayList<Integer>();
		
		System.out.println("Introduzca numero de notas a evaluar");
		numNotas = sc.nextInt();
	
		do {
		System.out.println("Introduzca una nota");
		nota = sc.nextInt();
		if (nota >= 0 && nota <=10) {
			listado.add(nota);
			total += nota;
			i++;
		} else {
			System.out.println("La nota debe estar entre 0 y 10");
		}
		} while (i < numNotas);
		
		System.out.println("La maxima nota fue :"+maximaNota(listado));
		System.out.println("La nota media fue :"+(float)total/numNotas);
		System.out.println("La minima nota fue :"+minimaNota(listado));
		
		if (total/numNotas < 5) {
			System.out.println("La nota mitjana de la classe està suspesa. Els alumnes haurien de preguntar els seus dubtes i treballar més");
		} else if (total/numNotas < 7) {
			System.out.println("La nota mitjana de la classe és bona, però els alumnes haurien de millorar el treball personal\"");
		} else {
			System.out.println("Enhorabona! La nota mitjana de la classe es correspon amb l'esforç realitzat");
		}
		
	}

		public static int maximaNota(ArrayList<Integer> e) {
			int max;
			Collections.sort(e);
			max = e.get(0);
			return max;
		}
		public static int minimaNota(ArrayList<Integer> e) {
			int min;
			Collections.sort(e);
			min = e.get(2);
			return min;
		}

}
