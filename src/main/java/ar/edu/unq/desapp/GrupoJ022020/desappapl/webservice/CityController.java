package ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
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
}
