package br.com.comanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dao.ComandaDAO;
import br.com.comanda.dto.Comanda;

@Controller
@RequestMapping("/abrir")
public class ComandaController {
	
	@Autowired
	private ComandaDAO comandaDAO;
	
	@RequestMapping(value = {"/mesa/{numeroComanda}/status/{status}/id/{id}"})
	public ModelAndView abrirMesa(@PathVariable("numeroComanda") int numeroComanda, @PathVariable("status")boolean status, @PathVariable("id")Long id) {
		
		Comanda comanda;
		
		if(status == true) {
			comanda = comandaDAO.buscar(id);
			
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("UserClickComandaGerenciamento", true);
			return mv;
			
		}else {
			comanda = new Comanda();
			comanda.setNumeroComanda(numeroComanda);
			comanda.setStatus(true);
			
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("UserClickComandaCadastro", true);
			return mv;
		}
		
		
		
		
		
		
		
	}

}
