package modelo;

import java.util.Objects;

public class Usuario {

	private String login;
	private String senha;
	
	public Usuario(String email,String senha) {
		this.login = email;
		this.senha = senha;
	}
	
	public Usuario(String linha) {
		this.login = linha.split(":")[0];
		this.senha = linha.split(";")[1];
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String email) {
		this.login = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int hashCode() {
		return Objects.hash(login);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(login, other.login) && Objects.equals(senha, other.senha);
	}

	public String toString() {
		return  login + "\t" + senha;
	}
	
	public String toCSV() {
		return login +";" + senha + "\r\n";
	}	
}