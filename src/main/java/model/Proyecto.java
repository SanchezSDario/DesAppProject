package model;

import java.util.Date;

public class Proyecto {

	String id;
	Integer factor = 1000;
	Integer porcentajeMinimoCierre;
	String nombre;
	Date fechaInicio;
	Date fechaFin;
	Localidad localidad;
	Double totalRecaudado;
	
	public Proyecto() {
		
	}

	public Proyecto(String id, Integer factor, Integer porcentajeMinimoCierre, String nombre, Date fechaInicio,
			Date fechaFin, Localidad localidad, Double totalRecaudado) {
		this.id = id;
		this.factor = factor;
		this.porcentajeMinimoCierre = porcentajeMinimoCierre;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.localidad = localidad;
		this.totalRecaudado = totalRecaudado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

	public Integer getPorcentajeMinimoCierre() {
		return porcentajeMinimoCierre;
	}

	public void setPorcentajeMinimoCierre(Integer porcentajeMinimoCierre) {
		this.porcentajeMinimoCierre = porcentajeMinimoCierre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Double getTotalRecaudado() {
		return totalRecaudado;
	}

	public void setTotalRecaudado(Double totalRecaudado) {
		this.totalRecaudado = totalRecaudado;
	}
	
	/*METHODS*/
	
	public Double importeTotalParaCompletar() {
		return (double) (this.factor * this.localidad.getPoblacion());
	}
}

