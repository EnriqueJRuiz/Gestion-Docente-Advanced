package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "cliente")
@Table(name = "cliente")
@NamedQueries({ @NamedQuery(name = "cliente.getAll", query = "SELECT c FROM cliente as c WHERE c.activo =true") })
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	private String nombre;
	private String identificador;
	private String email;
	private String direccion;
	private int codigoPostal;
	private String poblacion;
	private String telefono;
	private boolean activo;
	@Transient
	private List<Curso> cursos;
	//private Map<Long, com.ipartek.formacion.persistence.Curso> cursos;
	
	//@OneToMany(fetch = FetchType.LAZY)
	//List<Curso> curso;
	
	public Cliente(){
		super();
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	/*
	public Map<Long, com.ipartek.formacion.persistence.Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Map<Long, com.ipartek.formacion.persistence.Curso> cursos) {
		this.cursos = cursos;
	
	}
	*/
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
		if (obj != null && obj instanceof Cliente && this.codigo == ((Cliente) obj).getCodigo()) {
			iguales = true;
		}
		return iguales;
	}
	
	
	
}
