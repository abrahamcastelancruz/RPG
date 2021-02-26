import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Competir {
	Scanner entrada = new Scanner(System.in);
	Random random = new Random();
	Database database = new Database();
	Jugador jugador;
	
	public Competir(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void carrera() {
		System.out.println("Bienvenido a la competición");
		Pista pista = seleccionarPista();
		Vehiculo vehiculo = seleccionarVehiculo(pista.getCasillas());
		if(vehiculo != null) {
			Jugador[] jugador = new Jugador[1];
			jugador[0] = this.jugador;
			jugador[0].setVehiculo(vehiculo);
			int cantidadRivales = cantidadRivales();
			Jugador[] rivales = crearRivales(cantidadRivales, pista.getCasillas());
			Jugador[] jugadores = Stream.of(rivales, jugador).flatMap(Stream::of).toArray(Jugador[]::new);
			Competidor[] competidores = competidores(jugadores);
			Competidor primerLugar;
			int op;
			boolean revancha;
			do {
				int ronda = 1;
				do {
					competidores = turnos(competidores);
					competidores = avance(competidores, pista);
					Arrays.sort(competidores, Collections.reverseOrder());
					primerLugar = competidores[0];
				}while(primerLugar.getCasillas() <= pista.getCasillas());
				
				for (int i = 0; i < competidores.length; i++) {
					System.out.println((i+1)+".- Lugar\nNombre : "+competidores[i].getJugador().getNombre()
							+"\nCasillas avanzadas : "+competidores[i].getCasillas());				
				}
				do {
					System.out.println("¿Desea una revancha?");
					System.out.println("1.- Si\n2.- No");
					op = entrada.nextInt();
					revancha = (op ==1) ? true : false;	
				}while(op < 1 || op > 2);
				for (int i = 0; i < competidores.length; i++) {
					competidores[i].setCasillas(0);
					competidores[i].getVehiculo().setGasolina(pista.getCasillas());
				}
				System.out.println(revancha);
			}while(revancha);
		}
	}
	
	public Competidor[] avance(Competidor[] competidores, Pista pista) {
		int coeficientePista = pista.getCoeficiente();
		Competidor[] competidoresAvance = competidores;
		for (int i = 0; i < competidores.length; i++) {
			int potencia = potencia(competidores[i].getVehiculo().getPotencia());
			int coeficienteNeumaticos = coeficienteNeumaticos(competidores[i].getVehiculo().getNeumaticos());
			int avance = (potencia*random.nextInt(9))+coeficientePista+(coeficienteNeumaticos*random.nextInt(4));
			competidores[i].getVehiculo().setGasolina(competidores[i].getVehiculo().getGasolina()-avance);
			competidores[i].setCasillas(competidores[i].getCasillas()+avance);
		}
		return competidoresAvance;
	}
	
	public int coeficienteNeumaticos(String llantas) {
		int coeficiente = 0;
		switch (llantas) {
		case "Calidad Baja":
			coeficiente = 2;
			break;
		
		case "Calidad Media":
			coeficiente = 3;
			break;

		case "Calidad Alta":
			coeficiente = 5;
			break;
		}
		return coeficiente;
	}
	
	public int potencia(String motor) {
		int potencia = 0;
		switch (motor) {
		case "Motor Básico":
			potencia = 4;
			break;
		
		case "Motor Medio":
			potencia = 5;
			break;

		case "Motor de Alto Rendimiento":
			potencia = 7;
			break;
		}
		return potencia;
	}
	
	public Competidor[] competidores(Jugador[] jugadores) {
		Jugador[] jugadoresIniciales = jugadores;
		Competidor[] competidores = new Competidor[jugadores.length];
		
		for (int i = 0; i < competidores.length; i++) {
			competidores[i] = new Competidor(jugadoresIniciales[i], 0, jugadoresIniciales[i].getVehiculo());			
		}
		return competidores;
	}
		
	public Competidor[] turnos(Competidor[] competidores) {
		Competidor[] jugadores = new Competidor[competidores.length];
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i] = competidores[i];
		}
		
		for (int i = 0; i < jugadores.length; i++) {
			int ordernAleatorio = random.nextInt(jugadores.length);
			Competidor temp = jugadores[i];
			
			jugadores[i] = jugadores[ordernAleatorio];
			jugadores[ordernAleatorio] = temp;
		}
		
		return jugadores;		
	}
	
	public Jugador[] crearRivales(int cantidad, int casillas) {
		Jugador[] rivales = new Jugador[cantidad];
		
		for (int i = 0; i < rivales.length; i++) {
			rivales[i] = new Jugador(database.nombresRandom(), vehiculoRival(casillas));
		}
		
		return rivales;
	}
	
	public Vehiculo vehiculoRival(int casillas) {
		Vehiculo vehiculo = new Vehiculo(database.galonesRandomRival(casillas), database.potenciasRandom(), database.neumaticosRandom(), database.colorRandom());
		return vehiculo;
	}
	
	public int cantidadRivales() {
		int rivales;
		do {
			System.out.println("¿Con cuantos rivales deseas competir?");
			for (int i = 0; i < 5; i++) {
				System.out.println((i+1)+".- "+(i+1)+" Rivales");				
			}
			rivales = entrada.nextInt();
		}while(rivales < 1 || rivales > 5);
		return rivales;
	}
	
	public Vehiculo seleccionarVehiculo(int galones) {
		int carroSeleccionado = 0;
		boolean aptos = false;
		System.out.println("Selecciona un vehículo para competir");
		do {
			for (int i = 0; i < this.jugador.getVehiculos().length; i++) {
				if(this.jugador.vehiculos[i] != null && this.jugador.vehiculos[i].getGasolina() >= galones) {
					this.jugador.vehiculos[i].mostrarVehiculo();
					System.out.println((i+1)+".-\nGasolina : "+this.jugador.vehiculos[i].getGasolina()
							+"\nPotencia : "+this.jugador.vehiculos[i].getPotencia()
							+"\nNeumáticos : "+this.jugador.vehiculos[i].getNeumaticos()
							+"\nColor : "+this.jugador.vehiculos[i].getColor());
					aptos = true;
				}
			}
			if(!aptos) {
				System.out.println("No cuentas con vehículos disponibles");
				break;
			}
			carroSeleccionado = entrada.nextInt();	
		}while(carroSeleccionado < 1 || carroSeleccionado > 5);
		if(aptos) {
			return this.jugador.vehiculos[carroSeleccionado-1];
		}
		return null;
	}
	
	public Pista seleccionarPista() {
		int pistaSeleccionada;
		do {
			System.out.println("Selecciona una pista para la carrera");
			System.out.println("1.- Tierra\n2.- Arena\n3.- Concreto");
			pistaSeleccionada = entrada.nextInt();
		}while(pistaSeleccionada < 1 || pistaSeleccionada > 3);
	
		Pista pista = null;
		
		switch (pistaSeleccionada) {
		case 1:
			pista = new Tierra();
			break;
		
		case 2:
			pista = new Arena();
			break;

		case 3:
			pista = new Concreto();
			break;
		}
		
		return pista;
	}
	
}
