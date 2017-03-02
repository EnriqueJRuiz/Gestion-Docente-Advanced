package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "modulo")
public class Modulo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private long codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "nHoras")
	private int nHoras;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "precio")
	private String precio;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="modulo")
	private Set<CursoDetalle> detalle; 
	
	public long getCodigo() {
		return codigo;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getnHoras() {
		return nHoras;
	}
	public void setnHoras(int nHoras) {
		this.nHoras = nHoras;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Set<CursoDetalle> getDetalle() {
		return detalle;
	}
	public void setDetalle(Set<CursoDetalle> detalle) {
		this.detalle = detalle;
	}
	@Override
	public String toString() {
		return "Modulo [nombre=" + nombre + ", nHoras=" + nHoras + ", descripcion=" + descripcion + "]";
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
		if (obj != null && obj instanceof Modulo && this.codigo == ((Modulo) obj).getCodigo()) {
			iguales = true;
		}
		return iguales;
	}
	
	
	
	
}
