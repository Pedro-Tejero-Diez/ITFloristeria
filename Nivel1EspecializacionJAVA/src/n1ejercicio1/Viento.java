package n1ejercicio1;

public class Viento extends Instrumento {
	
	/*coloco aqui la variable estatica en lugar de en la clase madre, para comprobar que 
	 * al acceder al valor de una variable estatica, se debe cargar la clase madre
	 */
	public static int valor = 10;
	
	public Viento (String Nombre, int Precio) {
	
	super(Nombre, Precio);

	}
	public void Tocar () {
		System.out.println("Esto es un instrumento de viento");
	}
}