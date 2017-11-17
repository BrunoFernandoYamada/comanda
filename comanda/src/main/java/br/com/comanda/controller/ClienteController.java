/**
 * 
 */
package br.com.comanda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dao.ClienteDAO;
import br.com.comanda.dto.Cliente;

/**
 * @author Bruno Fernando Yamada
 * 17 de nov de 2017
 *	
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.GET)
	public ModelAndView gerirCliente(@RequestParam(name = "operation", required = false) String operation) {
	
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Gerenciamento de Cliente");
		mv.addObject("userClickGerirCliente", true);
		
		if (operation != null) {
			if (operation.equals("cliente")) {
				mv.addObject("message", "O Cliente foi salvo com sucesso!");
			}
		}
		
		Cliente cliente = new Cliente();
		mv.addObject("cliente", cliente);
		
		return mv;
				
	}
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.POST)
	public String salvarCliente(@Valid @ModelAttribute("cliente") Cliente cliente,BindingResult result ) {
	
		if(result.hasErrors()) {
			/*
			ModelAndView mv = new ModelAndView();
			mv.addObject("titulo", "Gerenciamento de Cliente");
			mv.addObject("userClickGerirCliente", true);
			*/
		}
		
		clienteDAO.adicionar(cliente);
		
		return "redirect:/cliente/cadastrar?operation=cliente";
				
	}
}
