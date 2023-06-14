package m7_3ejercicio7;

import java.util.Scanner;

public class M7_3Ejercicio7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		float comensales, preuFideos, preuCalamars, preuGambes, kgFideos, kgCalamars, kgGambes, costeTotal, costexInvitado;
				
		System.out.println("Introduzca precio Kg Fideos en Euros");
		preuFideos = sc.nextFloat();
		System.out.println("Introduzca precio Kg Calamares en Euros");
		preuCalamars = sc.nextFloat();
		System.out.println("Introduzca precio Kg Gambas en Euros");
		preuGambes = sc.nextFloat();
		System.out.println("Introduzca Número de Comensales");
		comensales = sc.nextInt();
		
		kgFideos=comensales/2;
		kgCalamars=comensales/10;
		kgGambes=comensales/20;
		
		costeTotal= (kgFideos*preuFideos)+(kgCalamars*preuCalamars)+(kgGambes*preuGambes);
		costexInvitado=costeTotal/comensales;
		
		System.out.println("Las cantidades que hacen falta para una fideua con "+comensales+" comensales son¨");
		System.out.println("Kilos de Fideos: "+kgFideos+" Kg");
		System.out.println("Kilos de Calamares: "+kgCalamars+" Kg");
		System.out.println("Kilos de Gambas: "+kgGambes+" Kg");
		System.out.println("El coste por invitado asciende a: "+costexInvitado+" euros");
		System.out.println("El coste total de la Fideua es de: "+costeTotal+" euros");
		

	}

}
