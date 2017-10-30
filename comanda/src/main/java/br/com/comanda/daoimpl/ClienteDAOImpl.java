package br.com.comanda.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.comanda.dao.ClienteDAO;
import br.com.comanda.dto.Cliente;

@Repository("clienteDAO")
@Transactional
public class ClienteDAOImpl implements ClienteDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean adicionar(Cliente cliente) {
		try {
			sessionFactory.getCurrentSession().persist(cliente);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Cliente buscar(Long id) {
		
		return sessionFactory.getCurrentSession().get(Cliente.class, id);
		
	}

	@Override
	public boolean excluir(Cliente cliente) {
		try {
			sessionFactory.getCurrentSession().delete(cliente);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean alterar(Cliente cliente) {
		try {
			sessionFactory.getCurrentSession().update(cliente);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public List<Cliente> listar() {
		String querySelecAllClientes = "FROM Cliente";
		Query query = sessionFactory.getCurrentSession().createQuery(querySelecAllClientes);
		
		return query.getResultList();
	}

}
