package ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<User> allUsers() {
		return userService.findAll();
    }
}
