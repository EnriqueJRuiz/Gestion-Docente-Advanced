package com.ipartek.formacion.dbms.persistence;


import java.io.Serializable;
import java.util.Date;




public class Curso implements Serializable, Comparable<Curso> {
	
	protected int codigo;
	private String nombre;
	private int duracion;
	private Date fechaInicio;
	private Date fechaFin;
	public static final int CODIGO_NULO = -1;
	
	public Curso(){
		super();
		this.codigo = CODIGO_NULO;
		this.nombre = "";
		this.duracion = 0;
		this.fechaInicio = new Date();
		this.fechaFin = new Date();
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

	public void setNombre(String nombre)  {

		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		
		this.duracion = duracion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin)  {
		
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Curso nombre:" + getNombre() + ", duracion:" + getDuracion();
	}

	@Override
	public int compareTo(Curso o) {
		return this.nombre.compareToIgnoreCase(o.nombre);
	}
}
