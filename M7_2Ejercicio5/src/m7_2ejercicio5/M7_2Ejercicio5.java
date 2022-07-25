package m7_2ejercicio5;

import java.util.Scanner;

public class M7_2Ejercicio5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numero;

		System.out.println("Introduce un numero");
		numero = sc.nextInt();
		
		if (esPrimer(numero)) {
			System.out.println("El numero NO es primo");
		} else {
			System.out.println("El numero ES primo");
		}
	}

	public static boolean esPrimer(int numero) {
		int resto, i = numero - 1;
		boolean encontrado = false;
		//el numer 1 no es primo y daria error porque la resta seria cero en el nominador
		if (numero == 1) {
			encontrado = true;
		} else {
		
		do {

			// un numero primo es solo divisible por si mismo y por uno por eso pongo i=2
			// como limite

			resto = numero % i;
			if (resto == 0) {
			
				encontrado = true;
			}
			
			i--;
		} while (i > 1 && !encontrado);
		}

		return encontrado;
	}
}
