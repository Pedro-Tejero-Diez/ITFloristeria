package herencias;

public class Cine extends Edificio {
	
	private int aforoMaximo;

	public Cine(String nombre, int numeroPlantas, int superficie, int aforoMaximo) {
		super(nombre, numeroPlantas, superficie);
		this.aforoMaximo = aforoMaximo;
	}

	public int getAforoMaximo() {
		return aforoMaximo;
	}

	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}
	
	
	public String proyectarSesion(int precioEntrada, int numeroAsistentes) {
		int totalRecaudacion=0;
		if (numeroAsistentes > aforoMaximo) {
			System.out.println("El numero de asistentes supera el aforo máximo de la sala");
		} else
			totalRecaudacion= precioEntrada+numeroAsistentes;
		
		return ("Se han recaudado "+totalRecaudacion+" euros");
	}

	@Override
	public String calcularCosteVigilancia() {
		super.superficie = superficie;
		float numeroVigilantes = (int) Math.ceil(superficie/3000);
		int costeMensualVigilantes = (int)numeroVigilantes*1300;
		return ("El coste de Vigilancia mensual es de: "+costeMensualVigilantes);
	}
	
	
	

}
