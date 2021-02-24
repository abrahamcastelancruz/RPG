import java.util.Scanner;

public class Ruleta {
	Scanner entrada = new Scanner(System.in);
	Jugador jugador;
	
	public Ruleta(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void minijuego() {
		boolean jugar;
		do {
			int gemasJugador = this.jugador.getGemas();
			jugar = bienvenida();
			if(jugar && gemasJugador >= 5) {
				this.jugador.setGemas(this.jugador.getGemas()-5);
				juego(this.jugador);
				break;
			}else {
				System.out.println("No cuentas con las gemas suficientes para jugar\nVUELVE CUANDO TENGAS AL MENOS 5 GEMAS");
			}
		}while(jugar);
	}
	
	public boolean bienvenida() {
		int op;
		do {
			System.out.println("Bienvenido a el minijuego de la ruleta");
			System.out.println("¿Deseas jugar?\n1.- Si\n2.- No");
			op = entrada.nextInt();
		}while(op < 1 || op > 2);
		return op == 1;
	}
	
	public void juego(Jugador player) {
		System.out.println("Girando la ruleta");
		for (int i = 0; i < 10; i++) {
			System.out.println(i+1);			
		}
		System.out.println(".......................");
		System.out.println("Felicidades");
		double probabilidad = Math.random();
		if (probabilidad < 0.05) {
			System.out.println("Ganaste 1000 Gemas con un ticket : "+probabilidad);
			player.setGemas(player.getGemas()+1000);
		}else if (probabilidad < 0.1) {
			System.out.println("Ganaste 2000 de Oro con un ticket : "+probabilidad);
			player.setOro(player.getOro()+2000);
		}else if (probabilidad < 0.20) {
			System.out.println("Ganaste 40 Gemas con un ticket : "+probabilidad);
			player.setGemas(player.getGemas()+40);
		}else if (probabilidad < 0.35) {
			System.out.println("Ganaste 75 de Oro con un ticket : "+probabilidad);
			player.setOro(player.getOro()+75);
		}else if (probabilidad < 0.7) {
			System.out.println("Ganaste 10 de Oro con un ticket : "+probabilidad);
			player.setOro(player.getOro()+10);
		}else {
			System.out.println("Ganaste 5 Gemas con un ticket : "+probabilidad);
			player.setGemas(player.getGemas()+5);
		}
	}
	
}
