package br.com.comanda.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.comanda.dao.LocalizacaoDAO;
import br.com.comanda.dto.Localizacao;

@Repository("localizacaoDAO")
@Transactional
public class LocalizacaoDAOImpl implements LocalizacaoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean adicionar(Localizacao localizacao) {
		try {
			sessionFactory.getCurrentSession().persist(localizacao);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Localizacao buscar(int id) {
		return sessionFactory.getCurrentSession().get(Localizacao.class, id);
	}

	@Override
	public boolean excluir(Localizacao localizacao) {
		try {
			sessionFactory.getCurrentSession().delete(localizacao);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean alterar(Localizacao localizacao) {
		try {
			sessionFactory.getCurrentSession().update(localizacao);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Localizacao> listar() {
		String listarQuery = "from Localizacao";
		Query query = sessionFactory.getCurrentSession().createQuery(listarQuery);

		return  query.getResultList();
	}

}
