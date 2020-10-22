package ar.edu.unq.desapp.GrupoJ022020.desappapl.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosedProjectException;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column(name = "id")
	Long id;
	@Column
	@ApiModelProperty(required = true)
	String firstName;
	@Column
	String lastName;
	@Column
	@ApiModelProperty(required = true)
	String mail;
	@Column
	@ApiModelProperty(required = true)
	String password;
	@Column
	Integer points;
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	Set<Project> projectsDonatedTo;
	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	Set<Donation> donationsMade;
	
	public User() {
		this.points = 0;
		this.projectsDonatedTo = new HashSet<Project>();
		this.donationsMade = new HashSet<Donation>();
	}

	public User(String nombre, String apellido, Integer puntos, String mail, String password, Set<Project> projectsDonatedTo, Set<Donation> donationsDone) {
		this.firstName = nombre;
		this.lastName = apellido;
		this.points = puntos;
		this.mail = mail;
		this.password = password;
		this.projectsDonatedTo = projectsDonatedTo;
		this.donationsMade = donationsDone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Project> getProjectsDonatedTo() {
		return projectsDonatedTo;
	}

	public void setProjectsDonatedTo(Set<Project> projectsDonatedTo) {
		this.projectsDonatedTo = projectsDonatedTo;
	}
	
	public void addProjectDonatedTo(Project project) {
		this.projectsDonatedTo.add(project);
	}
	
	public Set<Donation> getDonationsMade() {
		return donationsMade;
	}

	public void setDonationsMade(Set<Donation> donationsDone) {
		this.donationsMade = donationsDone;
	}

	public void addDonation(Donation donation) {
		this.donationsMade.add(donation);
	}
	
	/* METHODS */
	
	public void addPoints(Integer amount) {
		this.points += amount;
	}
	
	public Donation registerDonation(Project project, Donation donation) throws ClosedProjectException{
		if(project.isClosed()) {
			throw new ClosedProjectException();
		}
		this.addProjectDonatedTo(project);
		project.addDonation(donation.getAmount());
		this.addDonation(donation);
		PointManager.addPointsToUser(this, project, donation);
		
		return donation;
	}
}
