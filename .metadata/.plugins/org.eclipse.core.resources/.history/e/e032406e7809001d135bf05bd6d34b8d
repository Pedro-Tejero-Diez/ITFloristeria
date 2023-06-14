package herencias;

public class Hotel extends Edificio {
	
	private int numeroHabitaciones;

	public Hotel(String nombre, int numeroPlantas, int superficie, int numHabitaciones) {
		super(nombre, numeroPlantas, superficie);
		
	}

	public int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(int numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}
	public String calculoPersonas (int numeroHabitaciones) {
		this.numeroHabitaciones=numeroHabitaciones;
		float numeroPersonas = (int)Math.ceil(numeroHabitaciones)/20;
		int sueldoTotal=(int)numeroPersonas*1000;
		
		return("El número de personas de Servicio necesarias son:"+numeroPersonas+"\n El coste total mensual en personas es:  "+sueldoTotal);
	}
	@Override
	public String calcularCosteVigilancia() {
		super.superficie = superficie;
		float numeroVigilantes = (int) Math.ceil(superficie/1000);
		int costeMensualVigilantes = (int)numeroVigilantes*1800;
		return ("El coste de Vigilancia mensual es de: "+costeMensualVigilantes);
	}


	

}
