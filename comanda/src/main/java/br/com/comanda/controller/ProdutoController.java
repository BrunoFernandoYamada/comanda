/**
 * 
 */
package br.com.comanda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.comanda.dao.GrupoDAO;
import br.com.comanda.dao.LocalizacaoDAO;
import br.com.comanda.dao.ProdutoDAO;
import br.com.comanda.dto.Grupo;
import br.com.comanda.dto.Localizacao;
import br.com.comanda.dto.Produto;
import br.com.comanda.resources.GrupoEditor;
import br.com.comanda.resources.LocalizacaoEditor;
import br.com.comanda.util.FileUploadUtility;
import br.com.comanda.util.ParseDoubleToDecimalUtility;

/**
 * @author Bruno Fernando Yamada 16 de nov de 2017
 * 
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoDAO produtoDAO;

	@Autowired
	private GrupoDAO grupoDAO;

	@Autowired
	private LocalizacaoDAO localizacaoDAO;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Grupo.class, new GrupoEditor(grupoDAO));
		binder.registerCustomEditor(Localizacao.class, new LocalizacaoEditor(localizacaoDAO));
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView gerirProduto(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("titulo", "Gerir Produtos");
		mv.addObject("userClickGerirProduto", true);

		if (operation != null) {
			if (operation.equals("produto")) {
				mv.addObject("mensagem", "O Produto foi salvo com sucesso!");
			}
		}
		
		Produto produto = new Produto();
		mv.addObject("produto", produto);

		return mv;

	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String salvarProduto(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Gerir Produtos");
			model.addAttribute("userClickGerirProduto", true);
			model.addAttribute("mensagem", "Não foi possível salvar o Produto!");
			
			System.out.println(result.getErrorCount());

			return "index";
		}

		if (!produto.getFile().getOriginalFilename().equals("")) {
			produto.setImagemUrl(produto.getFile().getOriginalFilename());
			FileUploadUtility.uploadFile(request, produto.getFile(), produto.getImagemUrl());
		}
		
		ParseDoubleToDecimalUtility pd = new ParseDoubleToDecimalUtility();
				
		System.out.println("VALOR DO PRODUTO::::::::::::::::::: " + produto.getPreco());
		
		produtoDAO.adicionar(produto);
		
		

		return "redirect:/produto/cadastrar?operation=produto";

	}

	@ModelAttribute("grupos")
	public List<Grupo> listarGrupos() {
		return grupoDAO.listar();
	}

	@ModelAttribute("localizacoes")
	public List<Localizacao> listarLocalizacoes() {
		return localizacaoDAO.listar();
	}

}
