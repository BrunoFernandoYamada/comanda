/**
 * 
 */
package br.com.comanda.resources;

import java.beans.PropertyEditorSupport;

import br.com.comanda.dao.LocalizacaoDAO;
import br.com.comanda.dto.Localizacao;

/**
 * @author Bruno Fernando Yamada
 * 16 de nov de 2017
 *	
 */
public class LocalizacaoEditor extends PropertyEditorSupport {
		
	private final LocalizacaoDAO localizacaoDAO;
	
	public LocalizacaoEditor(LocalizacaoDAO localicacaoDAO) {
		this.localizacaoDAO = localicacaoDAO;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Localizacao localizacao = localizacaoDAO.buscar(Integer.valueOf(text));
		setValue(localizacao);
	}
}
