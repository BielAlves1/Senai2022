package model;

import java.util.Random;
import java.util.Scanner;

public class Exercicio {
	
	public static Scanner sc = new Scanner(System.in);
	public static Random rand = new Random();
	public static void main(String[] args) {
		int menu = 0;
		while(menu != 3) {
			System.out.println("1 - Exrcício\n2 - Exercício\n3 - Sair.");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				ex1();
				break;
			case 2:
				ex2();
				break;
			case 3:
				System.out.println("Tchau!");
				break;
			default:
				System.out.println("Opção Inválida.");
			}
		}

	}
	public static void ex1() {
		int matriz[][] = new int[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				matriz[i][j] = rand.nextInt(100);
			}
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println();
			for(int j = 0; j < 5; j++) {
				System.out.print("["+matriz[i][j]+"]");
			}
		}
		System.out.println();
	}
	public static void ex2() {
		String alunos_id[][] = new String[10][2];
		int notas[][] = new int[10][3];
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; i++) {
				alunos_id[i][j] = sc.next();
			}
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; i++) {
				notas[i][j] = sc.nextInt();
			}
		}
		/*int menu = 0;
		while(menu != 4) {
			System.out.println("1 - Cadastrar\n2 - Buscar\n3 - Mostrar\n4 - Sair:");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("Cadastrar");
				break;
			case 2:
				System.out.println("Buscar");
				break;
			case 3:
				System.out.println("Mostrar");
				break;
			case 4:
				System.out.println("Tchau!");
				break;
			default:
				System.out.println("Opção Inválida.");
			}
		}*/
	}
}
