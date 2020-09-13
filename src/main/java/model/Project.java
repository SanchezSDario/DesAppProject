package model;

import java.util.Date;

public class Project {

	String id;
	Integer factor = 1000;
	Integer minClosingPercent;
	String name;
	Date startDate;
	Date endDate;
	City city;
	Double totalRaised;
	
	public Project() {
		this.totalRaised = 0d;
	}

	public Project(String id, Integer factor, Integer minClosingPercent, String name, Date startDate,
			Date endDate, City city, Double totalRaised) {
		this.id = id;
		this.factor = factor;
		this.minClosingPercent = minClosingPercent;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
		this.totalRaised = totalRaised;
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

	public Integer getMinClosingPercent() {
		return minClosingPercent;
	}

	public void setMinClosingPercent(Integer minClosingPercent) {
		this.minClosingPercent = minClosingPercent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Double getTotalRaised() {
		return totalRaised;
	}

	public void setTotalRaised(Double totalRaised) {
		this.totalRaised = totalRaised;
	}
	
	/*METHODS*/
	
	public Double getTotalCost() {
		return (double) (this.factor * this.city.getPopulation());
	}
	
	public void addDonation(Double amount) {
		this.totalRaised += amount;
	}
}

