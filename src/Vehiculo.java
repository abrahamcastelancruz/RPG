
public class Vehiculo {
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

	@Override
	public String toString() {
		return "Vechiculo [gasolina=" + gasolina + ", potencia=" + potencia + ", neumaticos=" + neumaticos + ", color="
				+ color + "]";
	}
}
