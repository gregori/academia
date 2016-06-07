package br.org.catolicasc.academia.dao;

import java.util.List;

import br.org.catolicasc.academia.model.Aluno;

public interface AlunoDAO {
	Aluno findById(Long id);
	void deleteAlunoByCPF(Long cpf);
	Aluno findAlunoByCPF(Long cpf);
	void save(Aluno aluno);
	List<Aluno> findAll();
}
