import java.util.Scanner;

public class Rpg {
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		if(saludo()) {
			int opcion;
			String nombre = obtenerNombre();
			String nickname = obtenerNickname();
			int edad = obtenerEdad();
			Vehiculo vehiculos[] = new Vehiculo[5];
			vehiculos[0] = vehiculoInicial();
			Jugador player = new Jugador(nombre, nickname, edad, 50, 30, vehiculos);
			do {
				opcion = menu(player);
				switch (opcion) {
					case 1:
						Competir competir = new Competir(player);
						competir.carrera();
						break;
					
					case 2:
						Ruleta ruleta = new Ruleta(player);
						ruleta.minijuego();
						break;
					
					case 3:
						Garage garage = new Garage(player);
						garage.menuGarage();
						break;
						
					case 4:
						System.out.println("Pistas");
						break;
					
					case 5:
						System.out.println("Estats");
						break;
					
					case 6:
						System.out.println("Adios");
						break;
				}
			}while(opcion != 6);
		}
	}
	
	public static boolean saludo() {
		int terminos;
		System.out.println("Bienvenido a el Juego RPG");
		do {
			System.out.println("¿Aceptas todos los terminos y condiciones?");
			System.out.println("1.- Si\n2.- No");
			terminos = entrada.nextInt();
		}while(terminos < 1 || terminos > 2);
		
		if(terminos == 1) {
			return true;
		}
		return false;
	}
	
	public static String obtenerNombre() {
		String nombre;
		do {
			System.out.println("¿Cual es tu nombre?");
			nombre = entrada.nextLine();
		}while(nombre.length() < 1);
		return nombre;
	}
	
	public static String obtenerNickname() {
		String nickname;
		do {
			System.out.println("¿Cual es será tu nickname?");
			nickname = entrada.nextLine();
		}while(nickname.length() < 1);
		return nickname;
	}
	
	public static int obtenerEdad() {
		int edad;
		do {
			System.out.println("¿Cual es tu edad?");
			edad = entrada.nextInt();
		}while(edad < 5);
		return edad;
	}
	
	public static int menu(Jugador player) {
		int op;
		do {
			System.out.println("-------- Menu ---------");
			System.out.println("Nickname : "+player.getNickname()+"\t\tOro : "+player.getOro()+"\t\tGemas : "+player.getGemas());
			System.out.println("Selecciona una opción");
			System.out.println("1.- Competir");
			System.out.println("2.- Ruleta");
			System.out.println("3.- Garage");
			System.out.println("4.- Pistas");
			System.out.println("5.- Estadísticas y Reportes");
			System.out.println("6.- Salir");
			op = entrada.nextInt();
		}while(op < 1 || op >6);
		return op;
	}
	
 	public static Vehiculo vehiculoInicial() {
		Database data = new Database();
		Vehiculo iniciales[] = new Vehiculo[3];
		int numeroVehiculo;
		
		for (int i = 0; i < iniciales.length; i++) {
			iniciales[i] = new Vehiculo(data.galonesRandom(), data.potenciasRandom(), data.neumaticosRandom(), data.colorRandom());
		}
		
		do {
			System.out.println("Selecciona un vehiculo Inicial");
			for (int i = 0; i < iniciales.length; i++) {
				iniciales[i].mostrarVehiculo();
				System.out.println(i+1+".-\nCantidad de galones iniciales : "+iniciales[i].getGasolina()
						+"\nTipo de neumáticos : "+iniciales[i].getNeumaticos()
						+"\nTipo de potencia : "+iniciales[i].getPotencia()
						+"\nColor de vehículo : "+iniciales[i].getColor());
			}
			numeroVehiculo = entrada.nextInt();
		}while(numeroVehiculo < 1 || numeroVehiculo > 3);
		return iniciales[numeroVehiculo-1];
	}
}
