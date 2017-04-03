package com.ipartek.formacion.alumno;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Alumno;

/**
 * Session Bean implementation class AlumnoServiceBean
 */
@Stateless (name = "alumnoServiceBean")
public class AlumnoServiceBean implements AlumnoServiceRemote {

	@PersistenceContext(unitName = "gestiondocente")
	private EntityManager entityManager;
	@Resource
	private SessionContext sessionContext;
	
    public AlumnoServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Alumno> getAll() {
		TypedQuery<Alumno> alumnos = entityManager.createNamedQuery("alumno.getAll",Alumno.class);
		return alumnos.getResultList();
	}

	@Override
	public Alumno getById(long codigo) {
		Alumno alumno = entityManager.find(Alumno.class, codigo);
		return alumno;
	}

	@Override
	public Alumno update(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno create(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}

}
