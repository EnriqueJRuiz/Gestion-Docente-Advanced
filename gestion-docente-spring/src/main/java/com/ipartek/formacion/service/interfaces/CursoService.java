package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.curso.CursoServiceRemote;
import com.ipartek.formacion.persistence.Curso;

public interface CursoService {

	public void setCursoServiceRemote(CursoServiceRemote CursoService);
	
	public Curso getById(long codigo);
	
	public List<Curso> getAll();
	
	public Curso create(Curso curso);
	
	public void delete (long codigocurso);
	
	public Curso getInforme(long codigo);
	
	public Curso update(Curso curso);
}
