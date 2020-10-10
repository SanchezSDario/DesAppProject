package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.City;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;

@Service
@Transactional
public class InitServiceInMemory {

	protected final Log logger = LogFactory.getLog(getClass());

	@Value("${spring.datasource.driverClassName:NONE}")
	private String className;
	
	@Autowired
	private CityService cityService;
	@Autowired
	private ProjectService projectService;

	@PostConstruct
	public void initialize() {
		if (className.equals("org.h2.Driver")) {
			logger.warn("Init Data Using H2 DB");
			fireInitialData();
		}
	}

	private void fireInitialData() {
		City city = new City("city", "province", "connectivityStatus", 1);
		cityService.save(city);
		Project project = new Project(60, 20, "project", LocalDate.parse("2020-09-12"), LocalDate.parse("2020-09-12"), city, 1000d);
		projectService.save(project);
	}
}
