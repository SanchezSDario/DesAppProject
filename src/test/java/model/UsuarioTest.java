package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

class UsuarioTest {

	@Test
	void testUsuarioSeCreaConTodosSusValores() {
		Usuario unUsuario = new Usuario("id", "nombre", "apellido", 0, new HashSet<Proyecto>());
			
		assertEquals("id", unUsuario.getId());
		assertEquals("nombre", unUsuario.getNombre());
		assertEquals("apellido", unUsuario.getApellido());
		assertEquals(0, unUsuario.getPuntos());
		assertEquals(0, unUsuario.getProyectosDonados().size());
	}
	
	@Test
	void testUsuarioSeCreaYSeAsignanTodosSusValores() {
		Usuario unUsuario = new Usuario();
		unUsuario.setId("id");
		unUsuario.setNombre("nombre");
		unUsuario.setApellido("apellido");
		unUsuario.setPuntos(0);
		unUsuario.setProyectosDonados(new HashSet<Proyecto>());
			
		assertEquals("id", unUsuario.getId());
		assertEquals("nombre", unUsuario.getNombre());
		assertEquals("apellido", unUsuario.getApellido());
		assertEquals(0, unUsuario.getPuntos());
		assertEquals(0, unUsuario.getProyectosDonados().size());
	}
}
