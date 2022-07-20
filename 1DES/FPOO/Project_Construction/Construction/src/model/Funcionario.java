package model;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Funcionario {
	private int idF;
	private String nome, funcao;
	private Date dataNascimento;
	private double diaria;
	
	private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat decf = new DecimalFormat("#.00");
	
	public Funcionario(int idF) {
		this.idF = idF;
	}
	
	public Funcionario(int idF, String nome, String funcao, String dataNascimento, double diaria) {
		decf.setCurrency(Currency.getInstance(BRASIL));
		this.idF = idF;
		this.nome = nome;
		this.funcao = funcao;
		try {
			this.dataNascimento = df.parse(dataNascimento);
		} catch (ParseException e) {
			System.out.println(e);
		}
		this.diaria = diaria;
	}

	public Funcionario(String linha) {
		decf.setCurrency(Currency.getInstance(BRASIL));
		this.idF = Integer.parseInt(linha.split(";")[0]);
		this.nome = linha.split(";")[1];
		this.funcao = linha.split(";")[2];
		try {
			this.dataNascimento = df.parse(linha.split(";")[3]);
			this.diaria = Double.parseDouble(linha.split(";")[4]);
		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public int getIdF() {
		return idF;
	}
	
	public String getIdF(String s) {
		return String.format("%d", idF);
	}

	public void setIdF(int idF) {
		this.idF = idF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public String getDataNascimento(String s) {
		return df.format(dataNascimento);
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getDiaria() {
		return diaria;
	}
	
	public String getDiaria(String s) {
		return String.format("%.2f", diaria);
	}

	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}
	
	@SuppressWarnings("deprecation")
	public int calcIdade() {
		return new Date().getYear() - dataNascimento.getYear();
	}

	@Override
	public int hashCode() {
		return Objects.hash(idF);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return idF == other.idF;
	}

	@Override
	public String toString() {
		return idF + "\t" + nome + "\t" + funcao + "\t" + calcIdade() + "\t" + String.format("%.2f", diaria) + "\n";
	}
	
	public String toCSV() {
		return idF + ";" + nome + ";" + funcao + ";" + df.format(dataNascimento)
				+ ";" + String.format("%.2f", diaria) + "\r\n";
	}
}
