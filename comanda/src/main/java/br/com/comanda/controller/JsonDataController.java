/**
 * 
 */
package br.com.comanda.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.comanda.dao.ItemComandaDAO;
import br.com.comanda.dao.ProdutoDAO;
import br.com.comanda.dto.ItemComanda;
import br.com.comanda.dto.Produto;

/**
 * @author Bruno Fernando Yamada
 * 21 de nov de 2017
 *	
 */
@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private ItemComandaDAO itemComandaDAO;
	
	@RequestMapping("/listarProdutoPorGrupo/{id}")
	@ResponseBody
	public List<Produto> listarProsutosPorCategoria(@PathVariable("id") int id){
		
		return produtoDAO.listarProdutoPorGrupo(id);
		
	}
	
	@RequestMapping("/listarComandaItens/{id}")
	@ResponseBody
	public List<ItemComanda> listarComandaItens(@PathVariable("id") Long id){
		
		return itemComandaDAO.listarItemComandaPorComanda(id);
		
	}
}
