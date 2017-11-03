package br.com.comanda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dao.ComandaDAO;
import br.com.comanda.dao.ConfigDAO;
import br.com.comanda.dto.Comanda;
import br.com.comanda.dto.Mesa;

@Controller
public class paginaController {

	@Autowired
	private ComandaDAO comandaDAO;

	@Autowired
	private ConfigDAO configDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		
		if (configDAO.verificarConfig() == false) {
			configDAO.adicionarConfigPadrao();
		}
		
		List<Comanda> comandas = new ArrayList<Comanda>();
		int quantidadeMesas = configDAO.buscar(1).getQuantComanda();
		List<Comanda> comandasAbertas = comandaDAO.listarComandaAberta();
		
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
}
