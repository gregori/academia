package br.org.catolicasc.academia.service;

import java.util.List;

import br.org.catolicasc.academia.model.Aluno;

public interface AlunoService {
	Aluno findById(Long id);
	void save(Aluno aluno);
	void update(Aluno aluno);
	void deleteAlunoByCPF(int cpf);
	List<Aluno> findAll();
	Aluno findAlunoByCPF(int cpf);
	boolean isAlunoCPFUnique(Long id, int cpf);
}
