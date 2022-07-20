package model;

import java.util.Random;
import java.util.Scanner;

public class Matriz {

	public static Random rand = new Random();
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int menu = 0;
		while(menu != 4) {
			opcoes();
			menu = sc.nextInt();
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
		int[] vet = new int[27];
		
		for(int i = 0; i < 27; i++) {
			vet[i] = rand.nextInt(100);
			System.out.println("["+vet[i]+"]");
		}
	}
	public static void matriz() {
		System.out.println("Números aleatórios numa Matriz:");
		int[][] matriz = new int[3][3];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; i < 3; i++) {
				matriz[i][j] = rand.nextInt(100);
				System.out.println("["+matriz[i][j]+"]");
			}
		}
	}
	public static void opcoes() {
		String[] opcoesV = new String[4];
		opcoesV[0] = "1 - |Vetor|";
		opcoesV[1] = "2 - |Matriz|";
		opcoesV[2] = "3 - |Matriz 3D|";
		opcoesV[3] = "4 -  Sair";
		
		for(int i = 0; i < opcoesV.length; i++) {
			System.out.println(opcoesV[i]);
		}
	}
}
