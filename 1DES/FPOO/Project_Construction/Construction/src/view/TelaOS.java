package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProcessaFuncionario;
import controllers.ProcessaOS;
import model.OrdemServico;

public class TelaOS extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel id, descricao, endereco, funcionario, dataInicio, dataFim, horaInicio, horaFim, valor, imagem;
	private JTextField tfId, tfEndereco, tfFuncionario, tfDataInicio, tfDataFim, tfHoraInicio, tfHoraFim, tfValor;
	private JScrollPane rolagem;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextArea tDescricao;
	private JButton create, read, update, delete;
	
	private String imgIco = "./assets/icone.png";
	private String[] imagens = { "", "", "",
			"./imagens/outros.jpg" };
	private ImageIcon icon;
	
	private int autoId = ProcessaOS.servicos.get(ProcessaOS.servicos.size()-1).getIdOS() + 1;
	private String texto = "";

	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat hdf = new SimpleDateFormat("HH:mm");

	TelaOS() {
		setTitle("Ordem de Serviços");
		setBounds(350, 85, 850, 650);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(174, 238, 238));
		setContentPane(painel);
		setLayout(null);

		id = new JLabel("Id:");
		id.setBounds(65, 25, 120, 30);
		painel.add(id);
		descricao = new JLabel("Descrição:");
		descricao.setBounds(20, 60, 120, 30);
		painel.add(descricao);
		endereco = new JLabel("Endereço:");
		endereco.setBounds(25, 130, 120, 30);
		painel.add(endereco);
		funcionario = new JLabel("Id Funcionário:");
		funcionario.setBounds(5, 170, 120, 30);
		painel.add(funcionario);
		dataInicio = new JLabel("Data Inicio:");
		dataInicio.setBounds(20, 205, 120, 30);
		painel.add(dataInicio);
		horaInicio = new JLabel("Hora Início:");
		horaInicio.setBounds(20, 240, 120, 30);
		painel.add(horaInicio);
		dataFim = new JLabel("Data Fim:");
		dataFim.setBounds(30, 275, 120, 30);
		painel.add(dataFim);
		horaFim = new JLabel("Hora Fim:");
		horaFim.setBounds(30, 310, 120, 30);
		painel.add(horaFim);
		valor = new JLabel("Valor da OS:");
		valor.setBounds(15, 345, 120, 30);
		painel.add(valor);

		tfId = new JTextField(String.format("%d", autoId));
		tfId.setEditable(false);
		tfId.setBounds(90, 25, 75, 30);
		painel.add(tfId);
		tDescricao = new JTextArea();
		tDescricao.setBounds(90, 60, 255, 60);
		tDescricao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		painel.add(tDescricao);
		tfEndereco = new JTextField();
		tfEndereco.setBounds(90, 130, 255, 30);
		painel.add(tfEndereco);
		tfFuncionario = new JTextField();
		tfFuncionario.setBounds(90, 175, 255, 30);
		painel.add(tfFuncionario);
		tfDataInicio = new JTextField();
		tfDataInicio.setBounds(90, 210, 255, 30);
		painel.add(tfDataInicio);
		tfHoraInicio = new JTextField();
		tfHoraInicio.setBounds(90, 245, 255, 30);
		painel.add(tfHoraInicio);
		tfDataFim = new JTextField();
		tfDataFim.setBounds(90, 280, 255, 30);
		painel.add(tfDataFim);
		tfHoraFim = new JTextField();
		tfHoraFim.setBounds(90, 315, 255, 30);
		painel.add(tfHoraFim);
		tfValor = new JTextField();
		tfValor.setBounds(90, 350, 255, 30);
		painel.add(tfValor);
		
		table = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Descreção");
		tableModel.addColumn("Endereço");
		tableModel.addColumn("Funcionário");
		tableModel.addColumn("Data Início");
		tableModel.addColumn("Hora Início");
		tableModel.addColumn("Data Fim");
		tableModel.addColumn("Hora Fim");
		tableModel.addColumn("Valor OS");
		if (ProcessaOS.servicos.size() != 0) {
			preencherTabela();
		}
		table = new JTable(tableModel);
		table.setEnabled(false);
		rolagem = new JScrollPane(table);
		rolagem.setBounds(10, 400, 815, 200);
		painel.add(rolagem);
		imagem = new JLabel();
		imagem.setBounds(405, 60, 350, 240);
		imagem.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
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
	
	private void preencherTabela() {
		int totLinhas = tableModel.getRowCount();
		if (tableModel.getRowCount() > 0) {
			for (int i = 0; i < totLinhas; i++) {
				tableModel.removeRow(0);
			}
		}
		for (OrdemServico os : ProcessaOS.servicos) {
			tableModel.addRow(new String[] { os.getIdOS("s"), os.getDescricao(), os.getEndereco(), os.getFuncionario("s"), 
					os.getDataInicio("s"), os.getHoraInicio("s"), os.getDataFim("s"), os.getHoraFim("s"), os.getValorOS("s")});
		}
	}

	private void limparCampos() {
		tfId.setText(String.format("%d", autoId));
		tDescricao.setText(null);
		tfEndereco.setText(null);
		tfFuncionario.setText(null);
		tfDataInicio.setText(sdf.format(new Date()));
		tfHoraInicio.setText(hdf.format(new Date()));
		tfDataFim.setText(sdf.format(new Date()));
		tfHoraFim.setText(sdf.format(new Date()));
	}
	
	private void cadastrar() {
		if (tDescricao.getText().length() > 0 && tfEndereco.getText().length() > 0 && tfDataInicio.getText().length() > 0
				&& tfHoraInicio.getText().length() > 0 && tfDataFim.getText().length() > 0 && tfHoraFim.getText().length() > 0 && tfValor.getText().length() > 0) {
			
			df.setCurrency(Currency.getInstance(BRASIL));
			double valor;
			try {
				valor = Double.parseDouble(df.parse(tfValor.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				valor = 0;
			}
			
			ProcessaOS.servicos.add(new OrdemServico(autoId, tDescricao.getText(), tfEndereco.getText(), tfFuncionario.getText(),
					tfDataInicio.getText(), tfHoraInicio.getText(), tfDataFim.getText(), tfHoraFim.getText(), valor));
			preencherTabela();
			autoId++;
			limparCampos();
			ProcessaOS.salvar();
		} else {
			JOptionPane.showMessageDialog(this, "Por Preencha todos os campos.");
		}
	}
	
	private void buscar() {
		String entrada = JOptionPane.showInputDialog(this, "Digite o Id da OS:");

		boolean isNumeric = true;
		if (entrada != null && !entrada.equals("")) {
			for (int i = 0; i < entrada.length(); i++) {
				if (!Character.isDigit(entrada.charAt(i))) {
					isNumeric = false;
				}
			}
		} else {
			isNumeric = false;
		}
		if (isNumeric) {
			int id = Integer.parseInt(entrada);
			OrdemServico os = new OrdemServico(id);
			if (ProcessaOS.servicos.contains(os)) {
				int indice = ProcessaOS.servicos.indexOf(os);
				tfId.setText(ProcessaOS.servicos.get(indice).getIdOS("s"));
				tfFuncionario.setText(ProcessaOS.servicos.get(indice).getFuncionario().getIdF("s"));
				tfDataInicio.setText(ProcessaOS.servicos.get(indice).getDataInicio("s"));
				tfHoraInicio.setText(ProcessaOS.servicos.get(indice).getHoraInicio("s"));
				tfDataFim.setText(ProcessaOS.servicos.get(indice).getDataFim("s"));
				tfHoraFim.setText(ProcessaOS.servicos.get(indice).getHoraFim("s"));
				tfValor.setText(ProcessaOS.servicos.get(indice).getValorOS("s"));
				create.setEnabled(false);
				update.setEnabled(true);
				delete.setEnabled(true);
				ProcessaOS.salvar();
			} else {
				JOptionPane.showMessageDialog(this, "Serviço não encontrado!");
			}
		}
	}

	
	private void alterar() {
		
	}


	private void excluir() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create) {
			cadastrar();
		}
		if (e.getSource() == read) {
			buscar();
		}
		if (e.getSource() == update) {
			alterar();
		}
		if (e.getSource() == delete) {
			excluir();
		}
	}
}