package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dbms.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService {
	
	@Autowired
	private AlumnoDAO alumnoDAO;

	@Override
	public Alumno create(Alumno alumno) {
		return alumnoDAO.create(alumno);
	}

	@Override
	public List<Alumno> getAll() {
		return alumnoDAO.getAll();
	}

	@Override
	public Alumno getById(int codigo) {
		return alumnoDAO.getById(codigo);
	}

	@Override
	public Alumno update(Alumno alumno) {
		return alumnoDAO.update(alumno);
	}

	@Override
	public void delete(int codigo) {
		alumnoDAO.delete(codigo);
	}

	@Override
	public void setAlumnoDao(AlumnoDAO alumnoDAO) {
		this.alumnoDAO = alumnoDAO;
		
	}

	@Override
	public Alumno comprobarDni(String dni) {
		return alumnoDAO.comprobarDni(dni);
	}
}
