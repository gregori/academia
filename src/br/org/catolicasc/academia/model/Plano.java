package br.org.catolicasc.academia.model;

import javax.persistence.Entity;

@Entity
public class Plano {

	private long id;
	private String nome;
	private String descricao;
	private double valor;
	private int aulas;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getAulas() {
		return this.aulas;
	}

	public void setAulas(int aulas) {
		this.aulas = aulas;
	}

}
