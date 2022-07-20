package exercicios;

import java.time.Year;
import java.util.Scanner;

public class ClassIdade {
	public static void main(String[] args) {
		//Variáveis
		Scanner sc = new Scanner(System.in);
		int ano, idade;
		int anoAtual = Year.now().getValue();
		
		//Entrada
		System.out.print("Digite o ano em que você nasceu: ");
		ano = sc.nextInt();
		
		//Processamento 1
		idade = anoAtual - ano;
		
		//Processamento 2 e Saída
		if(idade < 12) {
			System.out.println("Você é uma criança");
		}else if(idade < 18) {
			System.out.println("Você é um(a) adolescente");
		}else if(idade < 21) {
			System.out.println("Você é um(a) Jovem");
		}else if(idade < 50) {
			System.out.println("Você é um(a) adulto");
		}else if(idade < 100) {
			System.out.println("Você é um(a) idoso");
		}else {
			System.out.println("Você passou da idade");
		}
		
	}
}
