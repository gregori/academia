package br.org.catolicasc.academia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.org.catolicasc.academia.model.Aluno;

@Repository("alunoDao")
public class AlunoDAOImpl extends AbstractDao<Long, Aluno> implements AlunoDAO {

	@Override
	public Aluno findById(Long id) {
		return getByKey(id);
	}

	@Override
	public void deleteAlunoByCPF(int cpf) {
		Query query = getSession().createSQLQuery("delete from Aluno where cpf = :cpf");
		query.setInteger("cpf", cpf);
		query.executeUpdate();
	}

	@Override
	public Aluno findAlunoByCPF(int cpf) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("cpf", cpf));
		return (Aluno) criteria.uniqueResult();
	}
	
	@Override
	public void save(Aluno aluno) {
		persist(aluno);
	}
	
	@Override
	public List<Aluno> findAll() {
		return super.findAll();
	}

}
