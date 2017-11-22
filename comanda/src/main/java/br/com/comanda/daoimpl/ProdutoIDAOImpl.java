package br.com.comanda.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.comanda.dao.ProdutoDAO;
import br.com.comanda.dto.Produto;

@Repository("produtoDAO")
@Transactional
public class ProdutoIDAOImpl implements ProdutoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean adicionar(Produto produto) {
		try {
			sessionFactory.getCurrentSession().persist(produto);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public Produto buscar(Long id) {
		return sessionFactory.getCurrentSession().get(Produto.class, id);
	}

	@Override
	public boolean excluir(Produto produto) {
		try {
			sessionFactory.getCurrentSession().delete(produto);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterar(Produto produto) {
		try {
			sessionFactory.getCurrentSession().update(produto);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Produto> listar() {
		String selectAllQuery = "FROM Produto";
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllQuery);
		return query.getResultList(); 
	}

	
	@Override
	public List<Produto> listarProdutoPorGrupo(int id) {
		
		String selectAllPorGrupo = "FROM Produto WHERE grupo_id = :grupo";
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllPorGrupo);
		query.setParameter("grupo", id);
		return query.getResultList();
	}

}
