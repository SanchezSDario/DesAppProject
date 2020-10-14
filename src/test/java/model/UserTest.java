package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;

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
}
