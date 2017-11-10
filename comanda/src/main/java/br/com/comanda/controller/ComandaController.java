package br.com.comanda.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dao.ClienteDAO;
import br.com.comanda.dao.ComandaDAO;
import br.com.comanda.dto.Cliente;
import br.com.comanda.dto.Comanda;
import br.com.comanda.dto.TipoComanda;

@Controller
public class ComandaController {
	
	@Autowired
	private ComandaDAO comandaDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@RequestMapping(value = {"/abrir/mesa/{numeroComanda}/status/{status}/id/{id}"})
	public ModelAndView abrirMesa(@PathVariable("numeroComanda") int numeroComanda, @PathVariable("status")boolean status, @PathVariable("id")Long id) {
		
		Comanda comanda;
		
		if(status == true) {
			comanda = comandaDAO.buscar(id);
			
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("UserClickComandaGerenciamento", true);
			return mv;
			
		}else {
			
			comanda = new Comanda();
			comanda.setHoraAbertura(new Date());
			comanda.setNumeroComanda(numeroComanda);
			comanda.setStatus(true);
			
			TipoComanda tipoComanda = new TipoComanda();
			tipoComanda.setId(1);
			
			comanda.setTipo(tipoComanda);
			
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("UserClickComandaSalvar", true);
			mv.addObject("comanda", comanda);
			return mv;
		}	
		
	}
	
	@RequestMapping("/salvarComanda")
	public String salvarComanda(@ModelAttribute("comanda") Comanda comanda, BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			
			model.addAttribute("titulo", "Configurações");
			model.addAttribute("mensagem", "Não foi possível salvar Mesa");
			model.addAttribute("UserClickComanda", true);
			
			return "index";
			
			
		}
		
		comandaDAO.adicionar(comanda);
		
		return "redirect:/abrir/mesa/" + comanda.getNumeroComanda() + "/status/ " + comanda.getStatus() + " /id/ " + comanda.getId();
		
	}
	
	public List<Cliente> listarClientes(){
		
		return clienteDAO.listar();
	}
	

}
