import java.util.Random;

public class Database {
	Random random = new Random();
	String colores[] = {"Azul", "Rojo", "Verde"};
	String neumaticos[] = {"Calidad Baja", "Calidad Media", "Calidad Alta"};
	String potencias[] = {"Motor Básico", "Motor Medio", "Motor de Alto Rendimiento"};
	
	public String colorRandom() {
		int pos = random.nextInt(colores.length);
		return colores[pos];
	}
	
	public String neumaticosRandom() {
		int pos = random.nextInt(neumaticos.length);
		return neumaticos[pos];
	}
	
	public String potenciasRandom() {
		int pos = random.nextInt(potencias.length);
		return potencias[pos];
	}
	
	public int galonesRandom() {
		int galones = random.nextInt(101)+1;
		return galones;
	}
}
