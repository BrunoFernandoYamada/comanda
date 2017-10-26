/**
 * @author Bruno Fernando Yamada
 * 23 de out de 2017
 *	
 */
package br.com.comanda.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.comanda.dao.TipoComandaDAO;
import br.com.comanda.dto.TipoComanda;

@Repository("tipoComandaDAO")
@Transactional
public class TipoComandaDAOImpl implements TipoComandaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean adicionar(TipoComanda tipoComanda) {
		
		try {
			sessionFactory.getCurrentSession().persist(tipoComanda);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public TipoComanda buscar(int id) {
		
		return sessionFactory.getCurrentSession().get(TipoComanda.class, id);
	}

	@Override
	public boolean excluir(TipoComanda tipoComanda) {
		try {
			sessionFactory.getCurrentSession().delete(tipoComanda);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean alterar(TipoComanda tipoComanda) {
		
		try {
			sessionFactory.getCurrentSession().update(tipoComanda);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<TipoComanda> listar() {
		
		String listarQuery = "from TipoComanda";
		Query query = sessionFactory.getCurrentSession().createQuery(listarQuery);

		return query.getResultList();
	}

}
