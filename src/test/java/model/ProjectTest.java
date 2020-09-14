package model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ProjectTest {

	@Test
	void testProjectIsCreatedWithAllItsValues() throws ParseException {
		City aCity = new City();
		
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdformat.parse("2020-09-12");
		Date endDate = sdformat.parse("2020-09-12");
		
		Project aProject = new Project("id", 2000, 1, "nombre", startDate, endDate, aCity, 0d);
			
		assertEquals("id", aProject.getId());
		assertEquals(2000, aProject.getFactor());
		assertEquals(1, aProject.getMinClosingPercent());
		assertEquals("nombre", aProject.getName());
		assertEquals(startDate, aProject.getStartDate());
		assertEquals(endDate, aProject.getEndDate());
		assertEquals(aCity, aProject.getCity());
		assertEquals(0d, aProject.getTotalRaised());
	}
	
	@Test
	void testProjectIsCreatedAndItsValuesAreSet() throws ParseException {
		City aCity = new City();
		
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdformat.parse("2020-09-12");
		Date endDate = sdformat.parse("2020-09-12");
		
		Project aProject = new Project();
		aProject.setId("id");
		aProject.setFactor(2000);
		aProject.setMinClosingPercent(1);
		aProject.setName("nombre");
		aProject.setStartDate(startDate);
		aProject.setEndDate(endDate);
		aProject.setCity(aCity);
		aProject.setTotalRaised(0d);
			
		assertEquals("id", aProject.getId());
		assertEquals(2000, aProject.getFactor());
		assertEquals(1, aProject.getMinClosingPercent());
		assertEquals("nombre", aProject.getName());
		assertEquals(startDate, aProject.getStartDate());
		assertEquals(endDate, aProject.getEndDate());
		assertEquals(aCity, aProject.getCity());
		assertEquals(0d, aProject.getTotalRaised());
	}
	
	@Test
	void testProjectIsCreatedWithDefaultValuesAndHasFactorSetTo1000() {
		Project aProject = new Project();
		assertEquals(1000, aProject.getFactor());
	}
	
	@Test
	void testProjectsWithCityWith1500PeopleAndAFactorOf2000HasATotalCostOf3Millions(){
		City aCity = new City();
		aCity.setPopulation(1500);
		
		Project aProject = new Project();
		aProject.setCity(aCity);
		aProject.setFactor(2000);
		
		assertEquals(3000000, aProject.getTotalCost());
	}
}
