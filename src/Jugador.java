import java.util.Arrays;

public class Jugador {
	String nombre, nickname;
	int edad, gemas;
	double oro;
	Vehiculo[] vehiculos;
	Vehiculo vehiculo;
	CarreraGanada carreraGanada;
	
	public Jugador(String nombre, String nickname, int edad, double oro, int gemas, Vehiculo[] vehiculos) {
		this.nombre = nombre;
		this.nickname = nickname;
		this.edad = edad;
		this.oro = oro;
		this.gemas = gemas;
		this.vehiculos = vehiculos;
	}
	
	public Jugador(String nombre, Vehiculo vehiculo) {
		this.nombre = nombre;
		this.vehiculo = vehiculo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getOro() {
		return oro;
	}

	public void setOro(double oro) {
		this.oro = oro;
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) {
		this.gemas = gemas;
	}

	public Vehiculo[] getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Vehiculo[] vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public CarreraGanada getCarreraGanada() {
		return carreraGanada;
	}

	public void setCarreraGanada(CarreraGanada carreraGanada) {
		this.carreraGanada = carreraGanada;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", nickname=" + nickname + ", edad=" + edad + ", gemas=" + gemas + ", oro="
				+ oro + ", vehiculos=" + Arrays.toString(vehiculos) + ", vehiculo=" + vehiculo + "]";
	}

	
}
