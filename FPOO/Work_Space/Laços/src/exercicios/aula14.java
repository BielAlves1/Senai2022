package exercicios;

import java.util.Scanner;

public class aula14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, cont = 0;
		
			int menu = 0;
			while(menu != 7) {
			System.out.println("1 - Par\n2 - Impar\n3 - Maior e Menor\n4 - Fatorial\n5 - Xerox\n6 Sair");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("Digite o primeiro valor: ");
				a = sc.nextInt();
				System.out.println("Digite o segundo valor: ");
				b = sc.nextInt();
				
				if(a % 2 != 0) a++;
				for(int i = a; i <= b; i+=2) {
					System.out.println("Pares: "+i);
				}
				break;
			case 2:
				System.out.println("Digite o primeiro valor: ");
				a = sc.nextInt();
				System.out.println("Digite o segundo valor: ");
				b = sc.nextInt();
				
				if(a % 2 == 0) a++;
				for(int i = a; i <= b; i+=2) {
					System.out.println("Impares: "+i);
				}
				break;
			case 3:
				int maior = 0, menor = 0;
				for(int i = 0; i < 10; i++) {
					System.out.println("Digite o valor");
					a = sc.nextInt();
					if(i == 0) {
						maior = a;
						menor = a;
					}else {
						if(a > maior) maior = a;
						if(a < menor) menor = a;
					}
				}
				System.out.println("O maior valor entre os 10 digitados, é: "+ maior);
				System.out.println("O menor valor entre os 10 digitados, é: "+ menor);
				break;
			case 4:
				int fat = 1;
				System.out.println("Digite um número maior do que 0: ");
				a = sc.nextInt();
				for(int i = a; i >= 1; i--) {
					fat = fat * i;
				}
				System.out.println("Fatorial de "+a+"! é: "+fat);
				break;
			case 5:
				System.out.println("Digite o valor da cópia: ");
				float c = sc.nextInt();
				
				for(int i = 1; i <=200; i++) {
					System.out.printf("%d = %.2f\t", i, (c * i));
					cont++;
					if(cont == 10) {
						cont = 0;
								System.out.println();
					}
				}
				break;
			case 6:
				int sPar = 0, sImpar = 0;
				System.out.println("Digite o primeiro valor: ");
				a = sc.nextInt();
				System.out.println("Digite o segundo valor: ");
				b = sc.nextInt();
				
				for(int i = a; i <= b; i++) {
					if(i % 2 == 0) {
						sPar +=i;
					}else {
						sImpar += i;
					}
				}
				System.out.println("Soma dos pares: "+sPar);
				System.out.println("Soma dos pares: "+sImpar);
				break;
			case 7:
				System.out.println("Flw!");
				break;
			default:
				System.out.println("Opção Inválida.");

			}
		}
	}
}

