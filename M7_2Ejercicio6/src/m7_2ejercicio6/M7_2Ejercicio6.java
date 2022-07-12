package m7_2ejercicio6;

import java.util.Scanner;

public class M7_2Ejercicio6 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner (System.in);
		int numero;
		
		System.out.println("Introduce un numero : ");
		numero = sc.nextInt();
		esPrimer(numero);
		
		if (esPrimer(numero)) {
			System.out.println("El numero "+numero+" NO es primo");
		} else {
			System.out.println("En efecto el numero "+numero+" es PRIMO");
			
		}
	}
public static boolean esPrimer(int numero) {
	boolean primo = false;
	int resto, i=2;
	
	while (i<numero && !primo) {
		
	resto = numero%i;
	
	if (resto ==0) {
		primo = true;
	}
	i++;
		
	}
	return primo;
}
}
