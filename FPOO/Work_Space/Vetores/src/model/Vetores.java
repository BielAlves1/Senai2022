package model;

import java.util.Scanner;
import java.util.Arrays;


public class Vetores {

	static Scanner sc = new Scanner(System.in);
	static int[] num =  new int[10];
	static int[] num2 =  new int[10];
	static double[] numeros = new double[10];
	static String[] c = new String[10];
	static int size;
	public static void main(String[] args) {
		
		int menu = 0;
		while(menu != 8) {
			System.out.println("\n\n1 - Ex1\n2 - Ex2\n3 - Ex3\n4 - Ex4\n5 - Ex5\n6 - Ex6\n7 - Ex7\\n8 - Sair");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				ex1();
				break;
			case 2:
				ex2();
				break;
			case 3:
				ex3();
				break;
			case 4:
				ex4();
				break;
			case 5:
				ex5();
				break;
			case 6:
				ex6();
				break;
			case 7:
				ex7();
				break;
			case 8:
				System.out.println("Tchau!");
				break;
			default:
				System.out.println("Opção Inválida.");
			}
		}
	}
	public static void ex1() {
		for(int i = 0; i < num.length; i++) {
			System.out.println("Digite um número: ");
			num[i] = sc.nextInt();
		}
		System.out.println();
		System.out.println("Sentido normal: ");
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
		System.out.println("Sentido inverso: ");
		for(int i = num.length - 1; i >= 0 ; i--) {
			System.out.print(num[i] + " ");
		}
	}
	public static void ex2() {
		for(int i = 0; i < num.length; i++) {
			System.out.println("Digite um número: ");
			num[i] = sc.nextInt();
		}
		
		for(int i = num.length - 1; i >= 0 ; i--) {
			num2[9-i] = num[i];
		}
		System.out.println("1° Vetor: ");
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
		System.out.println("2° Vetor: ");
		for(int i = 0; i < num2.length; i++) {
			System.out.print(num2[i] + " ");
		}	
	}
	public static void ex3() {
		for(int i = 0; i < num.length; i++) {
			System.out.println("Digite um número inteiro: ");
			num[i] = sc.nextInt();
		}
		
		for(int i = 0; i < num.length; i++) {
			if(i % 2 == 0) {
				numeros[i] = (double) num[i] / 2;
			}else {
				numeros[i] = (double) num[i] * 3;
			}
		}
		System.out.println();
		System.out.println("1° Vetor: ");
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
		System.out.println("2° Vetor: ");
		for(int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
	}
	public static void ex4() {
		String nome;
		for(int i = 0; i < c.length; i++) {
			System.out.println("Digite um nome: ");
			c[i] = sc.next();
		}
		boolean busca = false;
		System.out.println("Digite o nome a ser buscado: ");
		nome = sc.next();
		for(int i = 0; i < c.length; i++) {
			if(c[i].equals(nome)) {
				System.out.println("ACHEI o nome");
				busca = true;
			}
		}
		if(!busca) {
			System.out.println("NÃO ACHEI o nome._.");
		}
	}
	public static void ex5() {
		int size2 = 20;
		int[] vet = new int[size2];
		int[] vet2 = new int[size2];
		int[] vet3 = new int[size2];
		int[] vet4 = new int[size2];
		int[] vet5 = new int[size2];
		
		System.out.println("Preencha o primeiro Vetor.");
		for (int i = 0; i < size2; i++) {
			System.out.println("Digite um número inteiro: ");
			vet[i] = sc.nextInt();
		}
		System.out.println("Preencha o segundo Vetor.");
		for (int i = 0; i < size2; i++) {
			System.out.println("Digite um número inteiro: ");
			vet2[i] = sc.nextInt();
		}
		System.out.println("1° Vetor: ");
		for (int i = 0; i < size2; i++) {
			System.out.print("["+vet[i]+"] ");
		}
		System.out.println();
		System.out.println("2° Vetor: ");
		for (int i = 0; i < size2; i++) {
			System.out.print("["+vet2[i]+"] ");
		}
		System.out.println();
		System.out.println("3° Vetor: ");
		for (int i = 0; i < size2; i++) {
			vet3[i] = vet2[i] - vet[i];
			System.out.print("["+vet3[i]+"] ");
		}
		System.out.println();
		System.out.println("4° Vetor: ");
		for (int i = 0; i < size2; i++) {
			vet4[i] = vet2[i] + vet[i];
			System.out.print("["+vet4[i]+"] ");
		}
		System.out.println();
		System.out.println("5° Vetor: ");
		for (int i = 0; i < size2; i++) {
			vet5[i] = vet2[i] * vet[i];
			System.out.print("["+vet5[i]+"] ");
		}
	}
	public static void ex6() {
		System.out.println("Digite o tamanho do vetor: ");
		size = sc.nextInt();
		
		int[] vetor = new int[size];
		int quantImp = 0, quantPar = 0;
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite um número: ");
			vetor[i] = sc.nextInt();
			if(vetor[i] % 2 == 0) {
				quantPar++;
			} else {
				quantImp++;
			}
		}
		int[] impar = new int[quantImp];
		int[] par = new int[quantPar];
		
		for (int i = 0; i < par.length; i++) {
			par[i] = 1;
		}
		
		for (int i = 0; i < impar.length; i++) {
			impar[i] = 0;
		}
		
		for (int i = 0; i < vetor.length; i++) {
			if(vetor[i] % 2 == 0) {
				for (int j = 0; j < par.length; j++) {
					if(par[j] == 1) {
						par[j] = vetor[i];
						break;
					}
				}
			} else {
				for (int j = 0; j < impar.length; j++) {
					if(impar[j] == 0) {
						impar[j] = vetor[i];
						break;
					}
				}
			}
		}
		
		Arrays.sort(par);
		Arrays.sort(impar);
		
		System.out.println("Pares: ");
		for (int i = 0; i < par.length; i++) {
			System.out.print(par[i] + " ");
		}
		System.out.println();
		System.out.println("\nImpares: ");
		for (int i = impar.length - 1; i >= 0; i--) {
			System.out.print(impar[i]+" ");
		}
	}
	public static void ex7() {
		System.out.println("Digite o tamanho dos dois vetores:");
		size = sc.nextInt();
				
		int[] vetor1 = new int[size];
		int[] vetor2 = new int[size];
		
		System.out.println("1° Vetor: ");
		for (int i = 0; i < size; i++) {
			System.out.println("Digite um número: ");
			vetor1[i] = sc.nextInt();
		}
		
		System.out.println("\n2° Vetor: ");
		for (int i = 0; i < size; i++) {
			System.out.println("Digite um número: ");
			vetor2[i] = sc.nextInt();
		}
		
		boolean igual = false;
		for (int i = 0; i < size; i++) {
			if(vetor1[i] == vetor2[i]) {
				igual = true;
			} else {
				igual = false;
				break;
			}
		}
		if (igual) {
			System.out.println("O conteúdo é Igual!");
		} else {
			System.out.println("O conteúdo é diferente!");
		}
	}
}
