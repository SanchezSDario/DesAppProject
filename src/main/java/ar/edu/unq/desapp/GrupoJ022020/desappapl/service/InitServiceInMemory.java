package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.City;

@Service
@Transactional
public class InitServiceInMemory {

	protected final Log logger = LogFactory.getLog(getClass());

	@Value("${spring.datasource.driverClassName:NONE}")
	private String className;
	
	@Autowired
	private CityService cityService;

	@PostConstruct
	public void initialize() {
		if (className.equals("org.h2.Driver")) {
			logger.warn("Init Data Using H2 DB");
			fireInitialData();
		}
	}

	private void fireInitialData() {
		City city = new City(123l, "city", "province", "connectivityStatus", 1);
		cityService.save(city);
	}
}
