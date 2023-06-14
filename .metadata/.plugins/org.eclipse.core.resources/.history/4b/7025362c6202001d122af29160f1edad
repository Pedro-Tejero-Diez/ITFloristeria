package m7_2ejercicio8;

import java.util.Scanner;
import java.util.ArrayList;


public class M7_2Ejercicio8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numero;

		System.out.println("Introduzca un numero");
		numero = sc.nextInt();
		esFibonacci(numero);// llamada al método
	}

	public static void esFibonacci(int numero) {

		// arraylist donde se guardaran las posiciones de la serie
		ArrayList<Integer> serie = new ArrayList<Integer>();

		/* las dos primeras posiciones de la serie son 0 y 1 
		por eso las restamos de numero*/
		int suma = 0, numeroModificado = numero - 2;
		serie.add(0);
		serie.add(1);
		// 0 y 1 han de estar siempre en la serie
if (numero ==1 || numero ==0) {
	System.out.println("La serie de fibonacci para este numero es cero");
} else {
		/* en este bucle se suman la ultima posición del array y la anterior para
		generar cada nuevo valor de la serie*/
		for (int i = 1; i <= numeroModificado; i++) {
			suma = serie.get(i) + serie.get(i - 1);
			serie.add(suma);
		}
		System.out.println("Los " + numero + " primeros numeros de la serie de Fibonacci son: \n \n" + serie);
	}
	}
}
