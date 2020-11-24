package ar.edu.unq.desapp.GrupoJ022020.desappapl.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "donations")
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column(name = "id")
	private Long id;
	@Column
	@ApiModelProperty(required = true)
	private Double amount;
	@Column
	private String comment;
	@Column
	@ApiModelProperty(required = true)
	private LocalDate donationDate;
	@Column
	private String donorNickname;
	
	public Donation() {
		
	}

	public Donation(Double amount, String comment, String donorNickname) {
		this.amount = amount;
		this.comment = comment;
		this.donorNickname = donorNickname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDonorUser() {
		return donorNickname;
	}

	public void setDonorUser(String donorNickname) {
		this.donorNickname = donorNickname;
	}
}
