package br.com.comanda.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.comanda.dao.ProdutoDAO;
import br.com.comanda.dto.Grupo;
import br.com.comanda.dto.Localizacao;
import br.com.comanda.dto.Produto;


public class ProdutoTeste {
	
	private static AnnotationConfigApplicationContext context;
	private static ProdutoDAO produtoDAO;
	private Produto produto;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.comanda");
		context.refresh();
		
		produtoDAO = (ProdutoDAO) context.getBean("produtoDAO");
		
	}

	@Test
	public void adicionarProdutoTeste() {
		
		Grupo grupo = new Grupo();
		grupo.setId(1);
		
		Localizacao localizacao = new Localizacao();
		localizacao.setId(1);
		
		produto = new Produto();
		produto.setNome("Hot Dog");
		produto.setGrupo(grupo);
		produto.setImagemUrl("C:\\sitema\\immage");
		produto.setLocalizacao(localizacao);
		produto.setPreco(12.90);
		produto.setQuantidadeEstoque(10);
		
		
		assertEquals("Produto cadastrado com sucesso!", true, produtoDAO.adicionar(produto));
		
	}
	
	
	@Test
	public void buscarProdutoTeste() {
		
		produto = produtoDAO.buscar(Long.valueOf(1)); 
		System.err.println(produto.getNome());
		assertEquals("Produto cadastrado com sucesso!", "Hot Dog", produto.getNome());
		
	}
	
	
	
	
	

	@Test
	public void alterarProdutoTeste() {
		
		produto = produtoDAO.buscar(Long.valueOf(1));
		produto.setImagemUrl("C:\\resources\\hotdog.jpg");

		assertEquals("Produto excluído com sucesso!", true, produtoDAO.alterar(produto));
		System.out.println("Produto alterado com sucesso!");
	}
	
	
	@Test
	public void listarProdutoTeste() {
		
		List<Produto> listaProduto = produtoDAO.listar();

		assertEquals("Produto Listado com sucesso!", 1 ,listaProduto.size());
		
	}
	
	@Test
	public void excluirProdutoTeste() {
		
		produto = produtoDAO.buscar(Long.valueOf(1));

		assertEquals("Produto excluído com sucesso!", true, produtoDAO.excluir(produto));
		System.out.println("Produto excluído com sucesso!");
	}
	
}
