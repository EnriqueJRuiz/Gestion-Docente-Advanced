package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipartek.formacion.curso.CursoServiceRemote;
import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Transactional
@Service("cursoServiceImp")
public class CursoServiceImp implements CursoService {
	@Resource(name = "cursoServiceRemote")
	private CursoServiceRemote cursoServiceRemote;
	
	@Override
	public void setCursoServiceRemote(CursoServiceRemote cursoService) {
		this.cursoServiceRemote = cursoService;
	}

	@Override
	public Curso getById(long codigo) {
		
		return cursoServiceRemote.getById(codigo);
	}
	
	
	@Override
	public List<Curso> getAll() {
		return cursoServiceRemote.getAll();
	}

	@Override
	public Curso create(Curso curso) {
		return cursoServiceRemote.create(curso);
	}

	@Override
	public void delete(long codigo) {
		cursoServiceRemote.delete(codigo);
	}

	@Override
	public Curso getInforme(long codigo) {
		return cursoServiceRemote.getInforme(codigo);
	}

	@Override
	public Curso update(Curso curso) {
		// TODO Auto-generated method stub
		return cursoServiceRemote.update(curso);
	}

}
