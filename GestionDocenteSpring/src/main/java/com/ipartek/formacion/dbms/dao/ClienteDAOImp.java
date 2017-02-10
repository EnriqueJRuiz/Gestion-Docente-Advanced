package com.ipartek.formacion.dbms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dbms.dao.interfaces.ClienteDAO;
import com.ipartek.formacion.dbms.mappers.ClienteMapper;
import com.ipartek.formacion.dbms.persistence.Cliente;

@Repository("clienteDaoImp")
public class ClienteDAOImp implements ClienteDAO {

	@Override
	public String toString() {
		return "ClienteDAOImp []";
	}

	private DataSource dataSource;
	private JdbcTemplate template;
	private Logger logger = LoggerFactory.getLogger(ClienteDAOImp.class);
	
	@Autowired // = que inject
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Cliente create(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> getAll() {
		final String SQL = "SELECT codigo as codigo, nombre as nombre, telefono as telefono, email as email FROM cliente";
		List<Cliente> clientes = null;
		try{
			clientes = template.query(SQL, new ClienteMapper());
		}catch(EmptyResultDataAccessException e){
			logger.trace(e.getMessage());
			clientes = new ArrayList<Cliente>();
		}
		return clientes;
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
	

	


}
