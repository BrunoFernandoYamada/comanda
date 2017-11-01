package br.com.comanda.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.comanda.dao.LocalizacaoDAO;
import br.com.comanda.dto.Localizacao;


public class LocalizacaoTeste {
	
	private static AnnotationConfigApplicationContext context;
	private static LocalizacaoDAO localizacaoDAO;
	private Localizacao localizacao;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.comanda");
		context.refresh();
		
		localizacaoDAO = (LocalizacaoDAO) context.getBean("localizacaoDAO");
		
	}


	@Test
	public void adicionarLocalizacaoTeste() {
		
		localizacao = new Localizacao();
		localizacao.setNome("Cozinha");
		localizacao.setCaminhoImpressao("\\C:\\meucompurtador\\impressora");
		
		assertEquals("Localizacao cadastrado com sucesso!", true, localizacaoDAO.adicionar(localizacao));
		
	}

	/*
	@Test
	public void buscarLocalizacaoTeste() {
		
		localizacao = localizacaoDAO.buscar(Integer.valueOf(1)); 
		System.err.println(localizacao.getNome());
		assertEquals("Localizacao cadastrado com sucesso!", "Cozinha", localizacao.getNome());
		
	}
	
	
	
	@Test
	public void excluirLocalizacaoTeste() {
		
		localizacao = localizacaoDAO.buscar(1);

		assertEquals("Localizacao excluído com sucesso!", true, localizacaoDAO.excluir(localizacao));
		System.out.println("Localizacao excluído com sucesso!");
	}
	
	
	@Test
	public void alterarLocalizacaoTeste() {
		
		localizacao = localizacaoDAO.buscar(1);
		localizacao.setNome("Balcão");

		assertEquals("Localizacao alterado com sucesso!", true, localizacaoDAO.alterar(localizacao));
		System.out.println("Localizacao alterado com sucesso!");
	}
	

	@Test
	public void listarLocalizacaoTeste() {
		
		List<Localizacao> listaLocalizacao = localizacaoDAO.listar();

		assertEquals("Localizacao Listado com sucesso!", 1 ,listaLocalizacao.size());
		
	}
	
	
	*/

}
