package br.org.catolicasc.academia.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import br.org.catolicasc.academia.model.Matricula;

@Repository("matriculaDao")
public class MatriculaDAOImpl extends AbstractDao<Long, Matricula> implements MatriculaDAO {

	@Override
	public Matricula findById(Long id) {
		return getByKey(id);
	}

	@Override
	public void delete(Long id) {
		Query query = getSession().createSQLQuery("delete from Matricula where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}
	
	@Override
	public void save(Matricula matricula) {
		persist(matricula);
	}
	
	@Override
	public List<Matricula> findAll() {
		return super.findAll();
	}

	@Override
	public void update(Matricula matricula) {
		persist(matricula);
	}

}
