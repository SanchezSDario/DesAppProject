package ar.edu.unq.desapp.GrupoJ022020.desappapl.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosedProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UnableToCloseProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UserTypeActionException;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Inheritance
@Table(name = "users")
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column(name = "id")
	private Long id;
	@Column
	@Enumerated(EnumType.STRING)
	@Access(AccessType.FIELD)
	protected UserProfile profile;
	@Column
	@ApiModelProperty(required = true)
	private String firstName;
	@Column
	private String lastName;
	@Column
	@ApiModelProperty(required = true)
	private String mail;
	@Column
	@ApiModelProperty(required = true)
	private String userName;
	@Column
	private String nickName;
	@Column
	@ApiModelProperty(required = true)
	private String password;
	@Column
	private Integer points;
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Set<Project> projectsDonatedTo;
	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Set<Donation> donationsMade;
	
	public User() {
		this.lastName = "";
		this.nickName = "";
		this.points = 0;
		this.projectsDonatedTo = new HashSet<Project>();
		this.donationsMade = new HashSet<Donation>();
	}

	public User(String nombre, 
				String apellido, 
				Integer puntos, 
				String mail,
				String userName,
				String nickName,
				String password, 
				Set<Project> projectsDonatedTo, 
				Set<Donation> donationsDone) {
		this.firstName = nombre;
		this.lastName = apellido;
		this.points = puntos;
		this.mail = mail;
		this.userName = userName;
		this.nickName = nickName;
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
	
	public UserProfile getProfile() {
		return profile;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/* METHODS */

	public void addPoints(Integer amount) {
		this.points += amount;
	}
	
	public abstract Donation registerDonation(Project project, Donation donation) throws ClosedProjectException, UserTypeActionException;
	
	public abstract Project closeProject(Project project) throws UnableToCloseProjectException, UserTypeActionException;	
}
