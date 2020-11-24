package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;

class DonationTest {

	@Test
	void testDonationIsCreatedWithAllItsValues() {
		Donation aDonation = new Donation(1d, "comentario", "donorNickname");
		
		assertEquals(1d, aDonation.getAmount());
		assertEquals("comentario", aDonation.getComment());
		assertEquals("donorNickname", aDonation.getDonorUser());
	}
	
	@Test
	void testDonationIsCreatedAndItsValuesAreSet() {
		Donation aDonation = new Donation();
		aDonation.setId(123l);
		aDonation.setAmount(1d);
		aDonation.setComment("comentario");
		aDonation.setDonorUser("donorNickname");
			
		assertEquals(123l, aDonation.getId());
		assertEquals(1d, aDonation.getAmount());
		assertEquals("comentario", aDonation.getComment());
		assertEquals("donorNickname", aDonation.getDonorUser());
	}

}
