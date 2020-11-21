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

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UnableToCloseProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UserTypeActionException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.ProjectService;

@RestController
@EnableAutoConfiguration
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("/api/projects")
	@ResponseBody
	public List<Project> allProjects() {
		return projectService.findAll();
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "/api/project/create", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public Project createProject(@RequestBody Project project, @RequestParam Long cityId, @RequestParam Long userId) throws UserTypeActionException {
		return projectService.save(project, userId, cityId);
	}
		
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "/api/project/close", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Project close(@RequestParam Long userId, @RequestParam Long projectId) throws UnableToCloseProjectException, UserTypeActionException{
		return projectService.close(userId, projectId);
	}
}
