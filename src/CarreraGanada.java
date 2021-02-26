
public class CarreraGanada {
	Competidor[] competidores;
	Pista pista;

	public CarreraGanada(Competidor[] competidores, Pista pista) {
		this.competidores = competidores;
		this.pista = pista;
	}
	
	public void ultimaCarrera() {
		System.out.print("Pista : "+this.pista.getNombre());
		System.out.println("Nombres de Rivales");
		for (int i = 0; i < this.competidores.length; i++) {
			System.out.println("Puesto : "+(i+1)+" "+this.competidores[i]+"\nDistancia : "+this.competidores[i].getCasillas());
		}
	}
}
