package br.com.comanda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dao.MesaDAO;
import br.com.comanda.daoimpl.MesaDAOImpl;
import br.com.comanda.dto.Mesa;

@Controller
public class paginaController {
	
	
	@Autowired
	private MesaDAO mesas;
	
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("titulo", "Comanda");
		mv.addObject("mensagem", "Bem vindo ao Sitema Comanda!");
		mv.addObject("userClickHome", true);
		mv.addObject("mesas", mesas.list());
		return mv;
	}
}
