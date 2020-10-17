package ar.edu.unq.desapp.GrupoJ022020.desappapl;

import java.time.LocalDate;
import java.util.HashSet;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.City;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.CityService;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.DonationService;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.ProjectService;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.UserService;

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
	@Autowired
	private UserService userService;
	@Autowired
	private DonationService donationService;


	@PostConstruct
	public void initialize() {
		if (className.equals("org.h2.Driver")) {
			logger.warn("Init Data Using H2 DB");
			fireInitialData();
		}
	}

	private void fireInitialData() {
		City city = new City("city", "province", "connectivityStatus", 10000);
		cityService.save(city);
		Project project = new Project(60, 20, "project", LocalDate.parse("1911-10-03"), LocalDate.parse("2120-10-03"), city, 1000d);
		projectService.save(project);
		Donation donation = new Donation(123d, "Hola");
		donation.setDonationDate(LocalDate.parse("2120-10-03"));
		donationService.save(donation);
		User user = new User("nombre", "apellido", 1000, "mail", "password", new HashSet<Project>(), new HashSet<Donation>());
		user.addProjectDonatedTo(project);
		user.addDonation(donation);
		userService.save(user);
	}
}
