/**
 * 
 */
package br.com.comanda.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dao.GrupoDAO;
import br.com.comanda.dto.Grupo;
import br.com.comanda.resources.DataNascimentoEditor;

/**
 * @author Bruno Fernando Yamada
 * 17 de nov de 2017
 *	
 */
@Controller
@RequestMapping("/grupo")
public class GrupoController {
	
	@Autowired
	private GrupoDAO grupoDAO;
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.GET)
	public ModelAndView gerirGrupo(@RequestParam(name = "operation", required = false) String operation) {
	
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("titulo", "Gerenciamento de Grupo");
		mv.addObject("userClickGerirGrupo", true);
		
		if (operation != null) {
			if (operation.equals("grupo")) {
				mv.addObject("mensagem", "O Grupo foi salvo com sucesso!");
			}
		}
		
		Grupo grupo = new Grupo();
		
		mv.addObject("grupo", grupo);
		
		return mv;
				
	}
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.POST)
	public String salvarGrupo(@Valid @ModelAttribute("grupo") Grupo grupo,BindingResult result,Model model) {
	
		if(result.hasErrors()) {
			
			model.addAttribute("titulo", "Gerenciamento de Grupo");
			model.addAttribute("userClickGerirGrupo", true);
			
			return ("index");
			
		}
		
		if(grupo.getId() == 0) {
			grupoDAO.adicionar(grupo);
		}else {
			grupoDAO.alterar(grupo);
		}
		
		
		return "redirect:/grupo/cadastrar?operation=grupo";
				
	}
	
	@RequestMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") int id) {
	
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("titulo", "Gerenciamento de Grupo");
		mv.addObject("userClickGerirGrupo", true);
		mv.addObject("grupo", grupoDAO.buscar(id));
		
		return mv;
				
	}
}
