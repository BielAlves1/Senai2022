package controle;

import java.util.ArrayList;

import modelo.Recepcao;
import modelo.modelodao.RecepcaoDAO;

public class RecepcaoProcessa {

	public static ArrayList<Recepcao> recepcao = new ArrayList<>();
	public static RecepcaoDAO pd = new RecepcaoDAO();

	public static void salvar() {
		pd.escrever(recepcao);
	}

	public static void abrir() {
		recepcao = pd.ler();

	}
}