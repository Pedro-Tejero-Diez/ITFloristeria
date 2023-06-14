package pooclase3ejercico8_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {

	String nombre;
	int numeroHab;
	int numeroPlantas;
	int superficieTotal;

	public Hotel(String nombre, int numeroHab, int numeroPlantas, int superficieTotal) {
		this.nombre = nombre;
		this.numeroHab = numeroHab;
		this.numeroPlantas = numeroPlantas;
		this.superficieTotal = superficieTotal;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumeroHab() {
		return numeroHab;
	}

	public void setNumeroHab(int numeroHab) {
		this.numeroHab = numeroHab;
	}

	public int getNumeroPlantas() {
		return numeroPlantas;
	}

	public void setNumeroPlantas(int numeroPlantas) {
		this.numeroPlantas = numeroPlantas;
	}

	public int getSuperficieTotal() {
		return superficieTotal;
	}

	public void setSuperficieTotal(int superficieTotal) {
		this.superficieTotal = superficieTotal;
	}

	public void calcularManteniment(Hotel hotel) {
		
		int maxHabitaciones = 20;
		float personalHotel = this.numeroHab / maxHabitaciones;
		float costeTotal = personalHotel * 1500;
		System.out.println("El numero de personas de servicio necesarias son:" + personalHotel);
		System.out.println("El coste total de mantenimiento es:" + costeTotal);
	}
	

	@Override
	public String toString() {
		return "Hotel [nombre=" + nombre + ", numeroHab=" + numeroHab + ", numeroPlantas=" + numeroPlantas
				+ ", superficieTotal=" + superficieTotal + "]";
	}
}
