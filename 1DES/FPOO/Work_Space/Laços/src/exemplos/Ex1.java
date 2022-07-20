package exemplos;

import java.io.IOException;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("Digite 1 para sair: ");
				opcao = sc.nextInt();
		} while(opcao != 1);
		System.out.println("Flw!");
	}

}
