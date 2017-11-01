package br.com.comanda.dao;

import java.util.List;

import br.com.comanda.dto.Cliente;

public interface ClienteDAO {

	boolean adicionar(Cliente cliente);
	Cliente buscar(Long id);
	boolean excluir(Cliente cliente);
	boolean alterar(Cliente cliente);
	List<Cliente> listar();

}
