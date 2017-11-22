package br.com.comanda.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.comanda.dao.ItemComandaDAO;
import br.com.comanda.dto.Comanda;
import br.com.comanda.dto.ItemComanda;
import br.com.comanda.dto.Produto;

public class ItemComandaTeste {
	private static AnnotationConfigApplicationContext context;
	private static ItemComandaDAO itemComandaDAO;
	private ItemComanda itemComanda;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.comanda");
		context.refresh();

		itemComandaDAO = (ItemComandaDAO) context.getBean("itemComandaDAO");
	}
	/*
	@Test
	public void AdicionarComandaTeste() {
		
		Comanda comanda = new Comanda();
		comanda.setId(Long.valueOf(1));
		
		Produto produto = new Produto();
		produto.setId(Long.valueOf(1));

		ItemComanda item = new ItemComanda();
		item.setComanda(comanda);
		item.setProduto(produto);
		item.setQuantidade(1);
		item.setValorToral(12.0);
		item.setValorUnit(12.0);

		assertEquals("Comanda adicionada com sucesso", true, itemComandaDAO.adicionar(item));

	}
	
	
	@Test
	public void BuscaritemComandaTeste() {

		assertEquals("itemComanda adicionado com sucesso", "X-Salada", itemComandaDAO.buscar(Long.valueOf(1)).getProduto().getNome());

	}
	
	
	
	@Test
	public void alteraritemComandaTeste() {

		itemComanda = itemComandaDAO.buscar(Long.valueOf(1));
		itemComanda.setQuantidade(30);;

		assertEquals("itemComanda alterado com sucesso", true, itemComandaDAO.alterar(itemComanda));

	}
	
	
	
	@Test	
	public void listaritemComandaTeste() {

		assertEquals("itemComanda listado com sucesso", 1, itemComandaDAO.listar().size());

	}
	
	
	
	@Test
	public void excluiritemComandaTeste() {

		itemComanda = itemComandaDAO.buscar(Long.valueOf(1));
	
		assertEquals("itemComanda excluido com sucesso", true, itemComandaDAO.excluir(itemComanda));

	}
	
	@Test	
	public void listaritemComandaTeste() {

		assertEquals("itemComanda ativa listada com sucesso", 1, itemComandaDAO.listar().size());

	}
	*/
	@Test	
	public void listaritemComandaPorComandaTeste() {

		assertEquals("itemComanda ativa listada com sucesso", 1, itemComandaDAO.listarItemComandaPorComanda(Long.valueOf(1)).size());

	}
	

}
