package br.org.catolicasc.academia.dao;

import org.springframework.stereotype.Repository;

import br.org.catolicasc.academia.model.Presenca;

@Repository("presencaDao")
public class PresencaDAO extends AbstractDao<Long, Presenca> {

	public PresencaDAO() {
		super();
	}
}
