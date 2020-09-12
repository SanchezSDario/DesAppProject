package model;

import java.util.Set;

public class Usuario {

	String id;
	String nombre;
	String apellido;
	Integer puntos;
	Set<Proyecto> proyectosDonados;
	
	public Usuario() {
		
	}

	public Usuario(String id, String nombre, String apellido, Integer puntos, Set<Proyecto> proyectosDonados) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.puntos = puntos;
		this.proyectosDonados = proyectosDonados;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Set<Proyecto> getProyectosDonados() {
		return proyectosDonados;
	}

	public void setProyectosDonados(Set<Proyecto> proyectosDonados) {
		this.proyectosDonados = proyectosDonados;
	}
}
