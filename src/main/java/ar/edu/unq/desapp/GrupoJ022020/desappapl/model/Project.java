package ar.edu.unq.desapp.GrupoJ022020.desappapl.model;

import java.time.LocalDate;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosingPercentageException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.FactorException;

public class Project {

	String id;
	Integer factor = 1000;
	Integer minClosingPercentage = 100;
	String name;
	LocalDate startDate;
	LocalDate endDate;
	City city;
	Double totalRaised;
	
	public Project() {
		this.totalRaised = 0d;
	}

	public Project(String id, Integer factor, Integer minClosingPercentage, String name, LocalDate startDate,
			LocalDate endDate, City city, Double totalRaised) {
		this.id = id;
		this.factor = factor;
		this.minClosingPercentage = minClosingPercentage;
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

	public void setFactor(Integer factor) throws FactorException {
		if(factor < 0 || factor > 100000) {
			throw new FactorException();
		}
		this.factor = factor;
	}

	public Integer getMinClosingPercentage() {
		return minClosingPercentage;
	}

	public void setMinClosingPercentage(Integer minClosingPercentage) throws ClosingPercentageException {
		if(minClosingPercentage < 50 || minClosingPercentage > 100) {
			throw new ClosingPercentageException();
		}
		this.minClosingPercentage = minClosingPercentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
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
	
	public Boolean isClosed() {
		LocalDate date = LocalDate.now();
		return this.endDate.isBefore(date) || this.totalRaised >= this.getTotalCost(); 
	}
	
	public Integer remainingPercentageToComplete() {
		return (int) (100 - (this.totalRaised / this.getTotalCost() * 100));
	}
}

