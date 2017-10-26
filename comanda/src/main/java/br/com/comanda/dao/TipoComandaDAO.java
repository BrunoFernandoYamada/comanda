package br.com.comanda.dao;

import java.util.List;

import br.com.comanda.dto.TipoComanda;

public interface TipoComandaDAO {
	
	boolean adicionar(TipoComanda tipoComanda);
	TipoComanda buscar(int id);
	boolean excluir(TipoComanda tipoComanda);
	boolean alterar(TipoComanda tipoComanda);
	List<TipoComanda> listar();
	
	
}
