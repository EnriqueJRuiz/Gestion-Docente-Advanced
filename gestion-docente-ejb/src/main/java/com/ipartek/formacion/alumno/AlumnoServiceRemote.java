package com.ipartek.formacion.alumno;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistence.Alumno;

@Remote
public interface AlumnoServiceRemote {
	public List<Alumno> getAll();

	public Alumno getById(long codigo);
	
	public Alumno update(Alumno alumno);
	
	public Alumno create(Alumno alumno);
	
	public void delete (int codigo);
}
