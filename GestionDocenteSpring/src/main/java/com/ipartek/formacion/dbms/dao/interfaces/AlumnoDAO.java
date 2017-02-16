package com.ipartek.formacion.dbms.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dbms.persistence.Alumno;

/**
 * Esta interfaz defina los metodos de consulta a la Base de Datos de la entidad 
 * Alumno que tiene su correspondencia en la clase <code>Alumno</code> de la
 * capa de persistencia
 * @author Enrique J. Ruiz
 *
 */
public interface AlumnoDAO extends DAOSetter{
	
	/**
	 * Metodo que crea un <code>Alumno</code> en la Base de Datos.
	 * El <code>Alumno</code> tendra los datos necesariosexcepto el codigo que es 
	 * generado por la base de datos
	 * w
	 * @param alumno
	 * @return <code>Alumno</code> se devuelve el obgeto creado con el codigo
	 */
	public Alumno create (Alumno alumno);
	
	public Alumno getById(int codigo);
	
	public List<Alumno> getAll();
	
	public Alumno update(Alumno alumno);
	
	public void delete (int codigo);
	
	public Alumno comprobarDni(int dni);
	
	
}
