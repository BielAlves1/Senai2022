package model;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class BuscaRand {

	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	public static void main(String[] args) throws IOException {
		System.out.println("Digite quantos núemros deseja: ");
		int num = sc.nextInt();
		int dados[] = numerosRand(num);
		
		System.out.println("Digite o número que deseja buscar: ");
		int nb = sc.nextInt();
		mostrarDados(dados);
		boolean resultado = buscaSimples(dados,nb);
		System.out.println("A busca obteve sucesso? "+resultado);
	}
	static int[] numerosRand(int n) {
		int[] x = new int[n];
		for(int i = 0; i < n; i++) {
			x[i] = rand.nextInt(1000);
			
		}
		return x;
	}
	static void mostrarDados(int[] dados) {
		for(int i = 0; i < dados.length; i++)
			System.out.println(i);
	}
	static boolean buscaSimples(int[] dados, int b) {
		for(int i = 0; i < dados.length; i++)
			if(dados[i] == b)
				return true;
		return false;
	}
}
