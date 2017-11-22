package br.com.comanda.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.comanda.dao.ItemComandaDAO;
import br.com.comanda.dto.ItemComanda;

@Repository("itemComandaDAO")
@Transactional
public class ItemComandaDAOImpl implements ItemComandaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean adicionar(ItemComanda item) {
		try {
			sessionFactory.getCurrentSession().persist(item);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public ItemComanda buscar(Long id) {
	
			return sessionFactory.getCurrentSession().get(ItemComanda.class,id);
	
	}

	@Override
	public boolean excluir(ItemComanda item) {
		try {
			sessionFactory.getCurrentSession().delete(item);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterar(ItemComanda item) {
		try {
			sessionFactory.getCurrentSession().update(item);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<ItemComanda> listar() {
		String queryListarItens = "FROM ItemComanda";
		Query query = sessionFactory.getCurrentSession().createQuery(queryListarItens);
		return query.getResultList();
	}

	@Override
	public List<ItemComanda> listarItemComandaPorComanda(Long id) {
		String str = "FROM ItemComanda where comanda_id = :id";
		Query query = sessionFactory.getCurrentSession().createQuery(str);
		query.setParameter("id", id);
		return query.getResultList();
	}


}
