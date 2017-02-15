package com.ipartek.formacion.dbms.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dbms.persistence.Cliente;

/**
 * Esta interfaz defina los metodos de consulta a la Base de Datos de la entidad 
 * Cliente que tiene su correspondencia en la clase <code>Cliente</code> de la
 * capa de persistencia
 * @author Enrique J. Ruiz
 *
 */

public interface ClienteDAO  extends DAOSetter{

	public Cliente create (Cliente cliente);
	
	public Cliente getById(int codigo);
	
	public List<Cliente> getAll();
	
	public Cliente update(Cliente cliente);
	
	public void delete (int codigo);

}
