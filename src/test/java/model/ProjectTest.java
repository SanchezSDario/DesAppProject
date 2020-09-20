package model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import modelExceptions.ClosedProjectException;
import modelExceptions.ClosingPercentageException;
import modelExceptions.FactorException;

class ProjectTest {

	@Test
	void testProjectIsCreatedWithAllItsValues() throws ParseException {
		City aCity = new City();
		
		LocalDate startDate = LocalDate.parse("2020-09-12");
		LocalDate endDate = LocalDate.parse("2020-09-12");
		
		Project aProject = new Project("id", 2000, 50, "nombre", startDate, endDate, aCity, 0d);
			
		assertEquals("id", aProject.getId());
		assertEquals(2000, aProject.getFactor());
		assertEquals(50, aProject.getMinClosingPercentage());
		assertEquals("nombre", aProject.getName());
		assertEquals(startDate, aProject.getStartDate());
		assertEquals(endDate, aProject.getEndDate());
		assertEquals(aCity, aProject.getCity());
		assertEquals(0d, aProject.getTotalRaised());
	}
	
	@Test
	void testProjectIsCreatedAndItsValuesAreSet() throws FactorException, ClosingPercentageException {
		City aCity = new City();
		
		LocalDate startDate = LocalDate.parse("2020-09-12");
		LocalDate endDate = LocalDate.parse("2020-09-12");
		
		Project aProject = new Project();
		aProject.setId("id");
		aProject.setFactor(2000);
		aProject.setMinClosingPercentage(50);
		aProject.setName("nombre");
		aProject.setStartDate(startDate);
		aProject.setEndDate(endDate);
		aProject.setCity(aCity);
		aProject.setTotalRaised(0d);
			
		assertEquals("id", aProject.getId());
		assertEquals(2000, aProject.getFactor());
		assertEquals(50, aProject.getMinClosingPercentage());
		assertEquals("nombre", aProject.getName());
		assertEquals(startDate, aProject.getStartDate());
		assertEquals(endDate, aProject.getEndDate());
		assertEquals(aCity, aProject.getCity());
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
	void testProjectWithTotalRaisedSameAsTotalCostShouldBeClosed() {	
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		//It's still on date, but has raised what was needed
		aProject.setEndDate(LocalDate.now());
		aProject.setTotalRaised(1500000d);

		assertTrue(aProject.isClosed());
	}
	
	@Test
	void testProjectThatReachedEndDateShouldBeClosed() {
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		aProject.setTotalRaised(15d);
		//Hasn't raised what was needed, but arrived to end date
		aProject.setEndDate(LocalDate.now().minusDays(1));
		
		assertTrue(aProject.isClosed());
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
}
