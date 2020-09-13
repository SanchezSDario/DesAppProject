package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testUserIsCreatedWithAllItsValues() {
		User anUser = new User("id", "nombre", "apellido", 0, new HashSet<Project>());
			
		assertEquals("id", anUser.getId());
		assertEquals("nombre", anUser.getFirstName());
		assertEquals("apellido", anUser.getLastName());
		assertEquals(0, anUser.getPoints());
		assertEquals(0, anUser.getProjectsDonatedTo().size());
	}
	
	@Test
	void testUserIsCreatedAndItsValuesAreSet() {
		User unUsuario = new User();
		unUsuario.setId("id");
		unUsuario.setFirstName("nombre");
		unUsuario.setLastName("apellido");
		unUsuario.setPoints(0);
		unUsuario.setProjectsDonatedTo(new HashSet<Project>());
			
		assertEquals("id", unUsuario.getId());
		assertEquals("nombre", unUsuario.getFirstName());
		assertEquals("apellido", unUsuario.getLastName());
		assertEquals(0, unUsuario.getPoints());
		assertEquals(0, unUsuario.getProjectsDonatedTo().size());
	}
}
