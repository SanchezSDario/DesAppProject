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
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.UserAdmin;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.UserDonor;
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
		City city1 = new City("Rio Cuarto", "Cordoba", "Conectado", 10000);
		cityService.save(city1);
		City city2 = new City("General Pico", "La Pampa", "No conectado", 5000);
		cityService.save(city2);
		City city3 = new City("Concepcion", "Tucuman", "Conectado", 4725);
		cityService.save(city3);
		City city4 = new City("Cachi", "Salta", "No Conectado", 7000);
		cityService.save(city4);
		City city5 = new City("Belgrano", "San Luis", "No Conectado", 23000);
		cityService.save(city5);
		City city6 = new City("Villa España", "Buenos Aires", "Conectado", 5300);
		cityService.save(city6);
		City city7 = new City("Rodeo", "San Juan", "No Conectado", 7300);
		cityService.save(city7);
		City city8 = new City("El Bolson", "Rio Negro", "Conectado", 2000);
		cityService.save(city8);
		City city9 = new City("Rawson", "Chubut", "Conectado", 9000);
		cityService.save(city9);
		City city10 = new City("Santa Maria", "Catamarca", "Conectado", 10000);
		cityService.save(city10);
		City city11 = new City("Posadas", "Misiones", "Conectado", 5400);
		cityService.save(city11);
		City city12 = new City("Rafaela", "Santa Fe", "Conectado", 11111);
		cityService.save(city12);
		City city13 = new City("Itatí", "Corrientes", "No Conectado", 10000);
		cityService.save(city13);
		City city14 = new City("Maipú", "Mendoza", "No Conectado", 8600);
		cityService.save(city14);
		City city15 = new City("Concordia", "Entre Rios", "No Conectado", 9000);
		cityService.save(city15);
		City city16 = new City("Haro", "La Rioja", "No Conectado", 6100);
		cityService.save(city16);
		
		Project project1 = new Project(60, 50, "Rio Cuarto Conecta", LocalDate.parse("2020-10-03"), LocalDate.parse("2021-10-03"), city1, 1000d);
		projectService.save(project1);
		Project project2 = new Project(60, 68, "General Pico Conecta", LocalDate.parse("2020-03-15"), LocalDate.parse("2021-05-21"), city2, 1000d);
		projectService.save(project2);
		Project project3 = new Project(60, 83, "Concepcion Conecta", LocalDate.parse("2020-07-11"), LocalDate.parse("2021-01-03"), city3, 1000d);
		projectService.save(project3);
		Project project4 = new Project(60, 90, "Cachi Conecta", LocalDate.parse("2020-05-03"), LocalDate.parse("2021-12-31"), city4, 1000d);
		projectService.save(project4);
		Project project5 = new Project(60, 47, "Belgrano Conecta", LocalDate.parse("2020-04-21"), LocalDate.parse("2021-10-03"), city5, 1000d);
		projectService.save(project5);
		Project project6 = new Project(60, 75, "Villa España Conecta", LocalDate.parse("2020-10-03"), LocalDate.parse("2022-07-11"), city6, 1000d);
		projectService.save(project6);
		Project project7 = new Project(60, 81, "Rodeo Conecta", LocalDate.parse("2019-12-03"), LocalDate.parse("2025-11-03"), city7, 1000d);
		projectService.save(project7);
		Project project8 = new Project(60, 60, "El Bolson Conecta", LocalDate.parse("2020-01-31"), LocalDate.parse("2022-09-17"), city8, 1000d);
		projectService.save(project8);
		Project project9 = new Project(60, 97, "Rawson Conecta", LocalDate.parse("2020-04-13"), LocalDate.parse("2023-10-03"), city9, 1000d);
		projectService.save(project9);
		Project project10 = new Project(60, 58, "Santa Maria Conecta", LocalDate.parse("2018-12-03"), LocalDate.parse("2023-10-03"), city10, 1000d);
		projectService.save(project10);
		Project project11 = new Project(60, 66, "Posadas Conecta", LocalDate.parse("2020-02-02"), LocalDate.parse("2021-11-23"), city11, 1000d);
		projectService.save(project11);
		Project project12 = new Project(60, 87, "Rafaela Conecta", LocalDate.parse("2020-05-15"), LocalDate.parse("2021-05-03"), city12, 1000d);
		projectService.save(project12);
		Project project13 = new Project(60, 69, "Itatí Conecta", LocalDate.parse("2020-04-13"), LocalDate.parse("2021-08-20"), city13, 1000d);
		projectService.save(project13);
		Project project14 = new Project(60, 80, "Maipú Conecta", LocalDate.parse("2020-06-17"), LocalDate.parse("2024-10-03"), city14, 1000d);
		projectService.save(project14);
		Project project15 = new Project(60, 100, "Concordia Conecta", LocalDate.parse("2019-06-11"), LocalDate.parse("2021-11-14"), city15, 1000d);
		projectService.save(project15);
		Project project16 = new Project(60, 63, "Haro Conecta", LocalDate.parse("2020-01-01"), LocalDate.parse("2021-06-29"), city16, 1000d);
		projectService.save(project16);
		
		City city17 = new City("Ushuaia", "Tierra del Fuego", "Conectado", 1500);
		cityService.save(city17);
		
		Project project17 = new Project(60, 63, "Ushuaia Conecta", LocalDate.parse("2020-01-01"), LocalDate.parse("2021-06-29"), city17, 1500000d);
		projectService.save(project17);
		
		Donation donation = new Donation(1000d, "Nueva donacion");
		donation.setDonationDate(LocalDate.parse("2020-10-03"));
		donationService.save(donation);
		User pepita = new UserDonor("Pepita", "Paloma", 1000, "pepita@mail.com", "pepitaDonor", "Pepita", "nacer", new HashSet<Project>(), new HashSet<Donation>());
		pepita.addProjectDonatedTo(project1);
		pepita.addDonation(donation);
		userService.save(pepita);
		
		User admin = new UserAdmin("Admin", "Admin", 1000, "admin@admin.com", "admin", "admin", "admin", new HashSet<Project>(), new HashSet<Donation>());
		userService.save(admin);
	}
}
