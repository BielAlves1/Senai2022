package model;

import java.util.Scanner;

public class Media {
	
	public static Scanner sc;
	public static void main(String[] args) {
	
		sc = new Scanner(System.in);
		float nota1, nota2, mediaR;
		
		System.out.println("Digite a primeira nota:");
		nota1 = sc.nextFloat();
		System.out.println("Digite a secunda nota:");
		nota2 = sc.nextFloat();
		
		mediaR = (nota1 + nota2) / 2;
		
		System.out.println("A média é: "+ mediaR);		
		if(mediaR >= 5) {
			System.out.println("Aluno aprovado");
		}else {
			System.out.println("Aluno reprovado");
		}
	}
}
