package com.ipartek.formacion.dbms.persistence;

import java.util.Date;

public class Profesor {
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static final int CODIGO_NULO = -1;
	protected int codigo;
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fNacimiento;
	private String email;
	private String direccion;
	private String id;
	private int nSS;
	

	public Profesor() {
		super();
		this.nombre= "";
		this.apellidos = "";
		this.dni = "";
		this.email = "";
		this.direccion = "";
		this.fNacimiento = new Date();
		this.id = "";
		this.codigo = CODIGO_NULO;
		this.nSS = 0;
	}

	public int getnSS() {
		return nSS;
	}

	public void setnSS(int nSS) {
		this.nSS = nSS;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Profesor :Email=" + getEmail() + ", Direccion=" + getDireccion() + ", Dni=" + getDni()
				+ ", Nombre=" + getNombre() + ", Apellidos=" + getApellidos() ;
	}

	
	
}
