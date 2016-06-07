package br.org.catolicasc.academia.dao;

import org.springframework.stereotype.Repository;

import br.org.catolicasc.academia.model.Matricula;

@Repository("alunoDao")
public class MatriculaDAO extends AbstractDao<Long, Matricula> {

	public MatriculaDAO() {
		super();
	}
	
}
