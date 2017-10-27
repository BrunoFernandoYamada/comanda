package br.com.comanda.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
		grupo.setNome("Lanches");
		
		assertEquals("Grupo cadastrado com sucesso!", true, grupoDAO.adicionar(grupo));
		
	}
	
	
	@Test
	public void buscarGrupoTeste() {
		
		grupo = grupoDAO.buscar(Integer.valueOf(1)); 
		System.err.println(grupo.getNome());
		assertEquals("Grupo cadastrado com sucesso!", "Lanches", grupo.getNome());
		
	}
	
	
	
	@Test
	public void excluirGrupoTeste() {
		
		grupo = grupoDAO.buscar(1);

		assertEquals("Grupo excluído com sucesso!", true, grupoDAO.excluir(grupo));
		System.out.println("Grupo excluído com sucesso!");
	}


	@Test
	public void alterarGrupoTeste() {
		
		grupo = grupoDAO.buscar(1);
		grupo.setNome("Bebidas");

		assertEquals("Grupo excluído com sucesso!", true, grupoDAO.alterar(grupo));
		System.out.println("Grupo alterado com sucesso!");
	}
	

	@Test
	public void listarGrupoTeste() {
		
		List<Grupo> listaGrupo = grupoDAO.listar();

		assertEquals("Grupo Listado com sucesso!", 1 ,listaGrupo.size());
		
	}
	
	
	
}
