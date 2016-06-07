package br.org.catolicasc.academia.service;

import java.util.List;

import br.org.catolicasc.academia.model.Aluno;

public interface AlunoService {
	Aluno findById(Long id);
	void save(Aluno aluno);
	void update(Aluno aluno);
	void deleteAlunoByCPF(Long cpf);
	List<Aluno> findAll();
	Aluno findAlunoByCPF(Long cpf);
	boolean isAlunoCPFUnique(Long id, Long cpf);
}
