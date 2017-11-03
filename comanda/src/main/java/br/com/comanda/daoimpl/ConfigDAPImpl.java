package br.com.comanda.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.comanda.dao.ConfigDAO;
import br.com.comanda.dto.Config;

@Repository("configDAO")
@Transactional
public class ConfigDAPImpl implements ConfigDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean adicionarConfigPadrao() {
		Config config = new Config();
		config.setQuantComanda(30);
		config.setQuantDelivey(30);
		config.setQuantFastSell(0);
		try {
			sessionFactory.getCurrentSession().persist(config);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}

	@Override
	public boolean verificarConfig() {
		String texto = "FROM Config";
		Query query = sessionFactory.getCurrentSession().createQuery(texto);
		
		List<Config> configs = query.getResultList();
		
		if(configs.size() >= 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean alterar(Config config) {
		try {
			sessionFactory.getCurrentSession().update(config);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Config buscar(int id) {
		
		return sessionFactory.getCurrentSession().get(Config.class,id);
	}
	
	
	
	

}
