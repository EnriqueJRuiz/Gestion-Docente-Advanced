package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.clientes.ClienteServiceRemote;
import com.ipartek.formacion.persistence.Cliente;
import com.ipartek.formacion.service.interfaces.ClienteServiceEJB;

@Service("clienteServiceEJB")
public class ClienteServiceEJBImp implements ClienteServiceEJB {
	
	@Resource(name = "clienteServiceRemote")	
	private ClienteServiceRemote clienteSerciceremote;
	
	@Override
	public void setClienteServiceRemote(ClienteServiceRemote clienteService) {
		this.clienteSerciceremote = clienteService;
	}

	@Override
	public Cliente create(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getById(int codigo) {
		return clienteSerciceremote.getById(codigo);
	}

	@Override
	public List<Cliente> getAll() {
		return clienteSerciceremote.getAll();
	}

	@Override
	public Cliente update(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente comprobarIdentificador(String identificador) {
		// TODO Auto-generated method stub
		return null;
	}

}
