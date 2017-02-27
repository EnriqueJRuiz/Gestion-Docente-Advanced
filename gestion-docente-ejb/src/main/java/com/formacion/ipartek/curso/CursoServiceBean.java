package com.formacion.ipartek.curso;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ipartek.formacion.persistence.Curso;

/**
 * Session Bean implementation class CursoServiceBean
 */
@Stateless
@LocalBean
public class CursoServiceBean implements CursoServiceRemote {

    /**
     * Default constructor. 
     */
    public CursoServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Curso> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso getById(long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso update(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

}
