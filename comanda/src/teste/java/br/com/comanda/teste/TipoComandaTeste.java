/*
 * Author: Bruno Fernando Yamada
 * 23 de out de 2017
 * Classe Responsável por Teste TipoComanda
*/
package br.com.comanda.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.comanda.dao.TipoComandaDAO;
import br.com.comanda.dto.TipoComanda;

public class TipoComandaTeste {
	
	private static AnnotationConfigApplicationContext context;
	private static TipoComandaDAO tipoComandaDAO;
	private TipoComanda tipoComanda;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.comanda");
		context.refresh();
		
		tipoComandaDAO = (TipoComandaDAO) context.getBean("tipoComandaDAO");	
			
		}
	/*
	@Test
	public void adicionarTipoComandaTeste() {
		
		tipoComanda = new TipoComanda();
		tipoComanda.setNome("Fast Sell");
		
		assertEquals("Tipo de Comanda cadastrado com sucesso!", true, tipoComandaDAO.adicionar(tipoComanda));
		
	}
	
*/
/*	
	@Test
	public void buscarTipoComandaTeste() {
		
		tipoComanda = tipoComandaDAO.buscar(Integer.valueOf(1)); 
		System.err.println(tipoComanda.getNome());
		assertEquals("Tipo de Comanda cadastrado com sucesso!", "Delivery", tipoComanda.getNome());
		
	}
	*/
	/*
	@Test
	public void excluirTipoComandaTeste() {
		
		tipoComanda = tipoComandaDAO.buscar(1);

		assertEquals("Tipo de Comanda excluída com sucesso!", true, tipoComandaDAO.excluir(tipoComanda));
		System.out.println("Tipo de Comanda excluída com sucesso!");
	}
*/
	/*
	@Test
	public void alterarTipoComandaTeste() {
		
		tipoComanda = tipoComandaDAO.buscar(3);
		tipoComanda.setNome("Venda Rápida");

		assertEquals("Tipo de Comanda excluída com sucesso!", true, tipoComandaDAO.alterar(tipoComanda));
		System.out.println("Tipo de Comanda alterada com sucesso!");
	}
	*/
	@Test
	public void listarTipoComandaTeste() {
		
		List<TipoComanda> listaTipoComanda = tipoComandaDAO.listar();

		assertEquals("Tipo de Comanda Listada com sucesso!", 3 ,listaTipoComanda.size());
		
	}
}
