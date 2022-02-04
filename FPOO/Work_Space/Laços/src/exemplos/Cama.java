package exemplos;

import java.io.IOException;
import java.util.Scanner;

public class Cama {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int menu = 0;
		while(menu != 3) {
			System.out.println("1.Coisa\n2.E tal\n3.Sair\nEscolha:");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("Aee, vc escolheu \"Coisa\"\n");
				break;
			case 2:
				System.out.println("Aee, vc escolheu \"E tal\"\n");
				break;
			case 3:
				System.out.println("Flw Mermão!");
				break;
			default:
				System.out.println("Presta atenção seu primata!\n");
			}
		}
	}
}
