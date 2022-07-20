package model;

public class Carro extends Veiculo{

	private String tipo;
	private int passageiros;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}

	@Override
	public String toString() {
		return "\t[Placa\t\tModelo\t\tMarca\t\tAno do Modelo\t\tAno de Fabricação\t\tValor\t\tTipo\t\tQnt.Passageiros]";
	}
}
