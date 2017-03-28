package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "imparticion")
public class Imparticion  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long codigo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_profesor", referencedColumnName="codigo")
	private Profesor profesor;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name ="asistente",
			joinColumns= @JoinColumn(name = "imparticion_codigo",referencedColumnName="codigo"),
			inverseJoinColumns = @JoinColumn(name="alumno_codigo",referencedColumnName="codigo"))
	private Set<Alumno> alumnos;
	
	public Imparticion(){
		super();
	}
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Set<Alumno> getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}


	@Override
	public String toString() {
		return "Imparticion [codigo=" + codigo  + ", profesor=" + profesor + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj != null && obj instanceof Curso && this.codigo == ((Curso) obj).getCodigo()) {
			iguales = true;
		}
		return iguales;
	}
	
	
	

}
