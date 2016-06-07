package br.org.catolicasc.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.catolicasc.academia.dao.AlunoDAO;
import br.org.catolicasc.academia.model.Aluno;

@Service("alunoService")
@Transactional
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoDAO dao;
	
	@Override
	public Aluno findById(Long	 id) {
		return dao.findById(id);
	}

	@Override
	public void save(Aluno aluno) {
		dao.save(aluno);
	}

	 /*
     * Como o método está rodando com Transaction, não é preciso chamar o
     * update do hibernate. Basta buscar a entidade do banco e atualizar com 
     * os valores. Vai ser atualizado assim que a transação terminar. 
     */
	@Override
	public void update(Aluno aluno) {
		Aluno entity = dao.findById(aluno.getId());
		if (entity != null) {
			entity.setNome(aluno.getNome());
			entity.setCpf(aluno.getCpf());
			entity.setDtNascimento(aluno.getDtNascimento());
			entity.setEndereco(aluno.getEndereco());
		}
	}

	
	@Override
	public void deleteAlunoByCPF(int cpf) {
		dao.deleteAlunoByCPF(cpf);
	}

	@Override
	public List<Aluno> findAll() {
		return dao.findAll();
	}

	@Override
	public Aluno findAlunoByCPF(int cpf) {
		return dao.findAlunoByCPF(cpf);
	}

	@Override
	public boolean isAlunoCPFUnique(Long id, int cpf) {
		Aluno aluno = dao.findAlunoByCPF(cpf);
		return (aluno == null || ((id != null) && (aluno.getId() == id)));
	}

}
