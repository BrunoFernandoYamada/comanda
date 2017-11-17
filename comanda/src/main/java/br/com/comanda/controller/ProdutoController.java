/**
 * 
 */
package br.com.comanda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dao.GrupoDAO;
import br.com.comanda.dao.LocalizacaoDAO;
import br.com.comanda.dto.Grupo;
import br.com.comanda.dto.Localizacao;
import br.com.comanda.dto.Produto;
import br.com.comanda.resources.GrupoEditor;
import br.com.comanda.resources.LocalizacaoEditor;

/**
 * @author Bruno Fernando Yamada
 * 16 de nov de 2017
 *	
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	
	@Autowired
	private GrupoDAO grupoDAO;
	
	@Autowired
	private LocalizacaoDAO localizacaoDAO;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder)     {
	      binder.registerCustomEditor(Grupo.class, new GrupoEditor(grupoDAO));
	      binder.registerCustomEditor(Localizacao.class, new LocalizacaoEditor(localizacaoDAO) );
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public ModelAndView gerirProduto() {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("titulo", "Gerir Produtos");
		mv.addObject("userClickGerirProduto", true);
		
		Produto produto =  new Produto();
		mv.addObject("produto", produto);
		
		return mv;
		
	}
	
	
	@ModelAttribute("grupos")
	public List<Grupo> listarGrupos(){
		return grupoDAO.listar();
	}
	
	@ModelAttribute("localizacoes")
	public List<Localizacao> listarLocalizacoes(){
		return localizacaoDAO.listar();
	}
	
	
	
	
}
