/**
 * 
 */
package br.com.comanda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dao.LocalizacaoDAO;
import br.com.comanda.dto.Localizacao;

/**
 * @author Bruno Fernando Yamada
 * 17 de nov de 2017
 *	
 */
@Controller
@RequestMapping("/localizacao")
public class LocalizacaoController {
	
	@Autowired
	private LocalizacaoDAO localizacaoDAO;
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.GET)
	public ModelAndView gerirLocalizacao(@RequestParam(name = "operation", required = false) String operation) {
	
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("titulo", "Gerenciamento de Localizacao");
		mv.addObject("userClickGerirLocalizacao", true);
		
		if (operation != null) {
			if (operation.equals("localizacao")) {
				mv.addObject("mensagem", "O Localizacao foi salvo com sucesso!");
			}
		}
		
		Localizacao localizacao = new Localizacao();
		
		mv.addObject("localizacao", localizacao);
		
		return mv;
				
	}
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.POST)
	public String salvarLocalizacao(@Valid @ModelAttribute("localizacao") Localizacao localizacao,BindingResult result,Model model) {
	
		if(result.hasErrors()) {
			
			model.addAttribute("titulo", "Gerenciamento de Localizacao");
			model.addAttribute("userClickGerirLocalizacao", true);
			model.addAttribute("mensagem", "Não foi possível salvar Localização");
			
			return ("index");
			
		}
		
		localizacaoDAO.adicionar(localizacao);
		
		return "redirect:/localizacao/cadastrar?operation=localizacao";
				
	}
}
