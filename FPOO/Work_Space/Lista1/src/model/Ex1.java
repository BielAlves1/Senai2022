package model;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float a, b, c, result;
		
		System.out.print("Digite o valor de A: ");
		a = sc.nextFloat();
		System.out.print("Digite o valor de B: ");
		b = sc.nextFloat();
		System.out.print("Digite o valor C: ");
		c = sc.nextFloat();
		
		result = (a + b) / c;
		
		System.out.printf("O resultado é %.2f", result);
	}
}
