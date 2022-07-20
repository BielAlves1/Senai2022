package model;

import java.io.IOException;
import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int k = 10, m2;
		double custoUni = 130.00, metros = 3.7;
		
		System.out.println("Digite a �rea, em m�, a ser revestida: ");
		m2 = sc.nextInt();
		
		int pacotes = (int) Math.ceil(m2 / metros);
		double custo = pacotes * custoUni;
		
		System.out.printf("Voc� precisar� de %d pacotes.\n", pacotes);
		System.out.printf("O que custar� %.2f pacotes.\n", pacotes);
	}
}
