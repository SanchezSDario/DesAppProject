package model;

public class Localidad {

	private String id;
	private String nombre;
	private String provincia;
	private String estadoConectividad;
	private Integer poblacion;
	
	public Localidad() {
		
	}

	public Localidad(String id, String nombre, String provincia, String estadoConectividad, Integer poblacion) {
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
		this.estadoConectividad = estadoConectividad;
		this.poblacion = poblacion;
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getEstadoConectividad() {
		return estadoConectividad;
	}

	public void setEstadoConectividad(String estadoConectividad) {
		this.estadoConectividad = estadoConectividad;
	}

	public Integer getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Integer poblacion) {
		this.poblacion = poblacion;
	}
}
