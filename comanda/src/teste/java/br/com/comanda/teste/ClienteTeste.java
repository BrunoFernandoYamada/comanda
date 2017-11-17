package br.com.comanda.teste;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.comanda.dao.ClienteDAO;
import br.com.comanda.dto.Cliente;

public class ClienteTeste {

	private static AnnotationConfigApplicationContext context;
	private static ClienteDAO clienteDAO;
	private Cliente cliente;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.comanda");
		context.refresh();
		
		clienteDAO = (ClienteDAO) context.getBean("clienteDAO");
	}
	
	@Test
	public void adicionarClienteTeste() {
		
		cliente = new Cliente();
		cliente.setNome("Venda ao consumidor");
		cliente.setBairro("");
		cliente.setCel("");
		cliente.setCidade("");
		cliente.setCpfCnpj("");
		cliente.setDataCadastro(new Date());
		cliente.setDataNascimento(new Date());
		cliente.setLogradouro("");
		cliente.setNumeroCasa("");
		cliente.setRgIe("");
		cliente.setTel("");
		cliente.setTipoPessoa('f');
		
		assertEquals("Cliente inserido com sucesso", true, clienteDAO.adicionar(cliente));
		
	}
	/*
	
	@Test 
	public void buscarClinteTeste() {
		
		assertEquals("Cliente encontrado com sucesso", "Venda ao consumidor", clienteDAO.buscar(Long.valueOf(1)).getNome());
		
	}
	
	
	@Test 
	public void atualizarClinteTeste() {
		
		
		cliente = clienteDAO.buscar(Long.valueOf(1));
		cliente.setBairro(null);
		cliente.setCel(null);
		cliente.setCidade(null);
		cliente.setCpfCnpj(null);
		cliente.setDataCadastro(new Date());
		cliente.setDataNascimento(null);
		cliente.setLogradouro(null);
		cliente.setNumeroCasa(null);
		cliente.setRgIe(null);
		cliente.setTel(null);
		cliente.setTipoPessoa('f');
		
		assertEquals("Cliente alterado com sucesso", true , clienteDAO.alterar(cliente));
		
	}
	
	@Test 
	public void ListarClinteTeste() {
		
		assertEquals("Clientes listados com sucesso", 1, clienteDAO.listar().size());
		
	}
	
	
	@Test 
	public void buscarClinteTeste() {
		
		cliente = clienteDAO.buscar(Long.valueOf(1));
		assertEquals("Cliente excluído com sucesso",true, clienteDAO.excluir(cliente));
		
	}
	*/
}
