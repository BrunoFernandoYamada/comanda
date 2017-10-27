package br.com.comanda.dao;

import java.util.List;

import br.com.comanda.dto.Grupo;

public interface GrupoDAO {
	
	boolean adicionar(Grupo Grupo);
	Grupo buscar(int id);
	boolean excluir(Grupo Grupo);
	boolean alterar(Grupo Grupo);
	List<Grupo> listar();

}
