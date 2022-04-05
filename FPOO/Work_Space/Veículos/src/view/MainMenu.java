package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import model.Carro;
import model.Moto;

public class MainMenu {

	private static Scanner sc = new Scanner(System.in);
	private static Carro carro;
	private static Moto moto;
	private static ArrayList<Carro> carros = new ArrayList<>();
	private static ArrayList<Moto> motos = new ArrayList<>();
	private static int indice;

	public static void main(String[] args) throws ParseException {

		int menu = 0;
		while (menu != 5) {
			opcoes();
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				cadastrar();
				break;
			case 2:
				listar();
				break;
			case 3:
				alterar();
				break;
			case 4:
				deletar();
				break;
			case 5:
				System.out.println("Vlw Flw!");
				break;
			default:
				System.out.println("Opção Inválida.\n");
			}
		}
	}

	private static void cadastrar() throws ParseException {
		String nasc;
		int subMenu = 0;
		while (subMenu != 3) {
			System.out.println("\t1. |Cadastrar Cliente|\n\t2. |Cadastrar Funcionário|\n\t3. Sair");
			subMenu = sc.nextInt();
			switch (subMenu) {
			case 1:
				carro = new Carro();
				System.out.println("\t|Informe as informações do Cliente|");
				System.out.println("\tDigite o Id: ");
				carro.setId(sc.nextInt());
				System.out.println("\tDigite o Nome: ");
				carro.setNome(sc.next());
				System.out.println("\tDigite o Telefone: ");
				carro.setTelefone(sc.next());
				System.out.println("\tDigite a Data de Nascimento: ");
				nasc = sc.next();
				carro.setNascimento(df.parse(nasc));
				System.out.println("\tDigite o saldo da conta: ");
				carro.setCreditoLimite(sc.nextDouble());
				carros.add(carro);
				System.out.println("\tCliente cadastrado com sucesso!\n");
				break;
			case 2:
				moto = new Moto();
				System.out.println("\t|Informe as informações do Funcionario|");
				System.out.println("\tDigite a matrícula(vulgo ID) do Funcionário: ");
				moto.setMatricula(sc.nextInt());
				System.out.println("\tDigite o Nome: ");
				moto.setNome(sc.next());
				System.out.println("\tDigite o Telefone: ");
				moto.setTelefone(sc.next());
				System.out.println("\tDigite a Data de Nascimento: ");
				nasc = sc.next();
				moto.setNascimento(df.parse(nasc));
				System.out.println("\tDigite a comissão do funcionário: ");
				moto.setComissao(sc.nextDouble());
				motos.add(moto);
				System.out.println("\tFuncionário cadastrado com sucesso!\n");
				break;
			case 3:
				System.out.println("\tVoltando pro menu principal\n");
				break;
			default:
				System.out.println("\tOpção Inválida.\n");
			}
		}
	}

	private static void listar() {
		int subMenu2 = 0;
		while (subMenu2 != 3) {
			System.out.println("\t1. |Listar Clientes|\n\t2. |Listar Funcionários|\n\t3. Sair");
			subMenu2 = sc.nextInt();
			switch (subMenu2) {
			case 1:
					for(Carro c : carros) {
						System.out.println(c.toString());
						System.out.print("\t["+c.getId()+"\t\t");
						System.out.print(c.getNome()+"\t\t");
						System.out.print(c.getTelefone()+"\t\t");
						System.out.print(df.format(c.getNascimento())+"\t\t");
						System.out.println(c.getCreditoLimite()+"]\n");
					
					}
					if(carros.size() ==  0){
						System.out.println("\tLista de clientes vazia.\n");
					}
				break;
			case 2:
					for(Moto f : motos) {
						System.out.println(f.toString());
						System.out.print("\t["+f.getMatricula()+"\t\t");
						System.out.print(f.getNome()+"\t\t");
						System.out.print(f.getTelefone()+"\t\t");
						System.out.print(df.format(f.getNascimento())+"\t\t");
						System.out.println(f.getComissao()+"]\n");
					}
				if(motos.size() ==  0){
					System.out.println("\tLista de funcionários vazia.\n");
				}
				break;
			case 3:
				System.out.println("\tVoltando pro menu principal\n");
				break;
			default:
				System.out.println("\tOpção Inválida.\n");
			}
		}
	}
	private static void alterar() throws ParseException{
		String nasc;
		int subMenu3 = 0;
		while (subMenu3 != 3) {
			System.out.println("\t1. |Alterar Cliente|\n\t2. |Alterar Funcionário|\n\t3. Sair");
			subMenu3 = sc.nextInt();
			switch (subMenu3) {
			case 1:
				System.out.println("\tDigite o índice(posição)");
				indice = sc.nextInt();
				carros.remove(indice);
				carro = new Carro();
				System.out.println("\t|Informe as informações do Cliente|");
				System.out.println("\tDigite o Id: ");
				carro.setId(sc.nextInt());
				System.out.println("\tDigite o Nome: ");
				carro.setNome(sc.next());
				System.out.println("\tDigite o Telefone: ");
				carro.setTelefone(sc.next());
				System.out.println("\tDigite a Data de Nascimento: ");
				nasc = sc.next();
				carro.setNascimento(df.parse(nasc));
				System.out.println("\tDigite o saldo da conta: ");
				carro.setCreditoLimite(sc.nextDouble());
				carros.add(indice, carro);
				System.out.println("\tCliente alterado com sucesso!\n");
				break;
			case 2:
				System.out.println("\tDigite o índice(posição)");
				indice = sc.nextInt();
				motos.remove(indice);
				moto = new Moto();
				System.out.println("\t|Informe as informações do Funcionario|");
				System.out.println("\tDigite a matrícula(vulgo ID) do Funcionário: ");
				moto.setMatricula(sc.nextInt());
				System.out.println("\tDigite o Nome: ");
				moto.setNome(sc.next());
				System.out.println("\tDigite o Telefone: ");
				moto.setTelefone(sc.next());
				System.out.println("\tDigite a Data de Nascimento: ");
				nasc = sc.next();
				moto.setNascimento(df.parse(nasc));
				System.out.println("\tDigite a comissão do funcionário: ");
				moto.setComissao(sc.nextDouble());
				motos.add(indice, moto);
				System.out.println("\tFuncionário alterado com sucesso!\n");
				break;
			case 3:
				System.out.println("\tVoltando pro menu principal\n");
				break;
			default:
				System.out.println("\tOpção Inválida.\n");
			}
		}
	}

	private static void deletar() {
		int op;
		int subMenu4 = 0;
		while (subMenu4 != 4) {
			System.out.println("\t1. |Deletar Cliente|\n\t2. |Deletar Funcionário|\n\t3. |Deletar Todos|\n\t4. Sair");
			subMenu4 = sc.nextInt();
			switch (subMenu4) {
			case 1:
				System.out.println("\t\t1. |Deletar só um cliente|\n\t\t2. |Deletar todos os clientes|\n\t\t3. Sair");
				op = sc.nextInt();
				if(op == 1) {
					System.out.println("\t\tDigite o índice(posição) do cliente na lista: ");
					indice = sc.nextInt();
					carros.remove(indice);
					System.out.println("\t\tCliente removido com sucesso!");
				} else if(op == 2) {
					carros.clear();
					System.out.println("\t\tLista de clientes deletada com sucesso");
				}
				else if(op == 3){
					System.out.println("\t\tVoltando ao SubMenu");
					break;
				}else {
					System.out.println("\t\tOpção Inválida.");
				}
				break;
			case 2:
				System.out.println("\t\t1. |Deletar só um funcionário|\n\t\t2. |Deletar todos os funcionários|\n\t\t3. Sair");
				op = sc.nextInt();
				if(op == 1) {
					System.out.println("\t\tDigite o índice(posição) do funcionário na lista: ");
					indice = sc.nextInt();
					motos.remove(indice);
					System.out.println("\t\tFuncionário removido com sucesso!");
				} else if(op == 2) {
					motos.clear();
					System.out.println("\t\tLista de funcionários deletada com sucesso");
				}
				else if(op == 3){
					System.out.println("\t\tVoltando ao SubMenu");
					break;
				}else {
					System.out.println("\t\tOpção Inválida.");
				}
				break;
			case 3:
				carros.clear();
				motos.clear();
				System.out.println("\tTodos foram deletados.");
				break;
			case 4:
				System.out.println("\tVoltando pro menu principal\n");
				break;
			default:
				System.out.println("\tOpção Inválida.\n");
			}
		}
	}

	public static void opcoes() {
		String[] opcoes = new String[5];
		opcoes[0] = "1. |Cadastrar Uma Pessoa|";
		opcoes[1] = "2. |Listar Uma Pessoa|";
		opcoes[2] = "3. |Alterar Uma Pessoal|";
		opcoes[3] = "4. |Deletar Uma Pessoa|";
		opcoes[4] = "5. Sair";

		for (int i = 0; i < opcoes.length; i++) {
			System.out.println(opcoes[i]);
		}
	}
}
