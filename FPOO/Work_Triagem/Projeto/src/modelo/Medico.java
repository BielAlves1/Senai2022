package modelo;

import java.util.Objects;

public class Medico {
	
	private int id;
	private String nome, data, horario, medico, diagnostico, recomendacao;
	
	public Medico(int id) {
		this.id = id;
	}

	public Medico(int id, String nome, String data, String horario, String medico, String diagnostico, String recomendacao) {
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.horario = horario;
		this.medico = medico;
		this.diagnostico = diagnostico;
		this.recomendacao = recomendacao;
	}

	public Medico(String linha) {
		this.id = Integer.parseInt(linha.split(";")[0]);
		this.nome = linha.split(";")[1];
		this.data = linha.split(";")[2];
		this.horario = linha.split(";")[3];
		this.medico = linha.split(";")[4];
		this.diagnostico = linha.split(";")[5];
		this.recomendacao = linha.split(";")[6];
	}

	
	
	public int getId() {
		return id;
	}
	
	public String getId(String s) {
		return String.format("%d", id);
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDiagnostico() {
		return diagnostico;
	}

	public String setDiagnostico(String diagnostico) {
		return this.diagnostico = diagnostico;
	}

	public String getRecomendacao() {
		return recomendacao;
	}

	public String setRecomendacao(String recomendacao) {
		return this.recomendacao = recomendacao;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return id + "\t" + nome + "\t" + data + "\t" + horario + "\t" + medico
				+ "\t" + diagnostico + "\t" + recomendacao +"\n";
	}

	public String toCSV() {
		return id + ";" + nome + ";" + data + ";" + horario + ";" + medico + ";" + diagnostico + ";" + recomendacao + "\r\n";
	}
}