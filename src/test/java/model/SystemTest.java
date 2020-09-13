package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

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
}
