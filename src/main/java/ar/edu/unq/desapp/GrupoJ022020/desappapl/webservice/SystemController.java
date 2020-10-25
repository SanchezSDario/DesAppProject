package ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosedProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.DonationService;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.ProjectService;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.UserService;

@RestController
@EnableAutoConfiguration
public class SystemController {

	@Autowired
    private UserService userService;
	@Autowired
    private ProjectService projectService;
	@Autowired
    private DonationService donationService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "/api/donate", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public User donate(@RequestParam Long userId, @RequestParam Long projectId, @RequestBody Donation donation) throws ClosedProjectException {
		User user = userService.findByID(userId);
		Project project = projectService.findByID(projectId);
		user.registerDonation(project, donation);
		donationService.save(donation);
		projectService.save(project);
		return userService.save(user);
    }
}