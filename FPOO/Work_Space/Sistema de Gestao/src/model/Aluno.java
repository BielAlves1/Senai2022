package model;

import java.time.Period;
import java.util.Date;
import model.Nota;

public class Aluno {
	
	public int ra;
	public String nome;
	public Date nascimento;
	public Nota[] notas = new Nota[4];
	
	public Aluno() {}
	
	public Aluno(int ra, String nome, Date nascimento) {
		this.ra = ra;
		this.nome = nome;
		this.nascimento = nascimento;
	}
	public String obterConceito() {
		boolean aprov = false;
		for(int i = 0; i < notas.length; i++) {
			if(notas[i].obterMedia() >= 50) {
				aprov = true;
				break;
			}
		}
		if(aprov) {
			return nome+" foi APROVADO(a)!";
		} else {
			return nome+" foi REPROVADO!(a)";
		}
	}
	public int calcIdade() {
		java.util.Date hoje = new java.util.Date();  
		if(hoje.getMonth() == nascimento.getMonth()) {
			if(hoje.getDay() >= nascimento.getDay()) {
				return hoje.getYear() - nascimento.getYear();
			} else{
				return hoje.getYear() - nascimento.getYear() - 1;
			}
		}else if(hoje.getMonth() > nascimento.getMonth()) {
			return hoje.getYear() - nascimento.getYear();
		}else{
			return hoje.getYear() - nascimento.getYear() - 1;
		}
	}
}
