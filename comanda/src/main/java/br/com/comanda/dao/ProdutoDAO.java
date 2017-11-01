package br.com.comanda.dao;

import java.util.List;

import br.com.comanda.dto.Produto;

public interface ProdutoDAO {

	boolean adicionar(Produto produto);
	Produto buscar(Long id);
	boolean excluir(Produto produto);
	boolean alterar(Produto produto);
	List<Produto> listar();
	
}
