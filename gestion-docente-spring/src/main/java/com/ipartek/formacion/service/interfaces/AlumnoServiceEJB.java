package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.alumno.AlumnoServiceRemote;
import com.ipartek.formacion.persistence.Alumno;

public interface AlumnoServiceEJB {
	
	public void setAlumnoServiceRemote(AlumnoServiceRemote alumnoService);
	
	public Alumno create (Alumno alumno);
	
	public Alumno getById(int codigo);
	
	public List<Alumno> getAll();
	
	public Alumno update(Alumno alumno);
	
	public void delete (int codigo);
}
