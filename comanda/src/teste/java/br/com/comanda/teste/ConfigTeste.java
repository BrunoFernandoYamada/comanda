package br.com.comanda.teste;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.comanda.dao.ConfigDAO;
import br.com.comanda.dto.Config;

public class ConfigTeste {
	
	private static AnnotationConfigApplicationContext context;
	private static ConfigDAO configDAO;
	private Config config;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.comanda");
		context.refresh();
		configDAO = (ConfigDAO) context.getBean("configDAO");
		
	}
	/*
	@Test
	public void adiconarConfigPadraoTeste() {
		
		assertEquals("Adicionado com sucesso", true, configDAO.adicionarConfigPadrao());
		
	}
	
	@Test
	public void verificarrConfigPadraoTeste() {
		
		assertEquals("Config verificada e existente", true, configDAO.verificarConfig());
		
	}

*/
	@Test
	public void buscarEalterarConfigPadraoTeste() {
		
		config = configDAO.buscar(1);
		config.setQuantFastSell(1);
		assertEquals("Config verificada e existente", true, configDAO.alterar(config));
		
	}
}
