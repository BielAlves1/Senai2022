package model;

import java.util.Random;

public class vetor2 {

	public static void main(String[] args) {
		imprimirVetor();
	}

	public static void imprimirVetor() {
		String[] nomes = new String[4];
		nomes[0] = "Bruno";
		nomes[1] = "Felipe";
		nomes[2] = "Luiz";
		nomes[3] = "Carlos";
		
		String[] sobreNomes = new String[4];
		sobreNomes[0] = "Alves";
		sobreNomes[1] = "Silva";
		sobreNomes[2] = "Santos";
		sobreNomes[3] = "Dias";
		
		Random rand = new Random();
		for(int i = 0; i < nomes.length; i++) {
			int numeroRand = rand.nextInt(nomes.length);
			
			System.out.print(nomes[numeroRand]+" ");
			System.out.println(sobreNomes[numeroRand]);
			
		}
	}
}
