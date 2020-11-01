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
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.UserAdmin;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.UserProfile;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosingPercentageException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UnableToCloseProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UserTypeActionException;

class UserAdminTest {
	
	@Test
	void testUserAdminIsCreatedWithAllItsValues() {
		User anUser = new UserAdmin("nombre", "apellido", 0, "mail", "userName", "nickName", "pass", new HashSet<Project>(), new HashSet<Donation>());
		
		assertEquals(UserProfile.ADMIN, anUser.getProfile());
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
	void testUserAdminIsCreatedAndItsValuesAreSet() {
		User anUser = new UserAdmin();
		anUser.setProfile(UserProfile.ADMIN);
		anUser.setId(123l);
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
		assertEquals(UserProfile.ADMIN, anUser.getProfile());
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
	void testProjectWithTotalRaisedSameAsTotalCostIsClosedByAdminUser() throws UnableToCloseProjectException, UserTypeActionException {
		User user = new UserAdmin();
		
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		//It's still on date, but has raised what was needed
		aProject.setEndDate(LocalDate.now());
		aProject.setTotalRaised(1500000d);

		user.closeProject(aProject);
		
		assertTrue(aProject.getIsClosed());
	}
	
	@Test
	void testProjectThatReachedEndDateIsClosedByAdminUser() throws UnableToCloseProjectException, UserTypeActionException {
		
		User user = new UserAdmin();
		
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		aProject.setTotalRaised(15d);
		//Hasn't raised what was needed, but arrived to end date
		aProject.setEndDate(LocalDate.now().minusDays(1));
		
		user.closeProject(aProject);
		
		assertTrue(aProject.getIsClosed());
	}
	
	@Test
	void testProjectThatReachedMinClosedPercentageIsClosedByAdminUser() throws UnableToCloseProjectException, UserTypeActionException, ClosingPercentageException {
		
		User user = new UserAdmin();
		
		City aCity = new City();
		aCity.setPopulation(10);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		
		aProject.setEndDate(LocalDate.now().plusDays(1));
		aProject.setMinClosingPercentage(50);
		//Has raised the minimum closed percentage to be closed
		aProject.setTotalRaised(5001d);
		
		user.closeProject(aProject);
		
		assertTrue(aProject.getIsClosed());
	}
	
	@Test
	void testUserAdminTriesToCloseAProjectAndUnableToCloseProjectExceptionIsThrown() throws UnableToCloseProjectException, UserTypeActionException, ClosingPercentageException {
		
		User user = new UserAdmin();
		
		City aCity = new City();
		aCity.setPopulation(10);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		
		aProject.setEndDate(LocalDate.now().plusDays(1));
		aProject.setMinClosingPercentage(50);
		aProject.setTotalRaised(1d);
		//The project is unable to be closed due to it's state, so exception is thrown
		
		Assertions.assertThrows(UnableToCloseProjectException.class, () -> user.closeProject(aProject));
	}
	
	@Test
	void testUserAdminTriesToRegisterADonationAndUserTypeActionExceptionIsThrown() throws UnableToCloseProjectException, UserTypeActionException, ClosingPercentageException {
		
		User user = new UserAdmin();
		Donation otherDonation = new Donation();
		otherDonation.setDonationDate(LocalDate.now());
		otherDonation.setAmount(1100d);
		
		City aCity = new City();
		aCity.setPopulation(10);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		
		aProject.setEndDate(LocalDate.now().plusDays(1));
		aProject.setMinClosingPercentage(50);
		aProject.setTotalRaised(1d);
		//The project is unable to be closed due to it's state, so exception is thrown
		
		Donation donation = new Donation();
		donation.setDonationDate(LocalDate.now());
		donation.setAmount(1d);
		
		Assertions.assertThrows(UserTypeActionException.class, () -> user.registerDonation(aProject, donation));
	}
}
