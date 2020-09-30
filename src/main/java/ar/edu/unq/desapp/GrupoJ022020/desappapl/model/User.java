package ar.edu.unq.desapp.GrupoJ022020.desappapl.model;

import java.util.HashSet;
import java.util.Set;

public class User {

	String id;
	String firstName;
	String lastName;
	Integer points;
	Set<Project> projectsDonatedTo;
	Set<Donation> donationsMade;
	
	public User() {
		this.points = 0;
		this.projectsDonatedTo = new HashSet<Project>();
		this.donationsMade = new HashSet<Donation>();
	}

	public User(String id, String nombre, String apellido, Integer puntos, Set<Project> projectsDonatedTo, Set<Donation> donationsDone) {
		this.id = id;
		this.firstName = nombre;
		this.lastName = apellido;
		this.points = puntos;
		this.projectsDonatedTo = projectsDonatedTo;
		this.donationsMade = donationsDone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
}
