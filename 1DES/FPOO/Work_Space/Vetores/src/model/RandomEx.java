package model;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RandomEx {

	public static Scanner sc;
	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
		
		int menu = 0;

		while(menu != 4) {
			System.out.println("1- Numeros inteiros\n2- Numeros Reais\n3- Nomes\n4- Sair");	
			menu = sc.nextInt();
			
			switch(menu) {
				case 1:
					GerarInteiro();
					break;
				case 2:
					GerarReal();
					break;
				case 3:
					GerarName();
					break;
				case 4:
					System.out.print("Flw Mermão");
					break;
				default:
					System.out.print("Opção Inválida");
					break;
			}
		}
	}
	public static void GerarInteiro() {
		sc = new Scanner(System.in);
		Random  rand = new Random();
		
		System.out.println("Digite quantos números deseja gerar: ");
		int quant = sc.nextInt();
		int[] numeros = new int[quant];
		
		for(int i = 0; i < quant; i++) {
			numeros[i] = rand.nextInt(100);
			System.out.println(numeros[i]);
			
			
		}
	}
	public static void GerarReal() {
		sc = new Scanner(System.in);
		Random  rand = new Random();
		
		System.out.println("Digite quantos números deseja gerar: ");
		int quant = sc.nextInt();
		double[] numeros = new double[quant];
		
		for(int i = 0; i < quant; i++) {
			numeros[i] = rand.nextDouble() * 100;
			System.out.printf("%.2f\n", numeros[i]);
			
			
		}
	}
	public static void GerarName() {
		sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Digite quantos nomes deseja gerar de 1 a 10: ");
		int quant = sc.nextInt();
		
		String[] nomes = {"Tuezin","MessiCareca","Boniro17","Jão","GuiGordola","MyConquister","Eduardo","Vitin","MatheuzinBundudo","MYNAMEISJHONCENNAA"};  
	
		for(int i = 0; i < quant; i++) {
			int a = rand.nextInt(nomes.length);
			System.out.println(nomes[i]);
		}
		
	}
	
}
