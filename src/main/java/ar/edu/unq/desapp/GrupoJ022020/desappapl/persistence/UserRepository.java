package ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;

@Configuration
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findById(Long id);
	
	List<User> findAll();
}