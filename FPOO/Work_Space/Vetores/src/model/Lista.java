package model;

public class Lista {

	public static void main(String[] args) {
		mostra();
	}
	public static void mostra() {
		int[] vet = new int [5];
		vet[0] = 2;
		vet[1] = 4;
		vet[2] = 5;
		vet[3] = 6;
		vet[4] = 8;
		
		int[] index = new int[5];
		index[0] = 0;
		index[1] = 1;
		index[2] = 2;
		index[3] = 3;
		index[4] = 4;
		
		System.out.println("\t\t|Indice\t\tValor|");
		for(int i = 0; i < vet.length; i++) {
			System.out.print("\t\t| "+index[i]+"\t\t");
			System.out.println("  "+vet[i]+"  |");
		}
	}
	public static void leVetor() {
		
	}
}
