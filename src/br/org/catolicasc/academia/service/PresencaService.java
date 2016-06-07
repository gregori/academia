package br.org.catolicasc.academia.service;

import java.util.Date;
import java.util.List;

import br.org.catolicasc.academia.model.Presenca;

public interface PresencaService {
	Presenca findById(Long id);
	void save(Presenca presenca);
	void update(Presenca presenca);
	List<Presenca> findAll();
	List<Presenca> findPresencaByDate(Date dtInicial, Date dtFinal);
}
