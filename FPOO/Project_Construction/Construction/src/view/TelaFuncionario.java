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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProcessaFuncionario;
import model.Funcionario;

public class TelaFuncionario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel idF, nome, funcao, dataNascimento, valorHora;
	private JTextField tfIdF, tfNome, tfDataNascimento, tfValorHora;
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
		valorHora = new JLabel("Valor da Diária:");
		valorHora.setBounds(20, 165, 120, 30);
		painel.add(valorHora);
		
		tfIdF = new JTextField(String.format("%d", autoId));
		tfIdF.setEditable(false);
		tfIdF.setBounds(140, 25, 40, 30);
		painel.add(tfIdF);
		tfNome = new JTextField();
		tfNome.setBounds(140, 60, 255, 30);
		painel.add(tfNome);
		cbFuncao = new JComboBox<String>(new String[] { "Eletricista", "Construtor", "Detetizador", "Cortador de grama" });
		cbFuncao.setBounds(140, 95, 255, 30);
		painel.add(cbFuncao);
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(140, 130, 255, 30);
		painel.add(tfDataNascimento);
		tfValorHora = new JTextField();
		tfValorHora.setBounds(140, 165, 255, 30);
		painel.add(tfValorHora);
		
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
	
	}

	private void limparCampos() {
		tfNome.setText(null);
		tfIdF.setText(null);
		tfDataNascimento.setText(null);
		tfValorHora.setText(null);
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	public static void main(String[] args) {
		ProcessaFuncionario.abrir();
		new TelaFuncionario().setVisible(true);
	}
}