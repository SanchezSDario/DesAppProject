package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosedProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence.DonationRepository;

@Service
public class DonationService {

	@Autowired
    private UserService userService;
	
	@Autowired
    private ProjectService projectService;
	
	@Autowired
	private DonationRepository repository;
	
	@Transactional
	public Donation save(Donation donation) {
		return this.repository.save(donation);
	}
	
	@Transactional
	public User donate(Long userId, Long projectId, Donation donation) throws ClosedProjectException {
		User user = userService.findByID(userId);
		Project project = projectService.findByID(projectId);
		user.registerDonation(project, donation);
		this.repository.save(donation);
		projectService.save(project);
		return userService.save(user);
	}
}
