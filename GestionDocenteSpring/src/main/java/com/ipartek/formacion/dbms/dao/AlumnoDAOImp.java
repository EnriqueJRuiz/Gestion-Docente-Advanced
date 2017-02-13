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

import com.ipartek.formacion.dbms.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dbms.mappers.AlumnoMapper;
import com.ipartek.formacion.dbms.persistence.Alumno;

@Repository("alumnoDaoImp")
public class AlumnoDAOImp implements AlumnoDAO{

	private DataSource dataSource;
	private JdbcTemplate template;
	private static final Logger LOGGER = LoggerFactory.getLogger(AlumnoDAOImp.class);
	
	@Autowired // = que inject
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public Alumno create(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> getAll() {
		final String SQL = "SELECT codigo as codigo, nombre as nombre, apellidos as apellidos FROM alumno";
		List<Alumno> alumnos = null;
		try{
			alumnos = template.query(SQL, new AlumnoMapper());
		}catch(EmptyResultDataAccessException e){
			LOGGER.trace(e.getMessage());
			alumnos = new ArrayList<Alumno>();
		}
		return alumnos;
	}

	@Override
	public Alumno update(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}

}
