package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public User update(Long id, User newUser) {
		User user = this.repository.findById(id).get();
		user = newUser;
		user.setId(id);
		return this.repository.save(user);
	}
	
	@Transactional
	public void delete(User user) {
		this.repository.delete(user);
	}
}
