package modelo.modelodao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Medico;

public class MedicoDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String path = ".//data//Funcionario.csv";

	public ArrayList<Medico> ler() {
		ArrayList<Medico> linhas = new ArrayList<>();
		Medico funcionario;
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while (linha != null) {
				funcionario = new Medico(linha);
				linhas.add(funcionario);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return linhas;
	}

	public void escrever(ArrayList<Medico> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(path));
			for (Medico f : linhas) {
				bw.write(f.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}