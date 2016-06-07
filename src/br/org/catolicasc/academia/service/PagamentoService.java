package br.org.catolicasc.academia.service;

import java.util.List;

import br.org.catolicasc.academia.model.Pagamento;

public interface PagamentoService {
	Pagamento findById(Long id);
	void save(Pagamento pagamento);
	void update(Pagamento pagamento);
	void deletePagamentoByid(Long id);
	List<Pagamento> findAll();
	Pagamento findPagamentoByid(Long id);
	boolean isPagamentoidUnique(Long id, Long id2);
}
