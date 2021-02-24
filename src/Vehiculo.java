
public class Vehiculo {
	final String reset = "\u001B[0m";
	int gasolina;
	String potencia, neumaticos, color;
	
	public Vehiculo(int gasolina, String potencia, String neumaticos, String color) {
		this.gasolina = gasolina;
		this.potencia = potencia;
		this.neumaticos = neumaticos;
		this.color = color;
	}

	public int getGasolina() {
		return gasolina;
	}

	public void setGasolina(int gasolina) {
		this.gasolina = gasolina;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getNeumaticos() {
		return neumaticos;
	}

	public void setNeumaticos(String neumaticos) {
		this.neumaticos = neumaticos;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void mostrarVehiculo() {
		String vehiculo = "";
		vehiculo += "                  .\n";
		vehiculo += "    __            |\\\n";
		vehiculo += " __/__\\___________| \\_\n";
		vehiculo += "|   ___    |  ,|   ___`-.\n";
		vehiculo += "|  /   \\   |___/  /   \\  `-.\n";
		vehiculo += "|_| (O) |_________| (O) |____|\n";
		vehiculo += "   \\___/           \\___/\n";
		
		System.out.println(cambiarColorConsola(this.color)+vehiculo+reset);		
	}
	
	public String cambiarColorConsola(String color) {
		String colorAuto = "";
		switch (color) {
		case "Azul":
			colorAuto = "\u001B[34m";
			break;
		
		case "Rojo":
			colorAuto = "\u001B[31m";
		
		case "Verde":
			colorAuto = "\u001B[32m";

		default:
			break;
		}
		
		return colorAuto;
	}

	@Override
	public String toString() {
		return "Vechiculo [gasolina=" + gasolina + ", potencia=" + potencia + ", neumaticos=" + neumaticos + ", color="
				+ color + "]";
	}
}
