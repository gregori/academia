package br.org.catolicasc.academia.service;

import java.util.List;

import br.org.catolicasc.academia.model.Aluno;
import br.org.catolicasc.academia.model.Matricula;

public interface MatriculaService {
	Matricula findById(Long id);
	void save(Matricula matricula);
	void update(Matricula matricula);
	void delete(Long id);
	List<Matricula> findAll();
}
