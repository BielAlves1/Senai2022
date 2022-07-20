package exercicios;

import java.time.Year;
import java.util.Scanner;

public class ClassIdade {
	public static void main(String[] args) {
		//Vari�veis
		Scanner sc = new Scanner(System.in);
		int ano, idade;
		int anoAtual = Year.now().getValue();
		
		//Entrada
		System.out.print("Digite o ano em que voc� nasceu: ");
		ano = sc.nextInt();
		
		//Processamento 1
		idade = anoAtual - ano;
		
		//Processamento 2 e Sa�da
		if(idade < 12) {
			System.out.println("Voc� � uma crian�a");
		}else if(idade < 18) {
			System.out.println("Voc� � um(a) adolescente");
		}else if(idade < 21) {
			System.out.println("Voc� � um(a) Jovem");
		}else if(idade < 50) {
			System.out.println("Voc� � um(a) adulto");
		}else if(idade < 100) {
			System.out.println("Voc� � um(a) idoso");
		}else {
			System.out.println("Voc� passou da idade");
		}
		
	}
}
