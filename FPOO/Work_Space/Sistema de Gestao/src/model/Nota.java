package model;

ppublic class Notas {
	
	public String componente;
	public float[] notas =  new float[3];
	
	public Notas() {
		// TODO Auto-generated constructor stub
	}
	
	public Notas(String componente, float[] notas) {
		this.componente = componente;
		this.notas = notas;
	}
	
	public float obterMedia() {
		float soma = 0;
		for (int i = 0; i < notas.length; i++) {
			soma += notas[i];
		}
		
		return soma/notas.length;
	}

}
