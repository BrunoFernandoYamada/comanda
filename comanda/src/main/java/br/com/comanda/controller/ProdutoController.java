/**
 * 
 */
package br.com.comanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dto.Produto;

/**
 * @author Bruno Fernando Yamada
 * 16 de nov de 2017
 *	
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@RequestMapping("/cadastrar")
	public ModelAndView gerirProduto() {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("titulo", "Gerir Produtos");
		mv.addObject("userClickGerirProduto", true);
		
		Produto produto =  new Produto();
		mv.addObject("produto", produto);
		
		return mv;
		
	}
	
}
