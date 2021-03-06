package com.ipartek.formacion.dbms.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ipartek.formacion.persistence.Curso;


/**
 * 
 * @author Urko Villanueva
 *
 */
public class Alumno implements Comparable<Alumno>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6698866485450376235L;
	public static final int CODIGO_NULO = -1;
	protected int codigo;
	private String id;
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fNacimiento;
	private String email;
	private String direccion;
	private int codigoPostal;
	private String poblacion;
	private String telefono;
	private boolean activo;
	private int nHermanos;
	private Map<Long, Curso> cursos;

	public Alumno() {
		super();// constructor de la clase padre
		this.codigo = CODIGO_NULO;
		this.nombre= "";
		this.apellidos = "";
		this.dni = "";
		this.email = "";
		this.direccion = "";
		this.fNacimiento = new Date();
		this.id = "";
		this.activo = true;
		this.nHermanos = 0;
		this.telefono = "";
		this.codigoPostal = 0;
		this.poblacion = "";
		cursos = new HashMap<Long, Curso>();

	}
	
	public Map<Long, Curso> getCursos() {
		return cursos;
	}


	public void setCursos(Map<Long, Curso> cursos) {
		this.cursos = cursos;
	}




	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getnHermanos() {
		return nHermanos;
	}

	public void setnHermanos(int nHermanos) {
		this.nHermanos = nHermanos;
	}
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

	@Override
	public int compareTo(Alumno o) {
		return this.getApellidos().compareToIgnoreCase(o.getApellidos());
	}
	
	

	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", fNacimiento=" + fNacimiento + ", email=" + email + ", direccion=" + direccion + ", codigoPostal="
				+ codigoPostal + ", poblacion=" + poblacion + ", telefono=" + telefono + ", activo=" + activo
				+ ", nHermanos=" + nHermanos + "]";
	}

	/**
	 * Para evaluar si los objetos son iguales
	 */

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;

		if (obj != null && obj instanceof Alumno) {
			final Alumno alum = (Alumno) obj;
			if (this == alum || (alum.getCodigo() == this.codigo && this.dni.equalsIgnoreCase(alum.getDni()))) {
				iguales = true;
			}
		}
		return iguales;
	}


}
