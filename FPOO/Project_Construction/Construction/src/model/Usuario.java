package model;

import java.util.Objects;

public class Usuario {
	
	private String email, senha;
	
	
	public Usuario(String login, String senha) {
		this.email = login;
		this.senha = senha;
	}

	public Usuario(String linha) {
		this.email = linha.split(";")[0];
		this.senha = linha.split(";")[1];
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String login) {
		this.email = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return email + "\t" + senha;
	}

	public String toCSV() {
		return email + ";" + senha + "\r\n";
	}
	
}
