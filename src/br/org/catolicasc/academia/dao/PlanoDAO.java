package br.org.catolicasc.academia.dao;

import org.springframework.stereotype.Repository;

import br.org.catolicasc.academia.model.Plano;

@Repository("planoDao")
public class PlanoDAO extends AbstractDao<Long, Plano> {
	public PlanoDAO() {
		super();
	}
}
