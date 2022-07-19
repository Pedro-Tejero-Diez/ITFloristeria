package pooclase3ejercico8_1;

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
//quitamos el setter de Nombre para que no se pueda cambiar una vez introducido
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

	public void calcularManteniment() {
		/*usamos variables en lugar del número directamente porque es mejor en programas largos
		así no tengo que recordar a cada paso cuánto era el sueldo o lo que sea*/
		int sueldo = 1500;
		int maxHabitaciones = 20;
		float personalHotel = this.numeroHab / maxHabitaciones;
		personalHotel = (int) Math.ceil(personalHotel);//redondeamos al alza
		int costeTotal = (int) personalHotel * sueldo;
		System.out.println("El numero de personas de servicio necesarias son:" + personalHotel);
		System.out.println("El coste total de mantenimiento es:" + costeTotal);
	}
	

	@Override
	public String toString() {
		return "Hotel [nombre=" + nombre + ", numeroHab=" + numeroHab + ", numeroPlantas=" + numeroPlantas
				+ ", superficieTotal=" + superficieTotal + "]";
	}
}
