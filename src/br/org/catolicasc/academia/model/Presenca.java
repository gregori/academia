package br.org.catolicasc.academia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Presenca {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Aluno aluno;
	private Date dtPresenca;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Date getDtPresenca() {
		return dtPresenca;
	}

	public void setDtPresenca(Date dtPresenca) {
		this.dtPresenca = dtPresenca;
	}
}
