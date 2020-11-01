package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UnableToCloseProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UserTypeActionException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public Project save(Project project) {
		return this.repository.save(project);
	}
	
	@Transactional
	public Project close(Long userId, Long projectId) throws UnableToCloseProjectException, UserTypeActionException{
		User user = userService.findByID(userId);
		Project project = this.findByID(projectId);
		user.closeProject(project);
		return this.save(project);
	}
	
	public Project findByID(Long id) {
		return this.repository.findById(id).get();
	}
	
	public List<Project> findAll() {
		return this.repository.findAll();
	}
}
