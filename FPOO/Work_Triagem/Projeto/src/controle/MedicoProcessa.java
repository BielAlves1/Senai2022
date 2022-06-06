package controle;

import java.util.ArrayList;

import modelo.Medico;
import modelo.modelodao.MedicoDAO;

public class MedicoProcessa {

	public static ArrayList<Medico> pets = new ArrayList<>();
	private static MedicoDAO pd = new MedicoDAO();
	
	public static void abrir() {
		pets = pd.ler();
		if(pets.size() == 0) {
			pets.add(new Medico(0));
		}
	}
	
	public static void salvar() {
		pd.escrever(pets);
	}
}