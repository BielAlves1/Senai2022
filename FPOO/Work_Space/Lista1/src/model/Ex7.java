package model;

import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		double den, vol, mas;
		
		System.out.print("Insira o volume da barra em m³: ");
		vol = entrada.nextDouble();
		System.out.print("Insira a massa da barra em Kg: ");
		mas = entrada.nextDouble();
		
		den = mas / vol;
		
		System.out.printf("A densidade da barra é de %.2fKg/m³", den);
	}
}
