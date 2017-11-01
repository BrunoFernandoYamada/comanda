package br.com.comanda.dao;

import java.util.List;

import br.com.comanda.dto.Comanda;

public interface ComandaDAO {
	
	boolean adicionar(Comanda comanda);
	Comanda buscar(Long id);
	boolean excluir(Comanda comanda);
	boolean alterar(Comanda comanda);
	List<Comanda> listar();
	List<Comanda> listarComandaAberta();
}
