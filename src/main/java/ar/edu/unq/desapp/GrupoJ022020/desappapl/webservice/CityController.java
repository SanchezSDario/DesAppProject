package ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.City;
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
	
	@GetMapping("/api/city/{id}")
	@ResponseBody
    public City getCity(@PathVariable("id") Long id) {
        return cityService.findByID(id);
    }
	
	@PostMapping(path = "/api/city", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public City postCity(@RequestBody City city) {
        return cityService.save(city);
    }
	
	@PutMapping(path = "/api/city/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public City putCity(@PathVariable("id") Long id, @RequestBody City city) {
        return cityService.update(id, city);
	}
	
	@DeleteMapping(path = "/api/city/{id}", produces = "application/json")
	@ResponseBody
    public City deleteCity(@PathVariable("id") Long id) {
        City city = this.getCity(id);
		cityService.delete(city);
        return city;
	}
}
