package br.org.catolicasc.academia.model;

import java.util.Date;

public class Presenca {

	private long id;
	private String aluno;
	private Date dtPresenca;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public Date getDtPresenca() {
		return dtPresenca;
	}

	public void setDtPresenca(Date dtPresenca) {
		this.dtPresenca = dtPresenca;
	}
}
