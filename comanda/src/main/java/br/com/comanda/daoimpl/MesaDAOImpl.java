package br.com.comanda.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.comanda.dao.MesaDAO;
import br.com.comanda.dto.Mesa;

@Repository("mesaDAO")
public class MesaDAOImpl implements MesaDAO {

	private static List<Mesa> mesas = new ArrayList<>() ;
	
	static {
		
		for(int i = 1; i <= 30; i++) {
			
			Mesa mesa = new Mesa();
			mesa.setId(i);
			mesa.setActive(true);
			
			mesas.add(mesa);
			
		}
	}
	
	@Override
	public List<Mesa> list() {
		
		return mesas;
	}

}
