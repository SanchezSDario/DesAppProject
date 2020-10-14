package ar.edu.unq.desapp.GrupoJ022020.desappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column(name = "id")
	private Long id;
	@Column
	private String name;
	@Column
	private String province;
	@Column
	private String connectivityStatus;
	@Column
	@ApiModelProperty(required = true)
	private Integer population;
	
	public City() {
		
	}

	public City(String name, String province, String connectivityStatus, Integer population) {
		this.name = name;
		this.province = province;
		this.connectivityStatus = connectivityStatus;
		this.population = population;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getConnectivityStatus() {
		return connectivityStatus;
	}

	public void setConnectivityStatus(String connectivityStatus) {
		this.connectivityStatus = connectivityStatus;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}
}
