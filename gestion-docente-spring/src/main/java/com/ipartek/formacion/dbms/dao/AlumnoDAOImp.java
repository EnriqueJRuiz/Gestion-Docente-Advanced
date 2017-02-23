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

import com.ipartek.formacion.dbms.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dbms.mappers.AlumnoMapper;
import com.ipartek.formacion.dbms.persistence.Alumno;

@Repository("alumnoDaoImp")
public class AlumnoDAOImp implements AlumnoDAO{

	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	private JdbcTemplate template;
	private static final Logger LOGGER = LoggerFactory.getLogger(AlumnoDAOImp.class);
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public Alumno create(Alumno alumno) {
		final String SQL="alumnoCreate";
		//se asigna el nombre del procedimiento almacenado PHPMYADMIN
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		
		jdbcCall.withProcedureName(SQL);
		//crear un mapa con los parametros de procedimientos almacenados.
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pnombre", alumno.getNombre())
				.addValue("papellidos", alumno.getApellidos())
				.addValue("pdni", alumno.getDni())
				.addValue("ptelefono", alumno.getTelefono())
				.addValue("pemail", alumno.getEmail())
				.addValue("pcodigoPostal", alumno.getCodigoPostal())
				.addValue("pfNacimiento", alumno.getfNacimiento())
				.addValue("pdireccion", alumno.getDireccion())
				.addValue("ppoblacion", alumno.getPoblacion())
				.addValue("pnHermanos", alumno.getnHermanos());
		LOGGER.info(alumno.toString());
		//se ejecuta la consulta
		Map<String, Object> out = jdbcCall.execute(in);
		//en out se han recogido los parametros out de la consulta a BBDD
		alumno.setCodigo((Integer)out.get("pcodigo"));
		
		return alumno;
	}

	@Override
	public Alumno getById(int codigo) {
		Alumno alumno = null;
		final String SQL="CALL alumnogetById(?)";
		try{
			alumno = template.queryForObject(SQL, new AlumnoMapper(),new Object[] { codigo });
			LOGGER.info(alumno.toString());
		}catch(EmptyResultDataAccessException e){
				alumno = new Alumno();
			 LOGGER.info("no se he encontrado Alumno: "+ codigo + " "+e.getMessage());
		}
		return alumno;
	}

	@Override
	public List<Alumno> getAll() {
		final String SQL = "CALL alumnogetAll()";
				
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
		final String SQL="alumnoUpdate";
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pnombre", alumno.getNombre())
				.addValue("papellidos", alumno.getApellidos())
				.addValue("pdni", alumno.getDni())
				.addValue("ptelefono", alumno.getTelefono())
				.addValue("pemail", alumno.getEmail())
				.addValue("pcodigoPostal", alumno.getCodigoPostal())
				.addValue("pfNacimiento", alumno.getfNacimiento())
				.addValue("pdireccion", alumno.getDireccion())
				.addValue("ppoblacion", alumno.getPoblacion())
				.addValue("pnHermanos", alumno.getnHermanos())
				.addValue("pcodigo", alumno.getCodigo());
		LOGGER.info(alumno.toString());
		
			jdbcCall.execute(in);
		
		
		return alumno;
	}

	@Override
	public void delete(int codigo) {
		final String SQL= "alumnoDeleteF";
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pcodigo", codigo);
		LOGGER.info(String.valueOf(codigo));
		
		jdbcCall.execute(in);
	}

	@Override
	public Alumno comprobarDni(String dni) {
		Alumno alumno = null;
		final String SQL= "CALL alumnoDniUnico(?);";
		try{
			alumno = template.queryForObject(SQL, new AlumnoMapper(),new Object[] { dni });
			LOGGER.info("hay alguien con ese DNI");
		}catch(EmptyResultDataAccessException e){
			LOGGER.info("NO hay alguien con ese DNI");
		}
		return alumno;
	}

}
