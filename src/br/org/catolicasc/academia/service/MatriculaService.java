package br.org.catolicasc.academia.service;

import java.util.List;

import br.org.catolicasc.academia.model.Matricula;

public interface MatriculaService {
	Matricula findById(int id);
	void save(Matricula matricula);
	void update(Matricula matricula);
	void delete(int id);
	List<Matricula> findAll();
}
