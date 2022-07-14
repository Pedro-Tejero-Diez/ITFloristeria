package pooclase1;

public class Coche {
	/*
	 * atributs añadidos por mi y que no se podran cambiar desde fuera de la clase
	 * es decir, hay que venir a este archivo para modificarlos
	 */
	private String marca;
	private String modelo;
	private int potencia;
	private int cilindrada;
	private String color;

	/*
	 * metodos añadidos por mí y que pongo como publicos, por lo que se pueden usar
	 * desde fuera de la clase, o sea dentro de todo el package (o más alla?¿)
	 */
	public void arrancar() {
		System.out.println("Estoy Arrancando");
	}

	public void frenar() {
		System.out.println("Estoy Frenando");
	}

	public void acelerar() {
		System.out.println("Estoy acelerando");
	}

	public void girar() {
		System.out.println("Estoy Girando");
	}

	// getter and setters autogenerados con eclipse (menu izqu.source)
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Coche(String marca, String modelo, int potencia, int cilindrada, String color) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
		this.cilindrada = cilindrada;
		this.color = color;
	}

}
