package br.com.comanda.daoimpl;

import org.hibernate.SessionFactory;
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

}
