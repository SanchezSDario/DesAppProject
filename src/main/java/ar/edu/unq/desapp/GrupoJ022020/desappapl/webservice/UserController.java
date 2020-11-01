package ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "/api/login", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public User loginUser(@RequestParam String userMail, 
    					  @RequestParam String userName, 
    					  @RequestParam String userPass) throws Exception {
		return userService.login(userMail, userName, userPass);
    }
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "/api/register", consumes = "application/json", produces = "application/json")
	@ResponseBody
    public User registerUser(@RequestParam String userMail, 
    						 @RequestParam String userName,
    						 @RequestParam String userPass, 
    						 @RequestParam String userFirstName,
    						 @RequestParam(required=false) String userLastName,
    						 @RequestParam(required=false) String userNickName) throws Exception {
		return userService.register(userMail, userName, userPass, userFirstName, userLastName, userNickName);
    }
}
