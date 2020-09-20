package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CityTest {

	@Test
	void testCityCreatesWithValues() {
		City aCity = new City("id", "nombre", "provincia", "estado", 1);
			
		assertEquals("id", aCity.getId());
		assertEquals("nombre", aCity.getName());
		assertEquals("provincia", aCity.getProvince());
		assertEquals(1, aCity.getPopulation());
		assertEquals("estado", aCity.getConnectivityStatus());
	}
	
	@Test
	void testCityCreatesAndSetItsValues() {
		City aCity = new City();
		aCity.setId("id");
		aCity.setName("nombre");
		aCity.setProvince("provincia");
		aCity.setConnectivityStatus("estado");
		aCity.setPopulation(1);
			
		assertEquals("id", aCity.getId());
		assertEquals("nombre", aCity.getName());
		assertEquals("provincia", aCity.getProvince());
		assertEquals(1, aCity.getPopulation());
		assertEquals("estado", aCity.getConnectivityStatus());
	}
}
