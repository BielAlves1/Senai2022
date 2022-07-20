package modelo;

import java.util.Scanner;

public class Div {

	public static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		float val1, val2, result;
		
		System.out.print("Digite um valor real: ");
		val1 = sc.nextFloat();
		System.out.print("Digite outro valor diferente de zero: ");
		val2 = sc.nextFloat();
		
		result = val1 / val2;
		
		System.out.printf("O valor da divisão é: %.1f", result);
	}
}
