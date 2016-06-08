package br.org.catolicasc.academia.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.org.catolicasc.academia.model.Aluno;
import br.org.catolicasc.academia.model.Presenca;

@Repository("alunoDao")
public class AlunoDAOImpl extends AbstractDao<Long, Aluno> implements AlunoDAO {

	@Override
	public Aluno findById(Long id) {
		return getByKey(id);
	}

	@Override
	public void deleteAlunoByCPF(Long cpf) {
		Query query = getSession().createSQLQuery("delete from Aluno where cpf = :cpf");
		query.setLong("cpf", cpf);
		query.executeUpdate();
	}

	@Override
	public Aluno findAlunoByCPF(Long cpf) {
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

	@Override
	public List<Presenca> findPresencasByDate(Date dtInicial, Date dtFinal) {
		// TODO Auto-generated method stub
		return null;
	}

}
