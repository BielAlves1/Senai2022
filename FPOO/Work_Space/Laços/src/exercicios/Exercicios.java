package exercicios;

import java.io.IOException;
import java.util.Scanner;

public class Exercicios {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a, b, cont = 0;
		
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
				a = sc.nextInt();
				for (int i = 0; i < a; i++) {
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
				for(int i = 0; i <= 100; i++) {
		            cont += i;
		            System.out.println(cont);
				}
				
				break;
			case 7:
				System.out.print("Digite o primeiro valor inteiro: ");
				a = sc.nextInt();
				System.out.println("Digite o segundo valor inteiro: ");
				b = sc.nextInt();
				if(a < b) {
					for(int i = a; i <= b; i++) {
			            cont += i;
			            System.out.println(cont);
					}
				}else {
					for(int i = b; i >= b; i++) {
			            cont += i;
			            System.out.println(cont);
					}
				}
				break;
			case 8:
				System.out.print("Digite o primeiro valor inteiro: ");
				a = sc.nextInt();
				System.out.println("Digite o segundo valor inteiro: ");
				b = sc.nextInt();
				for(int i = a; i <= b; i++) {
		            cont += i;
		            if(cont % 2 == 0) {
		            	System.out.println(cont);
		            }
		            
				}
				break;
			case 9:
				for(int i = 1; i <= 15; i++) {
					System.out.printf("Digite o %d° valor inteiro: ", i);
					cont += sc.nextInt();
				}
				System.out.println(cont);
				
				break;
			case 10:
				for(int i = 11; i <= 250; i++) {
					if(i % 2 == 0) {
						System.out.println(i);
					}
				}
				
		
				break;
			case 11:
				System.out.println("SHAZAM KARAI!");
				break;
			default:
				System.out.println("Opção Inválida.");
			}
		}
	}
}
