package m7_2ejercicio8;

import java.util.Scanner;
import java.util.ArrayList;


public class M7_2Ejercicio8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numero;
		
		System.out.println("Introduzca un numero");
		numero = sc.nextInt();
		esFibonacci(numero);
	}
	public static void esFibonacci(int numero) {
		
		ArrayList<Integer> fibonacci = new ArrayList<Integer>();
		int suma=2;
		fibonacci.add(0);
		fibonacci.add(1);
		
		for (int i=1; i<=numero;i++) {
			suma = suma+fibonacci.get(i);
			fibonacci.add(suma);
		}
		System.out.print(fibonacci);
	}

}
