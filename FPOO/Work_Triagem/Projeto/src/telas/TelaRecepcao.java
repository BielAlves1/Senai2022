package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controle.RecepcaoProcessa;

import modelo.Recepcao;

public class TelaRecepcao extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel nome, data, horario, medico,rotulos;
	private JTextField tfnome, tfdata, tfhorario, tfmedico;
	private JScrollPane rolagem;
	private JTextArea verResultados;
	private JButton create, read, update, delete;
	private String imgIco = "";
	private String texto = "";

	public TelaRecepcao() {
		setTitle("cadastro do paciente");
		setBounds(100, 100, 800, 600);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(0, 255, 127));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		nome = new JLabel("nome:");
		nome.setBounds(20, 20, 120, 30);
		painel.add(nome);
		data = new JLabel("data:");
		data.setBounds(20, 60, 120, 30);
		painel.add(data);
		horario = new JLabel("horario:");
		horario.setBounds(20, 100, 120, 30);
		painel.add(horario);
		medico = new JLabel("medico:");
		medico.setBounds(20, 140, 120, 30);
		painel.add(medico);

		rotulos = new JLabel("agenda:");
		rotulos.setBounds(20, 310, 500, 30);
		painel.add(rotulos);

		tfnome = new JTextField();
		tfnome.setBounds(140, 20, 255, 30);
		painel.add(tfnome);

		tfdata = new JTextField();
		tfdata.setBounds(140, 60, 255, 30);
		painel.add(tfdata);

		tfhorario = new JTextField();
		tfhorario.setBounds(140, 100, 255, 30);
		painel.add(tfhorario);

		tfmedico = new JTextField();
		tfmedico.setBounds(140, 140, 255, 30);
		painel.add(tfmedico);

		verResultados = new JTextArea();
		verResultados.setEditable(false);
		verResultados.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		preencherAreaDeTexto();
		rolagem = new JScrollPane(verResultados);
		rolagem.setBounds(20, 340, 740, 200);
		painel.add(rolagem);

		create = new JButton("Cadastrar");
		read = new JButton("Buscar");
		update = new JButton("Atualizar");
		delete = new JButton("Excluir");

		create.setBounds(405, 20, 110, 30);
		read.setBounds(405, 60, 110, 30);
		update.setBounds(405, 100, 110, 30);
		delete.setBounds(405, 140, 110, 30);

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

	private void cadastrar() {
		if (tfnome.getText().length() != 0 && tfdata.getText().length() != 0 && tfhorario.getText().length() != 0
				&& tfmedico.getText().length() != 0 && tfdiagnostico.getText().length() != 0
				&& tfrecomendacao.getText().length() != 0) {

			RecepcaoProcessa.recepcao.add(new Recepcao(tfnome.getText(), tfdata.getText(), tfhorario.getText(),
					tfmedico.getText(), tfdiagnostico.getText(), tfrecomendacao.getText()));
			preencherAreaDeTexto();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
	}

	private void limparCampos() {
		tfdata.setText(null);
		tfhorario.setText(null);
		tfmedico.setText(null);
		tfdiagnostico.setText(null);
	}

	private void preencherAreaDeTexto() {
		texto = ""; 
		for (Recepcao p : RecepcaoProcessa.recepcao) {
			texto += p.toString();
		}
		verResultados.setText(texto);
	}
	
	private void buscar() {
		String entrada = JOptionPane.showInputDialog(this,"Digite o Id do animal:");

		boolean isNumeric = true;
		if (entrada != null) {
			for (int i = 0; i < entrada.length(); i++) {
				if (!Character.isDigit(entrada.charAt(i))) {
					isNumeric = false;
				}
			}
		}else {
			isNumeric = false;
		}
		if (isNumeric) {
			int id = Integer.parseInt(entrada);
			Recepcao recepcao = new Recepcao(id);
			if (RecepcaoProcessa.recepcao.contains(recepcao)) {
				int indice = RecepcaoProcessa.recepcao.indexOf(recepcao);
				tfnome.setText(RecepcaoProcessa.recepcao.get(indice).getId("s"));
				tfdata.setText(RecepcaoProcessa.recepcao.get(indice).getData());
				tfhorario.setText(RecepcaoProcessa.recepcao.get(indice).getHorario());
				tfmedico.setText(RecepcaoProcessa.recepcao.get(indice).getMedico());
				tfdiagnostico.setText(RecepcaoProcessa.recepcao.get(indice).setDiagnostico("s"));
				tfrecomendacao.setText(RecepcaoProcessa.recepcao.get(indice).setRecomendacao("s"));
				create.setEnabled(false);
				update.setEnabled(true);
				delete.setEnabled(true);
				RecepcaoProcessa.salvar();
			} else {
				JOptionPane.showMessageDialog(this, "Pet não encontrado");
			}
		}

	}

	private void alterar() {
		Recepcao p = new Recepcao(imgIco);
		int indice = RecepcaoProcessa.recepcao.indexOf(p);
		if (tfdata.getText().length() != 0 && tfhorario.getText().length() != 0 && tfmedico.getText().length() != 0
				&& tfdiagnostico.getText().length() != 0) {

			RecepcaoProcessa.recepcao.set(indice, new Recepcao(tfnome.getText(), tfdata.getText(), tfhorario.getText(),
					tfdiagnostico.getText(), tfrecomendacao.getText(), imgIco));
			preencherAreaDeTexto();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
		RecepcaoProcessa.salvar();
	}

	private void excluir() {
		Recepcao p = new Recepcao(imgIco);
		int indice = RecepcaoProcessa.recepcao.indexOf(p);
		RecepcaoProcessa.recepcao.remove(indice);
		preencherAreaDeTexto();
		limparCampos();
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == create) {
			cadastrar();
		}

		if (e.getSource() == update) {
			alterar();
		}
		if (e.getSource() == delete) {
			excluir();
		}
	}

	public static void main(String[] agrs) throws ParseException {
		RecepcaoProcessa.abrir();

		new TelaRecepcao().setVisible(true);
	}

	public void setModal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}