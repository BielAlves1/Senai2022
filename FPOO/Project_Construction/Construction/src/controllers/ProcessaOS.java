package controllers;

import java.util.ArrayList;

import model.OrdemServico;
import model.dao.OrdemServicoDAO;

public class ProcessaOS {

	public static ArrayList<OrdemServico> servicos = new ArrayList<>();
	private static OrdemServicoDAO osd = new OrdemServicoDAO();
	
	public static void abrir() {
		servicos = osd.ler();
		if(servicos.size() == 0) {
			servicos.add(new OrdemServico(1, "Instalar fiação na casa", "Rua José Serra, 165, Jardim Andrade", "1" , "02/05/2022", "08:00", "05/05/2022", "08:00", 350.50f));
		}
	}
	
	public static void salvar() {
		osd.escrever(servicos);
	}
}
