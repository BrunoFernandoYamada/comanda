package br.com.comanda.controller;

import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dao.ClienteDAO;
import br.com.comanda.dao.ComandaDAO;
import br.com.comanda.dao.GrupoDAO;
import br.com.comanda.dao.ItemComandaDAO;
import br.com.comanda.dao.ProdutoDAO;
import br.com.comanda.dto.Cliente;
import br.com.comanda.dto.Comanda;
import br.com.comanda.dto.ItemComanda;
import br.com.comanda.dto.Produto;
import br.com.comanda.dto.TipoComanda;
import br.com.comanda.resources.ClienteEditor;

@Controller
public class ComandaController {

	@Autowired
	private ComandaDAO comandaDAO;

	@Autowired
	private ClienteDAO clienteDAO;

	@Autowired
	private ItemComandaDAO itemComandaDAO;

	@Autowired
	private GrupoDAO grupoDAO;
	
	@Autowired
	private ProdutoDAO produtoDAO;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Cliente.class, new ClienteEditor(clienteDAO));
	}

	@RequestMapping(value = { "/abrir/mesa/{numeroComanda}/status/{status}/id/{id}" })
	public ModelAndView abrirMesa(@PathVariable("numeroComanda") int numeroComanda,
			@PathVariable("status") boolean status, @PathVariable("id") Long id) {

		Comanda comanda;

		if (status == true) {
			comanda = comandaDAO.buscar(id);

			ModelAndView mv = new ModelAndView("index");
			mv.addObject("comanda", comanda);
			mv.addObject("grupos", grupoDAO.listar());
			mv.addObject("titulo", "Gerenciamento de Comanda");
			mv.addObject("userClickComandaGerenciamento", true);
			
			mv.addObject("listaItens", itemComandaDAO.listarItemComandaPorComanda(comanda.getId()));

			return mv;

		} else {

			comanda = new Comanda();
			comanda.setNumeroComanda(numeroComanda);
			comanda.setStatus(true);
			comanda.setValorTotal(0.00);
			comanda.setDesconto(0.00);

			ModelAndView mv = new ModelAndView("index");
			mv.addObject("titulo", "Cadastro de Comanda");
			mv.addObject("userClickComandaCadastro", true);
			mv.addObject("comanda", comanda);

			return mv;
		}

	}

	@RequestMapping("/salvarcomanda")
	public String salvarComanda(@Valid @ModelAttribute("comanda") Comanda comanda, BindingResult result, Model model) {

		/*
		 * if(result.hasErrors()) { model.addAttribute("titulo", "Configurações");
		 * model.addAttribute("mensagem", "Não foi possível salvar Mesa");
		 * model.addAttribute("userClickComanda", true); return "redirect:";
		 * 
		 * }
		 */

		TipoComanda tipoComanda = new TipoComanda();
		tipoComanda.setId(1);
		comanda.setValorTotal(0.0);
		comanda.setDesconto(0.0);
		comanda.setTipo(tipoComanda);
		comanda.setHoraAbertura(new Date());

		comandaDAO.adicionar(comanda);

		return "redirect:/abrir/mesa/" + comanda.getNumeroComanda() + "/status/" + comanda.getStatus() + "/id/"
				+ comanda.getId();

	}

	@RequestMapping(value = { "/adicionar/item/comanda/{id}/produto/{produto_id}/quantidade/{qtd}" })
	public String adicionarItem(@PathVariable("id") Long id,@PathVariable("produto_id") Long produto_id, @PathVariable("qtd") int qtd, Model model) {

		Comanda comanda = comandaDAO.buscar(id);
		Produto produto = produtoDAO.buscar(produto_id);
		
		
		
		ItemComanda itemComanda = new ItemComanda();
		itemComanda.setQuantidade(qtd);
		itemComanda.setComanda(comanda);
		itemComanda.setProduto(produto);
		itemComanda.setValorUnit(produto.getPreco());
		itemComanda.setValorToral(qtd * produto.getPreco());
		
		itemComandaDAO.adicionar(itemComanda);
		
		comanda.setValorTotal(comanda.getValorTotal() + itemComanda.getValorToral());
		
		comandaDAO.alterar(comanda);
		return "redirect:/abrir/mesa/"+comanda.getNumeroComanda()+"/status/"+comanda.getStatus()+"/id/"+comanda.getId();	
	}

	@ModelAttribute("clientes")
	public List<Cliente> listarClientes() {

		return clienteDAO.listar();
	}

}
