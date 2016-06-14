package br.org.catolicasc.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.catolicasc.academia.dao.MatriculaDAO;
import br.org.catolicasc.academia.model.Matricula;

@Service("alunoService")
@Transactional
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private MatriculaDAO dao;
	
	@Override
	public Matricula findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void save(Matricula matricula) {
		dao.save(matricula);
	}

	 /*
     * Como o método está rodando com Transaction, não é preciso chamar o
     * update do hibernate. Basta buscar a entidade do banco e atualizar com 
     * os valores. Vai ser atualizado assim que a transação terminar. 
     */
	@Override
	public void update(Matricula matricula) {
		Matricula entity = dao.findById(matricula.getId());
		if (entity != null) {
			entity.setData(matricula.getData());
			entity.setValidade(matricula.getValidade());
			entity.setAluno(matricula.getAluno());
			entity.setPlano(matricula.getPlano());

		}
	}

	
	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public List<Matricula> findAll() {
		return dao.findAll();
	}

}
