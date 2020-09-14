package model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class System {

	private Set<City> cities;
	private Set<Project> projects;
	private Set<Donation> donations;
	private Set<User> users;
	
	public System() {
		cities = new HashSet<City>();
		projects = new HashSet<Project>();
		donations = new HashSet<Donation>();
		users = new HashSet<User>();
	}
	
	public System(Set<City> cities, Set<Project> projects, Set<Donation> donations, Set<User> users) {
		this.cities = cities;
		this.projects = projects;
		this.donations = donations;
		this.users = users;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Set<Donation> getDonations() {
		return donations;
	}

	public void setDonations(Set<Donation> donations) {
		this.donations = donations;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void addCity(City city) {
		this.cities.add(city);
	}
	
	public void removeCity(City city) {
		this.cities.remove(city);
	}
		
	public void addProject(Project project) {
		this.projects.add(project);
	}
	
	public void removeProject(Project project) {
		this.projects.remove(project);
	}
	
	public void addDonation(Donation donation) {
		this.donations.add(donation);
	}
	
	public void removeDonation(Donation donation) {
		this.donations.remove(donation);
	}

	public void addUser(User user) {
		this.users.add(user);
	}
	
	public void removeUser(User user) {
		this.users.remove(user);
	}
	
	/*METHODS*/
	
	public Donation registerDonation(User user, Project project, Donation donation){
		user.addProjectDonatedTo(project);
		project.addDonation(donation.getAmount());
		this.addDonation(donation);
		this.addPointsToUser(user, project, donation);
		
		return donation;
	}
	
	public Integer addPointsToUser(User user, Project project, Donation donation) {
		Integer totalAmount = 0;
		
		if(donation.getAmount() > 1000d) {
			totalAmount = donation.getAmount().intValue();
		}
		if(project.getCity().getPopulation() < 2000) {
			totalAmount = donation.getAmount().intValue()*2;
		}
		
		Set<Donation> donacionesDelMes = this.donations.stream().filter(don -> 
			don.getDonationDate().getMonth() == donation.getDonationDate().getMonth()).collect(Collectors.toSet());
		if(donacionesDelMes.size() > 1) {
			totalAmount += 500;
		}
		
		user.addPoints(totalAmount);
		return user.getPoints();
	}
}
