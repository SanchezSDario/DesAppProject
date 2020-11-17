package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.City;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosingPercentageException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.FactorException;

class ProjectTest {

	@Test
	void testProjectIsCreatedWithAllItsValues() throws ParseException {
		City aCity = new City();
		
		LocalDate startDate = LocalDate.parse("2020-09-12");
		LocalDate endDate = LocalDate.parse("2020-09-12");
		
		Project aProject = new Project(2000, 50, "nombre", startDate, endDate, aCity, new ArrayList<Donation>(), 0d);
			
		assertEquals(2000, aProject.getFactor());
		assertEquals(50, aProject.getMinClosingPercentage());
		assertEquals("nombre", aProject.getName());
		assertEquals(startDate, aProject.getStartDate());
		assertEquals(endDate, aProject.getEndDate());
		assertEquals(aCity, aProject.getCity());
		assertEquals(0, aProject.getDonationsRegistered().size());
		assertEquals(0d, aProject.getTotalRaised());
	}
	
	@Test
	void testProjectIsCreatedAndItsValuesAreSet() throws FactorException, ClosingPercentageException {
		City aCity = new City();
		
		LocalDate startDate = LocalDate.parse("2020-09-12");
		LocalDate endDate = LocalDate.parse("2020-09-12");
		
		Project aProject = new Project();
		aProject.setId(123l);
		aProject.setFactor(2000);
		aProject.setMinClosingPercentage(50);
		aProject.setName("nombre");
		aProject.setStartDate(startDate);
		aProject.setEndDate(endDate);
		aProject.setCity(aCity);
		aProject.setDonationsRegistered(new ArrayList<Donation>());
		aProject.setTotalRaised(0d);
			
		assertEquals(123l, aProject.getId());
		assertEquals(2000, aProject.getFactor());
		assertEquals(50, aProject.getMinClosingPercentage());
		assertEquals("nombre", aProject.getName());
		assertEquals(startDate, aProject.getStartDate());
		assertEquals(endDate, aProject.getEndDate());
		assertEquals(aCity, aProject.getCity());
		assertEquals(0, aProject.getDonationsRegistered().size());
		assertEquals(0d, aProject.getTotalRaised());
	}
	
	@Test
	void testProjectIsCreatedWithDefaultValuesAndHasFactorSetTo1000AndPercentageSetTo100() {
		Project aProject = new Project();
		assertEquals(1000, aProject.getFactor());
		assertEquals(100, aProject.getMinClosingPercentage());
	}
	
	@Test
	void testProjectsWithCityWith1500PeopleAndAFactorOf2000HasATotalCostOf3Millions() throws FactorException{
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		aProject.setFactor(2000);
		
		assertEquals(3000000, aProject.getTotalCost());
	}
	
	@Test
	void testProjectOf3000000CostHas1500000TotalRaisedThenAlsoHas50PercentageOfCompletion() throws FactorException {
		Donation donation = new Donation();
		donation.setDonationDate(LocalDate.now());
		donation.setAmount(1500000d);
		
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		aProject.setFactor(2000);
		
		aProject.addDonation(donation);
		
		assertEquals(50, aProject.remainingPercentageToComplete());
	}
	
	@Test
	void testProjectHasInvalidMinClosedPercentageValueAndExceptionIsThrown() {
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		Assertions.assertThrows(ClosingPercentageException.class, () -> aProject.setMinClosingPercentage(49));
	}
	
	@Test
	void testProjectHasInvalidFactorValueAndExceptionIsThrown() {
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		Assertions.assertThrows(FactorException.class, () -> aProject.setFactor(100001));
	}
	
	@Test
	void testProjectHas2DonationsAndGetsDonationWithEarlierDonationDate() throws FactorException {
		Donation donation = new Donation();
		donation.setDonationDate(LocalDate.now().minusDays(2));
		donation.setAmount(1500000d);
		
		Donation donation2 = new Donation();
		donation2.setDonationDate(LocalDate.now().minusDays(1));
		donation2.setAmount(1500000d);
		
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		aProject.setFactor(2000);
		
		aProject.addDonation(donation);
		aProject.addDonation(donation2);
		
		assertEquals(donation2, aProject.getDonationWithEarlierDonationDate());
	}
	
	@Test
	void testProjectHas1DonationAndGetsThatDonationWhenTriesToGetTheDonationWithEarlierDonationDate() throws FactorException {
		Donation donation = new Donation();
		donation.setDonationDate(LocalDate.now().minusDays(2));
		donation.setAmount(1500000d);
		
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		aProject.setFactor(2000);
		
		aProject.addDonation(donation);
		
		assertEquals(donation, aProject.getDonationWithEarlierDonationDate());
	}
	
	@Test
	void testProjectDoesNotHaveADonationThenReturnsNullWhenGetTheDonationWithEarlierDonationDate() throws FactorException {
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		aProject.setFactor(2000);
		
		assertEquals(null, aProject.getDonationWithEarlierDonationDate());
	}
}
