import java.util.Scanner;

public class Processa2{

	public static Scanner sc;
	
	public static void main(String[] args){
		sc = new Scanner(System.in);
		//Entrada
		System.out.print("Digite alguma coisa: ");
		String v1 = sc.next();
		//Sa�da
		System.out.printf("Voc� digitou %s \n", v1);
		
	}
}