package model;

import java.util.Scanner;

public class Express {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, bb, c, delta, r ,r2;
		
		System.out.println("Digite o valor de A: ");
		a = sc.nextInt();
		System.out.println("Digite o valor de B: ");
		b = sc.nextInt();
		System.out.println("Digite o valor de C: ");
		c = sc.nextInt();
		System.out.println(a+"X² "+"+ "+b+"X "+"+ "+c+" = 0");
		
		bb = b * b;
		delta = bb - (4 * a * c);
		System.out.println("Delta: "+ delta);
		
		if(delta > 0) {
			r = (int) ((-bb + Math.sqrt(delta)) / (2*a));
			System.out.println("Primeiro valor da raíz: "+ r);
			
			r2 = (int) ((-bb - Math.sqrt(delta)) / (2 * a));
			System.out.println("Segundo valor da raíz: "+ r2);
		}else {
			System.out.println("Não possui raízes reais");
		}
			
	}

}
