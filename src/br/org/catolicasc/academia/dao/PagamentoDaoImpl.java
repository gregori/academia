package br.org.catolicasc.academia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

import br.org.catolicasc.academia.model.Pagamento;

public class PagamentoDaoImpl extends AbstractDao<Long, Pagamento> implements PagamentoDao {

	@Override
	public Pagamento findById(Long id) {
		return getByKey(id);
	}

	@Override
	public void save(Pagamento pagamento) {
		persist(pagamento);
	}

	@Override
	public void delete(Long id) {
		Query query = getSession().createSQLQuery("delete from Pagamento where id = :id");
		query.setLong("id", id);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pagamento> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Pagamento>) criteria.list();
	}

}
