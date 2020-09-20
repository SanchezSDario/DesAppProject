package model;

public class City {

	private String id;
	private String name;
	private String province;
	private String connectivityStatus;
	private Integer population;
	
	public City() {
		
	}

	public City(String id, String name, String province, String connectivityStatus, Integer population) {
		this.id = id;
		this.name = name;
		this.province = province;
		this.connectivityStatus = connectivityStatus;
		this.population = population;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
