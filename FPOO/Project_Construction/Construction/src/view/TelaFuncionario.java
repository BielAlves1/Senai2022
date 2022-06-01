package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.ProcessaFuncionario;

public class TelaFuncionario extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel idF, funcao, nome, cargaHoraria, dataNascimento, valorHora;
	private JTextField tfIdF, tfNome, tfCargaHoraria, tfDataNascimento, tfValorHora;
	private JComboBox<String> cbFuncao;
	private JButton create, read, update, delete;
	
	private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private int autoId = ProcessaFuncionario.funcionarios.get(ProcessaFuncionario.funcionarios.size()-1).getIdF() + 1;

	public TelaFuncionario () {
		setTitle("Cadastro de Animais/Pets");
		setBounds(150, 170, 800, 600);
		painel = new JPanel();
		painel.setBackground(new Color(255, 233, 213));
		setContentPane(painel);
		setLayout(null);

		idF = new JLabel("Id:");
		idF.setBounds(20, 20, 120, 30);
		painel.add(idF);
		funcao = new JLabel("Espécie:");
		funcao.setBounds(20, 55, 120, 30);
		painel.add(funcao);
		nome = new JLabel("Nome f:");
		nome.setBounds(20, 90, 120, 30);
		painel.add(nome);
		
		cargaHoraria = new JLabel("Peso:");
		cargaHoraria.setBounds(20, 165, 120, 30);
		painel.add(cargaHoraria);
		dataNascimento = new JLabel("Nascimento:");
		dataNascimento.setBounds(20, 200, 120, 30);
		painel.add(dataNascimento);
		valorHora = new JLabel("Telefone:");
		valorHora.setBounds(20, 270, 120, 30);
		painel.add(valorHora);
		tfIdF = new JTextField(String.format("%d", autoId));
		tfIdF.setEditable(false);
		tfIdF.setBounds(140, 25, 140, 30);
		painel.add(tfIdF);
		cbFuncao = new JComboBox<String>(new String[] { "Pedreiro", "Carpinteiro", "Eletricista", "Encanador" });
		cbFuncao.setBounds(140, 60, 255, 30);
		painel.add(cbFuncao);
		tfNome = new JTextField();
		tfNome.setBounds(140, 95, 255, 30);
		painel.add(tfNome);
		tfCargaHoraria = new JTextField();
		tfCargaHoraria.setBounds(140, 165, 255, 30);
		painel.add(tfCargaHoraria);
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(140, 200, 255, 30);
		painel.add(tfDataNascimento);
		tfValorHora = new JTextField();
		tfValorHora.setBounds(140, 270, 255, 30);
		painel.add(tfValorHora);

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

		// Ouvir os eventos dos Bot�es, ComboBox e outros
		
		create.addActionListener(this);
		read.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
