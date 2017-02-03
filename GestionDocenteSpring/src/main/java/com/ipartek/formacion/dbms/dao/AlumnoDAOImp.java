package com.ipartek.formacion.dbms.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dbms.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dbms.mappers.AlumnoMapper;
import com.ipartek.formacion.dbms.persistence.Alumno;

@Repository("alumnoDaoImp")
public class AlumnoDAOImp implements AlumnoDAO{

	private DataSource dataSource;
	private JdbcTemplate template;
	@Autowired // = que inject
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		//template = dataSource.getConnection();
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
		final String SQL = "SELECT * FROM alumno";
		List<Alumno> alumnos = null;
		alumnos = (List<Alumno>)template.queryForObject(SQL, new AlumnoMapper());
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
