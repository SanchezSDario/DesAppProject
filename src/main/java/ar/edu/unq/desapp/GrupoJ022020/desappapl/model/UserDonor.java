package ar.edu.unq.desapp.GrupoJ022020.desappapl.model;

import java.util.Set;

import javax.persistence.Entity;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosedProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UnableToCloseProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UserTypeActionException;

@Entity
public class UserDonor extends User{

	public UserDonor() {
		super();
		this.profile = UserProfile.DONOR;
	}
	
	public UserDonor (String nombre, 
			  String apellido, 
			  Integer puntos, 
			  String mail,
			  String userName,
			  String nickName,
			  Set<Project> projectsDonatedTo, 
			  Set<Donation> donationsDone) {
		 super(nombre, apellido, puntos, mail, userName, nickName, projectsDonatedTo, donationsDone);
		 this.profile = UserProfile.DONOR;
	}
	
	public Donation registerDonation(Project project, Donation donation) throws ClosedProjectException{
		if(project.getIsClosed()) {
			throw new ClosedProjectException();
		}
		this.addProjectDonatedTo(project);
		project.addDonation(donation);
		this.addDonation(donation);
		PointManager.addPointsToUser(this, project, donation);
		donation.setDonorUser(this.getNickName());
		return donation;
	}

	@Override
	public Project closeProject(Project project) throws UnableToCloseProjectException, UserTypeActionException {
		throw new UserTypeActionException();
	}
}
