package br.com.comanda.dao;

import br.com.comanda.dto.Config;

public interface ConfigDAO {
	
	boolean adicionarConfigPadrao();
	boolean verificarConfig();
	boolean alterar(Config config);
	Config buscar(int id);

}
