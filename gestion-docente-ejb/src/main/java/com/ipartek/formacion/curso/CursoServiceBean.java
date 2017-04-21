package com.ipartek.formacion.curso;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Curso;

/**
 * Session Bean implementation class CursoServiceBean
 */
@Stateless(name = "cursoServiceBean")
public class CursoServiceBean implements CursoServiceRemote {

	@PersistenceContext(unitName = "gestiondocente")
	private EntityManager entityManager;
	@Resource
	private SessionContext sessionContext;

	/**
	 * Default constructor.
	 * 
	 * public CursoServiceBean() { // TODO Auto-generated constructor stub }
	 */
	
	@Override
	public List<Curso> getAll() {
		TypedQuery<Curso> pcursos = entityManager.createNamedQuery("curso.getAll", Curso.class);
		return pcursos.getResultList();
	}

	@Override
	public Curso getById(long codigo) {
		Curso curso = entityManager.find(Curso.class, codigo);
		/*StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("curso.getAlumnos");
		spq.setParameter(1, curso.getCodigo());
		List<Alumno> alumnos = spq.getResultList();
		curso.setAlumnos(alumnos);*/
		return curso;
	}

	@Override
	public Curso update(Curso curso) {

		//EntityTransaction tx = sessionContext.getUserTransaction();
		//EntityTransaction tx = entityManager.getTransaction();
		//tx.begin();
		//try{

			entityManager.merge(curso);
		//	System.out.println("update");
			//tx.commit();
		//}catch(Exception e){
			//	tx.rollback();

		//}
	
		return curso;
	}
	@Override
	public Curso create(Curso curso) {
		//EntityTransaction tx = sessionContext.getUserTransaction();
				//EntityTransaction tx = entityManager.getTransaction();
				////tx.begin();
				//try{
					System.out.println("Create");
					curso = entityManager.merge(curso);
					entityManager.flush();
					//tx.commit();
				//}catch(Exception e){
					//	tx.rollback();

				//}
			
				return curso;
	}
	@Override
	public void delete(long codigo) {
		//EntityTransaction txt = entityManager.getTransaction();
		//txt.begin();
		//try{
			entityManager.remove(entityManager.find(Curso.class, codigo));
			//txt.commit();
		//}catch(Exception e){
		//	//txt.rollback();
		//}
		
	}
	@Override
	public Curso getInforme(long codigo) {
		Curso curso = null;
		curso = entityManager.find(Curso.class, codigo);
		return curso;
	}
	
	

}