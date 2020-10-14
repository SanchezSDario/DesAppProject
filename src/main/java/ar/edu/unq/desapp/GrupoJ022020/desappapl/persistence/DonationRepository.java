package ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;

@Configuration
@Repository
public interface DonationRepository extends CrudRepository<Donation, Integer>{
	Optional<Donation> findById(Long id);
	
	List<Donation> findAll();
}
