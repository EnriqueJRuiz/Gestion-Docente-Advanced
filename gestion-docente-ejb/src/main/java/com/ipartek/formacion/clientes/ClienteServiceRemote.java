package com.ipartek.formacion.clientes;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistence.Cliente;

@Remote
public interface ClienteServiceRemote {

	public List<Cliente> getAll();

	public Cliente getById(long codigo);
	
	public Cliente update(Cliente cliente);
	
	public Cliente create(Cliente cliente);
	
	public void delete (int codigo);
	

}
