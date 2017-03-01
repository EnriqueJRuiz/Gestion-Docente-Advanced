package com.ipartek.formacion.curso;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ipartek.formacion.persistence.Curso;

/**
 * Session Bean implementation class CursoServiceBean
 */
@Stateless(name = "cursoServiceBean")
public class CursoServiceBean implements CursoServiceRemote {

	@PersistenceContext(unitName = "gestiondocente")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 * 
	 * public CursoServiceBean() { // TODO Auto-generated constructor stub }
	 */
	
	public CursoServiceBean() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Curso> getAll() {
		Query cursos = entityManager.createNamedQuery("curso.getAll");
		System.out.println("cursoservicebean");
		return cursos.getResultList();
	}

	@Override
	public Curso getById(long codigo) {
		Curso curso = entityManager.find(Curso.class, codigo);
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		entityManager.persist(curso);
		return curso;
	}

}