package br.org.catolicasc.academia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.org.catolicasc.academia.model.Pagamento;

@Repository("pagamentoDao")
public class PagamentoDAOImpl extends AbstractDao<Long, Pagamento> implements PagamentoDAO {


	@Override
	public void deletePagamentoByid(Long id) {
		Query query = getSession().createSQLQuery("delete from Pagamento where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public Pagamento findPagamentoByid(Long id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Pagamento) criteria.uniqueResult();
	}
	
	@Override
	public void save(Pagamento pagamento) {
		persist(pagamento);
	}

	@Override
	public Pagamento findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Pagamento pagamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPagamentoidUnique(Long id, Long id2) {
		// TODO Auto-generated method stub
		return false;
	}

}
