package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.City;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	
	public List<City> findAll() {
		return this.repository.findAll();
	}
	
	public City findByID(Long id) {
		return this.repository.findById(id).get(); 
	}
	
	@Transactional
	public City save(City city) {
		return this.repository.save(city);
	}
	
	@Transactional
	public City update(Long id, City newCity) {
		City city = this.repository.findById(id).get();
		city = newCity;
		city.setId(id);
		return this.repository.save(city);
	}
	
	@Transactional
	public void delete(City city) {
		this.repository.delete(city);
	}
}
