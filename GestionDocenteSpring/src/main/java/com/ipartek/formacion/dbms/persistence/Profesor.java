package com.ipartek.formacion.dbms.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.ipartek.formacion.dbms.persistence.validator.Phone;

public class Profesor implements Serializable, Comparable<Profesor> {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int CODIGO_NULO = -1;
	
	protected int codigo;
	private String nSS;
	
	@Pattern(regexp = "[0-9]{8}[a-zA-Z]", message = "DNI incorrecto")
	private String dni;
	@Size(min=3, max=50, message = "Size.nombre")
	private String nombre;
	@Size(min=7, max=150, message = "Size.apellidos")
	private String apellidos;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past(message = "Past.fNacimiento")
	private Date fNacimiento;
	@NotNull(message = "NotEmpty.email")
	@NotBlank(message = "NotBlank.email")
	@Email(message = "Email.email")
	private String email;
	private String direccion;
	private int codigoPostal;
	private String poblacion;
	@NotNull(message = "NotEmpty.telefono")
	@NotBlank(message = "NotBlank.telefono")
	@Phone(message = "Email.telefono")
	private String telefono;
	private String id;
	private boolean activo;
	

	public Profesor() {
		super();
		this.nombre= "";
		this.apellidos = "";
		this.dni = "";
		this.email = "";
		this.direccion = "";
		this.telefono = "";
		this.codigoPostal = 0;
		this.poblacion = "";
		this.fNacimiento = new Date();
		this.id = "";
		this.codigo = CODIGO_NULO;
		this.nSS = "";
		this.activo = true;
	}

	public String getnSS() {
		return nSS;
	}

	public void setnSS(String nSS) {
		this.nSS = nSS;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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


	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	

	@Override
	public String toString() {
		return "Profesor [codigo=" + codigo + ", nSS=" + nSS + ", dni=" + dni + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", fNacimiento=" + fNacimiento + ", email=" + email + ", direccion=" + direccion
				+ ", codigoPostal=" + codigoPostal + ", poblacion=" + poblacion + ", telefono=" + telefono + ", activo="
				+ activo + "]";
	}

	@Override
	public int compareTo(Profesor o) {
		return this.getApellidos().compareToIgnoreCase(o.getApellidos());
	}

	/**
	 * Para evaluar si los objetos son iguales
	 */

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj instanceof Profesor) {
			Profesor profe = (Profesor) obj;
			if (this.codigo == profe.getCodigo()) {
				iguales = true;
			}
		}
		return iguales;
	}
	
}
