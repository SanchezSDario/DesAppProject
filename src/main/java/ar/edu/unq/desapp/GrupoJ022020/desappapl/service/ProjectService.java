package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.UserProfile;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UnableToCloseProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UserTypeActionException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CityService cityService;
	
	@Transactional
	public Project save(Project project, Long userId, Long cityId) throws UserTypeActionException {
		if(this.userService.findByID(userId).getProfile().equals(UserProfile.DONOR))
			throw new UserTypeActionException();
		project.setCity(cityService.findByID(cityId));
		return this.repository.save(project);
	}
	
	@Transactional
	public Project quicksave(Project project) {
		return this.repository.save(project);
	}
	
	@Transactional
	public Project close(Long userId, Long projectId) throws UnableToCloseProjectException, UserTypeActionException{
		User user = userService.findByID(userId);
		Project project = this.findByID(projectId);
		user.closeProject(project);
		return this.quicksave(project);
	}
	

	@Transactional
	public Project findByID(Long id) {
		return this.repository.findById(id).get();
	}
	
	@Transactional
	public List<Project> findAll() {
		return this.repository.findAll();
	}
	
	@Transactional
	public List<Project> getProjectsWithOldestDonationDate(){
		List<Project> allProjects = this.repository.findAll();
		List<Project> projectList = allProjects.stream().filter(project -> project.getDonationsRegistered().isEmpty()).limit(10).collect(Collectors.toList());
		if(projectList.size() < 10) {
			List<Project> projectWithOldestDonationDate = allProjects.stream()
															  .filter(project -> !project.getDonationsRegistered().isEmpty())
															  .sorted((project1, project2) -> {
																try {
																	return (project1.getDonationWithEarlierDonationDate().getDonationDate().compareTo(
																			project2.getDonationWithEarlierDonationDate().getDonationDate()));
																} catch (Exception e) {
																	e.printStackTrace();
																}
																return 0;
															})
															  .limit(10 - projectList.size()).collect(Collectors.toList());
			projectList.addAll(projectWithOldestDonationDate);
		}
		return projectList;
	}
}
