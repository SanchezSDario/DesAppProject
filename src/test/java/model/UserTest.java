package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testUsuarioSeCreaConTodosSusValores() {
		User unUsuario = new User("id", "nombre", "apellido", 0, new HashSet<Project>());
			
		assertEquals("id", unUsuario.getId());
		assertEquals("nombre", unUsuario.getNombre());
		assertEquals("apellido", unUsuario.getApellido());
		assertEquals(0, unUsuario.getPuntos());
		assertEquals(0, unUsuario.getProyectosDonados().size());
	}
	
	@Test
	void testUsuarioSeCreaYSeAsignanTodosSusValores() {
		User unUsuario = new User();
		unUsuario.setId("id");
		unUsuario.setNombre("nombre");
		unUsuario.setApellido("apellido");
		unUsuario.setPuntos(0);
		unUsuario.setProyectosDonados(new HashSet<Project>());
			
		assertEquals("id", unUsuario.getId());
		assertEquals("nombre", unUsuario.getNombre());
		assertEquals("apellido", unUsuario.getApellido());
		assertEquals(0, unUsuario.getPuntos());
		assertEquals(0, unUsuario.getProyectosDonados().size());
	}
}
