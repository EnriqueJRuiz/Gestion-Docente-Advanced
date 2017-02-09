package com.ipartek.formacion.dbms.persistence;

import java.io.Serializable;



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
		this.codigo = CODIGO_NULO;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
