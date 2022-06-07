package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProcessaFuncionario;
import controllers.ProcessaUsuario;
import model.Funcionario;

public class TelaFuncionario extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel idF, nome, funcao, dataNascimento, diaria;
	private JTextField tfIdF, tfNome, tfDataNascimento, tfDiaria;
	private JScrollPane rolagem;
	private JTable table;
	private DefaultTableModel tableModel;
	private JComboBox<String> cbFuncao;
	private JButton create, read, update, delete;
	private String texto = "";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");
	private int autoId = ProcessaFuncionario.funcionarios.get(ProcessaFuncionario.funcionarios.size()-1).getIdF() + 1;

	

	TelaFuncionario () {
		setTitle("Construction Funcionarios");
		setBounds(150, 170, 800, 600);
		painel = new JPanel();
		painel.setBackground(new Color(174, 238, 238));
		setContentPane(painel);
		setLayout(null);

		idF = new JLabel("Id:");
		idF.setBounds(20, 20, 120, 30);
		painel.add(idF);
		nome = new JLabel("Nome:");
		nome.setBounds(20, 55, 120, 30);
		painel.add(nome);
		funcao = new JLabel("Função:");
		funcao.setBounds(20, 95, 120, 30);
		painel.add(funcao);
		dataNascimento = new JLabel("Nascimento:");
		dataNascimento.setBounds(20, 130, 120, 30);
		painel.add(dataNascimento);
		diaria = new JLabel("Valor da Diária:");
		diaria.setBounds(20, 165, 120, 30);
		painel.add(diaria);
		
		tfIdF = new JTextField(String.format("%d", autoId));
		tfIdF.setEditable(false);
		tfIdF.setBounds(140, 25, 40, 30);
		painel.add(tfIdF);
		tfNome = new JTextField();
		tfNome.setBounds(140, 60, 255, 30);
		painel.add(tfNome);
		cbFuncao = new JComboBox<String>(new String[] { "Eletricista", "Pedreiro", "Carpinteiro", "Detetizador" });
		cbFuncao.setBounds(140, 95, 255, 30);
		painel.add(cbFuncao);
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(140, 130, 255, 30);
		painel.add(tfDataNascimento);
		tfDiaria = new JTextField();
		tfDiaria.setBounds(140, 165, 255, 30);
		painel.add(tfDiaria);
		
		table = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Função");
		tableModel.addColumn("Idade");
		tableModel.addColumn("Diária");
		if (ProcessaFuncionario.funcionarios.size() != 0) {
			preencherTabela();
		}
		table = new JTable(tableModel);
		table.setEnabled(false);
		rolagem = new JScrollPane(table);
		rolagem.setBounds(20, 310, 740, 230);
		painel.add(rolagem);

		create = new JButton("Cadastrar");
		read = new JButton("Buscar");
		update = new JButton("Atualizar");
		delete = new JButton("Excluir");
		create.setBounds(545, 55, 110, 50);
		read.setBounds(425, 55, 110, 50);
		update.setBounds(425, 110, 110, 50);
		delete.setBounds(545, 110, 110, 50);
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
	
	int obterIndiceF(String funcao) {
		switch (funcao) {
		case "Eletricista":
			return 0;
		case "Pedreiro":
			return 1;
		case "Carpinteiro":
			return 2;
		case "Detetizador":
			return 3;
		default:
			return -1;
		}
	}
	
	private void limparCampos() {
		tfNome.setText(null);
		tfIdF.setText(null);
		tfDataNascimento.setText(null);
		tfDiaria.setText(null);
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
	}
	
	private void preencherTabela() {
		int totLinhas = tableModel.getRowCount();
		if (tableModel.getRowCount() > 0) {
			for (int i = 0; i < totLinhas; i++) {
				tableModel.removeRow(0);
			}
		}
		for (Funcionario f : ProcessaFuncionario.funcionarios) {
			tableModel.addRow(new String[] { f.getIdF("s"), f.getNome(), f.getFuncao(), String.format("%d", f.calcIdade()), f.getDiaria("s")});
		}
	}
	
	private void cadastrar() {
		if (tfNome.getText().length() != 0 && tfDataNascimento.getText().length() != 0 && tfDiaria.getText().length() != 0) {

			df.setCurrency(Currency.getInstance(BRASIL));
			double diaria;
			try {
				diaria = Double.parseDouble(df.parse(tfDiaria.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				diaria = 0;
			}

			ProcessaFuncionario.funcionarios.add(new Funcionario(autoId, tfNome.getText(), cbFuncao.getSelectedItem().toString(), tfDataNascimento.getText(), diaria));
			autoId++;
			preencherTabela();
			limparCampos();
			ProcessaFuncionario.salvar();
		} else {
			JOptionPane.showMessageDialog(this, "Por Favor preencher todos os campos.");
		}
	}
	
	private void buscar() {
		String entrada = JOptionPane.showInputDialog(this, "Digite o Id do Funcionario:");

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
			Funcionario funcionario = new Funcionario(id);
			if (ProcessaFuncionario.funcionarios.contains(funcionario)) {
				int indice = ProcessaFuncionario.funcionarios.indexOf(funcionario);
				tfIdF.setText(ProcessaFuncionario.funcionarios.get(indice).getIdF("s"));
				tfNome.setText(ProcessaFuncionario.funcionarios.get(indice).getNome());
				cbFuncao.setSelectedIndex(obterIndiceF(ProcessaFuncionario.funcionarios.get(indice).getFuncao()));
				tfDataNascimento.setText(ProcessaFuncionario.funcionarios.get(indice).getDataNascimento("s"));
				tfDiaria.setText(ProcessaFuncionario.funcionarios.get(indice).getDiaria("s"));
				create.setEnabled(false);
				update.setEnabled(true);
				delete.setEnabled(true);
				ProcessaFuncionario.salvar();
			} else {
				JOptionPane.showMessageDialog(this, "Funcionario não encontrado.");
			}
		}
	}
	
	private void alterar() {
		int id = Integer.parseInt(tfIdF.getText());
		Funcionario funcionario = new Funcionario(id);
		int indice = ProcessaFuncionario.funcionarios.indexOf(funcionario);
		if (tfNome.getText().length() != 0 && tfDataNascimento.getText().length() != 0 && tfDiaria.getText().length() != 0) {
			df.setCurrency(Currency.getInstance(BRASIL));
			double diaria;
			try {
				diaria = Double.parseDouble(df.parse(tfDiaria.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				diaria = 0;
			}

			ProcessaFuncionario.funcionarios.set(indice, new Funcionario(id, tfNome.getText(), cbFuncao.getSelectedItem().toString(), 
				tfDataNascimento.getText(), diaria));
			preencherTabela();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Por Favor preencher todos os campos.");
		}
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
		tfIdF.setText(String.format("%d", autoId));
		ProcessaFuncionario.salvar();
	}
	
	private void excluir() {
		int id = Integer.parseInt(tfIdF.getText());
		Funcionario funcionario = new Funcionario(id);
		int indice = ProcessaFuncionario.funcionarios.indexOf(funcionario);
		ProcessaFuncionario.funcionarios.remove(indice);
		preencherTabela();
		limparCampos();
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
		tfIdF.setText(String.format("%d", autoId));
		ProcessaFuncionario.salvar();
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