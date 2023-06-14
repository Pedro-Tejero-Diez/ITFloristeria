package m7_2ejercicio6variacion;

import java.util.Scanner;

public class M7_2Ejercicio6variacion {


		public static void main(String[] args) {
			
			Scanner sc= new Scanner (System.in);
			int numero;
			do {
			System.out.println("Introduce un numero : ");
			numero = sc.nextInt();
			esPrimer(numero);
			
			} while (esPrimer(numero));
			
			System.out.println("Exacto!! El numero "+numero+" ES primo");
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
