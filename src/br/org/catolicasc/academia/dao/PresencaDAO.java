package br.org.catolicasc.academia.dao;

import java.util.Date;
import java.util.List;

import br.org.catolicasc.academia.model.Presenca;

public interface PresencaDAO {
	Presenca findById(Long id);
	void save(Presenca presenca);
	List<Presenca> findAll();
	List<Presenca> findPresencaByDate(Date dtInicial, Date dtFinal);
}
