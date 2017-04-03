package com.ipartek.formacion.profesor;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Profesor;

@Stateless(name = "profesorServiceBean")
public class ProfesorServiceBean implements ProfesorServiceRemote  {

	@PersistenceContext(unitName = "gestiondocente")
	private EntityManager entityManager;
	@Resource
	private SessionContext sessionContext;
	
	
	public List<Profesor> getAll() {
		TypedQuery<Profesor> profesores = entityManager.createNamedQuery("profesor.getAll", Profesor.class );
		return profesores.getResultList();
	}

	@Override
	public Profesor getById(long codigo) {
		Profesor profesor=entityManager.find(Profesor.class, codigo);
		
		return profesor;
	}

	@Override
	public Profesor update(Profesor profesor) {
		try{

			entityManager.persist(profesor);
			//tx.commit();
		}catch(Exception e){
			//	tx.rollback();

		}
		return profesor;
	}

	@Override
	public Profesor create(Profesor curso) {
		try{
			
		}catch(Exception e){
			
		}
		return null;
	}

	@Override
	public void delete(int codigo) {
		try{
			entityManager.remove(entityManager.find(Profesor.class, codigo));
			//txt.commit();
		}catch(Exception e){
			//txt.rollback();
		}
		
	}

	@Override
	public Profesor getInforme(long codigo) {
		Profesor profesor = null;
		profesor= entityManager.find(Profesor.class, codigo);
		return profesor;
	}

}
