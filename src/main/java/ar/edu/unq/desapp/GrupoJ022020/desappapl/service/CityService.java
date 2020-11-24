package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.City;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.UserProfile;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UserTypeActionException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private ProjectService projectService;

	@Transactional
	public List<City> findAll() {
		return this.repository.findAll();
	}
	
	@Transactional
	public City findByID(Long id) {
		return this.repository.findById(id).get();
	}
	
	@Transactional
	public City quicksave(City city) {
		return this.repository.save(city);
	}
	
	
	@Transactional
	public City save(City city, Long userId) throws UserTypeActionException {
		if(this.userService.findByID(userId).getProfile().equals(UserProfile.DONOR))
			throw new UserTypeActionException();
		return this.repository.save(city);
	}

	@Transactional
	public List<City> findCitiesWithoutProject() {
		List <City> citiesWithProjectAssigned = new ArrayList<City>();
		this.projectService.findAll().stream().forEach(project -> citiesWithProjectAssigned.add(project.getCity()));
		return this.repository.findAll().stream().filter(city -> ! citiesWithProjectAssigned.contains(city)).collect(Collectors.toList());
	}
}
