package ar.edu.unq.desapp.GrupoJ022020.desappapl.model;

import java.time.LocalDate;

public class Donation {

	String id;
	Double amount;
	String comment;
	LocalDate donationDate;
	
	public Donation() {
		
	}

	public Donation(String id, Double amount, String comment) {
		this.id = id;
		this.amount = amount;
		this.comment = comment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
	}
}
