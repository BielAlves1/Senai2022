package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProcessaUsuario;
import model.Usuario;
import model.Cripto;

public class TelaUsuario extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel lbEmail, lbSenha;
	private JTextField email;
	private JPasswordField senha;
	private JButton cadastrar, buscar, alterar, deletar;
	private JScrollPane scroll;
	private JTable table;
	private DefaultTableModel tableModel;
	private String imgIco = "./assets/key.png";
	private int indice = -1;
	
	public TelaUsuario(){
		setTitle("Cadastro de UsuÃ¡rios");
		setIconImage(new ImageIcon(imgIco).getImage());
		setBounds(320, 250, 470, 400);
		painel = new JPanel(); 
		painel.setBackground(new Color(255, 233, 213));
		setContentPane(painel); 
		setLayout(null);

		lbEmail = new JLabel("E-mail:");
		lbEmail.setBounds(20, 20, 100, 30);
		painel.add(lbEmail);
		lbSenha = new JLabel("Senha:");
		lbSenha.setBounds(20, 55, 100, 30);
		painel.add(lbSenha);

		email = new JTextField();
		email.setBounds(135, 20, 300, 30);
		painel.add(email);
		senha = new JPasswordField();
		senha.setEchoChar('*');
		senha.setBounds(135, 55, 300, 30);
		painel.add(senha);

		cadastrar = new JButton("Cadastrar");
		buscar = new JButton("Buscar");
		alterar = new JButton("Alterar");
		deletar = new JButton("Excluir");
		cadastrar.setBounds(20, 90, 100, 30);
		buscar.setBounds(125, 90, 100, 30);
		alterar.setBounds(230, 90, 100, 30);
		deletar.setBounds(335, 90, 100, 30);
		painel.add(cadastrar);
		painel.add(buscar);
		painel.add(alterar);
		painel.add(deletar);

		tableModel = new DefaultTableModel();
		tableModel.addColumn("E-mail");
		tableModel.addColumn("Senha");
		if (ProcessaUsuario.usuarios.size() != 0) {
			preencheTabela();
		}
		table = new JTable(tableModel);
		table.setEnabled(false);
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 125, 415, 215);
		painel.add(scroll);

		cadastrar.addActionListener(this);
		buscar.addActionListener(this);
		alterar.addActionListener(this);
		deletar.addActionListener(this);

		alterar.setEnabled(false);
		deletar.setEnabled(false);
	}

	private void preencheTabela() {
		int totLinhas = tableModel.getRowCount();
		if (tableModel.getRowCount() > 0) {
			for (int i = 0; i < totLinhas; i++) {
				tableModel.removeRow(0);
			}
		}
		for (Usuario u : ProcessaUsuario.usuarios) {
			tableModel.addRow(new String[] { u.getEmail(), u.getSenha() });
		}
	}

	private void limparCampos() {
		email.setText("");
		senha.setText("");
	}

	private void cadastrar() {
		if (email.getText().length() > 0 && new String(senha.getPassword()).length() > 3) {
			Usuario user = new Usuario(email.getText(), Cripto.encripta(new String(senha.getPassword())));
			if (ProcessaUsuario.usuarios.contains(user)) {
				JOptionPane.showMessageDialog(this, "Usuário já está cadastrado.");
			} else {
				ProcessaUsuario.usuarios.add(user);
				ProcessaUsuario.salvar();
				preencheTabela();
				limparCampos();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Preencha com um email e senha com no mínimo 4 dígito.");
		}
	}

	private void buscar() {
		if (email.getText().length() > 0) {
			Usuario user = new Usuario(email.getText(), "");
			if (ProcessaUsuario.usuarios.contains(user)) {
				indice = ProcessaUsuario.usuarios.indexOf(user);
				email.setEnabled(false);
				cadastrar.setEnabled(false);
				buscar.setEnabled(false);
				alterar.setEnabled(true);
				deletar.setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(this, "Usuário não encontrado.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Preencha o campo email.");
		}
	}

	private void alterar() {
		if (email.getText().length() > 0 && new String(senha.getPassword()).length() > 3) {
			Usuario user = new Usuario(email.getText(), Cripto.encripta(new String(senha.getPassword())));
			ProcessaUsuario.usuarios.set(indice, user);
			ProcessaUsuario.salvar();
			preencheTabela();
			limparCampos();
			email.setEnabled(true);
			cadastrar.setEnabled(true);
			buscar.setEnabled(true);
			alterar.setEnabled(false);
			deletar.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(this, "Preencha com um email e senha com no mínimo 4 dígito.");
		}
	}

	private void delete() {
		ProcessaUsuario.usuarios.remove(indice);
		ProcessaUsuario.salvar();
		preencheTabela();
		limparCampos();
		email.setEnabled(true);
		cadastrar.setEnabled(true);
		buscar.setEnabled(true);
		alterar.setEnabled(false);
		deletar.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrar) {
			cadastrar();
		}
		if (e.getSource() == buscar) {
			buscar();
		}
		if (e.getSource() == alterar) {
			alterar();
		}
		if (e.getSource() == deletar) {
			delete();
		}
	}
	public static void main(String[] args) {
		new TelaUsuario().setVisible(true);
	}
}
