package pooclase2ejercicioextra;

import java.util.ArrayList;
import java.util.Scanner;

public class POOClase2Ejercicioextra {


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String marca, modelo;
		int i=0;
		boolean encontrado = false;
		ArrayList<NewOrdenador> listado = new ArrayList<NewOrdenador>();
		
			NewOrdenador cpu1 = new NewOrdenador("Packard Bell", "345HT","Pentium", 16, 1000 );
			NewOrdenador cpu2 = new NewOrdenador("HP", "4700P","PentiumII", 32, 1000 );
			NewOrdenador cpu3 = new NewOrdenador("Acer", "345HT","Acer", 32, 500 );
			NewOrdenador cpu4 = new NewOrdenador("Lenovo", "yoga","Core i5", 64, 1000 );
			NewOrdenador cpu5 = new NewOrdenador("Asus", "Aspire5","Core i7", 64, 1000 );
			
			listado.add(cpu1);
			listado.add(cpu2);
			listado.add(cpu3);
			listado.add(cpu4);
			listado.add(cpu5);
			
			int tamaño = listado.size();
			for (int j=0; j<tamaño;j++) {
				System.out.println(listado.get(j)); }
			
			System.out.println("Introduzca la Marca que está buscando: ");
			marca = sc.nextLine();
			System.out.println("Introduzca el Modelo que está buscando: ");
			modelo = sc.nextLine();
			
			while (i<tamaño && !encontrado) {
			if (listado.get(i).getMarca().equalsIgnoreCase(marca) && listado.get(i).getModelo().equalsIgnoreCase(modelo)) {
				encontrado = true;
						}
			i++;
			}
			int posicion = i-1;
			if (encontrado) {
				listado.remove(posicion);
				System.out.println("Tenemos el Modelo y Marca que está buscando");
			} else
				System.out.println("Lo sentimos, no tenemos el modelo y Marca que busca");
			
			int size2=listado.size();
			for (int j=0; j<size2;j++) {
				System.out.println(listado.get(j)); }
			
			
			//primera variacion del programa. Comento para realizar la segunda
			/*cpu1.programa("Eclipse");
			
			System.out.println(cpu1.getMarca());
			
			System.out.println(cpu2.getProcesador());
			
			System.out.println(cpu2.toString());
			System.out.println(cpu1.toString());*/

		}
	}


