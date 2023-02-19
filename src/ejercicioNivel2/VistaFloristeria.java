package ejercicioNivel2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VistaFloristeria {

	private Arbol arbol = new Arbol();
	private Flor flor = new Flor();
	private Decoracion decoracion = new Decoracion();

	public void mostrarFloristeria(Floristeria floristeria) {
		System.out.println("Floristeria: " + floristeria.getNombre());

	}

	public void mostrarValorTotal(String name) throws SQLException {
		ResultSet rA = Repository.mostrarCantidades(name);
		float total = 0;
		while (rA.next()) {
			float qtar = rA.getInt(4) * rA.getFloat(3);
			total += qtar;
			float qtfl = rA.getInt(1) * rA.getFloat(3);
			total += qtfl;
			float qtdr = rA.getInt(1) * rA.getFloat(3);
			total += qtdr;
		}
		System.out.println("El total del stock en euros es: " + total);
	}

	public void mostrarCantidadesStock(String name) throws SQLException {
		ResultSet rA = Repository.mostrarCantidades(name);

		while (rA.next()) {
			float alt = rA.getFloat(2);
			int qtarbol = rA.getInt(4);
			System.out.println("Altura árbol: " + alt + "        Cantidad: " + qtarbol);

			String color = rA.getString(6);
			int qtflor = rA.getInt(8);
			System.out.println("Color flor: " + color + "        Cantidad: " + qtflor);

			String tipo = rA.getString(10);
			int qtdecor = rA.getInt(12);
			System.out.println("Tipo Decoración: " + tipo + "        Cantidad: " + qtdecor);
		}
	}

	public void listadoComprasAnteriores(String name) throws SQLException {

		ResultSet rV = Repository.listadoCompras(name);
		System.out.println("LISTADO COMPRAS REALIZADAS");
		while (rV.next()) {
			System.out.println("fecha ticket: " + rV.getString("fecha"));
			System.out.println("tipo Abol: " + rV.getInt("tipo_arbol") + " Cantidad: " + rV.getInt("cantidad_arbol")
					+ "  Precio: " + rV.getFloat("precio_arbol") + "   TOTAL: "
					+ rV.getInt("cantidad_arbol") * rV.getFloat("precio_arbol"));
			System.out.println("tipo Flor: " + rV.getInt("tipo_flor") + " Cantidad: " + rV.getInt("cantidad_flor")
					+ "  Precio: " + rV.getFloat("precio_flor") + "   TOTAL: "
					+ rV.getInt("cantidad_flor") * rV.getFloat("precio_flor"));
			System.out.println("tipo Decoración: " + rV.getInt("tipo_decor") + " Cantidad: "
					+ rV.getInt("cantidad_decor") + "  Precio: " + rV.getFloat("precio_decor") + "   TOTAL: "
					+ rV.getInt("cantidad_decor") * rV.getFloat("precio_decor"));
			System.out.println("---------------------------------------------------------");
		}
	}

	public void vistaGananciasTotales(String name) throws SQLException {
		ResultSet rV = Repository.listadoCompras(name);
		float totales = 0.0f;
		System.out.println("GANANCIAS OBTENIDAS");
		while (rV.next()) {
			float totalarbol = rV.getInt("cantidad_arbol") * rV.getFloat("precio_arbol");
			float totalflor = rV.getInt("cantidad_flor") * rV.getFloat("precio_flor");
			float totaldecor = rV.getInt("cantidad_decor") * rV.getFloat("precio_decor");
			totales += (totalarbol + totalflor + totaldecor);
			System.out.println("fecha ticket: " + rV.getString("fecha"));
			System.out.println("TOTAL ARBOLES: " + totalarbol);
			System.out.println("TOTAL FLORES: " + totalflor);
			System.out.println("TOTAL DECOR: " + totaldecor);
			System.out.println("TOTAL TICKET: " + (totalarbol + totalflor + totaldecor));
			System.out.println("---------------------------------------------------------");
		}
		System.out.println("TOTAL GANANCIAS OBTENIDAS: " + totales);
	}

}
