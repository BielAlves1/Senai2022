package model;

import java.io.IOException;
import java.util.Scanner;

public class Avaliacao {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String nome;
		double salario, desconto = 0;
		double porcent;
		System.out.println("Digite o nome do funcionário: ");
		nome = sc.nextLine();
		System.out.print("Digite o salário: ");
		salario = sc.nextDouble();
		int menu = 0;
		while(menu != 4) {
			System.out.println("1 - INSS\n2 - IRRF\n3 - FGTS\n4 - Sair.");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("|INSS|");
				System.out.println(nome);
			
				if(salario > 7087.22) {
					porcent = 0f;
				}else if(salario > 3641.03) {
					porcent = 14f;
				}else if(salario > 2427.35){
					porcent = 12f;
				}else if(salario > 1212.01){
					porcent = 9f;
				} else {
					porcent = 7.5f;		
				}
				
				System.out.println(nome);
				System.out.printf("A porcentagem aplicada é %.2f%% \n",porcent);
				System.out.printf("O desconto de INSS é %.2f\n", desconto);
				break;
			case 2:
				System.out.println("|IRRF|");
				
				if (salario > 4664.68) {
					porcent = 27.5;
					desconto = salario * (porcent/100);
				} else if (salario > 3751.06) {
					porcent = 22.5;
					desconto = salario * (porcent/100);
				}else if (salario > 2826.66) {
					porcent = 15;
					desconto = salario * (porcent/100);
				} else if (salario > 1903.99) {
					porcent = 7.5;
					desconto = salario * (porcent/100);
				} else {
					porcent = 0;
					desconto = 0;
				}
				System.out.println(nome);
				System.out.printf("Foi descontado %.2f%%",porcent);
				System.out.printf("totalizando R$%.2f", desconto);
				break;
			case 3:
				System.out.println("|FGTS|");
				break;
			case 4:
				System.out.println("Flw Mermão!");
				
				break;
			default:
				System.out.println("Presta atenção seu primata!\n");
			}
		}
	}
}
