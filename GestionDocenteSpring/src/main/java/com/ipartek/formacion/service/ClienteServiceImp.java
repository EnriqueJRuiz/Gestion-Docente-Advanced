package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dbms.dao.interfaces.ClienteDAO;
import com.ipartek.formacion.dbms.persistence.Cliente;
import com.ipartek.formacion.service.interfaces.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Override
	public Cliente create(Cliente cliente) {
		return clienteDAO.create(cliente);
	}

	@Override
	public Cliente getById(int codigo) {
		return clienteDAO.getById(codigo);
	}

	@Override
	public List<Cliente> getAll() {
		return clienteDAO.getAll();
	}

	@Override
	public Cliente update(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDAO.update(cliente);
	}

	@Override
	public void delete(int codigo) {
		clienteDAO.delete(codigo);
		
	}

	@Override
	public void setClienteDao(ClienteDAO cliente) {
		this.clienteDAO = clienteDAO;
		
	}

	@Override
	public Cliente comprobarIdentificador(String identificador) {
		return clienteDAO.comprobarIdentificador(identificador);
	}

}
