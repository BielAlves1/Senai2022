package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Excel {

	SimpleDateFormat dfAbnt = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat dfSimples = new SimpleDateFormat("dd/MM");
	SimpleDateFormat hfAbnt = new SimpleDateFormat("HH:mm");
	SimpleDateFormat hfAmPm = new SimpleDateFormat("hh:mm:aa");
	
	public double soma(double valores[]) {
		double total = 0;
		for(int i = 0; i < valores.length; i++) {
			total += valores[i];
		}
		return total;
	}
	public double media(double valores[]) {
		double total = 0;
		for(int i = 0; i < valores.length; i++) {
			total += valores[i];
		}
		return total / valores.length;
	}
	public double maximo(double valores[]) {
		double max = 0;
		for(int i = 0; i < valores.length; i++) {
			if(max <= valores[i]) {
				max = valores[i];
			}
		}
		return max;
	}
	public double minimo(double valores[]) {
		double mini = soma(valores);
		for(int i = 0; i < valores.length; i++) {
			if(mini >= valores[i]) {
				mini = valores[i];
			}
		}
		return mini;
	}
	public String hoje() {
		Date data = new Date();
		return dfAbnt.format(data);
	}
	public String hojeSimples() {
		Date data = new Date();
		return dfSimples.format(data);
	}
	public String agora() {
		Date agora = new Date();
		return hfAbnt.format(agora);
	}
	public String agoraAmPm() {
		Date agora = new Date();
		return hfAmPm.format(agora);
	}
}
