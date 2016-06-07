package br.org.catolicasc.academia.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.catolicasc.academia.dao.PresencaDAO;
import br.org.catolicasc.academia.model.Presenca;

@Service("presencaService")
@Transactional
public class PresencaServiceImpl implements PresencaService {

	@Autowired
	private PresencaDAO dao;

	@Override
	public Presenca findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void save(Presenca presenca) {
		dao.save(presenca);
	}

	@Override
	public void update(Presenca presenca) {
		Presenca entity = dao.findById(presenca.getId());
		if (entity != null) {
			entity.setAluno(presenca.getAluno());
			entity.setDtPresenca(presenca.getDtPresenca());
		}
	}

	@Override
	public List<Presenca> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Presenca> findPresencaByDate(Date dtInicial, Date dtFinal) {
		return dao.findPresencaByDate(dtInicial, dtFinal);
	}

}
