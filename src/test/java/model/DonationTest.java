package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DonationTest {

	@Test
	void testDonacionSeCreaConTodosSusValores() {
		Donation unaDonacion = new Donation("id", 1d, "comentario");
			
		assertEquals("id", unaDonacion.getId());
		assertEquals(1d, unaDonacion.getCantidad());
		assertEquals("comentario", unaDonacion.getComentario());
	}
	
	@Test
	void testDonacionSeCreaYSeAsignanTodosSusValores() {
		Donation unaDonacion = new Donation();
		unaDonacion.setId("id");
		unaDonacion.setCantidad(1d);
		unaDonacion.setComentario("comentario");
			
		assertEquals("id", unaDonacion.getId());
		assertEquals(1d, unaDonacion.getCantidad());
		assertEquals("comentario", unaDonacion.getComentario());
	}

}
