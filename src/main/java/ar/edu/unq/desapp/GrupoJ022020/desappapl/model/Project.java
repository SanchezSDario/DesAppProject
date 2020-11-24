package ar.edu.unq.desapp.GrupoJ022020.desappapl.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosingPercentageException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.FactorException;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column(name = "id")
	private Long id;
	@Column
	private Integer factor = 1000;
	@Column
	private Integer minClosingPercentage = 100;
	@Column
	@ApiModelProperty(required = true)
	private String name;
	@Column
	@ApiModelProperty(required = true)
	private LocalDate startDate;
	@Column
	@ApiModelProperty(required = true)
	private LocalDate endDate;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ApiModelProperty(required = true)
	private City city;
	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Donation> donationsRegistered;
	@Column
	private Double totalRaised;
	@Column
	private Boolean isClosed;
	
	public Project() {
		this.totalRaised = 0d;
		this.isClosed = false;
		this.donationsRegistered = new ArrayList<Donation>();
	}

	public Project(Integer factor, Integer minClosingPercentage, String name, LocalDate startDate,
			LocalDate endDate, City city, List<Donation> donationsRegistered, Double totalRaised) {
		this.factor = factor;
		this.minClosingPercentage = minClosingPercentage;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
		this.donationsRegistered = donationsRegistered;
		this.totalRaised = totalRaised;
		this.isClosed = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public List<Donation> getDonationsRegistered() {
		return donationsRegistered;
	}

	public void setDonationsRegistered(List<Donation> donationsRegistered) {
		this.donationsRegistered = donationsRegistered;
	}

	public Double getTotalRaised() {
		return totalRaised;
	}

	public void setTotalRaised(Double totalRaised) {
		this.totalRaised = totalRaised;
	}
	
	public Boolean getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}
	
	/*METHODS*/

	public Double getTotalCost() {
		return (double) (this.factor * this.city.getPopulation());
	}
	
	public void addDonation(Donation donation) {
		this.donationsRegistered.add(donation);
		this.totalRaised += donation.getAmount(); 
	}
	
	public Integer remainingPercentageToComplete() {
		return (int) (100 - (this.totalRaised / this.getTotalCost() * 100));
	}
	
	public Donation getDonationWithEarlierDonationDate(){
		if(this.donationsRegistered.isEmpty()) {
			return null;
		}
		if(this.donationsRegistered.size() == 1) {
			return this.donationsRegistered.get(0);
		}
		return this.donationsRegistered.stream()
		 		.sorted((donation1, donation2) -> donation2.getDonationDate().compareTo(donation1.getDonationDate()))
		 		.limit(1).collect(Collectors.toList()).get(0);
	}
}

