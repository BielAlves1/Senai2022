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
	private JTextField tfId, tfEndereco, tfDataInicio, tfDataFim, tfHoraInicio, tfHoraFim, tfValor;
	private JScrollPane rolagem;
	private JTextArea list, tDescricao;
	private JButton create, read, update, delete;
	
	private String imgIco = "./assets/icone.png";
	private String[] imagens = { "", "", "",
			"./imagens/outros.jpg" };
	private ImageIcon icon;
	
	private int autoId = ProcessaOS.servicos.size() + 1;
	private String texto = "";

	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");

	TelaOS() {
		setTitle("Ordem de Serviços");
		setBounds(450, 100, 800, 600);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(174, 238, 238));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		id = new JLabel("Id:");
		id.setBounds(65, 25, 120, 30);
		painel.add(id);
		endereco = new JLabel("Endereço:");
		endereco.setBounds(20, 60, 120, 30);
		painel.add(endereco);
		descricao = new JLabel("Descrição:");
		descricao.setBounds(20, 115, 120, 30);
		painel.add(descricao);
		dataInicio = new JLabel("Data Inicio:");
		dataInicio.setBounds(20, 175, 120, 30);
		painel.add(dataInicio);
		horaInicio = new JLabel("Hora Início:");
		horaInicio.setBounds(20, 210, 120, 30);
		painel.add(horaInicio);
		dataFim = new JLabel("Data Fim:");
		dataFim.setBounds(30, 245, 120, 30);
		painel.add(dataFim);
		horaFim = new JLabel("Hora Fim:");
		horaFim.setBounds(30, 280, 120, 30);
		painel.add(horaFim);
		valor = new JLabel("Valor da OS:");
		valor.setBounds(15, 315, 120, 30);
		painel.add(valor);
		rotulos = new JLabel("Id        |     Endereço       |       Descrição       |       Data Inicio       |       Hora Inicio          |         Data Fim          |          Hora Fim           |           Valor");
		rotulos.setBounds(15, 360, 800, 30);
		painel.add(rotulos);

		tfId = new JTextField(String.format("%d", autoId));
		tfId.setEditable(false);
		tfId.setBounds(90, 25, 75, 30);
		painel.add(tfId);
		tfEndereco = new JTextField();
		tfEndereco.setBounds(90, 60, 255, 30);
		painel.add(tfEndereco);
		tDescricao = new JTextArea();
		tDescricao.setBounds(90, 105, 255, 60);
		tDescricao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		painel.add(tDescricao);
		tfDataInicio = new JTextField();
		tfDataInicio.setBounds(90, 175, 255, 30);
		painel.add(tfDataInicio);
		tfHoraInicio = new JTextField();
		tfHoraInicio.setBounds(90, 210, 255, 30);
		painel.add(tfHoraInicio);
		tfDataFim = new JTextField();
		tfDataFim.setBounds(90, 245, 255, 30);
		painel.add(tfDataFim);
		tfHoraFim = new JTextField();
		tfHoraFim.setBounds(90, 280, 255, 30);
		painel.add(tfHoraFim);
		tfValor = new JTextField();
		tfValor.setBounds(90, 315, 255, 30);
		painel.add(tfValor);
		list = new JTextArea();
		list.setEditable(false);
		list.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		preencherAreaDeTexto();
		rolagem = new JScrollPane(list);
		rolagem.setBounds(10, 400, 765, 150);
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
		TelaOS tos = new TelaOS();
		tos.setVisible(true);
	}

}