package model;

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int caminhao, viagens , alque, resto;
		int tonelC = 18;
		int tonelA = 250;
		
		System.out.print("Digite o n�mero de Caminhoes: ");
		caminhao = sc.nextInt();
		System.out.print("Digite o n�mero de Alqueires: ");
		alque = sc.nextInt();
		
		
		viagens = (alque * tonelA) / (caminhao * tonelC);
		resto = (alque * tonelA) % (caminhao * tonelC);
		
		if (resto > 0) {
			System.out.println("Ser�o nessess�rias " + (viagens + 1) + " viagens");
		} else {
			System.out.println("Ser�o nessess�rias " + viagens + " viagens");
		}
				
		
		
	}

}