package m5ejercicio1;

//import java.util.ArrayList;
import java.util.Scanner;

public class M5Ejercicio1 {

	public static void main(String[] args) {
//comentado pongo el original. Despues lo he cambiado al repasar
		byte i, numpal;
		String input, palabra = "";
		Scanner sc = new Scanner(System.in);
		//ArrayList<String> listado = new ArrayList<String>();
		
		System.out.println("¿cuántas palabras quieres introducir?");
		numpal = sc.nextByte();
		sc.nextLine();
		
		for (i = 0; i < numpal; i++ ) {

			System.out.println("Introduce una palabra");
			input = sc.nextLine();
			palabra += input;
			//listado.add(palabra);
					}
		//System.out.println(listado);
		System.out.println(palabra);

		}
		

	}
