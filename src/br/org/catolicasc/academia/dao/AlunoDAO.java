package br.org.catolicasc.academia.dao;

import java.util.Date;
import java.util.List;

import br.org.catolicasc.academia.model.Aluno;
import br.org.catolicasc.academia.model.Presenca;

public interface AlunoDAO {
	Aluno findById(Long id);
	void deleteAlunoByCPF(Long cpf);
	Aluno findAlunoByCPF(Long cpf);
	void save(Aluno aluno);
	List<Aluno> findAll();
	List<Presenca> findPresencasByDate(Date dtInicial, Date dtFinal);
}
