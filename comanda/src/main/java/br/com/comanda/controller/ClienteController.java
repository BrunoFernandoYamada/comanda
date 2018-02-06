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

import br.com.comanda.dao.ClienteDAO;
import br.com.comanda.dto.Cliente;
import br.com.comanda.resources.DataNascimentoEditor;

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
	
	@InitBinder
	protected void initBinder(WebDataBinder binder)     {
	      binder.registerCustomEditor(Date.class, new DataNascimentoEditor(new SimpleDateFormat("dd/MM/yyyy")));
	}
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.GET)
	public ModelAndView gerirCliente(@RequestParam(name = "operation", required = false) String operation) {
	
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("titulo", "Gerenciamento de Cliente");
		mv.addObject("userClickGerirCliente", true);
		
		if (operation != null) {
			if (operation.equals("cliente")) {
				mv.addObject("mensagem", "O Cliente foi salvo com sucesso!");
			}
		}
		
		Cliente cliente = new Cliente();
		
		mv.addObject("cliente", cliente);
		
		return mv;
				
	}
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.POST)
	public String salvarCliente(@Valid @ModelAttribute("cliente") Cliente cliente,BindingResult result,Model model) {
	
		if(result.hasErrors()) {
			
			model.addAttribute("titulo", "Gerenciamento de Cliente");
			model.addAttribute("userClickGerirCliente", true);
			
			return ("index");
			
		}
		if(cliente.getCpfCnpj() == "") {
			cliente.setCpfCnpj(null);
		}
		
		if(cliente.getId() == 0) {
			clienteDAO.adicionar(cliente);
		}else {
			clienteDAO.alterar(cliente);
		}
		return "redirect:/cliente/cadastrar?operation=cliente";
				
	}
	
	@RequestMapping(value="/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("titulo", "Gerenciamento de Cliente");
		mv.addObject("userClickGerirCliente", true);
		mv.addObject("cliente", clienteDAO.buscar(id));
		
		return mv;
		
		
	}
}
