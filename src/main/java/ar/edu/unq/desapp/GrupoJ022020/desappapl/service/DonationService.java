package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence.DonationRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository repository;
	
	@Transactional
	public Donation save(Donation donation) {
		return this.repository.save(donation);
	}
}
