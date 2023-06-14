package herencias;

public class Hospital extends Edificio {
	private int numeroEnfermos;
	public static final int RACIONESDIARIAS = 3;

	public Hospital(String nombre, int numeroPlantas, int superficie, int numeroEnfermos) {
		super(nombre, numeroPlantas, superficie);
		this.numeroEnfermos = numeroEnfermos;
	}

	public int getNumeroEnfermos() {
		return numeroEnfermos;
	}

	public void setNumeroEnfermos(int numeroEnfermos) {
		this.numeroEnfermos = numeroEnfermos;
	}
	
	
	public String repartirComida (int numeroEnfermos) {
		this.numeroEnfermos=numeroEnfermos;
		int totalRaciones = numeroEnfermos*RACIONESDIARIAS;
		return ("Se estan repartiendo "+totalRaciones+" Raciones");
	}

	@Override
	public String calcularCosteVigilancia() {
		super.superficie = superficie;
		float numeroVigilantes = (int) Math.ceil(superficie/1000);
		int costeMensualVigilantes = (int)numeroVigilantes*1300;
		return ("El coste de Vigilancia mensual es de: "+costeMensualVigilantes);
	}

}
