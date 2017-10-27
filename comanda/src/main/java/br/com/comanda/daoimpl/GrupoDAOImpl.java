package br.com.comanda.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.comanda.dao.GrupoDAO;
import br.com.comanda.dto.Grupo;

@Repository("grupoDAO")
@Transactional
public class GrupoDAOImpl implements GrupoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean adicionar(Grupo grupo) {
		try {
			sessionFactory.getCurrentSession().persist(grupo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Grupo buscar(int id) {
		
		return sessionFactory.getCurrentSession().get(Grupo.class, id);
		
	}

	@Override
	public boolean excluir(Grupo grupo) {
		try {
			sessionFactory.getCurrentSession().delete(grupo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean alterar(Grupo grupo) {
		try {
			sessionFactory.getCurrentSession().update(grupo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Grupo> listar() {
		String selectAllQuery = "FROM Grupo";
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllQuery);
		return query.getResultList(); 
	}

}
