package ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.City;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UserTypeActionException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.CityService;
@RestController
@EnableAutoConfiguration
public class CityController {

	@Autowired
    private CityService cityService;

	@GetMapping("/api/cities")
	@ResponseBody
    public List<City> allCities() {
        return cityService.findAll();
    }
	
	@GetMapping("/api/cities/projectless")
	@ResponseBody
    public List<City> projectlessCities() {
		return this.cityService.findCitiesWithoutProject();
    }
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "/api/city", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public City addCity(@RequestBody City city, @RequestParam Long userId) throws UserTypeActionException {
		return cityService.save(city, userId);
	}
}
