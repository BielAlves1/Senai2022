package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cadastro cad = new Cadastro();
		
		int opcao = 0;
		do {
			System.out.println("1. Cadastrar Carro\n2. Listar\n0. Sair");
			opcao = sc.nextInt();
			switch(opcao) {
			case 1:
				System.out.println("Informe a Marca: ");
				String marca = sc.next();
				System.out.println("Informe o Modelo: ");
				String modelo = sc.next();
				System.out.println("Informe a sua cidade: ");
				String cor = sc.next();
				System.out.println("Informe o seu nome: ");
				String placa = sc.next();
				
				String carro = marca+ ";" +modelo+ ";" +cor+ ";" +placa;
				cad.cadastrar(carro, "Carros", true);
				break;
			case 2:
				ArrayList<String> infoFile = cad.listar("Pessoas");
				System.out.println("Digite o nome que deseja buscar");
				String busca = sc.nextLine();
				for(String linha : infoFile) {
					String[] indice = linha.split(";");
					if(indice[3].toLowerCase().contains(busca.toLowerCase())){
						System.out.println("Nome: "+indice[0]);
						System.out.println("Idade: "+indice[1]);
						System.out.println("Cidade: "+indice[2]);
					}
				}
				break;
			case 0:
				System.out.println("Flw!");
				break;
			default:
				System.out.println("Opção Inválida");
			}
		}while(opcao != 0);
	}
}
