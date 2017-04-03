package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.clientes.ClienteServiceRemote;
import com.ipartek.formacion.persistence.Cliente;


public interface ClienteServiceEJB {
	
	public void setClienteServiceRemote(ClienteServiceRemote clienteService);
	
	public Cliente create (Cliente cliente);
	
	public Cliente getById(int codigo);
	
	public List<Cliente> getAll();
	
	public Cliente update(Cliente cliente);
	
	public void delete (int codigo);

	public Cliente comprobarIdentificador(String identificador);
	
}
