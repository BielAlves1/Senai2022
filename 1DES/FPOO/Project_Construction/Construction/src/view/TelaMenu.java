package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuCadastro, menuUsuario, menuRelatorio;
	private JMenuItem itemFuncionarios, itemOS, itemUsuarios, itemRelatorio;
	private String imgIco = "./assets/icone.png";
	private String pathFundo = "./assets/fundo.png";
	private ImageIcon fundo;
	private JLabel lbFundo = new JLabel();

	TelaMenu() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Construction - Ordens e Serviço");
		setBounds(150, 100, 800, 600);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(174, 238, 238));
		setJMenuBar(barraMenu);
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		fundo = new ImageIcon(new ImageIcon(pathFundo).getImage().getScaledInstance(785, 605, 100));
		lbFundo.setIcon(fundo);
		lbFundo.setBounds(0, 0, 850, 605);
		painel.add(lbFundo);

		menuCadastro = new JMenu("Cadastros");
		menuUsuario = new JMenu("Usuários");
		menuRelatorio = new JMenu("Relatórios");
		barraMenu.add(menuCadastro);
		barraMenu.add(menuUsuario);
		barraMenu.add(menuRelatorio);
		itemFuncionarios = new JMenuItem("Gerenciar Funcionários");
		itemOS = new JMenuItem("Gerenciar Ordens Serviços");
		itemUsuarios = new JMenuItem("Gerenciar Usuários");
		itemRelatorio = new JMenuItem("Gerenciar Relatórios");
		menuCadastro.add(itemFuncionarios);
		menuCadastro.add(itemOS);
		menuRelatorio.add(itemRelatorio);
		menuUsuario.add(itemUsuarios);
		barraMenu.setBackground(new Color(174, 238, 238));

		itemFuncionarios.addActionListener(this);
		itemOS.addActionListener(this);
		itemUsuarios.addActionListener(this);
		itemRelatorio.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itemFuncionarios) {
			TelaFuncionario tf = new TelaFuncionario();
			tf.setModal(true);
			tf.setVisible(true);
		}
		if (e.getSource() == itemOS) {
			TelaOS tOs = new TelaOS();
			tOs.setModal(true);
			tOs.setVisible(true);
		}
		if (e.getSource() == itemUsuarios) {
			TelaUsuario tu = new TelaUsuario();
			tu.setModal(true);
			tu.setVisible(true);
		}
//		if (e.getSource() == itemRelatorio) {
//			RelatorioForm tr = new RelatorioForm();
//			tr.setModal(true);
//			tr.setVisible(true);
//		}
	}
}
