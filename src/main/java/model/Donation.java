package model;

import java.util.Date;

public class Donation {

	String id;
	Double cantidad;
	String comentario;
	Date fechaDonacion;
	
	public Donation() {
		
	}

	public Donation(String id, Double cantidad, String comentario) {
		this.id = id;
		this.cantidad = cantidad;
		this.comentario = comentario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaDonacion() {
		return fechaDonacion;
	}

	public void setFechaDonacion(Date fechaDonacion) {
		this.fechaDonacion = fechaDonacion;
	}
}
