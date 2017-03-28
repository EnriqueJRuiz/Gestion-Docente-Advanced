package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Table(name = "curso")
@Entity(name = "curso")
@NamedQueries({ @NamedQuery(name = "curso.getAll", query = "SELECT c FROM curso as c WHERE c.activo =true") })
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "curso.getAlumnos", procedureName = "alumnogetByCurso", resultClasses = Alumno.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class) }) })
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long codigo;
	private String nombre;
	private String identificador;
	private int nHoras;
	private Date fInicio;
	private Date fFin;
	private String temario;
	private boolean activo;
	private String precio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_codigo")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profesor_codigo")
	private Profesor profesor;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	@Transient
	private List<Alumno> alumnos;
	
	public Curso(){
		super();
	}
	
	public long getCodigo() {
		return codigo;
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
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public int getnHoras() {
		return nHoras;
	}
	public void setnHoras(int nHoras) {
		this.nHoras = nHoras;
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
	public String getTemario() {
		return temario;
	}
	public void setTemario(String temario) {
		this.temario = temario;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
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
		if (obj != null && obj instanceof Curso && this.codigo == ((Curso) obj).getCodigo()) {
			iguales = true;
		}
		return iguales;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", identificador=" + identificador + ", nHoras="
				+ nHoras + ", fInicio=" + fInicio + ", fFin=" + fFin + ", temario=" + temario + ", activo=" + activo
				+ ", precio=" + precio + ", cliente=" + cliente + ", profesor=" + profesor + "]";
	}


	
	
	
	
}
