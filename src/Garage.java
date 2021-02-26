import java.util.Scanner;

public class Garage {
	Database database = new Database();
	Scanner entrada  = new Scanner(System.in);
	Jugador jugador;
	
	public Garage(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void menuGarage() {
		Vehiculo vehiculoActual = seleccionarVehiculo();
		int op;
		do {
			op = mostrarOpciones();
			switch (op) {
			case 1:
				mejoraPotencia(vehiculoActual);
				break;
			
			case 2:
				llenarTanque(vehiculoActual);
				break;

			case 3:
				mejoraNeumaticos(vehiculoActual);
				break;	
				
			case 4:
				cambioColor(vehiculoActual);
				break;
			
			case 5:
				mostrarVehiculoActual(vehiculoActual);
				break;

				
			case 6:
				comprarVehiculo();
				break;	
				
			case 7:
				seleccionarVehiculo();
				break;	
			}
		}while(op != 8);
	}
	
	public void comprarVehiculo() {
		if(vehiculosReales() < 5) {
			Vehiculo[] vehiculosCompra = new Vehiculo[6];
			int vehiculoComprado;
			for (int i = 0; i < vehiculosCompra.length; i++) {
				vehiculosCompra[i] = new Vehiculo(database.galonesRandom(), database.potenciasRandom(), database.neumaticosRandom(), database.colorRandom());				
			}
			
			do {
				System.out.println("Selecciona un vehículo");
				for (int i = 0; i < vehiculosCompra.length; i++) {
					vehiculosCompra[i].mostrarVehiculo();
					System.out.println((i+1)+".-\nGasolina : "+vehiculosCompra[i].getGasolina()
							+"\n Potencia : "+vehiculosCompra[i].getPotencia()
							+"\n Neumáticos : "+vehiculosCompra[i].getNeumaticos()
							+"\n Color : "+vehiculosCompra[i].getColor());
				}
				vehiculoComprado = entrada.nextInt();
			}while(vehiculoComprado < 1 || vehiculoComprado > 6);
			
			int gemas = this.jugador.getGemas();
			
			if(gemas >= 10) {
				for (int i = 0; i < this.jugador.vehiculos.length; i++) {
					if(this.jugador.vehiculos[i] == null) {
						this.jugador.vehiculos[i] = vehiculosCompra[vehiculoComprado-1];
						break;
					}
				}
				System.out.println("Vehículo comprado");
				this.jugador.setGemas(this.jugador.getGemas()-10);
			}else {
				System.out.println("No cuentas con suficientes gemas");
			}
		}else {
			System.out.println("No puede comprar más vehículos");
		}
	}
	
	public int vehiculosReales() {
		int cantidad = 0;
		for (int i = 0; i < this.jugador.vehiculos.length; i++) {
			if(this.jugador.vehiculos[i] != null) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public void llenarTanque(Vehiculo vehiculo) {
		int galones = vehiculo.getGasolina();
		int galonesCompra;
		do {
			System.out.println("Ingresa la contidad de galones que deseas comprar");
			galonesCompra = entrada.nextInt();
		}while(galonesCompra < 1 || galonesCompra > 100);
		
		if(!((galones + galonesCompra ) > 100)) {
			double oro = this.jugador.getOro();
			double total = galonesCompra * 2.5;
			if(oro >= total) {
				System.out.println("Llenando tanque");
				for (int i = 0; i < 10; i++) {
					System.out.println(i+1);
				}
				this.jugador.setOro(this.jugador.getOro()-total);
				vehiculo.setGasolina(vehiculo.getGasolina()+galonesCompra);
			}else {
				System.out.println("No cuentas con suficiente oro para "+galonesCompra+" galones");
			}
		}else {
			System.out.println("El vechículo no tiene capacidad para más de 100 galones");
		}
	}
	
	public void cambioColor(Vehiculo vehiculo) {
		int color;
		do {
			System.out.println("Selecciona un color");
			for (int i = 0; i < database.colores.length; i++) {
				System.out.println((i+1)+".- "+database.colores[i]);
			}
			color = entrada.nextInt();
		}while(color < 1 || color > database.colores.length);
		String colorActual = vehiculo.getColor();
		String colorNuevo = database.colores[color-1];
		if(!colorActual.equals(colorNuevo)) {
			double oro = this.jugador.getOro();
			if(colorNuevo.equals("Azul") && oro >= 20) {
				System.out.println("Cambiando el color");
				for (int i = 0; i < 10; i++) {
					System.out.println(i+1);
				}
				this.jugador.setOro(this.jugador.getOro()-20);
				vehiculo.setColor(colorNuevo);
			}else if(colorNuevo.equals("Rojo") && oro >= 20) {
				System.out.println("Cambiando el color");
				for (int i = 0; i < 10; i++) {
					System.out.println(i+1);
				}
				this.jugador.setOro(this.jugador.getOro()-20);
				vehiculo.setColor(colorNuevo);
			}else if(colorNuevo.equals("Verde") && oro >= 20) {
				System.out.println("Cambiando el color");
				for (int i = 0; i < 10; i++) {
					System.out.println(i+1);
				}
				this.jugador.setOro(this.jugador.getOro()-20);
				vehiculo.setColor(colorNuevo);
			}else {
				System.out.println("No cuentas con suficiente oro para el cambio de color");
			}
		}else {
			System.out.println("El vehículo ya tiene ese color");
		}
	}
	
	public void mejoraNeumaticos(Vehiculo vehiculo) {
		int neumaticos;
		do {
			System.out.println("Selecciona una mejora de neumaticos");
			for (int i = 0; i < database.neumaticos.length; i++) {
				System.out.println((i+1)+".- "+database.neumaticos[i]);
			}
			neumaticos = entrada.nextInt();
		}while(neumaticos < 1 || neumaticos > database.neumaticos.length);
		String neumaticosActuales = vehiculo.getNeumaticos();
		String neumaticosNuevos = database.neumaticos[neumaticos-1];
		if (!neumaticosActuales.equals(neumaticosNuevos)) {
			double oro = this.jugador.getOro();
			if(neumaticosNuevos.equals("Calidad Baja") && oro >= 25) {
				System.out.println("Modificando los neumáticos");
				for (int i = 0; i < 10; i++) {
					System.out.println(i+1);
				}
				this.jugador.setOro(this.jugador.getOro()-25);
				vehiculo.setNeumaticos(neumaticosNuevos);
			}else if(neumaticosNuevos.equals("Calidad Media") && oro >= 50) {
				System.out.println("Modificando los neumáticos");
				for (int i = 0; i < 10; i++) {
					System.out.println(i+1);
				}
				this.jugador.setOro(this.jugador.getOro()-50);
				vehiculo.setNeumaticos(neumaticosNuevos);
			}else if(neumaticosNuevos.equals("Calidad Alta") && oro >= 75) {
				System.out.println("Modificando los neumáticos");
				for (int i = 0; i < 10; i++) {
					System.out.println(i+1);
				}
				this.jugador.setOro(this.jugador.getOro()-75);
				vehiculo.setNeumaticos(neumaticosNuevos);
			}else {
				System.out.println("No cuentas con suficiente oro para la mejora");
			}
		}else {
			System.out.println("No se pueden comprar los mismos neumáticos");
		}
	}
	
	public void mejoraPotencia(Vehiculo vehiculo) {
		int potencia;
		do {
			System.out.println("Selecciona una mejora de potencia");
			for (int i = 0; i < database.potencias.length; i++) {
				System.out.println((i+1)+".- "+database.potencias[i]);
			}
			potencia = entrada.nextInt();
		}while(potencia < 1 || potencia > database.potencias.length);
		String motorActual = vehiculo.getPotencia();
		String motorNuevo = database.potencias[potencia-1];
		if (!motorActual.equals(motorNuevo)) {
			int gemas = this.jugador.getGemas();
			if(motorNuevo.equals("Motor Básico") && gemas >= 5) {
				System.out.println("Modificando la potencia");
				for (int i = 0; i < 10; i++) {
					System.out.println(i+1);
				}
				this.jugador.setGemas(this.jugador.getGemas()-5);
				vehiculo.setPotencia(motorNuevo);
			}else if(motorNuevo.equals("Motor Medio") && gemas >= 20) {
				System.out.println("Modificando la potencia");
				for (int i = 0; i < 10; i++) {
					System.out.println(i+1);
				}
				this.jugador.setGemas(this.jugador.getGemas()-20);
				vehiculo.setPotencia(motorNuevo);
			}else if (motorNuevo.equals("Motor de Alto Rendimiento") && gemas >= 35) {
				System.out.println("Modificando la potencia");
				for (int i = 0; i < 10; i++) {
					System.out.println(i+1);
				}
				this.jugador.setGemas(this.jugador.getGemas()-35);
				vehiculo.setPotencia(motorNuevo);
			}else {
				System.out.println("No cuentas con suficientes gemas para la mejora");
			}
		}else {
			System.out.println("No se puede comprar el mismo motor");
		}
	}
	
	public void mostrarVehiculoActual(Vehiculo vehiculo) {
		vehiculo.mostrarVehiculo();
		System.out.println("Gasolina : "+vehiculo.getGasolina()
		+"\nPotencia : "+vehiculo.getPotencia()
		+"\nNeumáticos : "+vehiculo.getNeumaticos()
		+"\nColor : "+vehiculo.getColor());
	}
	
	public int mostrarOpciones() {
		int opcinesMenu;
		do {
			System.out.println("Bienvenido a el garage");
			System.out.println("1.- Mejora de Potencia");
			System.out.println("2.- Llenar el tanque de gasolina");
			System.out.println("3.- Mejora de Neumáticos");
			System.out.println("4.- Cambiar color");
			System.out.println("5.- Ver carro actual");
			System.out.println("6.- Comprar un vehículo nuevo");
			System.out.println("7.- Cambiar vehículo");
			System.out.println("8.- Volver al menú principal");
			opcinesMenu = entrada.nextInt();
		}while(opcinesMenu <  1 || opcinesMenu > 8);
		return opcinesMenu;
	}
	
	public Vehiculo seleccionarVehiculo() {
		int carroSeleccionado = 0;
		System.out.println("Selecciona un vehículo a modificar");
		do {
			for (int i = 0; i < this.jugador.getVehiculos().length; i++) {
				if(this.jugador.vehiculos[i] != null) {
					this.jugador.vehiculos[i].mostrarVehiculo();
					System.out.println((i+1)+".-\nGasolina : "+this.jugador.vehiculos[i].getGasolina()
							+"\nPotencia : "+this.jugador.vehiculos[i].getPotencia()
							+"\nNeumáticos : "+this.jugador.vehiculos[i].getNeumaticos()
							+"\nColor : "+this.jugador.vehiculos[i].getColor());
				}
			}
			carroSeleccionado = entrada.nextInt();	
		}while(carroSeleccionado < 1 || carroSeleccionado > 5);
		return this.jugador.vehiculos[carroSeleccionado-1];
	}
}
