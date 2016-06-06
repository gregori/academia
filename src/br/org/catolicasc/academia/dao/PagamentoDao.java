package br.org.catolicasc.academia.dao;

import java.util.List;

import br.org.catolicasc.academia.model.Pagamento;

public interface PagamentoDao {

	Pagamento findById(Long id);
 
    void save(Pagamento pagamento);
     
    void delete(Long id);
     
    List<Pagamento> findAll();
}