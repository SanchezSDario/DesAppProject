package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repository;
	
	public List<Project> findAll() {
		return this.repository.findAll();
	}
	
	public Project findByID(Long id) {
		return this.repository.findById(id).get();
	}
	
	@Transactional
	public Project save(Project project) {
		return this.repository.save(project);
	}
	
	@Transactional
	public Project update(Long id, Project newProject) {
		Project project = this.repository.findById(id).get();
		project = newProject;
		project.setId(id);
		return this.repository.save(project);
	}
	
	@Transactional
	public void delete(Project project) {
		this.repository.delete(project);
	}
}
