package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.persistence.DonationRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository repository;
	
	public List<Donation> findAll() {
		return this.repository.findAll();
	}
	
	public Donation findByID(Long id) {
		return this.repository.findById(id).get();
	}
	
	@Transactional
	public Donation save(Donation donation) {
		return this.repository.save(donation);
	}
	
	@Transactional
	public Donation update(Long id, Donation newDonation) {
		Donation donation = this.repository.findById(id).get();
		donation = newDonation;
		donation.setId(id);
		return this.repository.save(donation);
	}
	
	@Transactional
	public void delete(Donation donation) {
		this.repository.delete(donation);
	}
}
