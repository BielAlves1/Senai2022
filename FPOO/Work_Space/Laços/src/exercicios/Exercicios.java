package exercicios;

import java.io.IOException;
import java.util.Scanner;

public class Exercicios {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a, b;
		
		int menu = 0;
		while(menu != 11) {
			System.out.println("1-Programa 1\t2-Programa 2\t3-Programa 3\t4-Programa 4");
			System.out.println("5-Programa 5\t6-Programa 6\t7-Programa 7\t8-Programa 8");
			System.out.println("9-Programa 9\t10-Programa 10\t11-Sair.");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				for (int i = 10; i <= 200; i++) {
					System.out.println(i);
				}
				break;
			case 2:
				for (int i = 200; i > 0; i--) {
					System.out.println(i);
				}
				break;
			case 3:
				System.out.println("Digite um valor inteiro:");
				int valor = sc.nextInt();
				for (int i = 0; i < valor; i++) {
					System.out.println(i);
				}
				break;
			case 4:
				System.out.println("Digite o primeiro valor inteiro: ");
				 a = sc.nextInt();
				 System.out.println("Digete o segundo valor inteiro: ");
				 b = sc.nextInt();
				 
				 for (int i = a; i < b; i++) {
					 System.out.println(i);
				 }
				break;
			case 5:
				System.out.println("Digite o primeiro valor inteiro: ");
				 a = sc.nextInt();
				 System.out.println("Digete o segundo valor inteiro: ");
				 b = sc.nextInt();
				 
				 for (int i = a; i < b; i++) {
					 if(i % 2 == 0) {
						 System.out.println(i);
					 }
				 }
				break;
			case 6:
				System.out.println("");
				break;
			case 7:
				System.out.println("");
				break;
			case 8:
				System.out.println("");
				break;
			case 9:
				System.out.println("");
				break;
			case 10:
				System.out.println("");
				break;
			case 11:
				System.out.println("Shazam Karai!");
				break;
			default:
				System.out.println("Opção Inválida.");
			}
		}
	}
}
