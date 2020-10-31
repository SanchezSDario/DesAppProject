package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.ServiceExceptions.*;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return this.repository.findAll();
	}
	
	public User findByID(Long id) {
		return this.repository.findById(id).get();
	}
	
	@Transactional
	public User save(User user) {
		return this.repository.save(user);
	}
	
	@Transactional
	public User login(String userMail, String userPass) throws LoginIncorrectMailOrPasswordException, InvalidEmailException {
		validateEmail(userMail);
		List<User> allUsers = this.findAll();
		List<User> filteredUser = allUsers.stream().filter(user -> user.getMail().equals(userMail) && user.getPassword().equals(userPass)).collect(Collectors.toList());
		if(!filteredUser.isEmpty()) {
			return filteredUser.get(0);
		}
		throw new LoginIncorrectMailOrPasswordException();
	}
	
	@Transactional
	public User register(String userMail, String userPass, String userFirstName) throws LoginIncorrectMailOrPasswordException, InvalidEmailException, RegisterEmailAlreadyExistsException {
		validateEmail(userMail);
		List<User> allUsers = this.findAll();
		List<User> filteredUser = allUsers.stream().filter(user -> user.getMail().equals(userMail)).collect(Collectors.toList());
		if(filteredUser.isEmpty()) {
			User newUser = new User();
			newUser.setMail(userMail);
			newUser.setPassword(userPass);
			newUser.setFirstName(userFirstName);
			return this.save(newUser);
		}
		throw new RegisterEmailAlreadyExistsException();
	}
	
	public static void validateEmail(String email) throws InvalidEmailException { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (!pat.matcher(email).matches()) 
            throw new InvalidEmailException();
    } 
}
