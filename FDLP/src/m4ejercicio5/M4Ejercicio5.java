package m4ejercicio5;

import java.util.Scanner;

public class M4Ejercicio5 {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int numero1;
	int numero2;
	String operacion;
	char operador;
	
System.out.println("Introduzca numero 1 :");
numero1 = sc.nextInt();

System.out.println("Introduzca numero 2 :");
numero2 = sc.nextInt();
sc.nextLine();

System.out.println("Introduzca operacion: suma, resta, multiplicación, división :");
operacion = sc.nextLine();

operador = operacion.charAt(0);

switch(operador) {
case 's':
System.out.println("La suma  de "+numero1+" y "+numero2+" es = "+(numero1+numero2));
		break;
case 'r':
System.out.println("La resta  de "+numero1+" y "+numero2+" es = "+(numero1-numero2));
		break;
case 'm':
System.out.println("La multiplicacion  de "+numero1+" y "+numero2+" es = "+numero1*numero2);
		break;
case 'd':
System.out.println("La division  de "+numero1+" y "+numero2+" es = "+(float)numero1/numero2);
		break;
		default:
			System.out.println("Por favor, introduzca unicamente uno de los operadores");

}
	}
}


