package exercicios;

import java.time.Year;
import java.util.Scanner;

public class Idade2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ano, idade;
		int anoAtual = Year.now().getValue();
		
		System.out.print("Digite o ano em que você nasceu: ");
		ano = sc.nextInt();
		
		idade = anoAtual - ano; 
		
		if(idade >= 18) {
			System.out.println("Você é maior de idade");
		}else {
			System.out.println("Você é menor de idade");
		}

	}

}
