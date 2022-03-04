package exemplos;

import java.io.IOException;
import java.util.Scanner;

public class Cama {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int menu = 0;
		while(menu != 3) {
			System.out.println("");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("");
				break;
			case 2:
				System.out.println("");
				break;
			case 3:
				System.out.println("");
				break;
			default:
				System.out.println("Opção Inválida.");
			}
		}
	}
}
