package br.com.comanda.dao;

import java.util.List;

import br.com.comanda.dto.Localizacao;

public interface LocalizacaoDAO {

	boolean adicionar(Localizacao localizacao);
	Localizacao buscar(int id);
	boolean excluir(Localizacao localizacao);
	boolean alterar(Localizacao localizacao);
	List<Localizacao> listar();
}
