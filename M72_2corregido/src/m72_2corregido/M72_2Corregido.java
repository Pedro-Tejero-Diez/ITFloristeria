package m72_2corregido;

import java.util.Scanner;

public class M72_2Corregido {

	public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			String text = "";
			
			System.out.println("Introduzca el numero de lineas del árbol");
			byte numero = sc.nextByte();

		for (int i = numero; i >=1 ; i--) {
			
				for (int j=1; j<=i; j++) {
				
						text += "*";
				}
				text += "\n";
			}
		System.out.println(text);
		}
	}


