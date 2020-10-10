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

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.ProjectService;

@RestController
@EnableAutoConfiguration
public class ProjectController {

		@Autowired
	    private ProjectService projectService;

		@GetMapping("/api/projects")
		@ResponseBody
	    public List<Project> allProjects() {
	        List<Project> list = projectService.findAll();
	        return list;
	    }
		
		@GetMapping("/api/project/{id}")
		@ResponseBody
	    public Project getProject(@PathVariable("id") Long id) {
			Project project = projectService.findByID(id);
	        return project;
	    }
		
		@PostMapping(path = "/api/project", consumes = "application/json", produces = "application/json")
		@ResponseBody
	    public Project postProject(@RequestBody Project project) {
	        projectService.save(project);
	        return project;
	    }
		
		@PutMapping(path = "/api/project/{id}", consumes = "application/json", produces = "application/json")
		@ResponseBody
	    public Project putProject(@PathVariable("id") Long id, @RequestBody Project project) {
	        projectService.update(id, project);
	        return project;
		}
		
		@DeleteMapping(path = "/api/project/{id}", produces = "application/json")
		@ResponseBody
	    public Project deleteProject(@PathVariable("id") Long id) {
			Project project = this.getProject(id);
			projectService.delete(project);
	        return project;
		}
}
