/**
 * 
 */
package br.com.comanda.resources;

import java.beans.PropertyEditorSupport;

import br.com.comanda.dao.GrupoDAO;
import br.com.comanda.dto.Grupo;

/**
 * @author Bruno Fernando Yamada
 * 16 de nov de 2017
 *	
 */
public class GrupoEditor extends PropertyEditorSupport {
	
	private final GrupoDAO grupoDAO;
	

	public GrupoEditor(GrupoDAO grupoDAO) {
		this.grupoDAO = grupoDAO;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Grupo grupo = grupoDAO.buscar(Integer.valueOf(text));
		setValue(grupo);
	}

}
