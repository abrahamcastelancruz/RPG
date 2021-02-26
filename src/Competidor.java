
public class Competidor implements Comparable<Competidor> {
	Jugador jugador;
	int casillas;
	Vehiculo vehiculo;
	public Competidor(Jugador jugador, int casillas, Vehiculo vehiculo) {
		this.jugador = jugador;
		this.casillas = casillas;
		this.vehiculo = vehiculo;
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public int getCasillas() {
		return casillas;
	}
	
	public void setCasillas(int casillas) {
		this.casillas = casillas;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "Competidor [jugador=" + jugador + ", casillas=" + casillas + ", vehiculo=" + vehiculo + "]";
	}

	@Override
	public int compareTo(Competidor o) {
		if (this.getCasillas() < o.casillas) {
			return -1;
		}
		
		if (this.getCasillas() > o.casillas) {
			return 1;
		}
		return 0;
	}
	
	
}
