package model;

import java.sql.Date;

public class Aluno {
	public int ra;
	public String nome;
	public Date nascimento;
	public Nota[] notas = new Nota[4];
	
	Aluno(){}
	
	Aluno(int id, String nome){
		this.ra = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.notas = notas;
	}
	
	public String contatoTab() {
		return ra+"\t"+nome+"\t"+nascimento+"\t"+notas;
	}
}
