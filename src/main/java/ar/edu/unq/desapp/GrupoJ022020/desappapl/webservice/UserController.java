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

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.UserService;

@RestController
@EnableAutoConfiguration
public class UserController {

	@Autowired
    private UserService userService;

	@GetMapping("/api/users")
	@ResponseBody
    public List<User> allProjects() {
		return userService.findAll();
    }
	
	@GetMapping("/api/user/{id}")
	@ResponseBody
    public User getProject(@PathVariable("id") Long id) {
		return userService.findByID(id);
    }
	
	@PostMapping(path = "/api/user", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public User postProject(@RequestBody User user) {
		return userService.save(user);
    }
	
	@PutMapping(path = "/api/user/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public User putProject(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.update(id, user);
    }
	
	@DeleteMapping(path = "/api/user/{id}", produces = "application/json")
	@ResponseBody
    public User deleteProject(@PathVariable("id") Long id) {
		User user = this.getProject(id);
		userService.delete(user);
        return user;
	}
}
