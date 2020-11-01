package ar.edu.unq.desapp.GrupoJ022020.desappapl.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.ClosedProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UnableToCloseProjectException;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions.UserTypeActionException;

@Entity
public class UserAdmin extends User{

	public UserAdmin() {
		super();
		this.profile = UserProfile.ADMIN;
	}
	
	public UserAdmin (String nombre, 
					  String apellido, 
					  Integer puntos, 
					  String mail,
					  String userName,
					  String nickName,
					  String password, 
					  Set<Project> projectsDonatedTo, 
					  Set<Donation> donationsDone) {
		 super(nombre, apellido, puntos, mail, userName, nickName, password, projectsDonatedTo, donationsDone);
		 this.profile = UserProfile.ADMIN;
	}

	@Override
	public Donation registerDonation(Project project, Donation donation) throws ClosedProjectException, UserTypeActionException {
		throw new UserTypeActionException();
	}

	@Override
	public Project closeProject(Project project) throws UnableToCloseProjectException, UserTypeActionException {
		LocalDate date = LocalDate.now();
		if(project.getEndDate().isBefore(date) || 
		   project.getTotalRaised() >= project.getTotalCost() ||
		   (project.getTotalRaised() / project.getTotalCost() * 100) >= project.getMinClosingPercentage()
		   ) {
			project.setIsClosed(true);
			return project;
		} else {
			throw new UnableToCloseProjectException();
		}
	}
}
