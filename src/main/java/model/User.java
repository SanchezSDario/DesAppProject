package model;

import java.util.HashSet;
import java.util.Set;

public class User {

	String id;
	String nombre;
	String apellido;
	Integer puntos;
	Set<Project> proyectosDonados;
	
	public User() {
		this.proyectosDonados = new HashSet<Project>();
		this.puntos = 0;
	}

	public User(String id, String nombre, String apellido, Integer puntos, Set<Project> proyectosDonados) {
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

	public Set<Project> getProyectosDonados() {
		return proyectosDonados;
	}

	public void setProyectosDonados(Set<Project> proyectosDonados) {
		this.proyectosDonados = proyectosDonados;
	}
	
	public void addProyectoDonado(Project proyecto) {
		this.proyectosDonados.add(proyecto);
	}
	
	/* METHODS */
	
	public void sumarPuntos(Integer cantidad) {
		this.puntos += cantidad;
	}
}
