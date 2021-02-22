import java.util.Arrays;

public class Jugador {
	String nombre, nickname;
	int edad, oro, gemas;
	Vehiculo[] vehiculos;
	
	public Jugador(String nombre, String nickname, int edad, int oro, int gemas, Vehiculo[] vehiculos) {
		this.nombre = nombre;
		this.nickname = nickname;
		this.edad = edad;
		this.oro = oro;
		this.gemas = gemas;
		this.vehiculos = vehiculos;
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

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
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

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", nickname=" + nickname + ", edad=" + edad + ", oro=" + oro + ", gemas="
				+ gemas + ", vehiculos=" + Arrays.toString(vehiculos) + "]";
	}
}
