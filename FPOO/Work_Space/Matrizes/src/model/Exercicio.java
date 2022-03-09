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
		int impar = 0, maiorI = 0, menorI = 101, par = 0, maiorP = 0, menorP = 101, sImp = 0, sPar = 0;
		int mImpar[][] = new int[5][5];
		int mPar[][] = new int[5][5];
		int mat[][] = new int[5][5];
		for(int i = 0; i < 5; i++) {
			System.out.println();
			for(int j = 0; j < 5; j++) {
				mat[i][j] = rand.nextInt(100);
				System.out.print("\t["+mat[i][j]+"]");
			}
		}
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(mat[i][j] % 2 != 0) {
					impar++;
					if(mat[i][j] > maiorI)
						maiorI = mat[i][j];
					if(mat[i][j] < menorI)
						menorI = mat[i][j];
					mat[i][j] = mImpar[i][j];
				}
			}
		}
		System.out.println("Entre os 25 números da Matriz, "+impar+" são Impares.");
		System.out.println("O menor valor impar é: "+menorI);
		System.out.println("O maior valor impar é: "+maiorI);
		
		for(int i = 0; i < mImpar.length; i++) {
			for(int j = 0; j < mImpar.length; j++) {
				sImp += mImpar[i][j];
			}
		}
		int mediaI = sImp / mImpar.length;
		System.out.println("Média dos números Impares :"+ mediaI);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(mImpar[i][j] % 2 == 0) {
					par++;
					if(mImpar[i][j] > maiorP)
						maiorP = mImpar[i][j];
					if(mImpar[i][j] < menorP)
						menorP = mImpar[i][j];
					mImpar[i][j] = mPar[i][j];
				}
			}
		}
		System.out.println("Entre os 25 números da Matriz "+par+" são Pares.");
		System.out.println("O menor valor par é: "+menorP);
		System.out.println("O maior valor par é: "+maiorP);
		System.out.println();
		
		for(int i = 0; i < mPar.length; i++) {
			for(int j = 0; j < mPar.length; j++) {
				sPar += mPar[i][j];
			}
		}
		int mediaP = sPar / mPar.length;
		
		System.out.println("Média dos números Pares :"+mediaP);
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
	}
}
