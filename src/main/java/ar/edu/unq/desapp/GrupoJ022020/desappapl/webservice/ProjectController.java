package ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
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
			return projectService.findAll();
	    }
}
