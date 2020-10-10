package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.City;

class CityTest {

	@Test
	void testCityCreatesWithValues() {
		City aCity = new City("nombre", "provincia", "estado", 1);
			
		assertEquals("nombre", aCity.getName());
		assertEquals("provincia", aCity.getProvince());
		assertEquals(1, aCity.getPopulation());
		assertEquals("estado", aCity.getConnectivityStatus());
	}
	
	@Test
	void testCityCreatesAndSetItsValues() {
		City aCity = new City();
		aCity.setId(123l);
		aCity.setName("nombre");
		aCity.setProvince("provincia");
		aCity.setConnectivityStatus("estado");
		aCity.setPopulation(1);
			
		assertEquals(123l, aCity.getId());
		assertEquals("nombre", aCity.getName());
		assertEquals("provincia", aCity.getProvince());
		assertEquals(1, aCity.getPopulation());
		assertEquals("estado", aCity.getConnectivityStatus());
	}
}
