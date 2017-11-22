package br.com.comanda.dao;

import java.util.List;

import br.com.comanda.dto.ItemComanda;

public interface ItemComandaDAO {
	
	boolean adicionar(ItemComanda item);
	ItemComanda buscar(Long id);
	boolean excluir(ItemComanda item);
	boolean alterar(ItemComanda item);
	List<ItemComanda> listar();
	List<ItemComanda> listarItemComandaPorComanda(Long id);

}
