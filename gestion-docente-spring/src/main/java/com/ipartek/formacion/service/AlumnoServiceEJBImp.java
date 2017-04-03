package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.alumno.AlumnoServiceRemote;
import com.ipartek.formacion.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoServiceEJB;

@Service("alumnoServiceEJB")
public class AlumnoServiceEJBImp implements AlumnoServiceEJB {
	@Resource(name= "alumnoServiceRemote")
	private AlumnoServiceRemote alumnoServiceRemote;
	
	@Override
	public void setAlumnoServiceRemote(AlumnoServiceRemote alumnoService) {
		this.alumnoServiceRemote = alumnoService;
	}

	@Override
	public Alumno create(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno getById(int codigo) {
		
		return alumnoServiceRemote.getById(codigo);
	}

	@Override
	public List<Alumno> getAll() {
		return alumnoServiceRemote.getAll();
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
