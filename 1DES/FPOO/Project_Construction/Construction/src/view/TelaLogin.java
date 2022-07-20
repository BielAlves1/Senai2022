package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.ProcessaFuncionario;
import controllers.ProcessaOS;
import controllers.ProcessaUsuario;
import model.Cripto;


public class TelaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel painel;
	private JLabel rotulo1, rotulo2;
	private JTextField email;
	private JPasswordField senha;
	private JButton login;

	TelaLogin() {

		setTitle("Tela de Login");
		setBounds(500, 300, 360, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel(); 
		painel.setBackground(new Color(174, 238, 238));
		setContentPane(painel); 
		setLayout(null);
		
		rotulo1 = new JLabel("Email:");
		rotulo1.setBounds(20, 20, 100, 20);
		email = new JTextField();
		email.setBounds(120, 20, 200, 30);
		rotulo2 = new JLabel("Senha:");
		rotulo2.setBounds(20, 60, 100, 20);
		senha = new JPasswordField();
		senha.setEchoChar('*');
		senha.setBounds(120, 60, 200, 30);
		login = new JButton("Login");
		login.setBounds(120, 100, 200, 30);
		
		
		login.addActionListener(this);

		
		painel.add(rotulo1);
		painel.add(email);
		painel.add(rotulo2);
		painel.add(senha);
		painel.add(login);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			if (email.getText().length() > 0 && new String(senha.getPassword()).length() > 0) {
				int indice = ProcessaUsuario.checarLogin(email.getText());
				if (indice != -1) {
					if (ProcessaUsuario.checarSenha(indice, Cripto.encripta(new String(senha.getPassword())))) {
						this.dispose();// Fecha o Formul?rio
						TelaMenu mf = new TelaMenu();
						mf.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(this, "Acesso negado!");
					}
				} else {
					JOptionPane.showMessageDialog(this, "Usuário não encontrado.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Preencha o email e a senha.");
			}
		}
	}

	public static void main(String[] args) {
		ProcessaUsuario.abrir();
		ProcessaFuncionario.abrir();
		ProcessaOS.abrir();
		TelaLogin login = new TelaLogin();
		login.setVisible(true);
	}
}