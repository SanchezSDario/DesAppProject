package ar.edu.unq.desapp.GrupoJ022020.desappapl.model;

import java.util.Set;
import java.util.stream.Collectors;

public class PointManager {

	public static Integer addPointsToUser(User user, Project project, Donation donation) {
		user.addPoints(getDonationPoints(user, project, donation));
		return user.getPoints();
	}
	
	private static Integer getDonationPoints(User user, Project project, Donation donation) {
		Integer totalAmount = 0;
		
		if(donation.getAmount() > 1000d) {
			totalAmount = donation.getAmount().intValue();
		}
		
		if(project.getCity().getPopulation() < 2000) {
			totalAmount = donation.getAmount().intValue()*2;
		}
		
		Set<Donation> donacionesDelMes = user.getDonationsMade().stream().filter(don ->
			don.getDonationDate().getYear() == donation.getDonationDate().getYear() &&
			don.getDonationDate().getMonth() == donation.getDonationDate().getMonth()).collect(Collectors.toSet());
		if(donacionesDelMes.size() > 1) {
			totalAmount += 500;
		}
		
		return totalAmount;
	}
}
