package br.com.comanda.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.comanda.dao.ComandaDAO;
import br.com.comanda.dao.TipoComandaDAO;
import br.com.comanda.dto.Comanda;
import br.com.comanda.dto.TipoComanda;

public class ComandaTeste {

	private static AnnotationConfigApplicationContext context;
	private static ComandaDAO comandaDAO;
	private static TipoComandaDAO tipoComandaDAO;
	private Comanda comanda;
	private TipoComanda tipoComanda;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.comanda");
		context.refresh();

		comandaDAO = (ComandaDAO) context.getBean("comandaDAO");
		tipoComandaDAO = (TipoComandaDAO) context.getBean("tipoComandaDAO");
	}

	@Test
	public void AdicionarComandaTeste() {

		tipoComanda = tipoComandaDAO.buscar(Integer.valueOf(1));

		comanda = new Comanda();
		comanda.setNumeroComanda(17);
		comanda.setStatus(true);
		comanda.setTipo(tipoComanda);

		assertEquals("Comanda adicionada com sucesso", true, comandaDAO.adicionar(comanda));

	}
	
	/*
	@Test
	public void BuscarComandaTeste() {

		assertEquals("Comanda adicionada com sucesso", true, comandaDAO.buscar(Long.valueOf(1)).getStatus());

	}
	
	
	@Test
	public void alterarComandaTeste() {

		comanda = comandaDAO.buscar(Long.valueOf(1));
		comanda.setStatus(false);

		assertEquals("Comanda adicionada com sucesso", true, comandaDAO.alterar(comanda));

	}
	
	
	@Test	
	public void listarComandaTeste() {

		assertEquals("Comanda adicionada com sucesso", 1, comandaDAO.listar().size());

	}
	
	
	
	@Test
	public void excluirComandaTeste() {

		comanda = comandaDAO.buscar(Long.valueOf(1));
	
		assertEquals("Comanda adicionada com sucesso", true, comandaDAO.excluir(comanda));

	}
	
	@Test	
	public void listarComandaAtivaTeste() {

		assertEquals("Comanda ativa listada com sucesso", 1, comandaDAO.listar().size());

	}
	*/
	
}
