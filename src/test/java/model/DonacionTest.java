package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DonacionTest {

	@Test
	void testDonacionSeCreaConTodosSusValores() {
		Donacion unaDonacion = new Donacion("id", 1d, "comentario");
			
		assertEquals("id", unaDonacion.getId());
		assertEquals(1d, unaDonacion.getCantidad());
		assertEquals("comentario", unaDonacion.getComentario());
	}
	
	@Test
	void testDonacionSeCreaYSeAsignanTodosSusValores() {
		Donacion unaDonacion = new Donacion();
		unaDonacion.setId("id");
		unaDonacion.setCantidad(1d);
		unaDonacion.setComentario("comentario");
			
		assertEquals("id", unaDonacion.getId());
		assertEquals(1d, unaDonacion.getCantidad());
		assertEquals("comentario", unaDonacion.getComentario());
	}

}
