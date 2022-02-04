package model;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float velo, dist, h, min, resto;
		
		System.out.print("Digite a velocidade do carro: ");
		velo = sc.nextFloat();
		System.out.print("Digite a distancia a ser percorrida: ");
		dist = sc.nextFloat();
		
		resto = (dist % velo) / 100;
		h = (dist / velo) - resto;
		
		min = resto * velo;
		
		System.out.printf("Vai demorar %.0f horas e %.0f minutos", h, min);
	}
}
