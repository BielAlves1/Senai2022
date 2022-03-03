package model;

import java.util.Random;
import java.util.Scanner;

public class Matriz {

	static Random rand = new Random();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int menu = 0;
		while(menu != 4) {
			menu = opcoes(new String[]{"1 - |Vetor|","2 - |Matriz|","3 - |Matriz 3D|","4 -  Sair"});
			switch(menu) {
			case 1:
				System.out.println("|Vetor|");
				vetor();
				break;
			case 2:
				System.out.println("|Matriz|");
				matriz();
				break;
			case 3:
				System.out.println("|Matriz 3D|");
				matriz3D();
				break;
			case 4:
				System.out.println("Tchau!");
				break;
			default:
				System.out.println("Opção Inválida");
			}
		}
	}
	public static void vetor() {
		System.out.println("Números aleatórios no Vetor:");
		int vet[] = new int[27];
		
		for(int i = 0; i < 27; i++) {
			vet[i] = rand.nextInt(100);
			System.out.print("["+vet[i]+"] ");
		}
		System.out.println();
	}
	public static void matriz() {
		int matriz[][] = new int[3][9];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				matriz[i][j] = rand.nextInt(100);
			}
		}
		
		for(int i = 0; i < 3; i++) {
			System.out.println();
			for(int j = 0; j < 9; j++) {
				System.out.print("["+matriz[i][j]+"]");
			}
		}
		System.out.println();
	}
	public static void matriz3D() {
		System.out.println("Números aleatórios numa Matriz 3D:");
		int matriz[][][] = new int[3][3][3];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					matriz[i][j][k] = rand.nextInt(100);
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			System.out.println();
			for(int j = 0; j < 3; j++) {
				System.out.println();
				for(int k = 0; k < 3; k++) {
					System.out.print("["+matriz[i][j][k]+"]");
				}
			}
		}
		System.out.println();
	}
	public static int opcoes(String[] opcoes) {
		for(int i = 0; i < opcoes.length; i++) {
			System.out.println(opcoes[i]);
		}
		return sc.nextInt();
	}
}
