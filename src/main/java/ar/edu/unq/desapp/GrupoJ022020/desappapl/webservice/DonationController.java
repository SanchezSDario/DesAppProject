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

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.DonationService;

@RestController
@EnableAutoConfiguration
public class DonationController {

	@Autowired
    private DonationService donationService;

	@GetMapping("/api/donations")
	@ResponseBody
    public List<Donation> allProjects() {
		return donationService.findAll();
    }
	
	@GetMapping("/api/donation/{id}")
	@ResponseBody
    public Donation getDonation(@PathVariable("id") Long id) {
		return donationService.findByID(id);
    }
	
	@PostMapping(path = "/api/donation", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public Donation postDonation(@RequestBody Donation donation) {
		return donationService.save(donation);
    }
	
	@PutMapping(path = "/api/donation/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public Donation putDonation(@PathVariable("id") Long id, @RequestBody Donation donation) {
		return donationService.update(id, donation);
    }
	
	@DeleteMapping(path = "/api/donation/{id}", produces = "application/json")
	@ResponseBody
    public Donation deleteProject(@PathVariable("id") Long id) {
		Donation donation = this.getDonation(id);
		donationService.delete(donation);
        return donation;
	}

}
