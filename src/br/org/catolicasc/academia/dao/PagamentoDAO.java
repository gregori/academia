package br.org.catolicasc.academia.dao;

import org.springframework.stereotype.Repository;

import br.org.catolicasc.academia.model.Pagamento;;

@Repository("pagamentoDao")
public class PagamentoDAO extends AbstractDao<Long, Pagamento> {

	public PagamentoDAO() {
		super();
	}
}
