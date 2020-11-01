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
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.UserDonor;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.UserProfile;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosedProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UnableToCloseProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UserTypeActionException;

class UserDonorTest {
	
	@Test
	void testUserDonorIsCreatedWithAllItsValues() {
		User anUser = new UserDonor("nombre", "apellido", 0, "mail", "userName", "nickName", "pass", new HashSet<Project>(), new HashSet<Donation>());
		
		assertEquals(UserProfile.DONOR, anUser.getProfile());
		assertEquals("nombre", anUser.getFirstName());
		assertEquals("apellido", anUser.getLastName());
		assertEquals(0, anUser.getPoints());
		assertEquals("mail", anUser.getMail());
		assertEquals("userName", anUser.getUserName());
		assertEquals("nickName", anUser.getNickName());
		assertEquals("pass", anUser.getPassword());
		assertEquals(0, anUser.getProjectsDonatedTo().size());
		assertEquals(0, anUser.getDonationsMade().size());
	}
	
	@Test
	void testUserDonorIsCreatedAndItsValuesAreSet() {
		User anUser = new UserDonor();
		anUser.setId(123l);
		anUser.setProfile(UserProfile.DONOR);
		anUser.setFirstName("nombre");
		anUser.setLastName("apellido");
		anUser.setMail("mail");
		anUser.setUserName("userName");
		anUser.setNickName("nickName");
		anUser.setPassword("pass");
		anUser.setPoints(0);
		anUser.setProjectsDonatedTo(new HashSet<Project>());
		anUser.setDonationsMade(new HashSet<Donation>());
			
		assertEquals(123l, anUser.getId());
		assertEquals(UserProfile.DONOR, anUser.getProfile());
		assertEquals("nombre", anUser.getFirstName());
		assertEquals("apellido", anUser.getLastName());
		assertEquals(0, anUser.getPoints());
		assertEquals("mail", anUser.getMail());
		assertEquals("userName", anUser.getUserName());
		assertEquals("nickName", anUser.getNickName());
		assertEquals("pass", anUser.getPassword());
		assertEquals(0, anUser.getProjectsDonatedTo().size());
		assertEquals(0, anUser.getDonationsMade().size());
	}

	@Test
	void testUserDoesADonationOf1001AndGetsTheDoubleAmountDonatedAsPoints() throws ClosedProjectException, UserTypeActionException {
		City city = new City();
		Project project = new Project();
		User user = new UserDonor();
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
	void testUserDoesADonationToCityWithLessThan2000PopulationAndGetsTheDoubleAmountDonatedAsPoints() throws ClosedProjectException, UserTypeActionException {
		City city = new City();
		Project project = new Project();
		User user = new UserDonor();
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
	void testUserDoesASecondDonationInTheSameMonthAndReceivesABonusOf500Points() throws ClosedProjectException, UserTypeActionException {
		City city = new City();
		Project project = new Project();
		User user = new UserDonor();
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
	void testUserDoesASecondDonationInADifferentYearAndNoBonusIsReceived() throws ClosedProjectException, UserTypeActionException {
		City city = new City();
		Project project = new Project();
		User user = new UserDonor();
		Donation donation = new Donation();
		
		city.setPopulation(2000);
		
		project.setCity(city);
		project.setStartDate(LocalDate.now().minusDays(5));
		project.setEndDate(LocalDate.now().plusDays(5));
		
		donation.setDonationDate(LocalDate.now());
		donation.setAmount(100d);
		
		user.registerDonation(project, donation);
		
		Donation otherDonation = new Donation();
		otherDonation.setDonationDate(LocalDate.now().plusYears(1));
		otherDonation.setAmount(1100d);
		
		user.registerDonation(project, otherDonation);
		
		assertEquals(1, user.getProjectsDonatedTo().size());
		assertEquals(1200, project.getTotalRaised());
		assertEquals(1100, user.getPoints());
	}
	
	@Test
	void testUserDoesASecondDonationInADifferentMonthAndNoBonusIsReceived() throws ClosedProjectException, UserTypeActionException {
		City city = new City();
		Project project = new Project();
		User user = new UserDonor();
		Donation donation = new Donation();
		
		city.setPopulation(2000);
		
		project.setCity(city);
		project.setStartDate(LocalDate.now().minusDays(5));
		project.setEndDate(LocalDate.now().plusDays(5));
		
		donation.setDonationDate(LocalDate.now());
		donation.setAmount(100d);
		
		user.registerDonation(project, donation);
		
		Donation otherDonation = new Donation();
		otherDonation.setDonationDate(LocalDate.now().plusMonths(1));
		otherDonation.setAmount(1100d);
		
		user.registerDonation(project, otherDonation);
		
		assertEquals(1, user.getProjectsDonatedTo().size());
		assertEquals(1200, project.getTotalRaised());
		assertEquals(1100, user.getPoints());
	}
	
	@Test
	void testUserDoesADonationButProjectIsClosedAndExceptionIsThrown() {
		City city = new City();
		Project project = new Project();
		User user = new UserDonor();
		Donation donation = new Donation();
		
		city.setPopulation(2000);
		
		project.setCity(city);
		project.setStartDate(LocalDate.now().minusDays(1));
		project.setEndDate(LocalDate.now().minusDays(1));
		project.setIsClosed(true);
		
		donation.setDonationDate(LocalDate.now());
		donation.setAmount(100d);
		
		Assertions.assertThrows(ClosedProjectException.class, () -> user.registerDonation(project, donation));
	}
	
	@Test
	void testUserTriesToCloseAProjectAndUserTypeActionExceptionIsThrown() throws UnableToCloseProjectException, UserTypeActionException {
		User user = new UserDonor();
		
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		aProject.setEndDate(LocalDate.now());
		aProject.setTotalRaised(1d);
		
		Assertions.assertThrows(UserTypeActionException.class, () -> user.closeProject(aProject));
	}

}
