package model;

import java.util.Scanner;

public class Ex3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int filhos;
		double salario, beneficio;
		
		System.out.print("Digite seu salario: ");
		salario = sc.nextDouble();
		System.out.print("Digite o numero de filhos caso sejam menores de 14 anos: ");
		filhos = sc.nextInt();
	
		beneficio = filhos * 56.47;
		
		if (salario > 1655.98) {
			System.out.println("Voc� n�o pode receber o benef�cio");
		} else {
			System.out.printf("O benef�cio recebido vai ser de R$%.2f", beneficio);
		}
	}

}
