package br.org.catolicasc.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.catolicasc.academia.dao.PagamentoDAO;
import br.org.catolicasc.academia.model.Pagamento;

@Service("pagamentoService")
@Transactional
public class PagamentoServiceImpl implements PagamentoService {

	@Autowired
	private PagamentoDAO dao;

	@Override
	public Pagamento findPagamentoByid(Long id) {
		return dao.findPagamentoByid(id);
	}

	@Override
	public void save(Pagamento pagamento) {
		dao.save(pagamento);
	}

	 /*
     * Como o método está rodando com Transaction, não é preciso chamar o
     * update do hibernate. Basta buscar a entidade do banco e atualizar com
     * os valores. Vai ser atualizado assim que a transação terminar.
     */
	@Override
	public void update(Pagamento pagamento) {
		Pagamento entity = dao.findById(pagamento.getId());
		if (entity != null) {
			entity.setId(pagamento.getId());
			entity.setDtPagamento(pagamento.getDtPagamento());
			entity.setValor(pagamento.getValor());
			entity.setAluno(pagamento.getAluno());			
		}
	}


	@Override
	public void deletePagamentoByid(Long id) {
		dao.deletePagamentoByid(id);
	}

	@Override
	public List<Pagamento> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Pagamento findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isPagamentoidUnique(Long id, Long id2) {
		// TODO Auto-generated method stub
		return false;
	}

}
