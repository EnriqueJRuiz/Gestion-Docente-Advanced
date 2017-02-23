package com.ipartek.formacion.dbms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dbms.dao.interfaces.ProfesorDAO;
import com.ipartek.formacion.dbms.mappers.ProfesorMapper;
import com.ipartek.formacion.dbms.persistence.Profesor;

@Repository("profesorDaoImp")
public class ProfesorDAOImp implements ProfesorDAO {
	
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
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
		final String SQL="profesorCreate";
		//se asigna el nombre del procedimiento almacenado PHPMYADMIN
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		
		jdbcCall.withProcedureName(SQL);
		//crear un mapa con los parametros de procedimientos almacenados.
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pnombre", profesor.getNombre())
				.addValue("papellidos", profesor.getApellidos())
				.addValue("pdni", profesor.getDni())
				.addValue("ptelefono", profesor.getTelefono())
				.addValue("pemail", profesor.getEmail())
				.addValue("pcodigoPostal", profesor.getCodigoPostal())
				.addValue("pfNacimiento", profesor.getfNacimiento())
				.addValue("pdireccion", profesor.getDireccion())
				.addValue("ppoblacion", profesor.getPoblacion())
				.addValue("pnSS", profesor.getnSS());
		LOGGER.info(profesor.toString());
		//se ejecuta la consulta
		Map<String, Object> out = jdbcCall.execute(in);
		//en out se han recogido los parametros out de la consulta a BBDD
		profesor.setCodigo((Integer)out.get("pcodigo"));
		
		return profesor;
		
	}

	@Override
	public Profesor getById(int codigo) {
		Profesor profesor = null;
		final String SQL="CALL profesorgetById(?)";
		try{
			profesor = template.queryForObject(SQL, new ProfesorMapper(),new Object[] { codigo });
			LOGGER.info(profesor.toString());
		}catch(EmptyResultDataAccessException e){
				profesor = new Profesor();
			 LOGGER.info("no se he encontrado Alumno: "+ codigo + " "+e.getMessage());
		}
		return profesor;
	}

	@Override
	public List<Profesor> getAll() {
		final String SQL="CALL profesorgetAll()";
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
		final String SQL="profesorUpdate";
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pnombre", profesor.getNombre())
				.addValue("papellidos", profesor.getApellidos())
				.addValue("pdni", profesor.getDni())
				.addValue("ptelefono", profesor.getTelefono())
				.addValue("pemail", profesor.getEmail())
				.addValue("pcodigoPostal", profesor.getCodigoPostal())
				.addValue("pfNacimiento", profesor.getfNacimiento())
				.addValue("pdireccion", profesor.getDireccion())
				.addValue("ppoblacion", profesor.getPoblacion())
				.addValue("pnSS", profesor.getnSS())
				.addValue("pcodigo", profesor.getCodigo());
		LOGGER.info(profesor.toString());
		
			jdbcCall.execute(in);
		return profesor;
	}

	@Override
	public void delete(int codigo) {
		final String SQL= "profesorDeleteF";
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pcodigo", codigo);
		LOGGER.info(String.valueOf(codigo));
		
		jdbcCall.execute(in);
	}
									
}
