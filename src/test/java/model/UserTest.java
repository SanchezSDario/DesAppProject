package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.City;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosedProjectException;

class UserTest {

	@Test
	void testUserIsCreatedWithAllItsValues() {
		User anUser = new User("nombre", "apellido", 0, "mail", "pass", new HashSet<Project>(), new HashSet<Donation>());
		
		assertEquals("nombre", anUser.getFirstName());
		assertEquals("apellido", anUser.getLastName());
		assertEquals(0, anUser.getPoints());
		assertEquals("mail", anUser.getMail());
		assertEquals("pass", anUser.getPassword());
		assertEquals(0, anUser.getProjectsDonatedTo().size());
		assertEquals(0, anUser.getDonationsMade().size());
	}
	
	@Test
	void testUserIsCreatedAndItsValuesAreSet() {
		User anUser = new User();
		anUser.setId(123l);
		anUser.setFirstName("nombre");
		anUser.setLastName("apellido");
		anUser.setMail("mail");
		anUser.setPassword("pass");
		anUser.setPoints(0);
		anUser.setProjectsDonatedTo(new HashSet<Project>());
		anUser.setDonationsMade(new HashSet<Donation>());
			
		assertEquals(123l, anUser.getId());
		assertEquals("nombre", anUser.getFirstName());
		assertEquals("apellido", anUser.getLastName());
		assertEquals(0, anUser.getPoints());
		assertEquals("mail", anUser.getMail());
		assertEquals("pass", anUser.getPassword());
		assertEquals(0, anUser.getProjectsDonatedTo().size());
		assertEquals(0, anUser.getDonationsMade().size());
	}
	
	@Test
	void testSystemRegistersDonationOf1001FromUserAndUserGetsTheDoubleAmountDonatedAsPoints() throws ClosedProjectException {
		City city = new City();
		Project project = new Project();
		User user = new User();
		Donation donation = new Donation();
		
		city.setPopulation(2000);
		
		project.setCity(city);
		project.setStartDate(LocalDate.now().minusDays(5));
		project.setEndDate(LocalDate.now().plusDays(5));
		
		donation.setDonationDate(LocalDate.now());
		donation.setAmount(1001d);
		
		user.registerDonation(project, donation);
		
		assertEquals(1, user.getProjectsDonatedTo().size());
		assertEquals(1001, project.getTotalRaised());
		assertEquals(1001, user.getPoints());
	}
	
	@Test
	void testSystemRegistersDonationToCityWithLessThan2000PopulationFromUserAndUserGetsTheDoubleAmountDonatedAsPoints() throws ClosedProjectException {
		City city = new City();
		Project project = new Project();
		User user = new User();
		Donation donation = new Donation();
		
		city.setPopulation(1999);
		
		project.setCity(city);
		project.setStartDate(LocalDate.now().minusDays(5));
		project.setEndDate(LocalDate.now().plusDays(5));
		
		donation.setDonationDate(LocalDate.now());
		donation.setAmount(1001d);
		
		user.registerDonation(project, donation);
		
		assertEquals(1, user.getProjectsDonatedTo().size());
		assertEquals(1001, project.getTotalRaised());
		assertEquals(2002, user.getPoints());
	}
	
	@Test
	void testSystemRegistersSecondDonationFromUserInTheSameMonthAndUserReceivesABonusOf500Points() throws ClosedProjectException {
		City city = new City();
		Project project = new Project();
		User user = new User();
		Donation donation = new Donation();
		
		city.setPopulation(2000);
		
		project.setCity(city);
		project.setStartDate(LocalDate.now().minusDays(5));
		project.setEndDate(LocalDate.now().plusDays(5));
		
		donation.setDonationDate(LocalDate.now());
		donation.setAmount(100d);
		
		user.registerDonation(project, donation);
		
		Donation otherDonation = new Donation();
		otherDonation.setDonationDate(LocalDate.now());
		otherDonation.setAmount(1100d);
		
		user.registerDonation(project, otherDonation);
		
		assertEquals(1, user.getProjectsDonatedTo().size());
		assertEquals(1200, project.getTotalRaised());
		assertEquals(1600, user.getPoints());
	}
	
	@Test
	void testSystemRegistersADonationButProjectIsClosedAndExceptionIsThrown() {
		City city = new City();
		Project project = new Project();
		User user = new User();
		Donation donation = new Donation();
		
		city.setPopulation(2000);
		
		project.setCity(city);
		project.setStartDate(LocalDate.now().minusDays(1));
		project.setEndDate(LocalDate.now().minusDays(1));
		
		donation.setDonationDate(LocalDate.now());
		donation.setAmount(100d);
		
		Assertions.assertThrows(ClosedProjectException.class, () -> user.registerDonation(project, donation));
	}
}
