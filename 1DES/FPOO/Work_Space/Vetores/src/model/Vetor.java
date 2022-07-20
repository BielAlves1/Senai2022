package model;

import java.util.Scanner;

public class Vetor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int comprimento = 3;
		
		String[] nomes = new String[comprimento];
		int[] idades = new int[comprimento];
		
		for(int i = 0; i < comprimento; i++) {
			System.out.println("Nome[" + i + "]: ");
			nomes[i] = sc.next();
			
			System.out.println("Idade[" + i + "]: ");
			idades[i] = sc.nextInt();
		}
		for(int i = 0; i < comprimento; i++) {
			if(idades[i] < 12) {
				System.out.println(nomes[i] + " é Crianca.");
			}else if(idades[i] < 21) {
				System.out.println(nomes[i] + " é Jovem.");
			}else {
				System.out.println(nomes[i] + " é Véio");
			}
		}
	}
}
