package br.com.comanda.dao;

import java.util.List;

import br.com.comanda.dto.Grupo;

public interface GrupoDAO {
	
	boolean adicionar(Grupo grupo);
	Grupo buscar(int id);
	boolean excluir(Grupo grupo);
	boolean alterar(Grupo grupo);
	List<Grupo> listar();

}
