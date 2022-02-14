package model;

import java.io.IOException;
import java.util.Scanner;

public class AAA {
 
    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    
    int codP1 = sc.nextInt();
    int uniP1 = sc.nextInt();
    float precoUnip1 = sc.nextFloat();
    int codP2 = sc.nextInt();
    int uniP2 = sc.nextInt();
    float precoUnip2 = sc.nextFloat();
    float total = (uniP1 * precoUnip1) + (uniP2 * precoUnip2);
    
    System.out.printf("VALOR A PAGAR: R$ %.2f",total);
    }
 
}
