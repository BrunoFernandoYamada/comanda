/*
 * Author: Bruno Fernando Yamada
 * 23 de out de 2017
 * Classe Responsável por Teste TipoComanda
*/
package br.com.comanda.teste;

import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void adicionarTipoComandaTeste() {
		
		tipoComanda = new TipoComanda();
		tipoComanda.setNome("Delivery");
		
		assertEquals("Tipo de Comanda cadastrado com sucesso!", true, tipoComandaDAO.adicionar(tipoComanda));
		
	}

}
