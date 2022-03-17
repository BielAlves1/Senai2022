package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.Aluno;
import model.Nota;

public class MainMenu {
	
	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static Aluno[] alunos = new Aluno[10];
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws ParseException {
		
		int menu = 0;
		while(menu != 8) {
			opcoes();
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				cadastrarAluno();
				break;
			case 2:
				cadastrarNota();
				break;
			case 3:
				listarAlunos();
				break;
			case 4:
				listarNotas();
				break;
			case 5:
				obterAluno();
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				System.out.println("Tchau!");
				break;
			default:
				System.out.println("Op��o Inv�lida.");
			}
		}
	}
	public static void cadastrarAluno() throws ParseException {
		for (int i = 0; i < alunos.length; i++) {
			if (alunos[9] == null) {
				if(alunos[i] == null) {
					System.out.println("Informe o nome do Aluno: ");
					String nome = sc.next();
					System.out.println("Informe a data de nascimento do Aluno: ");
					String nsc = sc.next();
				    Date nascimento = df.parse(nsc);
					int ra = i+1;
					alunos[i] = new Aluno(ra, nome, nascimento);
					System.out.println("RA do aluno �: "+ra+"\n");
					break;
				}
			} else {
				System.out.println("Chegou no Limite.");
				break; 	
			}
		}
	}
	public static void cadastrarNota()  throws ParseException{
		String componente;
		 float[] nota = new float[3];
		System.out.println("Informe o RA do aluno em que as notas ser�o cadastradas: ");
		int ra2 = sc.nextInt();
	    for(int i = 0; i < alunos.length; i++) {
	    	if(alunos[i] != null) {
	    		if(alunos[i].ra == ra2) {
					Nota[] notas = alunos[i].notas;
					for(int j = 0; j <= 3; j++) {
						if(notas[j] == null) {
							System.out.println(alunos[i].nome +" tem "+ j +" de 4 componentes(Mat�rias/Disciplinas) cadastrados.");
							System.out.println("Informe o nome da mat�ria pra cadastrar as notas:");
							componente = sc.next();
							for(int k = 0; k <= 2; k++) {
								System.out.println("Informe a " +(k+1)+ "� Nota: ");
								nota[k] = sc.nextFloat();
							}
							notas[j] = new Nota(componente, nota);
							alunos[i].notas = notas;
							break;
						}
						if(j == 4) {
							System.out.println("Limite excedido para os componentes do aluno(a) " +alunos[i].nome);
						}
					}
				}
			}
		}
	}
	public static String listarAlunos() {
		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i] != null) {
				System.out.println(alunos[i].toString());
			}
		}
		return null;
	}
	public static String listarNotas() throws ParseException{
		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i] != null) {
				System.out.println(alunos[i].nome);
				System.out.println("\t|Comp|\t|1�Nota|\t|2�Nota|\t|3�Nota|\t|M�dia|");
				for (int j = 0; j < alunos[i].notas.length; j++) {
					System.out.print("\t "+ alunos[i].notas[j].componente);
					for (int k = 0; k < alunos[i].notas[j].nota.length; k++) {
						System.out.print("\t  "+alunos[i].notas[j].nota[k]+"\t");
					}
					if(alunos[i].notas[j].obterMedia() < 50) {
						System.out.printf("\t%.2f\n", alunos[i].notas[j].obterMedia());	
					}
				}
				System.out.println(alunos[i].obterConceito());
				System.out.println();
			}
		}
		return null;
	}
	public static void obterAluno() {
		System.out.println("Informe o RA do aluno para buscar: ");
		int ra2 = sc.nextInt();
		System.out.println("\n|RA\tNome\tNascimento\tIdade|");
		for (int i = 0; i < alunos.length; i++) {
			if(alunos[i] != null && alunos[i].ra == ra2) {
				System.out.println(alunos[i].ra+ "\t" + alunos[i].nome+"\t"+
			df.format(alunos[i].nascimento)+"\t"+ alunos[i].calcIdade());
			}
		}
	}
	public static String ListarAprovados() {
		
		return null;
	}
	public static String ListarReprovados() {
		
		return null;
	}
	public static void opcoes() {
		String[] opcoesV = new String[8];
		opcoesV[0] = "1. |Cadastrar Aluno|";
		opcoesV[1] = "2. |Cadastrar Nota|";
		opcoesV[2] = "3. |Listar Alunos|";
		opcoesV[3] = "4. |Listar Notas|";
		opcoesV[4] = "5. |Buscar os Dados de um Aluno|";
		opcoesV[5] = "6. |Listar Alunos Aprovados|";
		opcoesV[6] = "7. |Listar Alunos Reprovados|";
		opcoesV[7] = "8. Sair";
		
		for(int i = 0; i < opcoesV.length; i++) {
			System.out.println(opcoesV[i]);
		}
	}
}
