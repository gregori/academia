package br.org.catolicasc.academia.dao;

import java.util.List;

import br.org.catolicasc.academia.model.Matricula;

public interface MatriculaDAO {
	Matricula findById(Long id);
	void save(Matricula matricula);
	void update(Matricula matricula);
	void delete(Long id);
	List<Matricula> findAll();
}

