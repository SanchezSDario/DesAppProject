package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.ServiceExceptions.*;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.UserDonor;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional
	public List<User> findAll() {
		return this.repository.findAll();
	}
	
	@Transactional
	public User findByID(Long id) {
		return this.repository.findById(id).get();
	}
	
	@Transactional
	public User save(User user) {
		return this.repository.save(user);
	}
	
	@Transactional
	public User login(String userMail, String userName, String userPass) throws LoginIncorrectMailUserNameOrPasswordException, InvalidEmailException {
		List<User> allUsers = this.findAll();
		List<User> filteredUser = allUsers.stream().filter(user -> (user.getMail().equals(userMail) || user.getUserName().equals(userName)) && user.getPassword().equals(userPass)).collect(Collectors.toList());
		if(!filteredUser.isEmpty()) {
			return filteredUser.get(0);
		}
		throw new LoginIncorrectMailUserNameOrPasswordException();
	}
	
	@Transactional
	public User register(String userMail, String userName, String userPass, String userFirstName, String userLastName, String userNickName) throws LoginIncorrectMailUserNameOrPasswordException, InvalidEmailException, RegisterEmailOrUserNameAlreadyExistsException {
		validateEmail(userMail);
		List<User> allUsers = this.findAll();
		List<User> filteredUser = allUsers.stream().filter(user -> user.getMail().equals(userMail) || user.getUserName().equals(userName)).collect(Collectors.toList());
		if(filteredUser.isEmpty()) {
			userLastName = userLastName == null ? "" : userLastName;
			userNickName = userNickName == null ? "" : userNickName;
			User newUser = new UserDonor();
			newUser.setMail(userMail);
			newUser.setUserName(userName);
			newUser.setLastName(userLastName);
			newUser.setPassword(userPass);
			newUser.setFirstName(userFirstName);
			if(userNickName.isEmpty()) 
				userNickName = userFirstName + userLastName;
			newUser.setNickName(userNickName);
			return this.save(newUser);
		}
		throw new RegisterEmailOrUserNameAlreadyExistsException();
	}
	
	private static void validateEmail(String email) throws InvalidEmailException { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (!pat.matcher(email).matches()) 
            throw new InvalidEmailException();
    } 
}
