package br.com.comanda.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.comanda.dao.GrupoDAO;
import br.com.comanda.dto.Grupo;

public class GrupoTeste {
	
	private static AnnotationConfigApplicationContext context;
	private static GrupoDAO grupoDAO;
	private Grupo grupo;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.comanda");
		context.refresh();
		
		grupoDAO = (GrupoDAO) context.getBean("grupoDAO");
		
	}
	
	
	@Test
	public void adicionarGrupoTeste() {
		
		grupo = new Grupo();
		grupo.setNome("Bebidas");
		
		assertEquals("Tipo de Comanda cadastrado com sucesso!", true, grupoDAO.adicionar(grupo));
		
	}
	
	
}
