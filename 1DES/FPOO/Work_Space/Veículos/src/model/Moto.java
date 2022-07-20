package model;

public class Moto extends Veiculo{

	private int cilindradas;
	
	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}

	@Override
	public String toString() {
		return "\t[Placa\t\tModelo\t\tMarca\t\tAno do Modelo\t\tAno de Fabricação\t\tValor\t\t Cilindros]";
	}
}
