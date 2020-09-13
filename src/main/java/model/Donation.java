package model;

import java.util.Date;

public class Donation {

	String id;
	Double amount;
	String comment;
	Date donationDate;
	
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

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}
}
