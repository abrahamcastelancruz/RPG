import java.util.Scanner;

public class Rpg {
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		//System.out.println(saludo());
		if(saludo()) {
			String nombre = obtenerNombre();
			//System.out.println(nombre);
			String nickname = obtenerNickname();
			//System.out.println(nickname);
			int edad = obtenerEdad();
			//System.out.println(nombre +" "+nickname+" "+edad);*/
			Vehiculo vehiculos[] = new Vehiculo[5];
			/*for (int i = 0; i < vehiculos.length; i++) {
				System.out.println(vehiculos[i].toString());
			}*/
			vehiculos[0] = vehiculoInicial();
			Jugador player = new Jugador(nombre, nickname, edad, 50, 30, vehiculos);
			System.out.println(player.toString());
			//System.out.println(vehiculoInicial());
			/*System.out.println(
					"Galones :"+data.galonesRandom()+
					"\nColor :"+data.colorRandom()+
					"\nNeumaticos:"+data.neumaticosRandom()+
					"\nPotencia :"+data.potenciasRandom());*/
			
			/*System.out.println(iniciales[0].getColor());
			iniciales[0].setColor("Oro");
			System.out.println(iniciales[0].getColor());*/
			
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
	
	public static Vehiculo vehiculoInicial() {
		Database data = new Database();
		Vehiculo iniciales[] = new Vehiculo[3];
		int numeroVehiculo;
		
		for (int i = 0; i < iniciales.length; i++) {
			iniciales[i] = new Vehiculo(data.galonesRandom(), data.potenciasRandom(), data.neumaticosRandom(), data.colorRandom());
			//System.out.println(iniciales[i].toString());
		}
		
		do {
			System.out.println("Selecciona un vehiculo Inicial");
			for (int i = 0; i < iniciales.length; i++) {
				System.out.println(i+1+".-\nCantidad de galones iniciales : "+iniciales[i].getGasolina()
						+"\nTipo de neumáticos : "+iniciales[i].getNeumaticos()
						+"\nTipo de potencia : "+iniciales[i].getPotencia()
						+"\nColor de vehículo : "+iniciales[i].getColor());
			}
			numeroVehiculo = entrada.nextInt();
		}while(numeroVehiculo < 1 || numeroVehiculo > 3);
		//System.out.println(iniciales[numeroVehiculo-1]);
		return iniciales[numeroVehiculo-1];
	}
}
