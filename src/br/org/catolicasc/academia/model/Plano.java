package br.org.catolicasc.academia.model;

public class Plano {

	private int id;
	private String nome;
	private String descricao;
	private String valor;
	private int aulas;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getAulas() {
		return this.aulas;
	}

	public void setAulas(int aulas) {
		this.aulas = aulas;
	}

}
