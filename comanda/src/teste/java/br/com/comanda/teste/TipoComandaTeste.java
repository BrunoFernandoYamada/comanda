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
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.comanda");
		context.refresh();
		
		tipoComandaDAO = (TipoComandaDAO) context.getBean("tipoComandaDAO");	
			
		}
	
	@Test
	public void adicionarTipoComandaTeste() {
		
		TipoComanda tipo = new TipoComanda();
		tipo.setNome("Mesa");
		
		assertEquals("Tipo de Comanda cadastrado com sucesso!", true, tipoComandaDAO.adicionar(tipo));
		
	}

}
