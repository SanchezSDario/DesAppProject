package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;

class DonationTest {

	@Test
	void testDonationIsCreatedWithAllItsValues() {
		Donation aDonation = new Donation(1d, "comentario");
		
		assertEquals(1d, aDonation.getAmount());
		assertEquals("comentario", aDonation.getComment());
	}
	
	@Test
	void testDonationIsCreatedAndItsValuesAreSet() {
		Donation aDonation = new Donation();
		aDonation.setId(123l);
		aDonation.setAmount(1d);
		aDonation.setComment("comentario");
			
		assertEquals(123l, aDonation.getId());
		assertEquals(1d, aDonation.getAmount());
		assertEquals("comentario", aDonation.getComment());
	}

}
