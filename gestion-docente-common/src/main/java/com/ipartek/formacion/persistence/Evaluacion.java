package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evaluacion")
public class Evaluacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private long codigo;
	private Date fExamen;
	private int nota;
	
	public Evaluacion(){
		super();
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getfExamen() {
		return fExamen;
	}

	public void setfExamen(Date fExamen) {
		this.fExamen = fExamen;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
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
		if (obj != null && obj instanceof Evaluacion && this.codigo == ((Evaluacion) obj).getCodigo()) {
			iguales = true;
		}
		return iguales;
	}

	@Override
	public String toString() {
		return "Evaluacion [codigo=" + codigo + ", fExamen=" + fExamen + ", nota=" + nota + "]";
	}
	
	

}
