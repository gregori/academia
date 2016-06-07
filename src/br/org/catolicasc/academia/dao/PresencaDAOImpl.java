package br.org.catolicasc.academia.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.org.catolicasc.academia.model.Presenca;

@Repository("presencaDao")
public class PresencaDAOImpl extends AbstractDao<Long, Presenca> implements PresencaDAO {

	@Override
	public Presenca findById(Long id) {
		return getByKey(id);
	}

	@Override
	public void save(Presenca presenca) {
		persist(presenca);
	}

	@Override
	public List<Presenca> findAll() {
		return super.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Presenca> findPresencaByDate(Date dtInicial, Date dtFinal) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.between("dtPresenca", dtInicial, dtFinal));
		return (List<Presenca>) criteria.list();
	}
}
