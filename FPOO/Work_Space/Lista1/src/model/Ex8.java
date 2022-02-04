package model;

import java.util.Scanner;

public class Ex8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int resto, a, b;
		
		System.out.print("Digite o primeiro valor: ");
		a = sc.nextInt();
		System.out.print("Digite o segundo valor: ");
		b = sc.nextInt();
		
		resto = a % b;
		
		System.out.println("O resto da divisão é de " + resto);
	}
}
