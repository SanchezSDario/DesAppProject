package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocalidadTest {

	@Test
	void testLocalidadSeCreaConTodosSusValores() {
		Localidad unaLocalidad = new Localidad("id", "nombre", "provincia", "estado", 1);
			
		assertEquals("id", unaLocalidad.getId());
		assertEquals("nombre", unaLocalidad.getNombre());
		assertEquals("provincia", unaLocalidad.getProvincia());
		assertEquals(1, unaLocalidad.getPoblacion());
		assertEquals("estado", unaLocalidad.getEstadoConectividad());
	}
	
	@Test
	void testLocalidadSeCreaYSeAsignanTodosSusValores() {
		Localidad unaLocalidad = new Localidad();
		unaLocalidad.setId("id");
		unaLocalidad.setNombre("nombre");
		unaLocalidad.setProvincia("provincia");
		unaLocalidad.setEstadoConectividad("estado");
		unaLocalidad.setPoblacion(1);
			
		assertEquals("id", unaLocalidad.getId());
		assertEquals("nombre", unaLocalidad.getNombre());
		assertEquals("provincia", unaLocalidad.getProvincia());
		assertEquals(1, unaLocalidad.getPoblacion());
		assertEquals("estado", unaLocalidad.getEstadoConectividad());
	}
}
