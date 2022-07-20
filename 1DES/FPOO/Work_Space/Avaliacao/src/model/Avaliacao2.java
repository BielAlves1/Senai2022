package model;

import java.io.IOException;
import java.util.Scanner;

public class Avaliacao2 {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		
		int menu = 0;
		while(menu != 5) {
			opcoes();
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				calcHEX();
				break;
			case 2:
				apuracao();
				break;
			case 3:
				materiasP();
				break;
			case 4:
				bloco();
				break;
			case 5:
				System.out.println("Vlw, Flw!");
			default:
				System.out.println("Opção Inválida");
			}
		}
	}
	public static void calcHEX() {
		double valorH = 5.625, valorHEX = valorH + (valorH * 0.75), salario, salarioR;
		int totalH, totalHEX;
		
		System.out.println("Informe o total de horas trabalhadas no mês: ");
		totalH = sc.nextInt();
		System.out.println("Informe o total de horas extras trabalhadas no mês: ");
		totalHEX = sc.nextInt();
		
		salario = totalH * valorH;
		salarioR = salario + (totalHEX * valorHEX);
		
		System.out.printf("Salário: R$%.2f\n", salario);
		System.out.printf("Salário reajustado com as horas extras: R$%.2f\n\n", salarioR);
	}
	public static void apuracao() {
		System.out.println("|Apuração|");
		int size = 6;
		
		String[] escolas = new String[size];
		float[] pontosB = new float[size];
		float[] pontosS = new float[size];
		float[] pontosF = new float[size];
		float[] media = new float[size];
		
		for(int i = 1; i < size; i++) {
			System.out.println("Nome da[" + i + "°] escola: ");
			escolas[i] = sc.next();
			System.out.println("Pontos de Bateria de 0 a 10: ");
			pontosB[i] = sc.nextFloat();
			System.out.println("Pontos de Samba-Enredo de 0 a 10: ");
			pontosS[i] = sc.nextFloat();
			System.out.println("Pontos de Fantasias de 0 a 10: ");
			pontosF[i] = sc.nextFloat();
			media[i] = (pontosB[i] + pontosS[i] + pontosF[i]) / 3; 
		}
		for(int i = 1; i < size; i++) {
			System.out.printf("Escola "+ escolas[i] +" com média de pontos: %.1f\n",media[i]);
		}
			if (media[1] > media[2] && media[1] > media[3] && media[1] > media[4] && media[1] > media[5]) {
				System.out.println("Escola " +escolas[1]+ " é a campeã");
			} else if (media[2] > media[1] && media[2] > media[3] && media[2] > media[4] && media[2] > media[5]) {
				System.out.println("Escola " +escolas[2]+ " é a campeã");
			} else if (media[3] > media[1] && media[3] > media[2] && media[3] > media[4] && media[3] > media[5]) {
				System.out.println("Escola " +escolas[3]+ " é a campeã");
			}else if (media[4] > media[1] && media[4] > media[2] && media[4] > media[3] && media[4] > media[5]) {
				System.out.println("Escola " +escolas[4]+ " é a campeã");
			}else if (media[5] > media[1] && media[5] > media[2] && media[5] > media[3] && media[5] > media[4]) {
				System.out.println("Escola " +escolas[5]+ " é a campeã");
			}else {
				System.out.println("Empate.");
			}
	}
	public static void materiasP() {
		
		String[] vetor_materias_primas = new String[3];
		vetor_materias_primas[0] = "Lantejoulas";
		vetor_materias_primas[1] = "Penas de Avestruz";
		vetor_materias_primas[2] = "Tecido de seda";
		
		Double[] valor_gasto = new Double[3];
		Double[] valor_estimado = new Double[3];
		int[] kg = new int[3];
		
		for(int i = 0; i < vetor_materias_primas.length; i++) {
			System.out.println(
					"Valor gasto do material " + vetor_materias_primas[i] + ": ");
			valor_gasto[i] = sc.nextDouble();
			
			System.out.println("Valor estimado do material " + vetor_materias_primas[i] + ": ");
			valor_estimado[i] = sc.nextDouble();
			
			System.out.println("Quantidade em quilos do material " + vetor_materias_primas[i] + ": ");
			kg[i] = sc.nextInt();
		}
		
		double maior_gasto = 0.0;
		int index_maior_gasto = 0;
		int index_menor_gasto = 0;
		int index_medio_gasto = 0;
		for(int i = 0; i< vetor_materias_primas.length; i++) {
			
			if(valor_gasto[i] > maior_gasto) {
				maior_gasto = valor_gasto[i];
				index_maior_gasto = i;
			}else if(maior_gasto > valor_gasto[0] && maior_gasto > valor_gasto[1] && maior_gasto > valor_gasto[2]) {
				index_maior_gasto = i;
			}else if(maior_gasto < valor_gasto[1] && maior_gasto > valor_gasto[2]) {
				index_medio_gasto = 1;
			}else if(maior_gasto < valor_gasto[0] && maior_gasto < valor_gasto[1] && maior_gasto < valor_gasto[2]) {
				index_menor_gasto = 2;
			}
			
			
			if(valor_gasto[i] > valor_estimado[i]) {
				System.out.println("A relação kg/R$ do material " + vetor_materias_primas[i] + " é: " + (kg[i]/valor_gasto[i]));
				System.out.println("O valor gasto do material " + vetor_materias_primas[i] + " foi maior que o valor estimado.");
			}else if(valor_gasto[i] < valor_estimado[i]) {
				System.out.println("A relação kg/R$ do material " + vetor_materias_primas[i] + " é: " + (kg[i]/valor_gasto[i]));
				System.out.println("O valor gasto do material " + vetor_materias_primas[i] + " foi menor que o estimado");
			}else {
				System.out.println("A relação kg/R$ do material " + vetor_materias_primas[i] + " é: " + (kg[i]/valor_gasto[i]));
				System.out.println("O valor gasto do material " + vetor_materias_primas[i] + " foi igual");
			}
		}
		
		System.out.println("O maior gasto, se encontra no material: " + vetor_materias_primas[index_maior_gasto]);
	}
	public static void bloco() {
		System.out.println("|Bloco|");
		int totalPessoas; 
		double comissaoF, abreA, alaB, carAleg, mestreS, portaB, bateria, madriBateria, recuoB;
		
		System.out.println("Quantas pessoas irão participar do desfile? ");
		totalPessoas = sc.nextInt();
		
		comissaoF = totalPessoas * 0.15;
		abreA = totalPessoas * 0.5;
		alaB = totalPessoas * 0.15;
		carAleg = totalPessoas * 0.20;
		mestreS = totalPessoas * 0.3;
		portaB = totalPessoas * 0.3;
		bateria = totalPessoas * 0.20;
		madriBateria = totalPessoas * 0.2;
		recuoB = totalPessoas * 0.20;
		
		System.out.println("Quantidade de pessoas do bloco Comissão da Frente: " + comissaoF);
		System.out.println("Quantidade de pessoas do bloco Abre-Alas: " + abreA);
		System.out.println("Quantidade de pessoas do bloco Ala das Baianas: " + alaB);
		System.out.println("Quantidade de pessoas do bloco Carros Alegóricos: " + carAleg);
		System.out.println("Quantidade de pessoas do bloco Mestre-sala: " + mestreS);
		System.out.println("Quantidade de pessoas do bloco Porta-Bandeira: " + portaB);
		System.out.println("Quantidade de pessoas do bloco Bateria: " + bateria);
		System.out.println("Quantidade de pessoas do bloco Madrinha de Bateria: " + madriBateria);
		System.out.println("Quantidade de pessoas do bloco Recuo da Bateria: " + recuoB);
	}
	public static void opcoes() {
		String[] opcoesV = new String[5];
		opcoesV[0] = "1. |Horas Extras|";
		opcoesV[1] = "2. |Apuração|";
		opcoesV[2] = "3. |Matérias Primas|";
		opcoesV[3] = "4. |Bloco|";
		opcoesV[4] = "5.  Sair";
		
		for(int i = 0; i < opcoesV.length; i++) {
			System.out.println(opcoesV[i]);
		}
	}
}
