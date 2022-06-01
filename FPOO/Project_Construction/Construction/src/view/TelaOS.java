package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.ProcessaOS;

public class TelaOS extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel id, endereco, descricao, dataInicio, dataFim, horaInicio, horaFim, valor, rotulos,imagem;
	private JTextField tfId, tfEndereco, tf, tfCustoHora, tfTempoGasto;
	private JComboBox<String> cbEquipamento;
	private JScrollPane rolagem;
	private JTextArea verResultados;
	private JButton create, read, update, delete;
	private String imgIco = "./assets/icone.png";
	private String[] imagens = { "./imagens/roï¿½adeira.jpg", "./imagens/trator.jpg", "./imagens/caminhao.jpg",
			"./imagens/outros.jpg" };
	private ImageIcon icon;
	private int autoId = ProcessaOS.servicos.size() + 1;
	private String texto = "";

	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");

	TelaOS() {
		setTitle("Ordem de Serviços");
		setBounds(100, 100, 800, 600);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(174, 238, 238));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		id = new JLabel("Id:");
		id.setBounds(20, 20, 120, 30);
		painel.add(id);
		endereco = new JLabel("Endereço:");
		endereco.setBounds(20, 55, 120, 30);
		painel.add(endereco);
		descricao = new JLabel("Descrição:");
		descricao.setBounds(20, 125, 120, 30);
		painel.add(descricao);
		dataInicio = new JLabel("Data Inicio:");
		dataInicio.setBounds(20, 165, 120, 30);
		painel.add(dataInicio);
		horaInicio = new JLabel("Hora início:");
		horaInicio.setBounds(20, 200, 120, 30);
		painel.add(horaInicio);
		dataFim = new JLabel("Data fim:");
		dataFim.setBounds(20, 240, 120, 30);
		painel.add(dataFim);
		horaFim = new JLabel("Hora Fim:");
		horaFim.setBounds(20, 280, 120, 30);
		painel.add(horaFim);
		valor = new JLabel("Valor:");
		valor.setBounds(20, 280, 120, 30);
		painel.add(valor);
		rotulos = new JLabel("Id | Endereço | Descrição | Data Inicio | Hora Inicio | Data Fim | Hora Fim | Valor");
		rotulos.setBounds(20, 360, 500, 30);
		painel.add(rotulos);

		tfId = new JTextField(String.format("%d", autoId));
		tfId.setEditable(false);
		tfId.setBounds(140, 25, 140, 30);
		painel.add(tfId);
		cbEquipamento = new JComboBox<String>(new String[] { "Pedreiro", "Carpinteiro", "Eletricista", "Encanador" });
		cbEquipamento.setBounds(140, 60, 255, 30);
		painel.add(cbEquipamento);
		tf = new JTextField();
		tf.setBounds(140, 95, 255, 30);
		painel.add(tf);
		tfCustoHora = new JTextField();
		tfCustoHora.setBounds(140, 130, 255, 30);
		painel.add(tfCustoHora);
		tfTempoGasto = new JTextField();
		tfTempoGasto.setBounds(140, 165, 255, 30);
		painel.add(tfTempoGasto);
		tfTempoGasto = new JTextField();
		tfTempoGasto.setBounds(140, 240, 255, 30);
		painel.add(tfTempoGasto);
		tfTempoGasto = new JTextField();
		tfTempoGasto.setBounds(140, 200, 255, 30);
		painel.add(tfTempoGasto);
		tfTempoGasto = new JTextField();
		tfTempoGasto.setBounds(140, 280, 255, 70);
		painel.add(tfTempoGasto);
		verResultados = new JTextArea();
		verResultados.setEditable(false);
		verResultados.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		preencherAreaDeTexto();
		rolagem = new JScrollPane(verResultados);
		rolagem.setBounds(20, 400, 740, 150);
		painel.add(rolagem);
		imagem = new JLabel();
		imagem.setBounds(405, 60, 350, 240);
		imagem.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		alternarImagens(0);
		painel.add(imagem);

		create = new JButton("Cadastrar");
		read = new JButton("Buscar");
		update = new JButton("Atualizar");
		delete = new JButton("Excluir");
		create.setBounds(285, 25, 110, 30);
		read.setBounds(405, 25, 110, 30);
		update.setBounds(525, 25, 110, 30);
		delete.setBounds(645, 25, 110, 30);
		update.setEnabled(false);
		delete.setEnabled(false);
		painel.add(create);
		painel.add(read);
		painel.add(update);
		painel.add(delete);

		cbEquipamento.addActionListener(this);
		create.addActionListener(this);
		read.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);

	}

	private void alternarImagens(int indice) {
		icon = new ImageIcon(new ImageIcon(imagens[indice]).getImage().getScaledInstance(350, 240, 100));
		imagem.setIcon(icon);
	}


	private void cadastrar() {
	
	}

	private void limparCampos() {
		
	}

	private void preencherAreaDeTexto() {
		
	}

	
	private void buscar() {
		
	}

	
	private void alterar() {
		
	}


	private void excluir() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public static void main(String[] agrs) throws ParseException {
		ProcessaOS.abrir();
		new TelaOS().setVisible(true);
	}

}