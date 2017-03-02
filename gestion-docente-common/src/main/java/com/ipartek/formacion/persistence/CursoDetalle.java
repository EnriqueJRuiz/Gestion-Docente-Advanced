package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "curso_detalle")
public class CursoDetalle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long codigo;
	private Date fInicio;
	private Date fFin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="curso_codigo")
	private Curso curso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="modulo_codigo")
	private Modulo modulo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo", referencedColumnName="codigo_curso_detalle")
	private Imparticion imparticion;
	
	
	


	public CursoDetalle(){
		super();
	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public Imparticion getImparticion() {
		return imparticion;
	}

	public void setImparticion(Imparticion imparticion) {
		this.imparticion = imparticion;
	}

	@Override
	public String toString() {
		return "CursoDetalle [codigo=" + codigo + ", fInicio=" + fInicio + ", fFin=" + fFin + ", curso=" + curso
				+ ", modulo=" + modulo + "]";
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
		if (obj != null && obj instanceof CursoDetalle && this.codigo == ((CursoDetalle) obj).getCodigo()) {
			iguales = true;
		}
		return iguales;
	}
	
}
