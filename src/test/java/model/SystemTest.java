package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import modelExceptions.ClosedProjectException;

class SystemTest {

	System system = new System();
	City city = new City();
	Project project = new Project();
	User user = new User();
	Donation donation = new Donation();
	
	@Test
	void testSystemCreatesWithoutData() {
		assertEquals(0, system.getDonations().size());
		assertEquals(0, system.getCities().size());
		assertEquals(0, system.getProjects().size());
		assertEquals(0, system.getUsers().size());
	}
	
	@Test
	void testSystemCreatesWithEmptyData() {
		system = new System(new HashSet<City>(), new HashSet<Project>(), new HashSet<Donation>(), new HashSet<User>());
		
		assertEquals(0, system.getDonations().size());
		assertEquals(0, system.getCities().size());
		assertEquals(0, system.getProjects().size());
		assertEquals(0, system.getUsers().size());
	}
	
	@Test
	void testSystemCreatesWithOneElementInTheirSets() {
		Set<City> localidades = new HashSet<City>();
		Set<Project> proyectos = new HashSet<Project>();
		Set<User> usuarios = new HashSet<User>();
		Set<Donation> donaciones = new HashSet<Donation>();
		
		localidades.add(city);
		proyectos.add(project);
		usuarios.add(user);
		donaciones.add(donation);
		
		system.setCities(localidades);
		system.setProjects(proyectos);
		system.setUsers(usuarios);
		system.setDonations(donaciones);
		
		assertEquals(1, system.getDonations().size());
		assertEquals(1, system.getCities().size());
		assertEquals(1, system.getProjects().size());
		assertEquals(1, system.getUsers().size());
	}
	
	@Test
	void testSystemAddNewValuesToSetsAndRemovesThem() {
		system.addCity(city);
		system.addProject(project);
		system.addUser(user);
		system.addDonation(donation);
		
		system.removeCity(city);
		system.removeProject(project);
		system.removeUser(user);
		system.removeDonation(donation);
		
		assertEquals(0, system.getDonations().size());
		assertEquals(0, system.getCities().size());
		assertEquals(0, system.getProjects().size());
		assertEquals(0, system.getUsers().size());
	}
	
	@Test
	void testSystemRegistersDonationOf1001FromUserAndUserGetsTheDoubleAmountDonatedAsPoints() throws ClosedProjectException {
		city.setPopulation(2000);
		system.addCity(city);
		
		project.setCity(city);
		system.addProject(project);
		
		system.addUser(user);
		
		project.setStartDate(LocalDate.now().minusDays(5));
		project.setEndDate(LocalDate.now().plusDays(5));
		
		donation.setDonationDate(new Date());
		donation.setAmount(1001d);
		
		system.registerDonation(user, project, donation);
		
		assertEquals(1, user.getProjectsDonatedTo().size());
		assertEquals(1001, project.getTotalRaised());
		assertEquals(1, system.getDonations().size());
		assertEquals(1001, user.getPoints());
	}
	
	@Test
	void testSystemRegistersDonationToCityWithLessThan2000PopulationFromUserAndUserGetsTheDoubleAmountDonatedAsPoints() throws ClosedProjectException {
		city.setPopulation(1999);
		system.addCity(city);
		
		project.setCity(city);
		system.addProject(project);
		
		system.addUser(user);
		
		project.setStartDate(LocalDate.now().minusDays(5));
		project.setEndDate(LocalDate.now().plusDays(5));
		
		donation.setDonationDate(new Date());
		donation.setAmount(1001d);
		
		system.registerDonation(user, project, donation);
		
		assertEquals(1, user.getProjectsDonatedTo().size());
		assertEquals(1001, project.getTotalRaised());
		assertEquals(1, system.getDonations().size());
		assertEquals(2002, user.getPoints());
	}
	
	@Test
	void testSystemRegistersSecondDonationFromUserInTheSameMonthAndUserReceivesABonusOf500Points() throws ClosedProjectException {
		city.setPopulation(2000);
		system.addCity(city);
		
		project.setCity(city);
		system.addProject(project);
		
		system.addUser(user);
		
		project.setStartDate(LocalDate.now().minusDays(5));
		project.setEndDate(LocalDate.now().plusDays(5));
		
		donation.setDonationDate(new Date());
		donation.setAmount(100d);
		
		system.registerDonation(user, project, donation);
		
		Donation otherDonation = new Donation();
		otherDonation.setDonationDate(new Date());
		otherDonation.setAmount(1100d);
		system.addDonation(otherDonation);
		
		system.registerDonation(user, project, otherDonation);
		
		assertEquals(1, user.getProjectsDonatedTo().size());
		assertEquals(1200, project.getTotalRaised());
		assertEquals(2, system.getDonations().size());
		assertEquals(1600, user.getPoints());
	}
	
	@Test
	void testSystemRegistersADonationButProjectIsClosedAndExceptionIsThrown() {
		city.setPopulation(2000);
		system.addCity(city);
		
		project.setCity(city);
		system.addProject(project);
		
		system.addUser(user);
		
		project.setStartDate(LocalDate.now().minusDays(1));
		project.setEndDate(LocalDate.now().minusDays(1));
		
		donation.setDonationDate(new Date());
		donation.setAmount(100d);
		
		Assertions.assertThrows(ClosedProjectException.class, () -> system.registerDonation(user, project, donation));
	}
}
