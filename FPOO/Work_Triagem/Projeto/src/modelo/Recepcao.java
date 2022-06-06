package modelo;

public class Recepcao {

	String nome;
	String data;
	String horario;
	String medico;

	
	public Recepcao(String nome, String data, String horario, String medico) {

		this.nome = nome;
		this.data = data;
		this.horario = horario;
		this.medico = medico;
	}

	public Recepcao(String linha) {

		this.nome = linha.split(";")[0];
		this.data = linha.split(";")[1];
		this.horario = linha.split(";")[2];
		this.medico = linha.split(";")[3];
	}

	public Recepcao(int id) {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String toString() {
		return "nome:" + nome + "\t" + data + "\t" + horario + "\t" + medico
				+ "\t" + "\n";
	}

	public String toCSV() {
		return nome + ";" + data + ";" + horario + ";" + medico + ";" + "\r\n";
	}

	public String getId(String string) {
		return null;
	}

}