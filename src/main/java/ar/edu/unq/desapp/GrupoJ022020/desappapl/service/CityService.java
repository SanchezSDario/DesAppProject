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

	@Transactional
	public List<City> findAll() {
		return this.repository.findAll();
	}
	
	@Transactional
	public City save(City city) {
		return this.repository.save(city);
	}
}
