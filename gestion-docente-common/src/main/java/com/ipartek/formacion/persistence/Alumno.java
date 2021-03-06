package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;
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

@Entity(name = "alumno")
@Table(name = "alumno")
@NamedQueries({ @NamedQuery(name = "alumno.getAll", query = "SELECT a FROM alumno as a WHERE a.activo =true") })
public class Alumno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int CODIGO_NULO = -1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private int nHermanos;
	
	//	@Fetch(FetchMode.JOIN)// Si fuese inprescindible una lista en vez del set
	// se tendria que usar esta anotación
	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name ="asistente",
	joinColumns= @JoinColumn(name = "alumno_codigo",referencedColumnName="codigo"),
	inverseJoinColumns = @JoinColumn(name="imparticion_codigo",referencedColumnName="codigo"))
	private Set<Imparticion> imparticiones;
	*/
	@Transient
	private List<Curso> curso;
	
	
	
	
	public List<Curso> getCurso() {
		return curso;
	}



	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}



	public Alumno(){
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
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
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
	public int getnHermanos() {
		return nHermanos;
	}
	public void setnHermanos(int nHermanos) {
		this.nHermanos = nHermanos;
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
		if (obj != null && obj instanceof Alumno && this.codigo == ((Alumno) obj).getCodigo()) {
			iguales = true;
		}
		return iguales;
	}
	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", fNacimiento=" + fNacimiento + ", email=" + email + ", direccion=" + direccion + ", codigoPostal="
				+ codigoPostal + ", poblacion=" + poblacion + ", telefono=" + telefono + ", activo=" + activo
				+ ", nHermanos=" + nHermanos + "]";
	}
	
	
	
	
}

