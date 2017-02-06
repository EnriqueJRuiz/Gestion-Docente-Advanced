package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dbms.dao.interfaces.ProfesorDAO;
import com.ipartek.formacion.dbms.persistence.Profesor;
import com.ipartek.formacion.service.interfaces.ProfesorService;

@Service

public class ProfesorServiceImp implements ProfesorService {
	@Autowired
	private ProfesorDAO profesorDAO;
	
	@Override
	public Profesor create(Profesor profesor) {
	
		return profesorDAO.create(profesor);
	}

	@Override
	public List<Profesor> getAll() {
		
		return profesorDAO.getAll();
	}

	@Override
	public Profesor getById(int codigo) {
		
		return profesorDAO.getById(codigo);
	}

	@Override
	public Profesor update(Profesor profesor) {
		
		return profesorDAO.update(profesor);
	}

	@Override
	public void delete(int codigo) {
		profesorDAO.delete(codigo);
		
	}

	@Override
	public void setAlumnoDao(ProfesorDAO profesorDAO) {
		this.profesorDAO = profesorDAO;
		
	}

}
