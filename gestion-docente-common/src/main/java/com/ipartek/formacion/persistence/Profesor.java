package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "profesor")
@Table(name = "profesor")
@NamedQueries({ @NamedQuery(name = "profesor.getAll", query = "SELECT p FROM profesor as p WHERE p.activo =true") })
public class Profesor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int CODIGO_NULO = -1;
	
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private long codigo;
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fNacimiento;
	private String email;
	private String direccion;
	private Integer codigoPostal;
	private String poblacion;
	private String telefono;
	private boolean activo;
	private String nSS;
	@Transient
	private List<Curso> cursos;

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Profesor(){
		super();
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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

	public String getnSS() {
		return nSS;
	}

	public void setnSS(String nSS) {
		this.nSS = nSS;
	}
	
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
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
		if (obj != null && obj instanceof Profesor && this.codigo == ((Profesor) obj).getCodigo()) {
			iguales = true;
		}
		return iguales;
	}
	
	@Override
	public String toString() {
		return "Profesor [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", fNacimiento=" + fNacimiento + ", email=" + email + ", direccion=" + direccion + ", codigoPostal="
				+ codigoPostal + ", poblacion=" + poblacion + ", telefono=" + telefono + ", activo=" + activo + ", nSS="
				+ nSS + "]";
	}
	
	
	
}
