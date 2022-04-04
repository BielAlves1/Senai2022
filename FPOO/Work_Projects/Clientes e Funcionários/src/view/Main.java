package view;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import model.Cliente;
import model.Funcionario;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static Cliente cliente;
	private static Funcionario funcionario;
	private static ArrayList<Cliente> clientes = new ArrayList<>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws IOException, ParseException {

		int menu = 0;
		while (menu != 3) {
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
				break;
			case 4:
				System.out.println("Vlw Flw!");
				break;
			default:
				System.out.println("Opção Inválida.\n");
			}
		}
	}

	private static void cadastrar() throws IOException, ParseException {
		String nasc;
		
		int subMenu = 0;
		while (subMenu != 3) {
			System.out.println("\t1. |Cadastrar Cão|\n\t2. |Cadastrar Gato|\n\t3. Sair");
			subMenu = sc.nextInt();
			switch (subMenu) {
			case 1:
				System.out.println("\t|Informe as informações do Cliente|");
				System.out.println("\tDigite o Id: ");
				cliente.setId(sc.nextInt());
				System.out.println("\tDigite o Nome: ");
				cliente.setNome(sc.nextLine());
				System.out.println("\tDigite o Telefone: ");
				cliente.setTelefone(sc.nextLine());
				System.out.println("\tDigite a Data de Nascimento: ");
				nasc = sc.next();
				cliente.setNascimento(df.parse(nasc));
				System.out.println("\tDigite o saldo da conta");
				cliente.setCreditoLimite(sc.nextDouble());
				clientes.add(cliente);
				System.out.println("\tCliente cadastrado com sucesso!\n");
				break;
			case 2:
				System.out.println("\t|Informe as informações do Funcionario|");
				System.out.println("\tDigite a matrícula(vulgo ID) do Funcionário: ");
				funcionario.setMatricula(sc.nextInt());
				System.out.println("\tDigite o Nome: ");
				funcionario.setNome(sc.nextLine());
				System.out.println("\tDigite o Telefone: ");
				funcionario.setTelefone(sc.nextLine());
				System.out.println("\tDigite a Data de Nascimento: ");
				nasc = sc.next();
				funcionario.setNascimento(df.parse(nasc));
				System.out.println("\tDigite a comissão do funcionário: ");
				funcionario.setComissao(sc.nextDouble());
				funcionarios.add(funcionario);
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
		System.out.println("\t. |Listar Cães|\n\t2. |Listar Gatos|");
		int op = sc.nextInt();
		if(op == 1) {
			for(Cliente c : clientes) {
				System.out.println("\t\t"+c.toString());
			}
		} else if(op == 2) {
			for(Funcionario f : funcionarios) {
				System.out.println("\t\t"+f.toString());
			}
		} else if(op == 3) {
			System.out.println("\tVoltando ao menu principal\n");
		}else {
			System.out.println("\tOpção Inválida.\n");
		}
	}
	private static void alterar() {
		
	}

	private static void deletar() {

	}

	public static void opcoes() {
		String[] opcoes = new String[5];
		opcoes[0] = "\t1. |Cadastrar Pessoa|";
		opcoes[1] = "\t2. |Listar Pessoa|";
		opcoes[2] = "\t3. |Alterar Pessoal|";
		opcoes[3] = "\t4. |Deletar Pessoa|";
		opcoes[4] = "\t5. Sair";

		for (int i = 0; i < opcoes.length; i++) {
			System.out.println(opcoes[i]);
		}
	}
}
