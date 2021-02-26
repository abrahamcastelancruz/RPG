public class Estadisticas {
	Jugador jugador;

	public Estadisticas(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void estadisticasCarrera() {
		this.jugador.carreraGanada.ultimaCarrera();
	}
}
