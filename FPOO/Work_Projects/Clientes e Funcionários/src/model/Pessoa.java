package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

	private String nome, telefone;
	private Date nascimento;
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	@Override
	public String toString() {
		return "\t\t"+nome+"\t\t\t"+telefone+"\t\t"+df.format(nascimento);
	}
	
}
