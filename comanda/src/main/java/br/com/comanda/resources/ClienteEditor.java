package br.com.comanda.resources;

import java.beans.PropertyEditorSupport;

import br.com.comanda.dao.ClienteDAO;
import br.com.comanda.dto.Cliente;

public class ClienteEditor extends PropertyEditorSupport {

	private final ClienteDAO clienteDAO;

    public ClienteEditor(ClienteDAO clienteDAO){
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      Cliente cliente = clienteDAO.buscar(Long.parseLong(text));
      setValue(cliente);
    }
	
}
