package pooclase3ejercicio8_3;

import java.util.ArrayList;

public class Cliente {
		
		private String name;
		private String lastName;
		private ArrayList<Cuenta> cuentas;

		public Cliente(String name, String lastName) {
			this.name = name;
			this.lastName = lastName;
			this.cuentas = new ArrayList<Cuenta>();
		}

		public String getName() {
			return name;
		}

		public String getLastName() {
			return lastName;
		}

		public ArrayList<Cuenta> getCuentas() {
			return cuentas;
		}
		
		public void agregarCuenta(Cuenta cuenta) {
			this.cuentas.add(cuenta);
		}

		@Override
		public String toString() {
			return "Cliente >>> Nombre=" + name + ", Apellido=" + lastName + ", Cuentas=" + cuentas;
		}
		

		}

