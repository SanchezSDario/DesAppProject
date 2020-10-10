package ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
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
        List<City> list = cityService.findAll();
        return list;
    }
	
	@GetMapping("/api/city/{id}")
	@ResponseBody
    public City getCity(@PathVariable("id") Long id) {
        City city = cityService.findByID(id);
        return city;
    }
	
	@PostMapping(path = "/api/city", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public City postCity(@RequestBody City city) {
        cityService.save(city);
        return city;
    }
	
	@PutMapping(path = "/api/city/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public City putCity(@PathVariable("id") Long id, @RequestBody City city) {
        cityService.update(id, city);
        return city;
	}
	
	@DeleteMapping(path = "/api/city/{id}", produces = "application/json")
	@ResponseBody
    public City deleteCity(@PathVariable("id") Long id) {
        City city = this.getCity(id);
		cityService.delete(city);
        return city;
	}
	
    @GetMapping("/api/version")
	@ResponseBody
	public ResponseEntity<?> getVersion() {
    	String version = "0.2.1";
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("version", version);
		return ResponseEntity.ok().body(resultado);
	}
}
