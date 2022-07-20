package exemplos;

import java.io.IOException;
import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		while(opcao != 1) {
			System.out.println("Digite 1 para sair: ");
			opcao = sc.nextInt();
		}
		System.out.println("Flw!");

	}

}
