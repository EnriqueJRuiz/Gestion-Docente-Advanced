package com.ipartek.formacion.dbms.persistence;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.ipartek.formacion.persistence.Curso;

public class Cliente implements Serializable, Comparable<Cliente> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int CODIGO_NULO = -1;
	
	
	protected int codigo;
	private String nombre;
	private String identificador;
	private String email;
	private String direccion;
	private int codigoPostal;
	private String poblacion;
	private String telefono;
	private String id;
	private boolean activo;
	//*private Map<Long, com.ipartek.formacion.persistence.Curso> cursos;
	private Map<Long, Curso> cursos;
	
	public Cliente() {
		super();
		this.nombre="";
		this.identificador = "";
		this.email = "";
		this.direccion = "";
		this.telefono = "";
		this.codigoPostal = 0;
		this.poblacion = "";
		this.id = "";
		this.activo = true;
		this.codigo = CODIGO_NULO;
		cursos = new HashMap<Long, Curso>();
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public Map<Long, Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Map<Long, Curso> cursos) {
		this.cursos = cursos;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", identificador=" + identificador + ", email=" + email + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj instanceof Cliente) {
			Cliente clien = (Cliente) obj;
			if (this.codigo == clien.getCodigo()) {
				iguales = true;
			}
		}
		return iguales;
		
	}
	
	@Override
	public int compareTo(Cliente o) {
		return this.getNombre().compareToIgnoreCase(o.getNombre());
	}

	

}
