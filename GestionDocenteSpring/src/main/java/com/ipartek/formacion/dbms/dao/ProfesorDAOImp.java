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

import com.ipartek.formacion.dbms.dao.interfaces.ProfesorDAO;
import com.ipartek.formacion.dbms.mappers.ProfesorMapper;
import com.ipartek.formacion.dbms.persistence.Profesor;

@Repository("profesorDaoImp")
public class ProfesorDAOImp implements ProfesorDAO {
	
	private DataSource dataSource;
	private JdbcTemplate template;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfesorDAOImp.class);
	
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.template= new JdbcTemplate(dataSource);
	}

	@Override
	public Profesor create(Profesor profesor) {
		return null;
	}

	@Override
	public Profesor getById(int profesor) {
		return null;
	}

	@Override
	public List<Profesor> getAll() {
		final String SQL="SELECT codigo as codigo, nombre as nombre, apellidos as apellidos FROM profesor";
		List<Profesor> profesores = null;
		try{
			profesores=template.query(SQL, new ProfesorMapper());
		}catch(EmptyResultDataAccessException e){
			profesores = new ArrayList<Profesor>();
		}
		return profesores;
	}

	@Override
	public Profesor update(Profesor profesor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}
									
}
