package br.com.comanda.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.comanda.dao.ComandaDAO;
import br.com.comanda.dto.Comanda;

public class ComandaDAOImpl implements ComandaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean adicionar(Comanda comanda) {
		try {
			sessionFactory.getCurrentSession().persist(comanda);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Comanda buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean excluir(Comanda comanda) {
		try {
			sessionFactory.getCurrentSession().delete(comanda);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean alterar(Comanda comanda) {
		try {
			sessionFactory.getCurrentSession().persist(comanda);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public List<Comanda> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
