package br.com.comanda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dao.ComandaDAO;
import br.com.comanda.dao.ConfigDAO;
import br.com.comanda.dto.Comanda;
import br.com.comanda.dto.Config;
import br.com.comanda.dto.TipoComanda;

@Controller
public class PaginaController {

	@Autowired
	private ComandaDAO comandaDAO;

	@Autowired
	private ConfigDAO configDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		
		if (configDAO.verificarConfig() == false) {
			configDAO.adicionarConfigPadrao();
		}
		
		TipoComanda tipoComanda = new TipoComanda();
		tipoComanda.setId(1);
		
		List<Comanda> comandas = new ArrayList<Comanda>();
		int quantidadeMesas = configDAO.buscar(1).getQuantComanda();
		List<Comanda> comandasAbertas = comandaDAO.listarComandaAbertaPorTipoComanda(tipoComanda);
		
		for (int i = 1; i <= quantidadeMesas; i++) {

			Comanda comanda = new Comanda();
			comanda.setNumeroComanda(i);
			comanda.setStatus(false);

			comandas.add(comanda);

		}
		
		for(Comanda comandaAberta : comandasAbertas) {

			comandas.set(comandaAberta.getNumeroComanda() - 1 , comandaAberta);
		}

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("titulo", "Comanda");
		mv.addObject("mensagem", "Bem vindo ao Sitema Comanda!");
		mv.addObject("userClickComanda", true);
/*
		mv.addObject("quantidadeMesas", comandaDAO.listarComandaAberta());
*/	
		mv.addObject("comandas", comandas);

	return mv;
	}
	
	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public ModelAndView abreConfig() {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("config", configDAO.buscar(1));
		mv.addObject("titulo", "Comanda");
		mv.addObject("mensagem", "Bem vindo ao Sitema Comanda!");
		mv.addObject("UserClickConfig", true);
		
		return mv;
	}
	
	@RequestMapping(value = "/config", method = RequestMethod.POST)
	public String salvaConfig(@Valid @ModelAttribute("config") Config config,BindingResult results,Model model) {
		
		if(results.hasErrors()) {
			model.addAttribute("titulo", "Configurações");
			model.addAttribute("UserClickConfig", true);
		
			return "index";
		}
		
		configDAO.alterar(config);
		
		return "redirect:/config";	
	}
	
}
